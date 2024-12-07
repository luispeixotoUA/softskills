package com.softskills.softskills.model;

public class AnalyticsListDTO {
    private String name;
    private String type;

    public AnalyticsListDTO(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "AnalyticsListDTO{name='" + name + "', type='" + type + "'}";
    }

}