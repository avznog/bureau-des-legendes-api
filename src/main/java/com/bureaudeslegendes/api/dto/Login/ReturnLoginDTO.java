package com.bureaudeslegendes.api.dto.Login;

import com.bureaudeslegendes.api.model.Person;

import lombok.Data;

@Data
public class ReturnLoginDTO {
  Person person;
  Boolean authorized;
}
