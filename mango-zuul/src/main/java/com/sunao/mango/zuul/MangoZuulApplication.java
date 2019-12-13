package com.sunao.mango.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * MangoZuulApplication 服务网关
 * 添加@EnableZuulProxy注解，开启服务网关支持
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/13 11:30
 */
@EnableZuulProxy
@SpringBootApplication
public class MangoZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(MangoZuulApplication.class, args);
    }

}
