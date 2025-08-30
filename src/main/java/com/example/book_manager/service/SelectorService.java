package com.example.book_manager.service;

import org.springframework.stereotype.Service;

/**
 * 通过 ImportSelector 动态导入的服务类
 */
@Service
public class SelectorService {
    
    public String getMessage() {
        return "这是通过 ImportSelector 动态导入的 Bean 类";
    }
}