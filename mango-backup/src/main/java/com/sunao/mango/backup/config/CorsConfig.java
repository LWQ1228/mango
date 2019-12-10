package com.sunao.mango.backup.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * CorsConfig（跨域请求配置，每当客户端发送请求时，都会在头部附上跨域信息）
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/10 9:16
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //允许跨域访问的路径
        registry.addMapping("/**")
                //允许跨域访问的源
                .allowedOrigins("*")
                //允许请求的方法
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                //预检间隔时间
                .maxAge(168000)
                //允许头部重置
                .allowedHeaders("*")
                //是否发送cookie
                .allowCredentials(true);
    }
}
