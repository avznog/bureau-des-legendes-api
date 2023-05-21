package com.bureaudeslegendes.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bureaudeslegendes.api.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
  Person findByEmail(String email);

  Boolean existsByEmail(String email);

  Optional<Person> findById(Long id);
}
