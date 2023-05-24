package com.bureaudeslegendes.api.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.bureaudeslegendes.api.dto.Form.FormCreationDTO;
import com.bureaudeslegendes.api.model.Form;
import com.bureaudeslegendes.api.model.Team;
import com.bureaudeslegendes.api.repository.FormRepository;
import com.bureaudeslegendes.api.repository.TeamRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FormService {
    final private ModelMapper mapper;

    final private TeamService teamService;

    final private TeamRepository teamRepository;

    final private PersonService personService;

    final private FormRepository formRepository;

    public List<Form> getForms() {
        return formRepository.findAll();
    }

    public Form getForm(Long id) {
        return formRepository.findById(id).orElseThrow();
    }

    public List<Form> getFormsByTeam(Long teamId) {
        Team team = teamRepository.findById(teamId).get();
        return formRepository.findByTeam(team);
    }

    public Form createForm(FormCreationDTO formCreationDTO) {
        Form form = mapper.map(formCreationDTO, Form.class);
        form.setTeam(teamService.getTeam(formCreationDTO.getTeam()));
        form.setCreator(personService.getPerson(formCreationDTO.getCreator()));
        return formRepository.save(form);
    }

    public Form updateForm(Long id, FormCreationDTO formCreationDTO) {
        Form currentForm = getForm(id);
        mapper.map(formCreationDTO, Form.class);
        return formRepository.save(currentForm);
    }

    public void deleteForm(Long id) {
        formRepository.deleteById(id);
    }
}
