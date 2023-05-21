package com.bureaudeslegendes.api.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bureaudeslegendes.api.dto.Person.PersonCreationDTO;
import com.bureaudeslegendes.api.dto.Person.PersonUpdateDTO;
import com.bureaudeslegendes.api.model.Person;
import com.bureaudeslegendes.api.service.PersonService;

@CrossOrigin(origins = {"http://localhost:3000", "https://bureau-des-legendes.juniorisep.com"})
@RequestMapping("/persons")
@RestController
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping
    public List<Person> getPeople() {
        return personService.getPeople();
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable Long id) {
        return personService.getPerson(id);
    }

    @PostMapping()
    public Person createPerson(@RequestBody PersonCreationDTO personCreationDTO) {
        return personService.createPerson(personCreationDTO);
    }

    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable Long id, @RequestBody PersonUpdateDTO personUpdateDTO) {
        return personService.updatePerson(id, personUpdateDTO);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
    }

    @GetMapping("/set-team")
    public Person setTeam(@RequestParam Long teamId, @RequestParam Long personId) {
        return personService.setTeam(personId, teamId);
    }
}