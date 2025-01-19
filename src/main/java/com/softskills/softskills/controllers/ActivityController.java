package com.softskills.softskills.controllers;

import com.softskills.softskills.facade.SoftSkillsFacade;
import com.softskills.softskills.model.ActivityRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ActivityController {

    @Autowired
    private SoftSkillsFacade facade;

    // Endpoint para obter URLS necessários para o registro de atividades
    @GetMapping("/register-activity")
    public Map<String, Object> getActivityRegistration() {
        return facade.registerActivity();
    }

    // Endpoint para obter os parâmetros de configuração da atividade
    @GetMapping("/json-params-activity")
    public List<Map<String, String>> getConfigParams() {
        return facade.getActivityParams();
    }

    // Endpoint para o deploy de uma atividade
    @GetMapping("/deploy-activity/{activityId}")
    public String deployActivity(@PathVariable String activityId) {
        return facade.deployActivity(activityId);
    }

    // Endpoint para o deploy de uma atividade
    @PostMapping("/provide-activity")
    public ResponseEntity<String> provideActivity(@RequestBody ActivityRequest activityRequest) {
        return ResponseEntity.ok().body(facade.provideActivity(activityRequest));
    }
}