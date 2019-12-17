package com.sunao.mango.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * MangoConfigApplication 服务消费（Ribbon、Feign）
 * 添加@EnableConfigServer注解，开启配置服务支持
 * 添加@EnableDiscoveryClient注解，开启服务发现支持
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/13 12:17
 */
@EnableConfigServer
@EnableDiscoveryClient
@SpringBootApplication
public class MangoConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(MangoConfigApplication.class, args);
    }

}
