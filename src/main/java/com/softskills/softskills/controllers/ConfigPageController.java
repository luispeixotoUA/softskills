package com.softskills.softskills.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/config")
public class ConfigPageController {

    @GetMapping("/activity-config")
    public String getConfigPage() {
        // Retorna o nome do arquivo HTML
        return "configuration";
    }


}
