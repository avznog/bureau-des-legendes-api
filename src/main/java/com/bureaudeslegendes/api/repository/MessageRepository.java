package com.bureaudeslegendes.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bureaudeslegendes.api.model.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
