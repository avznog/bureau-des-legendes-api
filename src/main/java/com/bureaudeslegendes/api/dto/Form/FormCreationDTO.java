package com.bureaudeslegendes.api.dto.Form;

import java.sql.Date;

import lombok.Data;

@Data
public class FormCreationDTO {
    private Date creationDate;

    private String type;

    private Long team;

    private Long creator;
}