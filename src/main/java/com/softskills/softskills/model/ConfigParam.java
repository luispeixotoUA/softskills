package com.softskills.softskills.model;

import jakarta.persistence.*;

@Entity
@Table(name = "config_params")
public class ConfigParam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;

    public ConfigParam() {}

    public ConfigParam(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getType() { return type; }

    public void setName(String name) { this.name = name; }
    public void setType(String type) { this.type = type; }
}