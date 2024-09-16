package org.example.backend.common.excel.exporter;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

import java.sql.Date;
import java.util.Objects;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2021/10/21 19:22
 */
public class DateConverter implements Converter<Date> {

    @Override
    public Class supportJavaTypeKey() {
        return Date.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    @Override
    public Date convertToJavaData(CellData cellData, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        return Date.valueOf(cellData.getStringValue());
    }

    @Override
    public CellData convertToExcelData(Date value, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        if (Objects.isNull(value)) {
            return new CellData<>("");
        }
        return new CellData<>(value.toString());
    }
}
