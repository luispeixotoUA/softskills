package com.softskills.softskills.model;

public class AnalyticsField {

    private String name;
    private Object value;

    public AnalyticsField(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "AnalyticsField{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}