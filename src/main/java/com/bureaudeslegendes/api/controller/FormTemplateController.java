package com.bureaudeslegendes.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bureaudeslegendes.api.model.FormTemplate;
import com.bureaudeslegendes.api.repository.FormTemplateRepository;

@RequestMapping("/form-templates")
@RestController
public class FormTemplateController {
    @Autowired
    private FormTemplateRepository formTemplateRepository;

    @GetMapping
    public List<FormTemplate> getFormTemplates() {
        return formTemplateRepository.findAll();
    }

    @GetMapping("/{id}")
    public FormTemplate getFormTemplate(@PathVariable Long id) {
        return formTemplateRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public ResponseEntity<FormTemplate> createFormTemplate(@RequestBody FormTemplate formTemplate) {
        formTemplateRepository.save(formTemplate);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<FormTemplate> updateFormTemplate(@PathVariable Long id,
            @RequestBody FormTemplate formTemplate) {
        FormTemplate updateFormTemplate = formTemplateRepository.findById(id).orElseThrow(RuntimeException::new);
        updateFormTemplate.setCreationDate(formTemplate.getCreationDate());
        updateFormTemplate.setType(formTemplate.getType());
        updateFormTemplate.setTeam(formTemplate.getTeam());
        updateFormTemplate.setCreator(formTemplate.getCreator());

        formTemplateRepository.save(updateFormTemplate);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FormTemplate> deleteFormTemplate(@PathVariable Long id) {
        formTemplateRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}