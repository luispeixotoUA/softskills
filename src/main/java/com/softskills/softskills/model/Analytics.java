package com.softskills.softskills.model;

import jakarta.persistence.*;

@Entity
@Table(name = "analytics_data")
public class Analytics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String studentId;

    @Column(name = "value", nullable = false)
    private String value;

    @Column(name = "analytic_id", nullable = false)
    private Long analyticId;

    private String activityId;

    public Analytics() {
    }

    public Analytics(Long id, String studentId, String value, Long analyticId, String activityId) {
        this.id = id;
        this.studentId = studentId;
        this.value = value;
        this.analyticId = analyticId;
        this.activityId = activityId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getAnalyticId() {
        return analyticId;
    }

    public void setAnalyticId(Long analyticId) {
        this.analyticId = analyticId;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    @Override
    public String toString() {
        return "Analytics{" +
                "id=" + id +
                ", studentId='" + studentId + '\'' +
                ", value='" + value + '\'' +
                ", analyticId=" + analyticId +
                ", activityId='" + activityId + '\'' +
                '}';
    }
}