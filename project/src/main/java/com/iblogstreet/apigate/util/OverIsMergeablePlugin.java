package com.iblogstreet.apigate.util;


import org.mybatis.generator.api.GeneratedXmlFile;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;

import java.lang.reflect.Field;
import java.util.List;

/**
 * 重写插件解决Mybatis code generator覆盖问题
 * 使用方式在generatorConfig.xml中使用
 *  <context id="DB2Tables" targetRuntime="MyBatis3">
    <plugin type="com.caijicn.utils.generator.OverIsMergeablePlugin"/>
      ....
 */
public class OverIsMergeablePlugin extends PluginAdapter {
    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public boolean sqlMapGenerated(GeneratedXmlFile sqlMap, IntrospectedTable introspectedTable) {
        try {
            Field field = sqlMap.getClass().getDeclaredField("isMergeable");
            field.setAccessible(true);
            field.setBoolean(sqlMap, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}