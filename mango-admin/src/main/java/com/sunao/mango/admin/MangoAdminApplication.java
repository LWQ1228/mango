package com.sunao.mango.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * MangoAdminApplication
 * 添加@EnableDiscoveryClient注解，开启服务发现支持
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/04
 */
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"com.sunao.mango"})
public class MangoAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(MangoAdminApplication.class, args);
    }

}
