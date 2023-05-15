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

import com.bureaudeslegendes.api.dto.Message.MessageCreationDTO;
import com.bureaudeslegendes.api.model.Message;
import com.bureaudeslegendes.api.service.MessageService;

@RequestMapping("/messages")
@RestController
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping
    public List<Message> getMessages() {
        return messageService.getMessages();
    }

    @GetMapping("/{id}")
    public Message getMessage(@PathVariable Long id) {
        return messageService.getMessage(id);
    }

    @PostMapping
    public Message createMessage(@RequestBody MessageCreationDTO messageCreationDTO) {
        return messageService.createMessage(messageCreationDTO);
    }

    @PutMapping("/{id}")
    public Message updateMessage(@PathVariable Long id,
            @RequestBody MessageCreationDTO messageCreationDTO) {
        return messageService.updateMessage(id, messageCreationDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteMessage(@PathVariable Long id) {
        messageService.deleteMessage(id);
    }
}