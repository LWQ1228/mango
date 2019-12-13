package com.sunao.mango.producer2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/13 11:42
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello() {
        return "Hello Mango2!";
    }
}
