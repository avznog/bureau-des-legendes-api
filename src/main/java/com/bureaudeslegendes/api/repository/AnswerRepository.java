package com.bureaudeslegendes.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bureaudeslegendes.api.model.Answer;
import com.bureaudeslegendes.api.model.Question;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    Answer findByQuestion(Question question);
}
