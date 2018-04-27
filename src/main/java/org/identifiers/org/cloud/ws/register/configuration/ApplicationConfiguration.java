package org.identifiers.org.cloud.ws.register.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.configuration
 * Timestamp: 2018-01-30 22:37
 * ---
 */
@Configuration
//@Profile({"production", "standalone"})
public class ApplicationConfiguration {
    // Production Environment Application Configuration

    @Value("${org.identifiers.cloud.ws.register.cors.origin}")
    private String corsOrigins;

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins(corsOrigins.split(","));
            }
        };
    }
}
