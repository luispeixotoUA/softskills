package com.softskills.softskills.repositories;

import com.softskills.softskills.entity.ConfigParameters;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigParametersRepository extends JpaRepository<ConfigParameters, Long> {
    // Métodos aqui
}