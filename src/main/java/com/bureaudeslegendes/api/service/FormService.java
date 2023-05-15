package com.bureaudeslegendes.api.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bureaudeslegendes.api.dto.Form.FormCreationDTO;
import com.bureaudeslegendes.api.model.Form;
import com.bureaudeslegendes.api.repository.FormRepository;

@Service
public class FormService {
    ModelMapper mapper;

    @Autowired
    private FormRepository formRepository;

    public List<Form> getForms() {
        return formRepository.findAll();
    }

    public Form getForm(Long id) {
        return formRepository.findById(id).orElseThrow();
    }

    public Form createForm(FormCreationDTO formCreationDTO) {
        Form form = mapper.map(formCreationDTO, Form.class);
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
