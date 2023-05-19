package com.bureaudeslegendes.api.dto.Login;

import com.bureaudeslegendes.api.enumList.Role;

import lombok.Data;

@Data
public class RegisterDTO {
  Role role;
  String firstname;
  String lastname;
  String email;
  String password;
  String phone;
}
