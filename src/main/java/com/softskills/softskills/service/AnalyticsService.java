package com.softskills.softskills.service;

import com.softskills.softskills.model.Analytics;
import com.softskills.softskills.model.AnalyticsField;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AnalyticsService {

    public Map<String, List<Map<String, String>>> getAnalyticsList() {
        Map<String, List<Map<String, String>>> analyticsList = new HashMap<>();

        // Lista de analytics qualitativos
        List<Map<String, String>> qualAnalytics = new ArrayList<>();
        addAnalytics(qualAnalytics, "access_info_before_answering", "boolean");
        addAnalytics(qualAnalytics, "participation_in_quiz", "boolean");

        // Lista de analytics quantitativos
        List<Map<String, String>> quantAnalytics = new ArrayList<>();
        addAnalytics(quantAnalytics, "accessed_activity", "boolean");
        addAnalytics(quantAnalytics, "activity_completion_time", "integer");
        addAnalytics(quantAnalytics, "correct_answers_quiz", "integer");
        addAnalytics(quantAnalytics, "incorrect_answers_quiz", "integer");
        addAnalytics(quantAnalytics, "accuracy_percentage", "number");
        addAnalytics(quantAnalytics, "reward_level_achieved", "integer");
        addAnalytics(quantAnalytics, "reaction_time", "integer");
        addAnalytics(quantAnalytics, "feedback_received", "boolean");
        addAnalytics(quantAnalytics, "certificate_issued", "boolean");

        // Adiciona as listas ao mapa
        analyticsList.put("qualAnalytics", qualAnalytics);
        analyticsList.put("quantAnalytics", quantAnalytics);

        return analyticsList;
    }

    private void addAnalytics(List<Map<String, String>> analyticsList, String name, String type) {
        Map<String, String> analytics = new HashMap<>();
        analytics.put("name", name);
        analytics.put("type", type);
        analyticsList.add(analytics);
    }

    public List<Analytics> getAnalyticsForActivity(String activityId) {
        // Lista de dados analíticos para todos os estudantes
        List<Analytics> analytics = new ArrayList<>();

        // Exemplo de analytics para o primeiro estudante
        List<AnalyticsField> quantAnalytics1 = new ArrayList<>();
        quantAnalytics1.add(new AnalyticsField("accessed_activity", true));
        quantAnalytics1.add(new AnalyticsField("activity_completion_time", 120));
        quantAnalytics1.add(new AnalyticsField("correct_answers_quiz", 8));
        quantAnalytics1.add(new AnalyticsField("incorrect_answers_quiz", 2));
        quantAnalytics1.add(new AnalyticsField("accuracy_percentage", 80));
        quantAnalytics1.add(new AnalyticsField("reward_level_achieved", 2));
        quantAnalytics1.add(new AnalyticsField("reaction_time", 500));
        quantAnalytics1.add(new AnalyticsField("feedback_received", true));
        quantAnalytics1.add(new AnalyticsField("certificate_issued", true));

        List<AnalyticsField> qualAnalytics1 = new ArrayList<>();
        qualAnalytics1.add(new AnalyticsField("access_info_before_answering", true));
        qualAnalytics1.add(new AnalyticsField("participation_in_quiz", true));

        Analytics student1Analytics = new Analytics("1001", quantAnalytics1, qualAnalytics1);
        analytics.add(student1Analytics);

        // Exemplo de analytics para o segundo estudante
        List<AnalyticsField> quantAnalytics2 = new ArrayList<>();
        quantAnalytics2.add(new AnalyticsField("accessed_activity", true));
        quantAnalytics2.add(new AnalyticsField("activity_completion_time", 140));
        quantAnalytics2.add(new AnalyticsField("correct_answers_quiz", 7));
        quantAnalytics2.add(new AnalyticsField("incorrect_answers_quiz", 3));
        quantAnalytics2.add(new AnalyticsField("accuracy_percentage", 70));
        quantAnalytics2.add(new AnalyticsField("reward_level_achieved", 1));
        quantAnalytics2.add(new AnalyticsField("reaction_time", 550));
        quantAnalytics2.add(new AnalyticsField("feedback_received", false));
        quantAnalytics2.add(new AnalyticsField("certificate_issued", false));

        List<AnalyticsField> qualAnalytics2 = new ArrayList<>();
        qualAnalytics2.add(new AnalyticsField("access_info_before_answering", false));
        qualAnalytics2.add(new AnalyticsField("participation_in_quiz", true));

        Analytics student2Analytics = new Analytics("1002", quantAnalytics2, qualAnalytics2);
        analytics.add(student2Analytics);

        return analytics;
    }
}