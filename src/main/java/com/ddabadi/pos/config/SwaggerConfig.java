package com.ddabadi.pos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Created with IntelliJ IDEA.
 * User: deddy
 * Date: 11/5/17
 * Time: 10:33 PM
 * To change this template use File | Settings | File Templates.
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket barangApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ddabadi.pos.rest.CategoryBarangController"))
                .paths(regex("/categoryBarang.*"))
                .build();
    }

}
