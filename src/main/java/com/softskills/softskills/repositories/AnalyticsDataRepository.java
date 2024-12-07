package com.softskills.softskills.repositories;

import com.softskills.softskills.model.Analytics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnalyticsDataRepository extends JpaRepository<Analytics, Long> {
    List<Analytics> findByActivityId(String studentId);
}