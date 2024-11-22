package com.softskills.softskills.controllers;

import com.softskills.softskills.entity.ConfigParameters;
import com.softskills.softskills.service.ConfigParametersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/config")
public class ConfigParametersController {

    @Autowired
    private ConfigParametersService configParametersService;

    @GetMapping("/all")
    public List<ConfigParameters> getAllConfigParameters() {
        return configParametersService.getAllConfigParameters();
    }

    @PostMapping("/add")
    public void addConfigParameter(@RequestBody ConfigParameters configParameters) {
        configParametersService.saveConfigParameter(configParameters);
    }
}
