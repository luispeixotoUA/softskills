package com.softskills.softskills.service;

import com.softskills.softskills.entity.ConfigParameters;
import com.softskills.softskills.repositories.ConfigParametersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigParametersService {

    @Autowired
    private ConfigParametersRepository repository;

    // Retorna os parametros da DB
    public List<ConfigParameters> getAllConfigParameters() {
        return repository.findAll();
    }

    public void saveConfigParameter(ConfigParameters configParameter) {
        repository.save(configParameter); // Salva na base de dados
    }
}