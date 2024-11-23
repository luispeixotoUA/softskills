package com.softskills.softskills.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class ActivityRequest {
    private String activityID;
    @JsonProperty("Inven!RAstdID")
    private String invenIRAstdID;
    private Map<String, String> jsonParams;

    public ActivityRequest(String activityID, String invenIRAstdID, Map<String, String> jsonParams) {
        this.activityID = activityID;
        this.invenIRAstdID = invenIRAstdID;
        this.jsonParams = jsonParams;
    }

    public String getActivityID() {
        return activityID;
    }

    public void setActivityID(String activityID) {
        this.activityID = activityID;
    }

    public String getInvenIRAstdID() {
        return invenIRAstdID;
    }

    public void setInvenIRAstdID(String invenIRAstdID) {
        this.invenIRAstdID = invenIRAstdID;
    }

    public Map<String, String> getJsonParams() {
        return jsonParams;
    }

    public void setJsonParams(Map<String, String> jsonParams) {
        this.jsonParams = jsonParams;
    }

    @Override
    public String toString() {
        return "ActivityRequest{" +
                "activityID='" + activityID + '\'' +
                ", invenIRAstdID='" + invenIRAstdID + '\'' +
                ", jsonParams=" + jsonParams +
                '}';
    }
}
