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

import com.bureaudeslegendes.api.model.Form;
import com.bureaudeslegendes.api.repository.FormRepository;

@RequestMapping("/forms")
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
    public ResponseEntity<Form> createForm(@RequestBody Form form) {
        formRepository.save(form);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Form> updateForm(@PathVariable Long id,
            @RequestBody Form form) {
        Form updateForm = formRepository.findById(id).orElseThrow(RuntimeException::new);
        updateForm.setCreationDate(form.getCreationDate());
        updateForm.setType(form.getType());
        updateForm.setTeam(form.getTeam());
        updateForm.setCreator(form.getCreator());

        formRepository.save(updateForm);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Form> deleteForm(@PathVariable Long id) {
        formRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}