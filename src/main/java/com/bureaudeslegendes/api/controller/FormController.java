package com.bureaudeslegendes.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bureaudeslegendes.api.model.Form;
import com.bureaudeslegendes.api.repository.FormRepository;

@RequestMapping("/form")
@RestController
public class FormController {
    @Autowired
    private FormRepository formRepository;

    @GetMapping
    public List<Form> getForms() {
        return formRepository.findAll();
    }

    @GetMapping("/{id}")
    public Form getForm(@PathVariable Long id) {
        return formRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public Form createForm(@RequestBody Form formTemplate) {
        return formRepository.save(formTemplate);
    }

    @PutMapping("/{id}")
    public Form updateForm(@PathVariable Long id,
            @RequestBody Form formTemplate) {
        Form updateForm = formRepository.findById(id).orElseThrow(RuntimeException::new);
        updateForm.setCreationDate(formTemplate.getCreationDate());
        updateForm.setType(formTemplate.getType());
        updateForm.setTeam(formTemplate.getTeam());
        updateForm.setCreator(formTemplate.getCreator());

        return formRepository.save(updateForm);
    }

    @DeleteMapping("/{id}")
    public void deleteForm(@PathVariable Long id) {
        formRepository.deleteById(id);
    }
}
