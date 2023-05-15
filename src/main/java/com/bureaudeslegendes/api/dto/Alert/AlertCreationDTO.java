package com.bureaudeslegendes.api.dto.Alert;

import java.sql.Date;

import lombok.Data;

@Data
public class AlertCreationDTO {
    private Date creationDate;

    private Boolean anonymous;

    private Boolean sendMail;

    private Long status;

    private Long filler;

    private Long reviewer;

    private Long form;
}
