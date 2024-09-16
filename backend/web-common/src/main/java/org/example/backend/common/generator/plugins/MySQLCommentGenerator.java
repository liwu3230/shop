package org.example.backend.common.generator.plugins;

import org.apache.commons.lang.StringUtils;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2022/9/29 11:32
 */
public class MySQLCommentGenerator extends EmptyCommentGenerator {
    private Properties properties;

    public MySQLCommentGenerator() {
        properties = new Properties();
    }

    @Override
    public void addConfigurationProperties(Properties properties) {
        // 获取自定义的 properties
        this.properties.putAll(properties);
    }

    @Override
    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        String author = properties.getProperty("author");
        // 获取表注释
        String remarks = introspectedTable.getRemarks();
        topLevelClass.addJavaDocLine("/**");
        if (StringUtils.isNotBlank(remarks)) {
            topLevelClass.addJavaDocLine(" * @Description: " + remarks);
        }
        topLevelClass.addJavaDocLine(" * @Author: " + author);
        String dateFormat = properties.getProperty("dateFormat", "");
        if (!"".equals(dateFormat)) {
            SimpleDateFormat dateFormatter = new SimpleDateFormat(dateFormat);
            topLevelClass.addJavaDocLine(" * @Date: " + dateFormatter.format(new Date()));
        }
        topLevelClass.addJavaDocLine(" */");
    }

    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        // 获取列注释
        String remarks = introspectedColumn.getRemarks();
        if (StringUtils.isNotBlank(remarks)) {
            field.addJavaDocLine("/**");
            field.addJavaDocLine(" * " + remarks);
            field.addJavaDocLine(" */");
        }
    }

}