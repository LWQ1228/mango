package com.sunao.mango.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * RibbonHelloController
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/13 13:45
 */
@RestController
public class RibbonHelloController {
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 模拟调用服务端提供的hello方法
     *
     * @return 返回结果
     */
    @RequestMapping("/ribbon/call")
    public String call() {
        //调用服务，service-producer为注册的服务名称
        String callServiceResult = restTemplate.getForObject("http://mango-producer/hello", String.class);
        System.out.println(callServiceResult);
        return callServiceResult;
    }
}
