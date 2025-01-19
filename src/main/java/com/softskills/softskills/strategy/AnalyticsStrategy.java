package com.softskills.softskills.strategy;

import com.softskills.softskills.model.Analytics;
import com.softskills.softskills.model.AnalyticsConfig;
import com.softskills.softskills.model.DTO.AnalyticsFieldDTO;

import java.util.List;
import java.util.Map;

public interface AnalyticsStrategy {
    List<AnalyticsFieldDTO> processAnalytics(List<Analytics> analytics, Map<Long, AnalyticsConfig> configMap);
}