package com.bureaudeslegendes.api.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.bureaudeslegendes.api.dto.Person.PersonCreationDTO;
import com.bureaudeslegendes.api.dto.Person.PersonUpdateDTO;
import com.bureaudeslegendes.api.model.Person;
import com.bureaudeslegendes.api.repository.PersonRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonService {
    final private ModelMapper mapper;

    final private PersonRepository personRepository;

    public List<Person> getPeople() {
        return personRepository.findAll();
    }

    public Person getPerson(Long id) {
        return personRepository.findById(id).orElseThrow();
    }

    public Person createPerson(PersonCreationDTO personCreationDTO) {
        Person person = mapper.map(personCreationDTO, Person.class);
        return personRepository.save(person);
    }

    public Person updatePerson(Long id, PersonUpdateDTO personUpdateDTO) {
        Person currentPerson = getPerson(id);
        mapper.map(personUpdateDTO, currentPerson);
        return personRepository.save(currentPerson);
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }
}