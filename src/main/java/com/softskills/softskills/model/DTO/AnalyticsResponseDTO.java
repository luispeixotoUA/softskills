package com.softskills.softskills.model.DTO;

import java.util.List;

public class AnalyticsResponseDTO {
    private String inveniraStdID;
    private List<AnalyticsFieldDTO> quantAnalytics;
    private List<AnalyticsFieldDTO> qualAnalytics;

    public AnalyticsResponseDTO(String inveniraStdID, List<AnalyticsFieldDTO> quantAnalytics, List<AnalyticsFieldDTO> qualAnalytics) {
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

    public List<AnalyticsFieldDTO> getQuantAnalytics() {
        return quantAnalytics;
    }

    public void setQuantAnalytics(List<AnalyticsFieldDTO> quantAnalytics) {
        this.quantAnalytics = quantAnalytics;
    }

    public List<AnalyticsFieldDTO> getQualAnalytics() {
        return qualAnalytics;
    }

    public void setQualAnalytics(List<AnalyticsFieldDTO> qualAnalytics) {
        this.qualAnalytics = qualAnalytics;
    }
}