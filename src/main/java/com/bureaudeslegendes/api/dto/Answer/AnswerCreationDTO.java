package com.bureaudeslegendes.api.dto.Answer;

import lombok.Data;

@Data
public class AnswerCreationDTO {
    private String answer;

    private Long question;

    private Long form;
}
