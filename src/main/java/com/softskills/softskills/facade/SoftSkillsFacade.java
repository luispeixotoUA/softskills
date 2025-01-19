package com.softskills.softskills.facade;

import com.softskills.softskills.model.ActivityRequest;
import com.softskills.softskills.model.AnalyticsListDTO;
import com.softskills.softskills.model.DTO.AnalyticsResponseDTO;
import com.softskills.softskills.service.ActivityService;
import com.softskills.softskills.service.AnalyticsService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class SoftSkillsFacade {

    private final ActivityService activityService;
    private final AnalyticsService analyticsService;

    // Métodos relacionados com analíticos
    public SoftSkillsFacade(ActivityService activityService, AnalyticsService analyticsService) {
        this.activityService = activityService;
        this.analyticsService = analyticsService;
    }

    // Métodos relacionados com atividades
    public Map<String, Object> registerActivity() {
        return activityService.getActivityRegistration();
    }

    public List<Map<String, String>> getActivityParams() {
        return activityService.getConfigParams();
    }

    public String deployActivity(String activityId) {
        return activityService.generateActivityUrl(activityId);
    }

    public String provideActivity(ActivityRequest activityRequest) {
        return activityService.provideActivity(activityRequest);
    }

    public Map<String, List<AnalyticsListDTO>> listAnalytics() {
        return analyticsService.getAnalyticsList();
    }

    public List<AnalyticsResponseDTO> getActivityAnalytics(String activityId) {
        return analyticsService.getAnalyticsByActivityId(activityId);
    }
}