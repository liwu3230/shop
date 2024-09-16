package org.example.backend.common.excel.importer;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.exception.ExcelDataConvertException;
import lombok.extern.slf4j.Slf4j;
import org.example.backend.common.utils.T;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2022/10/28 16:21
 */
@Slf4j
public abstract class AbstractFileHandler<E> extends AnalysisEventListener<E> implements SaveDataHandler<E> {

    protected static final int BATCH_COUNT = 100;

    protected List<E> dataList = new ArrayList<>();

    protected Map<Integer, String> headMap = new ConcurrentHashMap<>();

    protected AtomicInteger successCount = new AtomicInteger(0);

    protected AtomicInteger failCount = new AtomicInteger(0);

    protected List<String> analysisErrors = Collections.synchronizedList(new ArrayList<>());

    @Override
    public void onException(Exception exp, AnalysisContext context) throws Exception {
        // 如果是某一个单元格的转换异常 能获取到具体行号
        // 如果要获取头的信息 配合invokeHeadMap使用
        if (exp instanceof ExcelDataConvertException) {
            log.error("解析失败，但是继续解析下一行:{}", exp.getMessage());
            ExcelDataConvertException excelDataConvertExp = (ExcelDataConvertException) exp;
            log.error("第{}行，第{}列解析异常，数据为:{}", excelDataConvertExp.getRowIndex(), excelDataConvertExp.getColumnIndex() + 1, excelDataConvertExp.getCellData());
            String msg = String.format("第%d行，第%d列解析异常", excelDataConvertExp.getRowIndex(), excelDataConvertExp.getColumnIndex() + 1);
            analysisErrors.add(msg);
            failCount.incrementAndGet();
        } else {
            analysisErrors.add("解析异常:" + exp.getMessage());
            failCount.incrementAndGet();
            throw exp;
        }
    }

    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        this.headMap = headMap;
    }

    @Override
    public void invoke(E data, AnalysisContext analysisContext) {
        dataList.add(data);
        if (dataList.size() >= BATCH_COUNT) {
            saveData();
            dataList.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        saveData();
    }

    protected void saveData() {
        if (T.isNotEmpty(analysisErrors) || failCount.get() > 0) {
            throw new RuntimeException(buildErrorReport(null));
        }
        if (T.isEmpty(dataList)) {
            return;
        }
        log.info("{}条{}数据，开始存储数据库！", dataList.size(), getEClass().getSimpleName());
        try {
            for (E entity : dataList) {
                insert(entity);
                successCount.incrementAndGet();
            }
        } catch (Exception e) {
            log.error("{}数据存储失败！", getEClass().getSimpleName(), e);
            failCount.incrementAndGet();
            throw new RuntimeException(buildErrorReport(e));
        }
    }

    protected String buildErrorReport(Exception exp) {
        if (failCount.get() <= 0) {
            return null;
        }
        StringBuilder message = new StringBuilder();
        if (successCount.get() > 0) {
            message.append("成功数：").append(successCount.get()).append("\n");
        }
        message.append("失败数：").append(failCount.get()).append("\n");
        if (T.isNotEmpty(analysisErrors)) {
            message.append("解析异常报告：").append("\n");
            for (String analysisError : analysisErrors) {
                message.append(analysisError).append("\n");
            }
        }
        if (Objects.nonNull(exp)) {
            message.append("异常：").append(exp.getMessage()).append("\n");
        }
        return message.toString();
    }

    /**
     * 获取 E.class
     *
     * @return
     */
    private Class<T> getEClass() {
        return (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

}
