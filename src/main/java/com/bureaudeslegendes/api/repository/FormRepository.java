package com.bureaudeslegendes.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bureaudeslegendes.api.model.Form;

import java.util.Collection;

public interface FormRepository extends JpaRepository<Form, Long> {
    Collection<Form> findByTeamId(Long id);
}
