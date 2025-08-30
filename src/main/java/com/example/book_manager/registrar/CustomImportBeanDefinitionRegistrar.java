package com.example.book_manager.registrar;

import com.example.book_manager.service.RegistrarService;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 原理：ImportBeanDefinitionRegistrar允许编程式注册Bean定义
 * 提供了最大的灵活性，可以完全控制Bean的创建过程
 */
public class CustomImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, 
                                      BeanDefinitionRegistry registry) {
        // 编程式创建Bean定义
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(RegistrarService.class);
        
        // 注册Bean定义
        registry.registerBeanDefinition("registrarService", beanDefinition);
    }
}
