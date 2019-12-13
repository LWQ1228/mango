package com.sunao.mango.consumer.feign.service;

import org.springframework.stereotype.Component;

/**
 * MangoProducerHystrix
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/13 14:28
 */
@Component
public class MangoProducerHystrix implements MangoProducerService {
    /**
     * Hystrix熔断器
     *
     * @return 返回调用失败后的信息
     */
    @Override
    public String hello() {
        return "Sorry, hello service call failed.";
    }
}
