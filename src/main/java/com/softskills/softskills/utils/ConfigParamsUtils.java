package com.softskills.softskills.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigParamsUtils {

    public static List<Map<String, String>> getConfigParams() {
        List<Map<String, String>> params = new ArrayList<>();

        // Adicionando os parâmetros de configuração com a ordem desejada
        params.add(createParam("activity_info_url", "url"));
        params.add(createParam("question_1", "text/plain"));
        params.add(createParam("question_1_option_1", "text/plain"));
        params.add(createParam("question_1_option_2", "text/plain"));
        params.add(createParam("question_1_option_3", "text/plain"));
        params.add(createParam("question_1_option_4", "text/plain"));
        params.add(createParam("question_1_correct_answer", "integer"));
        params.add(createParam("question_2", "text/plain"));
        params.add(createParam("question_2_option_1", "text/plain"));
        params.add(createParam("question_2_option_2", "text/plain"));
        params.add(createParam("question_2_option_3", "text/plain"));
        params.add(createParam("question_2_option_4", "text/plain"));
        params.add(createParam("question_2_correct_answer", "integer"));
        params.add(createParam("reward_level_1", "text/plain"));
        params.add(createParam("reward_level_2", "text/plain"));
        params.add(createParam("certificate_url", "url"));
        params.add(createParam("feedback_material_intermediate", "text/plain"));
        params.add(createParam("support_material_repeat", "text/plain"));

        return params;
    }

    private static Map<String, String> createParam(String name, String type) {
        Map<String, String> param = new HashMap<>();
        param.put("name", name);
        param.put("type", type);
        return param;
    }
}