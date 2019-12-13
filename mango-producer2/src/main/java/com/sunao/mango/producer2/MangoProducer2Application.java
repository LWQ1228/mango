package com.sunao.mango.producer2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * MangoProducer2Application
 * 添加@EnableDiscoveryClient注解，开启服务发现支持
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/13 11:30
 */
@EnableDiscoveryClient
@SpringBootApplication
public class MangoProducer2Application {

    public static void main(String[] args) {
        SpringApplication.run(MangoProducer2Application.class, args);
    }

}
