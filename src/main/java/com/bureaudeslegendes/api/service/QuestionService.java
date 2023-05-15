package com.bureaudeslegendes.api.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bureaudeslegendes.api.dto.Question.QuestionCreationDTO;
import com.bureaudeslegendes.api.model.Question;
import com.bureaudeslegendes.api.repository.QuestionRepository;

@Service
public class QuestionService {
    ModelMapper mapper;

    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getQuestions() {
        return questionRepository.findAll();
    }

    public Question getQuestion(Long id) {
        return questionRepository.findById(id).orElseThrow();
    }

    public Question createQuestion(QuestionCreationDTO questionCreationDTO) {
        Question question = mapper.map(questionCreationDTO, Question.class);
        return questionRepository.save(question);
    }

    public Question updateQuestion(Long id, QuestionCreationDTO questionCreationDTO) {
        Question currentQuestion = getQuestion(id);
        mapper.map(questionCreationDTO, currentQuestion);
        return questionRepository.save(currentQuestion);
    }

    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }
}
