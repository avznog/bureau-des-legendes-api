package com.bureaudeslegendes.api.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bureaudeslegendes.api.dto.Answer.AnswerCreationDTO;
import com.bureaudeslegendes.api.model.Answer;
import com.bureaudeslegendes.api.repository.AnswerRepository;

@Service
public class AnswerService {
    ModelMapper mapper;

    @Autowired
    private AnswerRepository answerRepository;

    public List<Answer> getAnswers() {
        return answerRepository.findAll();
    }

    public Answer getAnswer(Long id) {
        return answerRepository.findById(id).orElseThrow();
    }

    public Answer createAnswer(AnswerCreationDTO answerCreationDTO) {
        Answer answer = mapper.map(answerCreationDTO, Answer.class);
        return answerRepository.save(answer);
    }

    public Answer updateAnswer(Long id, AnswerCreationDTO answerCreationDTO) {
        Answer currentAnswer = getAnswer(id);
        mapper.map(answerCreationDTO, currentAnswer);
        return answerRepository.save(currentAnswer);
    }

    public void deleteAnswer(Long id) {
        answerRepository.deleteById(id);
    }
}
