package com.bureaudeslegendes.api.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.bureaudeslegendes.api.dto.Alert.AlertCreationDTO;
import com.bureaudeslegendes.api.model.Alert;
import com.bureaudeslegendes.api.repository.AlertRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AlertService {
    final private ModelMapper mapper;

    final private PersonService personService;

    final private FormService formService;

    final private AlertRepository alertRepository;

    public List<Alert> getAlerts() {
        return alertRepository.findAll();
    }

    public Alert getAlert(Long id) {
        return alertRepository.findById(id).orElseThrow();
    }

    public Alert createAlert(AlertCreationDTO alertCreationDTO) {
        Alert alert = mapper.map(alertCreationDTO, Alert.class);
        alert.setFiller(personService.getPerson(alertCreationDTO.getFiller()));
        alert.setReviewer(personService.getPerson(alertCreationDTO.getReviewer()));
        alert.setForm(formService.getForm(alertCreationDTO.getForm()));
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
