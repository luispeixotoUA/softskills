package com.softskills.softskills.service;

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
        activity.put("config_url", baseUrl + "/configuracao-atividade.html");
        activity.put("json_params_url", baseUrl + "/json-params-atividade");
        activity.put("user_url", baseUrl + "/deploy-atividade");
        activity.put("analytics_url", baseUrl + "/analytics-atividade");
        activity.put("analytics_list_url", baseUrl + "/lista-analytics-atividade");

        return activity;
    }


    public List<Map<String, String>> getConfigParams() {
        // Chama a classe de utilidades para obter os parâmetros de configuração
        return ConfigParamsUtils.getConfigParams();
    }

    // Método para gerar o URL da atividade
    public String generateActivityUrl(String activityId) {
        // Aqui, você pode construir o URL baseado no activityId
        String urlActivity = baseUrl + "/deploy_ativity";
        return urlActivity + "/" + activityId;
    }

    // Método para gerar o URL do deploy da atividade
    public String generateDeployUrl(String activityID, String studentID, Map<String, Object> jsonParams) {
        // Criar o URL de deploy para a atividade usando o ID da atividade e do estudante
        String deployUrl = baseUrl + "/atividade/" + activityID;

        // Adiciona os parâmetros da atividade à URL (se houver algum parâmetro extra)
        StringBuilder urlBuilder = new StringBuilder(deployUrl);
        urlBuilder.append("?studentId=").append(studentID);

        // Convertendo os parâmetros JSON para um formato de query string simples
        if (jsonParams != null && !jsonParams.isEmpty()) {
            jsonParams.forEach((key, value) -> urlBuilder.append("&")
                    .append(key).append("=").append(value));
        }

        return urlBuilder.toString(); // Retorna a URL com os parâmetros de configuração
    }


}