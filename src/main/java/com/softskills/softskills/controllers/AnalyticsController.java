package com.softskills.softskills.controllers;

import com.softskills.softskills.facade.SoftSkillsFacade;
import com.softskills.softskills.model.AnalyticsListDTO;
import com.softskills.softskills.model.DTO.AnalyticsResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/analytics")
public class AnalyticsController {

    private static final Logger logger = LoggerFactory.getLogger(AnalyticsController.class);

    @Autowired
    private SoftSkillsFacade facade;

    /**
     * Endpoint para listar as métricas analíticas.
     */
    @GetMapping("/analytics-list")
    public Map<String, List<AnalyticsListDTO>> getAnalyticsList() {
        logger.info("GET request received: /analytics-list");

        Map<String, List<AnalyticsListDTO>> analyticsList = facade.listAnalytics();

        if (analyticsList.isEmpty()) {
            logger.warn("No analytics data found in the cache.");
        } else {
            logger.info("Analytics data successfully retrieved: {}", analyticsList);
        }

        return analyticsList;
    }

    /**
     * Endpoint para obter detalhes analíticos de uma atividade específica.
     */
    @PostMapping("/activity")
    public ResponseEntity<List<AnalyticsResponseDTO>> getActivityAnalytics(@RequestBody Map<String, String> request) {
        String activityId = request.get("activityID");
        logger.info("POST request received: /activity with activityID: {}", activityId);

        List<AnalyticsResponseDTO> analytics = facade.getActivityAnalytics(activityId);

        if (analytics.isEmpty()) {
            logger.warn("No analytics found for activityID: {}", activityId);
            return ResponseEntity.notFound().build();
        }

        logger.info("Analytics found for activityID {}: {}", activityId, analytics);
        return ResponseEntity.ok(analytics);
    }
}