package com.example.book_manager.config;

import com.example.book_manager.service.ImportedService;
import com.example.book_manager.selector.CustomImportSelector;
import com.example.book_manager.registrar.CustomImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Import的三种用法：
 * 1. 直接导入配置类
 * 2. 导入ImportSelector实现
 * 3. 导入ImportBeanDefinitionRegistrar实现
 */
@Configuration
@Import({
        ImportedService.class,                    // 1. 直接导入Bean类
        CustomImportSelector.class,               // 2. 导入ImportSelector
        CustomImportBeanDefinitionRegistrar.class // 3. 导入ImportBeanDefinitionRegistrar
})
public class ImportDemoConfig {
}
