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

import com.bureaudeslegendes.api.model.Person;
import com.bureaudeslegendes.api.repository.PersonRepository;

@RequestMapping("/persons")
@RestController
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable Long id) {
        return personRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        personRepository.save(person);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody Person person) {
        Person updatePerson = personRepository.findById(id).orElseThrow(RuntimeException::new);
        updatePerson.setRole(person.getRole());
        updatePerson.setFirstname(person.getFirstname());
        updatePerson.setLastname(person.getLastname());
        updatePerson.setEmail(person.getEmail());
        updatePerson.setPassword(person.getPassword());
        updatePerson.setPhone(person.getPhone());
        updatePerson.setTeam(person.getTeam());
        updatePerson.setPhone(person.getPhone());

        personRepository.save(updatePerson);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Person> deletePerson(@PathVariable Long id) {
        personRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
