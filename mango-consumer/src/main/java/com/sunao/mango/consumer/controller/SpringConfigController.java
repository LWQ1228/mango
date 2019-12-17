package com.sunao.mango.consumer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SpringConfigController
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/17 15:30
 */
@RefreshScope
@RestController
public class SpringConfigController {
    @Value("${hello}")
    private String hello;

    @RequestMapping("/hello")
    public String from() {
        return this.hello;
    }
}
