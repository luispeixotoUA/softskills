package com.softskills.softskills.repositories;

import com.softskills.softskills.model.ConfigParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigParamsRepository extends JpaRepository<ConfigParam, Long> {
    ConfigParam findByName(String name);
}
