package com.sunao.mango.backup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * MangoBackupApplication
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/10 9:15
 */
@SpringBootApplication(scanBasePackages = {"com.sunao.mango"})
public class MangoBackupApplication {

    public static void main(String[] args) {
        SpringApplication.run(MangoBackupApplication.class, args);
    }

}
