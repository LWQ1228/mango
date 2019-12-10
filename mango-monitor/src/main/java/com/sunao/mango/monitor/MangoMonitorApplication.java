package com.sunao.mango.monitor;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * MangoMonitorApplication
 * 添加@EnableAdminServer注解，开启监控服务
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/10 13:40
 */
@EnableAdminServer
@SpringBootApplication
public class MangoMonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(MangoMonitorApplication.class, args);
    }

}
