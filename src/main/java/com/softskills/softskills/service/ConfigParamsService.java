package com.softskills.softskills.service;

import com.softskills.softskills.model.ConfigParam;
import com.softskills.softskills.repositories.ConfigParamsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigParamsService {

    private final ConfigParamsRepository configParamsRepository;

    public ConfigParamsService(ConfigParamsRepository configParamsRepository) {
        this.configParamsRepository = configParamsRepository;
    }

    public List<ConfigParam> getAllParams() {
        return configParamsRepository.findAll();
    }

    public ConfigParam getParamByName(String name) {
        return configParamsRepository.findByName(name);
    }
}