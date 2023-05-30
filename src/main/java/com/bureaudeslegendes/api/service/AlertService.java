package com.bureaudeslegendes.api.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.bureaudeslegendes.api.dto.Alert.AlertCreationDTO;
import com.bureaudeslegendes.api.enumList.Role;
import com.bureaudeslegendes.api.model.Alert;
import com.bureaudeslegendes.api.model.Form;
import com.bureaudeslegendes.api.model.Person;
import com.bureaudeslegendes.api.model.Team;
import com.bureaudeslegendes.api.repository.AlertRepository;
import com.bureaudeslegendes.api.repository.FormRepository;
import com.bureaudeslegendes.api.repository.PersonRepository;
import com.bureaudeslegendes.api.repository.TeamRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AlertService {
    final private ModelMapper mapper;

    final private PersonRepository personRepository;

    final private FormRepository formRepository;

    final private AlertRepository alertRepository;

    final private TeamRepository teamRepository;

    public List<Alert> getAlerts() {
        return alertRepository.findAll();
    }

    public Alert getAlert(Long id) {
        return alertRepository.findById(id).orElseThrow();
    }

    public Alert createAlert(AlertCreationDTO alertCreationDTO) {
        Person filler = personRepository.findById(alertCreationDTO.getFiller()).get();
        Team team = teamRepository.findById(filler.getId()).get();
        Person rh = personRepository.findByTeamIdAndRole(team.getId(), Role.RH);
        System.out.println(rh);
        Form form = formRepository.findById(alertCreationDTO.getForm()).get();
        alertCreationDTO.setReviewer(rh.getId());
        System.out.println(alertCreationDTO);
        Alert alert = mapper.map(alertCreationDTO, Alert.class);

        alert.setFiller(filler);
        alert.setReviewer(rh);
        alert.setForm(form);
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
