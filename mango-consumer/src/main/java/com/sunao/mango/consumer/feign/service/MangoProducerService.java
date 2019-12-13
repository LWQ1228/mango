package com.sunao.mango.consumer.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * MangoProducerService
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/13 14:08
 */
@FeignClient(name = "mango-producer")
public interface MangoProducerService {
    /**
     * Feign接口
     *
     * @return Feign调用结果
     */
    @RequestMapping("/hello")
    String hello();
}
