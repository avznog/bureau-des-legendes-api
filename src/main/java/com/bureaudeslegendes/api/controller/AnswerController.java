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

import com.bureaudeslegendes.api.dto.Answer.AnswerCreationDTO;
import com.bureaudeslegendes.api.model.Answer;
import com.bureaudeslegendes.api.service.AnswerService;

@RequestMapping("/answers")
@RestController
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    @GetMapping
    public List<Answer> getAnswers() {
        return answerService.getAnswers();
    }

    @GetMapping("/{id}")
    public Answer getAnswer(@PathVariable Long id) {
        return answerService.getAnswer(id);
    }

    @GetMapping("/question/{questionId}")
    public Answer getAnswerByQuestion(@PathVariable Long questionId) {
        return answerService.getAnswerByQuestion(questionId);
    }

    @PostMapping
    public Answer createAnswer(@RequestBody AnswerCreationDTO answerCreationDTO) {
        return answerService.createAnswer(answerCreationDTO);
    }

    @PutMapping("/{id}")
    public Answer updateAnswer(@PathVariable Long id, @RequestBody AnswerCreationDTO answerCreationDTO) {
        return answerService.updateAnswer(id, answerCreationDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteAnswer(@PathVariable Long id) {
        answerService.deleteAnswer(id);
    }
}
