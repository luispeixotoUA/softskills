package com.softskills.softskills.service;

import com.softskills.softskills.model.ActivityRequest;
import com.softskills.softskills.model.ConfigParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ActivityService {

    // Ler o URL base do arquivo de configuração (application.properties)
    @Value("${softskills.api.base-url}")
    private String baseUrl;

    @Value("${softskills.api.config}")
    private String configUrl;

    @Value("${softskills.api.jsonParams}")
    private String jsonParamsUrl;

    @Value("${softskills.api.deploy}")
    private String deployUrl;

    @Value("${softskills.api.analytics}")
    private String analyticsUrl;

    @Value("${softskills.api.analyticsList}")
    private String analyticsListUrl;

    private final ConfigParamsService configParamsService;

    public ActivityService(ConfigParamsService configParamsService) {
        this.configParamsService = configParamsService;
    }

    public Map<String, Object> getActivityRegistration() {
        Map<String, Object> activity = new LinkedHashMap<>();
        activity.put("name", "SoftSk!lls");
        activity.put("config_url", configUrl);
        activity.put("json_params_url", jsonParamsUrl);
        activity.put("user_url", deployUrl + "/{activityId}");
        activity.put("analytics_url", analyticsUrl);
        activity.put("analytics_list_url", analyticsListUrl);

        return activity;
    }


    public List<Map<String, String>> getConfigParams() {
        List<ConfigParam> params = configParamsService.getAllParams();

        return params.stream().map(param -> {
            Map<String, String> paramMap = Map.of(
                    "name", param.getName(),
                    "type", param.getType()
            );
            return paramMap;
        }).collect(Collectors.toList());
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