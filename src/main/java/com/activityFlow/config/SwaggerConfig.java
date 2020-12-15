package com.activityFlow.config;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author liufenming <liu.fenming@chinaott.onaliyun.com>
 * @Date: 2020/12/15
 * @Description
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .select()
                //暴露全部接口
                //.apis(RequestHandlerSelectors.basePackage("com.activityFlow.controller"))
                //只暴露添加了该注解的接口
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.any())
                .build().apiInfo(new ApiInfoBuilder()
                        .title("ActivityFlow服务接口文档")
                        .description("工作流测试")
                        .version("1.0")
                        .contact(new Contact("yue", "", ""))
                        .license("")
                        .licenseUrl("")
                        .build());
        //访问地址 ，原生 /swagger-ui.html ，knife4j美化 /doc.html
    }
}
