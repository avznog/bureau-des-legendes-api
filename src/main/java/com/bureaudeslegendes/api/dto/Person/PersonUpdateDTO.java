package com.bureaudeslegendes.api.dto.Person;

import com.bureaudeslegendes.api.enumList.Role;

import lombok.Data;

@Data
public class PersonUpdateDTO {
    private Role role;

    private String firstname;

    private String lastname;

    private String email;

    private String password;

    private String phone;

    private String photo;
}
