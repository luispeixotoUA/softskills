package com.softskills.softskills.model;

import jakarta.persistence.*;

@Entity
@Table(name = "analytics_config")
public class AnalyticsConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;
    private String dataType;


    public AnalyticsConfig(Long id, String name, String type, String dataType) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.dataType = dataType;
    }

    public AnalyticsConfig() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    @Override
    public String toString() {
        return "AnalyticsConfig{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", dataType='" + dataType + '\'' +
                '}';
    }
}
