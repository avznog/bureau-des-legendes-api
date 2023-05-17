package com.bureaudeslegendes.api.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.bureaudeslegendes.api.dto.Message.MessageCreationDTO;
import com.bureaudeslegendes.api.model.Message;
import com.bureaudeslegendes.api.repository.MessageRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MessageService {
    final private ModelMapper mapper;

    final private AlertService alertService;

    final private PersonService personService;

    final private MessageRepository messageRepository;

    public List<Message> getMessages() {
        return messageRepository.findAll();
    }

    public Message getMessage(Long id) {
        return messageRepository.findById(id).orElseThrow();
    }

    public Message createMessage(MessageCreationDTO messageCreationDTO) {
        Message message = mapper.map(messageCreationDTO, Message.class);
        message.setAlert(alertService.getAlert(messageCreationDTO.getAlert()));
        message.setSender(personService.getPerson(messageCreationDTO.getSender()));
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
