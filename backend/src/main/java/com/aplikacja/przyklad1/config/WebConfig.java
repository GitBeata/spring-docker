package com.aplikacja.przyklad1.config;

import org.springframework.web.servlet.config.annotation.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.CONTEXT.annotation.Configuration;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMapping(CorsRegistry registry) {
        registry.addMapping("/**").AllowedOrigins("http://localhost:8080");
    }

}
