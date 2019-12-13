package com.sunao.mango.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * MangoHystrixApplication 服务熔断（Hystrix、Turbine）
 * 添加@EnableTurbine注解，开启Turbine支持
 * 添加@EnableHystrixDashboard注解，开启熔断监控支持
 * 添加@EnableDiscoveryClient注解，开启服务发现支持
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/13 14:42
 */
@EnableTurbine
@EnableHystrixDashboard
@EnableDiscoveryClient
@SpringBootApplication
public class MangoHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(MangoHystrixApplication.class, args);
    }

}
