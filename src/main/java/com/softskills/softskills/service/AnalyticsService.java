package com.softskills.softskills.service;

import com.softskills.softskills.model.Analytics;
import com.softskills.softskills.model.AnalyticsConfig;
import com.softskills.softskills.model.AnalyticsListDTO;
import com.softskills.softskills.model.DTO.AnalyticsFieldDTO;
import com.softskills.softskills.model.DTO.AnalyticsResponseDTO;
import com.softskills.softskills.repositories.AnalyticsConfigRepository;
import com.softskills.softskills.repositories.AnalyticsDataRepository;
import com.softskills.softskills.repositories.AnalyticsRepository;
import com.softskills.softskills.utils.AnalyticsCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AnalyticsService {

    private static final Logger logger = LoggerFactory.getLogger(AnalyticsService.class);

    private final AnalyticsCache analyticsCache;
    private final AnalyticsRepository analyticsRepository;
    private final AnalyticsConfigRepository analyticsConfigRepository;

    public AnalyticsService(AnalyticsCache analyticsCache, AnalyticsRepository analyticsRepository, AnalyticsConfigRepository analyticsConfigRepository) {
        this.analyticsCache = analyticsCache;
        this.analyticsRepository = analyticsRepository;
        this.analyticsConfigRepository = analyticsConfigRepository;
    }

    public Map<String, List<AnalyticsListDTO>> getAnalyticsList() {
        logger.info("Fetching analytics list from cache...");
        Map<String, List<AnalyticsListDTO>> analyticsList = analyticsCache.getAnalyticsList()
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream()
                                .map(map -> new AnalyticsListDTO(map.getName(), map.getType()))
                                .collect(Collectors.toList())
                ));
        logger.info("Analytics list fetched: {}", analyticsList);
        return analyticsList;
    }

    public List<AnalyticsResponseDTO> getAnalyticsByActivityId(String activityId) {
        logger.info("Fetching analytics for activityID: {}", activityId);

        List<Analytics> analyticsList = analyticsRepository.findByActivityId(activityId);

        if (analyticsList.isEmpty()) {
            logger.warn("No analytics found for activityID: {}", activityId);
            return Collections.emptyList();
        }

        List<AnalyticsConfig> configs = analyticsConfigRepository.findAll();
        Map<Long, AnalyticsConfig> configMap = configs.stream()
                .collect(Collectors.toMap(AnalyticsConfig::getId, config -> config));

        Map<String, List<Analytics>> groupedByStudent = analyticsList.stream()
                .collect(Collectors.groupingBy(Analytics::getStudentId));

        List<AnalyticsResponseDTO> response = groupedByStudent.entrySet().stream()
                .map(entry -> {
                    String studentId = entry.getKey();
                    List<Analytics> studentAnalytics = entry.getValue();

                    List<AnalyticsFieldDTO> quantAnalytics = studentAnalytics.stream()
                            .filter(a -> {
                                AnalyticsConfig config = configMap.get(a.getAnalyticId());
                                return config != null && "quantitative".equalsIgnoreCase(config.getType());
                            })
                            .map(a -> {
                                AnalyticsConfig config = configMap.get(a.getAnalyticId());
                                return new AnalyticsFieldDTO(config.getName(), a.getValue());
                            })
                            .collect(Collectors.toList());

                    List<AnalyticsFieldDTO> qualAnalytics = studentAnalytics.stream()
                            .filter(a -> {
                                AnalyticsConfig config = configMap.get(a.getAnalyticId());
                                return config != null && "qualitative".equalsIgnoreCase(config.getType());
                            })
                            .map(a -> {
                                AnalyticsConfig config = configMap.get(a.getAnalyticId());
                                return new AnalyticsFieldDTO(config.getName(), a.getValue());
                            })
                            .collect(Collectors.toList());

                    return new AnalyticsResponseDTO(studentId, quantAnalytics, qualAnalytics);
                })
                .collect(Collectors.toList());

        logger.info("Analytics fetched for activityID {}: {}", activityId, response);
        return response;
    }
}