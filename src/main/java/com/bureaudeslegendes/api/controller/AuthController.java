package com.bureaudeslegendes.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bureaudeslegendes.api.dto.Login.LoginDTO;
import com.bureaudeslegendes.api.dto.Login.RegisterDTO;
import com.bureaudeslegendes.api.dto.Login.ReturnLoginDTO;
import com.bureaudeslegendes.api.model.Person;
import com.bureaudeslegendes.api.service.AuthService;

@CrossOrigin(origins = {"http://localhost:3000", "https://bureau-des-legendes.juniorisep.com"})
@RequestMapping("/auth")
@RestController
public class AuthController {
  @Autowired
  private AuthService authService;

  @PostMapping("/login")
  public ReturnLoginDTO login(@RequestBody LoginDTO loginDTO) {
    return this.authService.login(loginDTO);
  }

  @PostMapping("/register")
  public Person register(@RequestBody RegisterDTO registerDTO) throws Exception {
    return this.authService.register(registerDTO);
  }
}
