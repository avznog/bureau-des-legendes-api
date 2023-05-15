package com.bureaudeslegendes.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bureaudeslegendes.api.model.Alert;

public interface AlertRepository extends JpaRepository<Alert, Long> {

}
