package com.bureaudeslegendes.api.service;

import java.util.Collection;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.bureaudeslegendes.api.dto.Question.QuestionCreationDTO;
import com.bureaudeslegendes.api.model.Question;
import com.bureaudeslegendes.api.repository.QuestionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuestionService {
    final private ModelMapper mapper;

    final private FormService formService;

    final private QuestionRepository questionRepository;

    public List<Question> getQuestions() {
        return questionRepository.findAll();
    }

    public Question getQuestion(Long id) {
        return questionRepository.findById(id).orElseThrow();
    }

    public Collection<Question> getQuestionsByFormId(Long id) {
        return questionRepository.findByFormId(id);

    }

    public Question createQuestion(QuestionCreationDTO questionCreationDTO) {
        Question question = mapper.map(questionCreationDTO, Question.class);
        question.setForm(formService.getForm(questionCreationDTO.getForm()));
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
