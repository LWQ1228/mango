package com.sunao.mango.admin.common;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * MySqlCommentGenerator
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/05
 */
public class MySqlCommentGenerator extends EmptyCommentGenerator {
    /**
     * 属性
     */
    private Properties properties;

    /**
     * 无参构造方法
     */
    public MySqlCommentGenerator() {
        properties = new Properties();
    }

    /**
     * 添加配置属性
     *
     * @param properties
     */
    @Override
    public void addConfigurationProperties(Properties properties) {
        // 获取自定义的 properties
        this.properties.putAll(properties);
    }

    /**
     * 增加Model类注释
     *
     * @param topLevelClass
     * @param introspectedTable
     */
    @Override
    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        String author = properties.getProperty("author");
        String blame = properties.getProperty("blame");
        String dateFormat = properties.getProperty("dateFormat", "yyyy/MM/dd");
        SimpleDateFormat dateFormatter = new SimpleDateFormat(dateFormat);

        // 获取表注释
        String remarks = introspectedTable.getRemarks();
        topLevelClass.addJavaDocLine("/**");
        topLevelClass.addJavaDocLine(" * " + remarks);
        topLevelClass.addJavaDocLine(" *");
        topLevelClass.addJavaDocLine(" * @author " + author);
        topLevelClass.addJavaDocLine(" * @blame " + blame);
        topLevelClass.addJavaDocLine(" * @date " + dateFormatter.format(new Date()));
        topLevelClass.addJavaDocLine(" */");
    }

    /**
     * 增加列名注释
     *
     * @param field
     * @param introspectedTable
     * @param introspectedColumn
     */
    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        // 获取列注释
        String remarks = introspectedColumn.getRemarks();
        field.addJavaDocLine("/**");
        field.addJavaDocLine(" * " + remarks);
        field.addJavaDocLine(" */");
    }
}
