package com.sunao.mango.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * MangoApplication
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/04
 */
@SpringBootApplication(scanBasePackages = {"com.sunao.mango"})
public class MangoAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(MangoAdminApplication.class, args);
    }

}
