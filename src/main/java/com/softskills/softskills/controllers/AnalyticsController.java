package com.softskills.softskills.controllers;

import com.softskills.softskills.model.Analytics;
import com.softskills.softskills.service.AnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/analytics")
public class AnalyticsController {

    @Autowired
    private AnalyticsService analyticsService;

    // Endpoint para obter a lista de analytics da atividade
    @GetMapping("/analytics-list")
    public List<Map<String, String>> getAnalyticsList() {
        return analyticsService.getAnalyticsList();
    }

    @PostMapping("/activity")
    public List<Analytics> getActivityAnalytics(@RequestBody Map<String, String> request) {
        String activityId = request.get("activityID"); // Pega o activityID da requisição
        return analyticsService.getAnalyticsForActivity(activityId); // Chama o serviço para buscar os analytics
    }
}