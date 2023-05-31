package com.bureaudeslegendes.api.model;

import java.util.Collection;

import com.bureaudeslegendes.api.enumList.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Role role;

    private String firstname;

    private String lastname;

    private String email;

    private String password;

    private String phone;

    private String photo;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn()
    private Team team;

    @JsonIgnore
    @OneToMany(mappedBy = "filler")
    private Collection<Alert> filledAlerts;

    @JsonIgnore
    @OneToMany(mappedBy = "reviewer")
    private Collection<Alert> reviewedAlerts;

    @OneToMany(mappedBy = "sender")
    private Collection<Message> messages;

    @OneToMany(mappedBy = "creator")
    private Collection<Form> forms;
}
