package com.softskills.softskills.controllers;

import com.softskills.softskills.model.ActivityRequest;
import com.softskills.softskills.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    // Endpoint para obter URLS necessários para o registro de atividades
    @GetMapping("/register-activity")
    public Map<String, Object> getActivityRegistration() {
        return activityService.getActivityRegistration();
    }

    // Endpoint para obter os parâmetros de configuração da atividade
    @GetMapping("/json-params-activity")
    public List<Map<String, String>> getConfigParams() {
        return activityService.getConfigParams();
    }

    // Endpoint para o deploy de uma atividade
    @GetMapping("/deploy-activity/{activityId}")
    public String deployActivity(@PathVariable String activityId) {
        String activityUrl = activityService.generateActivityUrl(activityId);
        return activityUrl;
    }

    // Endpoint para o deploy de uma atividade
    @PostMapping("/provide-activity")
    public ResponseEntity<String> provideActivity(@RequestBody ActivityRequest activityRequest) {
        String activityUrl = activityService.provideActivity(activityRequest);
        return ResponseEntity.ok().body(activityUrl);
    }
}