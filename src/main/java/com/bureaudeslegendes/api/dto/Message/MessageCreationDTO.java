package com.bureaudeslegendes.api.dto.Message;

import java.sql.Date;

import lombok.Data;

@Data
public class MessageCreationDTO {
    private Date date;

    private String content;

    private Long alert;

    private Long sender;
}
