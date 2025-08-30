package com.example.book_manager.service;

import org.springframework.stereotype.Service;

/**
 * 通过 ImportBeanDefinitionRegistrar 编程式注册的服务类
 */
@Service
public class RegistrarService {

    public String getMessage() {
        return "这是通过 ImportBeanDefinitionRegistrar 编程式注册的 Bean 类";
    }
}
