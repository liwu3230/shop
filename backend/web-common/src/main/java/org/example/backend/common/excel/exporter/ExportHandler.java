package org.example.backend.common.excel.exporter;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import cn.hutool.core.lang.Pair;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.example.backend.common.utils.T;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.OutputStream;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;
import java.util.function.Supplier;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2021/7/19 20:57
 */
@Slf4j
@Component
public class ExportHandler {

    private static final int BATCH_SIZE = 1000;
    private ExecutorService executorService;

    @PostConstruct
    public void init() {
        int executorSize = 2 * Runtime.getRuntime().availableProcessors();
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setDaemon(true).setNameFormat("handle-export-pool-%d").build();
        executorService = new ThreadPoolExecutor(executorSize, executorSize, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(), namedThreadFactory);
    }

    public <E> void handleExport(Pair<Supplier<Long>, BiFunction<Integer, Integer, List<E>>> pair,
                                 Class<E> headStyleClazz, OutputStream outputStream) throws ExecutionException, InterruptedException {
        Supplier<Long> queryCountSupp = pair.getKey();
        BiFunction<Integer, Integer, List<E>> queryListFunc = pair.getValue();
        //文件下载并且失败的时候返回json,需要设置不关闭流
        ExcelWriter excelWriter = EasyExcel.write(outputStream)
                .registerConverter(new DateConverter())
                .registerConverter(new TimestampConverter())
                .registerConverter(new LocalDateTimeConverter())
                .autoCloseStream(Boolean.FALSE)
                .head(headStyleClazz).build();
        try {
            WriteSheet writeSheet = EasyExcel.writerSheet("sheet1")
                    .registerWriteHandler(new CustomColumnWidthStyleStrategy())
                    .registerWriteHandler(styleWriteHandler())
                    .build();
            //分页查询导出
            long totalCount = queryCountSupp.get();
            int pageTotal = T.computePages((int) totalCount, BATCH_SIZE);
            if (pageTotal <= 0) {
                throw new RuntimeException("无数据可导出!");
            }
            List<CompletableFuture<List<E>>> futureList = Lists.newArrayList();
            for (int page = 1; page <= pageTotal; page++) {
                int finalPage = page;
                CompletableFuture<List<E>> future = CompletableFuture.supplyAsync(() -> {
                    int offset = (finalPage - 1) * BATCH_SIZE;
                    return queryListFunc.apply(BATCH_SIZE, offset);
                }, executorService);
                futureList.add(future);
            }
            List<E> dataList = Lists.newArrayList();
            Object lock = new Object();
            CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0])).whenComplete((v, t) -> {
                futureList.forEach(future -> {
                    synchronized (lock) {
                        dataList.addAll(future.getNow(null));
                    }
                });
            }).get();
            excelWriter.write(dataList, writeSheet);
            //文件下载并且失败的时候返回json,抛异常时不关闭流
            excelWriter.finish();
        } catch (Exception e) {
            log.error("export error", e);
            throw e;
        }
    }

    /**
     * 自定义通用头和内容的样式,其他策略可自已实现
     *
     * @return
     */
    private HorizontalCellStyleStrategy styleWriteHandler() {
        // 头的策略
        WriteFont headWriteFont = new WriteFont();
//        headWriteFont.setFontName("宋体");
        headWriteFont.setFontHeightInPoints((short) 12);
        headWriteFont.setBold(true);

        WriteCellStyle headWriteCellStyle = new WriteCellStyle();
        headWriteCellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        headWriteCellStyle.setWriteFont(headWriteFont);
        headWriteCellStyle.setBorderBottom(BorderStyle.THIN);
        headWriteCellStyle.setBottomBorderColor((short) 0);

        headWriteCellStyle.setBorderLeft(BorderStyle.THIN);
        headWriteCellStyle.setLeftBorderColor((short) 0);
        headWriteCellStyle.setBorderRight(BorderStyle.THIN);
        headWriteCellStyle.setRightBorderColor((short) 0);
        headWriteCellStyle.setBorderTop(BorderStyle.THIN);
        headWriteCellStyle.setTopBorderColor((short) 0);
        headWriteCellStyle.setWrapped(true);
        headWriteCellStyle.setHorizontalAlignment(HorizontalAlignment.LEFT);
        headWriteCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);

        // 内容的策略
        WriteFont contentWriteFont = new WriteFont();
        contentWriteFont.setFontHeightInPoints((short) 12);

        WriteCellStyle contentWriteCellStyle = new WriteCellStyle();
        contentWriteCellStyle.setWriteFont(contentWriteFont);
        contentWriteCellStyle.setFillPatternType(FillPatternType.SOLID_FOREGROUND);
        contentWriteCellStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());
        contentWriteCellStyle.setBorderBottom(BorderStyle.THIN);
        contentWriteCellStyle.setBottomBorderColor((short) 0);
        contentWriteCellStyle.setBorderLeft(BorderStyle.THIN);
        contentWriteCellStyle.setLeftBorderColor((short) 0);
        contentWriteCellStyle.setBorderRight(BorderStyle.THIN);
        contentWriteCellStyle.setRightBorderColor((short) 0);
        contentWriteCellStyle.setBorderTop(BorderStyle.THIN);
        contentWriteCellStyle.setTopBorderColor((short) 0);
        contentWriteCellStyle.setHorizontalAlignment(HorizontalAlignment.LEFT);
        contentWriteCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        contentWriteCellStyle.setWrapped(true);
        return new HorizontalCellStyleStrategy(headWriteCellStyle, contentWriteCellStyle);
    }

}
