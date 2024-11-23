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

    // Endpoint para o ficheiro de registo de uma atividade
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
        // Chama o serviço para gerar o URL para a atividade
        String activityUrl = activityService.generateActivityUrl(activityId);
        return activityUrl; // Retorna o URL para onde os alunos serão redirecionados
    }

    // Endpoint para o deploy de uma atividade
    @PostMapping("/provide-activity")
    public ResponseEntity<String> provideActivity(@RequestBody ActivityRequest activityRequest) {
        // Aqui você pode validar e processar os parâmetros, mas por enquanto só vai retornar uma resposta genérica
        // Isso pode ser ajustado mais tarde quando a segunda fase estiver implementada

        // O endpoint só vai retornar um URL fictício por enquanto
        String activityUrl = "http://activityprovider.com/activity/" + activityRequest.getActivityID() + "?studentID=" + activityRequest.getInvenIRAstdID();

        // A resposta pode ser personalizada conforme o que será necessário no futuro
        return ResponseEntity.ok(activityUrl);
    }
}