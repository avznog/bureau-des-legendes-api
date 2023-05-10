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

import com.bureaudeslegendes.api.model.Message;
import com.bureaudeslegendes.api.repository.MessageRepository;

@RequestMapping("/messages")
@RestController
public class MessageController {
    @Autowired
    private MessageRepository messageRepository;

    @GetMapping
    public List<Message> getMessages() {
        return messageRepository.findAll();
    }

    @GetMapping("/{id}")
    public Message getMessage(@PathVariable Long id) {
        return messageRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public Message createMessage(@RequestBody Message message) {
        return messageRepository.save(message);
    }

    @PutMapping("/{id}")
    public Message updateMessage(@PathVariable Long id,
            @RequestBody Message message) {
        Message updateMessage = messageRepository.findById(id).orElseThrow(RuntimeException::new);
        updateMessage.setDate(message.getDate());
        updateMessage.setAlert(message.getAlert());
        updateMessage.setSender(message.getSender());
        updateMessage.setContent(message.getContent());

        return messageRepository.save(updateMessage);
    }

    @DeleteMapping("/{id}")
    public void deleteMessage(@PathVariable Long id) {
        messageRepository.deleteById(id);
    }
}