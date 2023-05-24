package com.bureaudeslegendes.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bureaudeslegendes.api.model.Question;
import java.util.Collection;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    Collection<Question> findByFormId(Long id);
}
