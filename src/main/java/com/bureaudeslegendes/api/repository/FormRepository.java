package com.bureaudeslegendes.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bureaudeslegendes.api.model.Form;
import com.bureaudeslegendes.api.model.Team;

import java.util.List;

public interface FormRepository extends JpaRepository<Form, Long> {
    List<Form> findByTeam(Team team);
}
