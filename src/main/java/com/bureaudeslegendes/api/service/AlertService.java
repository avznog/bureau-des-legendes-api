package com.bureaudeslegendes.api.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bureaudeslegendes.api.dto.Alert.AlertCreationDTO;
import com.bureaudeslegendes.api.model.Alert;
import com.bureaudeslegendes.api.repository.AlertRepository;

@Service
public class AlertService {
    ModelMapper mapper;

    @Autowired
    private AlertRepository alertRepository;

    public List<Alert> getAlerts() {
        return alertRepository.findAll();
    }

    public Alert getAlert(Long id) {
        return alertRepository.findById(id).orElseThrow();
    }

    public Alert createAlert(AlertCreationDTO alertCreationDTO) {
        Alert alert = mapper.map(alertCreationDTO, Alert.class);
        return alertRepository.save(alert);
    }

    public Alert updateAlert(Long id, AlertCreationDTO alertCreationDTO) {
        Alert currentAlert = getAlert(id);
        mapper.map(alertCreationDTO, currentAlert);
        return alertRepository.save(currentAlert);
    }

    public void deleteAlert(Long id) {
        alertRepository.deleteById(id);
    }
}
