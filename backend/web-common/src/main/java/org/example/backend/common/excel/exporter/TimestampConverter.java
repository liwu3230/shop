package org.example.backend.common.excel.exporter;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import org.example.backend.common.utils.DateUtil;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2021/10/21 19:22
 */
public class TimestampConverter implements Converter<Timestamp> {

    @Override
    public Class supportJavaTypeKey() {
        return Timestamp.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    @Override
    public Timestamp convertToJavaData(CellData cellData, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        return new Timestamp(DateUtil.parse(cellData.getStringValue()).getTime());
    }

    @Override
    public CellData convertToExcelData(Timestamp value, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        if (Objects.isNull(value)) {
            return new CellData<>("");
        }
        return new CellData<>(DateUtil.format(new Date(value.getTime())));
    }
}
