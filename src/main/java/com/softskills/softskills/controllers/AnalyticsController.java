package com.softskills.softskills.controllers;

import com.softskills.softskills.model.Analytics;
import com.softskills.softskills.model.AnalyticsListDTO;
import com.softskills.softskills.model.DTO.AnalyticsResponseDTO;
import com.softskills.softskills.service.AnalyticsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/analytics")
public class AnalyticsController {

    private static final Logger logger = LoggerFactory.getLogger(AnalyticsController.class);
    @Autowired
    private AnalyticsService analyticsService;

    @GetMapping("/analytics-list")
    public Map<String, List<AnalyticsListDTO>> getAnalyticsList() {
        logger.info("GET request received: /analytics-list");
        Map<String, List<AnalyticsListDTO>> analyticsList = analyticsService.getAnalyticsList();
        logger.info("Response sent: {}", analyticsList);
        return analyticsList;
    }

    @PostMapping("/activity")
    public ResponseEntity<List<AnalyticsResponseDTO>> getActivityAnalytics(@RequestBody Map<String, String> request) {
        String activityId = request.get("activityID");
        logger.info("POST request received: /activity with activityID: {}", activityId);
        List<AnalyticsResponseDTO> analytics = analyticsService.getAnalyticsByActivityId(activityId);
        if (analytics.isEmpty()) {
            logger.warn("No analytics found for activityID: {}", activityId);
            return ResponseEntity.notFound().build();
        }
        logger.info("Analytics found for activityID {}: {}", activityId, analytics);
        return ResponseEntity.ok(analytics);
    }
}