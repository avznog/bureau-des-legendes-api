package com.bureaudeslegendes.api.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bureaudeslegendes.api.dto.Message.MessageCreationDTO;
import com.bureaudeslegendes.api.model.Message;
import com.bureaudeslegendes.api.repository.MessageRepository;

@Service
public class MessageService {
    ModelMapper mapper;

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getMessages() {
        return messageRepository.findAll();
    }

    public Message getMessage(Long id) {
        return messageRepository.findById(id).orElseThrow();
    }

    public Message createMessage(MessageCreationDTO messageCreationDTO) {
        Message message = mapper.map(messageCreationDTO, Message.class);
        return messageRepository.save(message);
    }

    public Message updateMessage(Long id, MessageCreationDTO messageCreationDTO) {
        Message currentMessage = getMessage(id);
        mapper.map(messageCreationDTO, currentMessage);
        return messageRepository.save(currentMessage);
    }

    public void deleteMessage(Long id) {
        messageRepository.deleteById(id);
    }
}
