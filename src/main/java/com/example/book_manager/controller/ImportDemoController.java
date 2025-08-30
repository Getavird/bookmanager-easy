package com.example.book_manager.controller;

import com.example.book_manager.service.ImportedService;
import com.example.book_manager.service.SelectorService;
import com.example.book_manager.service.RegistrarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试 @Import 三种用法的控制器
 */
@RestController
public class ImportDemoController {

    @Autowired(required = false)
    private ImportedService importedService;

    @Autowired(required = false)
    private SelectorService selectorService;

    @Autowired(required = false)
    private RegistrarService registrarService;

    @GetMapping("/test/import")
    public String testImport() {
        StringBuilder result = new StringBuilder();

        if (importedService != null) {
            result.append(importedService.getMessage()).append("<br/>");
        } else {
            result.append("ImportedService 未找到<br/>");
        }

        if (selectorService != null) {
            result.append(selectorService.getMessage()).append("<br/>");
        } else {
            result.append("SelectorService 未找到<br/>");
        }

        if (registrarService != null) {
            result.append(registrarService.getMessage()).append("<br/>");
        } else {
            result.append("RegistrarService 未找到<br/>");
        }

        return result.toString();
    }
}
