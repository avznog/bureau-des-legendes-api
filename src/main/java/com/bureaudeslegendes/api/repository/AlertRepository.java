package com.bureaudeslegendes.api.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bureaudeslegendes.api.model.Alert;

public interface AlertRepository extends JpaRepository<Alert, Long> {
    Collection<Alert> findByReviewerId(Long id);

    Collection<Alert> findByFillerId(Long id);
}
