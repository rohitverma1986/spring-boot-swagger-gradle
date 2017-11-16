package com.ORG_NAME.application;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
import com.wordnik.swagger.model.ApiInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@EnableSwagger
@ComponentScan(value = "com.ORG_NAME")
public class Application {

    public static void main(String[] args) {
        System.out.println("Hello world");
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private SpringSwaggerConfig springSwaggerConfig;

    public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
        this.springSwaggerConfig = springSwaggerConfig;
    }

    @Bean
    public SwaggerSpringMvcPlugin customImplementation() {
        return new SwaggerSpringMvcPlugin(this.springSwaggerConfig).apiInfo(
                apiInfo()).includePatterns("/*.*");
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo("<ORGANISATION NAME> API", "API for <ORGANISATION NAME>",
                "<ORGANISATION NAME> API terms of service", "<SUPPORT GROUP>@<ORGANISATION DOMAIN>",
                "<ORGANISATION NAME> API Licence Type", "<ORGANISATION NAME> API License URL");
        return apiInfo;
    }
}
