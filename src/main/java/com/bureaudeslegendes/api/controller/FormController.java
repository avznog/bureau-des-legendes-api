package com.bureaudeslegendes.api.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bureaudeslegendes.api.dto.Form.FormCreationDTO;
import com.bureaudeslegendes.api.model.Form;
import com.bureaudeslegendes.api.service.FormService;

@CrossOrigin(origins = { "http://localhost:3000", "https://bureau-des-legendes.juniorisep.com" })
@RequestMapping("/forms")
@RestController
public class FormController {
    @Autowired
    private FormService formService;

    @GetMapping
    public List<Form> getForms() {
        return formService.getForms();
    }

    @GetMapping("/{id}")
    public Form getForm(@PathVariable Long id) {
        return formService.getForm(id);
    }

    @GetMapping("/team/{id}")
    public Collection<Form> getFormsByTeamId(@PathVariable Long id) {
        return formService.getFormsByTeamId(id);
    }

    @PostMapping
    public Form createForm(@RequestBody FormCreationDTO formCreationDTO) {
        return formService.createForm(formCreationDTO);
    }

    @PutMapping("/{id}")
    public Form updateForm(@PathVariable Long id,
            @RequestBody FormCreationDTO formCreationDTO) {
        return formService.updateForm(id, formCreationDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteForm(@PathVariable Long id) {
        formService.deleteForm(id);
    }
}
