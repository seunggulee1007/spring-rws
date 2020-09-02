package com.inno.rws.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.ant("/**"))
                .build()
                .apiInfo(apiInfo())
                ;
    }
    
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "REST API",
                "External service",
                "REST API",
                "Terms of services",
                new Contact("lee seunggu", "localhost:9090", "leesg107@naver.com"),
                "License of API", "API license URL", Collections.emptyList());
    }
}
