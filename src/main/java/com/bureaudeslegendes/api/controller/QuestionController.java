package com.bureaudeslegendes.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bureaudeslegendes.api.model.Question;
import com.bureaudeslegendes.api.repository.QuestionRepository;

@RequestMapping("/questions")
@RestController
public class QuestionController {
    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping
    public List<Question> getQuestions() {
        return questionRepository.findAll();
    }

    @GetMapping("/{id}")
    public Question getQuestion(@PathVariable Long id) {
        return questionRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public Question createQuestion(@RequestBody Question question) {
        return questionRepository.save(question);
    }

    @PutMapping("/{id}")
    public Question updateQuestion(@PathVariable Long id, @RequestBody Question question) {
        Question updateQuestion = questionRepository.findById(id).orElseThrow(RuntimeException::new);
        updateQuestion.setForm(question.getForm());
        updateQuestion.setQuestion(question.getQuestion());

        return questionRepository.save(updateQuestion);
    }

    @DeleteMapping("/{id}")
    public void deleteQuestion(@PathVariable Long id) {
        questionRepository.deleteById(id);
    }
}