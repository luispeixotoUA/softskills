package com.softskills.softskills.service;

import com.softskills.softskills.model.ActivityRequest;
import com.softskills.softskills.utils.ConfigParamsUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class ActivityService {

    // Ler o URL base do arquivo de configuração (application.properties)
    @Value("${activity.baseUrl}")
    private String baseUrl;

    public Map<String, Object> getActivityRegistration() {
        Map<String, Object> activity = new LinkedHashMap<>();
        activity.put("name", "SoftSk!lls");
        activity.put("config_url", baseUrl + "/config-activity");
        activity.put("json_params_url", baseUrl + "/json-params-activity");
        activity.put("user_url", baseUrl + "/deploy-activity/123");
        activity.put("analytics_url", baseUrl + "/analytics/activity");
        activity.put("analytics_list_url", baseUrl + "/analytics/analytics-list");

        return activity;
    }


    public List<Map<String, String>> getConfigParams() {
        // Chama a classe de utilidades para obter os parâmetros de configuração
        return ConfigParamsUtils.getConfigParams();
    }

    // Método para gerar o URL da atividade
    public String generateActivityUrl(String activityId) {
        String urlActivity = baseUrl + "/deploy_ativity";
        return urlActivity + "/" + activityId;
    }

    // Endpoint para o deploy de uma atividade
    public String provideActivity(ActivityRequest activityRequest) {
        String activityUrl = baseUrl + "/activity/" + activityRequest.getActivityID() + "?studentID=" + activityRequest.getInvenIRAstdID();
        return activityUrl;
    }


}