package com.example.book_manager.selector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 原理：ImportSelector接口允许编程式选择要导入的配置类
 * 可以根据条件动态决定导入哪些配置
 */
public class CustomImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        // 这里可以添加复杂的条件逻辑
        return new String[]{
                "com.example.book_manager.service.SelectorService"
        };
    }
}
