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

import com.bureaudeslegendes.api.model.Answer;
import com.bureaudeslegendes.api.repository.AnswerRepository;

@RequestMapping("/answers")
@RestController
public class AnswerController {
    @Autowired
    private AnswerRepository answerRepository;

    @GetMapping
    public List<Answer> getAnswers() {
        return answerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Answer getAnswer(@PathVariable Long id) {
        return answerRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public Answer createAnswer(@RequestBody Answer answer) {
        return answerRepository.save(answer);
    }

    @PutMapping("/{id}")
    public Answer updateAnswer(@PathVariable Long id, @RequestBody Answer answer) {
        Answer updateAnswer = answerRepository.findById(id).orElseThrow(RuntimeException::new);
        updateAnswer.setForm(answer.getForm());
        updateAnswer.setQuestion(answer.getQuestion());
        updateAnswer.setAnswer(answer.getAnswer());

        return answerRepository.save(updateAnswer);
    }

    @DeleteMapping("/{id}")
    public void deleteAnswer(@PathVariable Long id) {
        answerRepository.deleteById(id);
    }
}
