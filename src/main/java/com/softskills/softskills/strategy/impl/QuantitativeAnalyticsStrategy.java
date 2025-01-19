package com.softskills.softskills.strategy.impl;

import com.softskills.softskills.model.Analytics;
import com.softskills.softskills.model.AnalyticsConfig;
import com.softskills.softskills.model.DTO.AnalyticsFieldDTO;
import com.softskills.softskills.strategy.AnalyticsStrategy;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class QuantitativeAnalyticsStrategy implements AnalyticsStrategy {
    @Override
    public List<AnalyticsFieldDTO> processAnalytics(List<Analytics> analytics, Map<Long, AnalyticsConfig> configMap) {
        return analytics.stream()
                .filter(a -> {
                    AnalyticsConfig config = configMap.get(a.getAnalyticId());
                    return config != null && "quantitative".equalsIgnoreCase(config.getType());
                })
                .map(a -> {
                    AnalyticsConfig config = configMap.get(a.getAnalyticId());
                    return new AnalyticsFieldDTO(config.getName(), a.getValue());
                })
                .collect(Collectors.toList());
    }
}