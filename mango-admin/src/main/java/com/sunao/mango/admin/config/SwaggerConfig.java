package com.sunao.mango.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * SwaggerConfig（通过注解EnableSwagger2声明Swagger的可用性）
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/04
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        //添加请求参数，我们这里吧token作为请求头部参数传入后端
        ParameterBuilder parameterBuilder = new ParameterBuilder();
        List<Parameter> parameters = new ArrayList<>();
        //由于引入Spring Security安全框架，接口受到保护，需要携带合法的token才可以正常访问
        parameterBuilder.name("token").description("令牌").modelRef(new ModelRef("string"))
                .parameterType("header").required(false).build();
        parameters.add(parameterBuilder.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                // 选择哪些路径和api会生成document
                .select()
                // 对所有api进行监控
                .apis(RequestHandlerSelectors.any())
                // 对所有路径进行监控
                .paths(PathSelectors.any())
                .build().globalOperationParameters(parameters);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().build();
    }
}
