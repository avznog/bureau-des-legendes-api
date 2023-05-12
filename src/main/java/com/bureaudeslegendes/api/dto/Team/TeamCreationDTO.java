package com.bureaudeslegendes.api.dto.Team;

import lombok.Data;

@Data
public class TeamCreationDTO {
    private String name;

    private Long manager;

    private Long rh;
}
