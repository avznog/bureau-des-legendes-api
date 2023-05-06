package com.bureaudeslegendes.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bureaudeslegendes.api.model.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {

}
