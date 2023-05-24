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

import com.bureaudeslegendes.api.dto.Question.QuestionCreationDTO;
import com.bureaudeslegendes.api.model.Question;
import com.bureaudeslegendes.api.service.QuestionService;

@RequestMapping("/questions")
@RestController
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping
    public List<Question> getQuestions() {
        return questionService.getQuestions();
    }

    @GetMapping("/{id}")
    public Question getQuestion(@PathVariable Long id) {
        return questionService.getQuestion(id);
    }

    @GetMapping("/form/{formId}")
    public List<Question> getQuestionsByForm(@PathVariable Long formId) {
        return questionService.getQuestionsByForm(formId);
    }

    @PostMapping
    public Question createQuestion(@RequestBody QuestionCreationDTO questionCreationDTO) {
        return questionService.createQuestion(questionCreationDTO);
    }

    @PutMapping("/{id}")
    public Question updateQuestion(@PathVariable Long id, @RequestBody QuestionCreationDTO questionCreationDTO) {
        return questionService.updateQuestion(id, questionCreationDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
    }
}