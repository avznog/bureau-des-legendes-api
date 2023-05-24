package com.bureaudeslegendes.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bureaudeslegendes.api.model.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    Answer findByQuestionId(Long id);
}
