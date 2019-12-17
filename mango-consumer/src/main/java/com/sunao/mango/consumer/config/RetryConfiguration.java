package com.sunao.mango.consumer.config;

import org.springframework.amqp.rabbit.config.RetryInterceptorBuilder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.retry.interceptor.RetryOperationsInterceptor;

/**
 * RetryConfiguration
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/17 15:48
 */
public class RetryConfiguration {
    @Bean
    @ConditionalOnMissingBean(name = "configServerRetryInterceptor")
    public RetryOperationsInterceptor configServerRetryInterceptor() {
        return RetryInterceptorBuilder.stateless().backOffOptions(1000, 1.2, 5000).maxAttempts(10).build();
    }
}
