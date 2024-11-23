package com.softskills.softskills.model;

import java.util.List;

public class Analytics {

    private String inveniraStdID; // ID do aluno na Inven!RA
    private List<AnalyticsField> quantAnalytics; // Dados quantitativos
    private List<AnalyticsField> qualAnalytics; // Dados qualitativos

    public Analytics(String inveniraStdID, List<AnalyticsField> quantAnalytics, List<AnalyticsField> qualAnalytics) {
        this.inveniraStdID = inveniraStdID;
        this.quantAnalytics = quantAnalytics;
        this.qualAnalytics = qualAnalytics;
    }

    public String getInveniraStdID() {
        return inveniraStdID;
    }

    public void setInveniraStdID(String inveniraStdID) {
        this.inveniraStdID = inveniraStdID;
    }

    public List<AnalyticsField> getQuantAnalytics() {
        return quantAnalytics;
    }

    public void setQuantAnalytics(List<AnalyticsField> quantAnalytics) {
        this.quantAnalytics = quantAnalytics;
    }

    public List<AnalyticsField> getQualAnalytics() {
        return qualAnalytics;
    }

    public void setQualAnalytics(List<AnalyticsField> qualAnalytics) {
        this.qualAnalytics = qualAnalytics;
    }

    @Override
    public String toString() {
        return "Analytics{" +
                "inveniraStdID='" + inveniraStdID + '\'' +
                ", quantAnalytics=" + quantAnalytics +
                ", qualAnalytics=" + qualAnalytics +
                '}';
    }
}