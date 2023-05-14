package com.bhx.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


public class MyWebConfig {
    @Bean
    public InternalResourceViewResolver jspViewResolver() {
        InternalResourceViewResolver resolver= new InternalResourceViewResolver();
        resolver.setPrefix("/htmlviews/");
        resolver.setSuffix(".html");
        return resolver;
    }
}
