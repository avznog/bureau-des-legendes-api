package com.bureaudeslegendes.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bureaudeslegendes.api.model.Form;

public interface FormRepository extends JpaRepository<Form, Long> {

}
