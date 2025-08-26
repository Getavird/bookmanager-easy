package com.example.book_manager.config;

import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebServerConfig {
    /**
     * 原理：Spring Boot通过自动配置检测类路径下的Web服务器依赖
     * 当存在多个服务器实现时，可以通过配置或排除依赖来选择
     */

    // 自定义Jetty服务器配置（可选）
    @Bean
    public WebServerFactoryCustomizer<JettyServletWebServerFactory> jettyCustomizer() {
        return factory -> {
            factory.setPort(8080);
            factory.setContextPath("/");
        };
    }

    // 自定义Undertow服务器配置（可选）
    @Bean
    public WebServerFactoryCustomizer<UndertowServletWebServerFactory> undertowCustomizer() {
        return factory -> {
            factory.setPort(8080);
            factory.setContextPath("/");
        };
    }
}
