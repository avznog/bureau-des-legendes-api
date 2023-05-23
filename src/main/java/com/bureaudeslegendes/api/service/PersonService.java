package com.bureaudeslegendes.api.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.bureaudeslegendes.api.dto.Person.PersonCreationDTO;
import com.bureaudeslegendes.api.dto.Person.PersonUpdateDTO;
import com.bureaudeslegendes.api.enumList.Role;
import com.bureaudeslegendes.api.model.Person;
import com.bureaudeslegendes.api.repository.PersonRepository;
import com.bureaudeslegendes.api.repository.TeamRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonService {
    final private ModelMapper mapper;

    final private PersonRepository personRepository;

    final private TeamRepository teamRepository;

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

    public Person setTeam(Long personId, Long teamId) {
        Person person = personRepository.findById(personId).get();
        person.setTeam(teamRepository.findById(teamId).get());
        personRepository.save(person);
        return person;   
    }

    public Collection<Person> getAllFreeRh() {
        return personRepository.findAllByRole(Role.RH)
            .stream()
            .filter(rh -> rh.getTeam() == null)
            .collect(Collectors.toList());

    }
}