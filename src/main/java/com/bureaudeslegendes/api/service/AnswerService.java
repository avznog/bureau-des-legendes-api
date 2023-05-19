package com.bureaudeslegendes.api.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.bureaudeslegendes.api.dto.Answer.AnswerCreationDTO;
import com.bureaudeslegendes.api.model.Answer;
import com.bureaudeslegendes.api.repository.AnswerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnswerService {
    final private ModelMapper mapper;

    final private QuestionService questionService;

    final private FormService formService;

    final private AnswerRepository answerRepository;

    public List<Answer> getAnswers() {
        return answerRepository.findAll();
    }

    public Answer getAnswer(Long id) {
        return answerRepository.findById(id).orElseThrow();
    }

    public Answer createAnswer(AnswerCreationDTO answerCreationDTO) {
        Answer answer = mapper.map(answerCreationDTO, Answer.class);
        answer.setQuestion(questionService.getQuestion(answerCreationDTO.getQuestion()));
        answer.setForm(formService.getForm(answerCreationDTO.getForm()));
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
