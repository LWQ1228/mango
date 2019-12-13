package com.sunao.mango.consumer.controller;

import com.sunao.mango.consumer.feign.service.MangoProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * FeignHelloController
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/13 14:10
 */
@RestController
public class FeignHelloController {
    @Autowired
    private MangoProducerService mangoProducerService;

    @RequestMapping("/feign/call")
    public String call() {
        //像调用本地服务一样
        return mangoProducerService.hello();
    }
}
