package com.example.book_manager.annotation;

import com.example.book_manager.config.CustomFeatureConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 原理：@Enable注解本质上是使用@Import导入配置类
 * 通过这种方式实现模块化配置和功能开关
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(CustomFeatureConfiguration.class)
public @interface EnableCustomFeature {
    boolean value() default true;
}
