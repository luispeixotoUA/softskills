package com.softskills.softskills.utils;

import com.softskills.softskills.model.AnalyticsConfig;
import com.softskills.softskills.model.AnalyticsListDTO;
import com.softskills.softskills.repositories.AnalyticsConfigRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class AnalyticsCache {

    private static final Logger logger = LoggerFactory.getLogger(AnalyticsCache.class);

    private final AnalyticsConfigRepository analyticsConfigRepository;

    private Map<String, List<AnalyticsListDTO>> analyticsList;

    public AnalyticsCache(AnalyticsConfigRepository analyticsConfigRepository) {
        this.analyticsConfigRepository = analyticsConfigRepository;
        logger.info("Initializing AnalyticsCache...");
        refreshCache();
    }

    public void refreshCache() {
        logger.info("Refreshing analytics cache...");
        List<AnalyticsConfig> configs = analyticsConfigRepository.findAll();

        analyticsList = new HashMap<>();
        analyticsList.put("qualAnalytics", filterAnalyticsByType(configs, "qualitative"));
        analyticsList.put("quantAnalytics", filterAnalyticsByType(configs, "quantitative"));

        logger.info("Analytics cache refreshed successfully.");
    }

    private List<AnalyticsListDTO> filterAnalyticsByType(List<AnalyticsConfig> configs, String type) {
        return configs.stream()
                .filter(config -> type.equalsIgnoreCase(config.getType()))
                .map(config -> new AnalyticsListDTO(config.getName(), config.getDataType()))
                .collect(Collectors.toList());
    }

    public Map<String, List<AnalyticsListDTO>> getAnalyticsList() {
        if (analyticsList == null) {
            logger.warn("Analytics cache is empty. Refreshing cache...");
            refreshCache();
        }
        return analyticsList;
    }
}