package com.bureaudeslegendes.api.repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bureaudeslegendes.api.enumList.Role;
import com.bureaudeslegendes.api.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
  Person findByEmail(String email);

  Boolean existsByEmail(String email);

  Optional<Person> findById(Long id);

  Collection<Person> findAllByRole(Role role);

  Person findByTeamIdAndRole(Long teamId, Role role);
}
