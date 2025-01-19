package com.softskills.softskills.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConfigPageController {
    @GetMapping("/config-activity")
    public String getConfigPage() {
        // Retorna o nome do arquivo HTML
        return "configuration";
    }

}
