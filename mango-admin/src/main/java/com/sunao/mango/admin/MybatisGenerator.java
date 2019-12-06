package com.sunao.mango.admin;

import org.hibernate.validator.internal.util.privilegedactions.GetResource;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * MybatisGenerator
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/05
 */
public class MybatisGenerator {
    /**
     * 主函数
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        List<String> warnings = new ArrayList<>();
        //取得配置文件路径
        String filePath = GetResource.class.getClassLoader().getResource("generatorConfig.xml").getPath();
        //实例化文件
        File configFile = new File(filePath);
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(true);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        //生成文件
        myBatisGenerator.generate(null);
    }
}
