package com.bureaudeslegendes.api.model;

import java.io.Serializable;
import java.util.Collection;

import com.bureaudeslegendes.api.enumList.Role;

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
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Role role;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String phone;

    @ManyToOne()
    @JoinColumn()
    private Team team;

    private String photo;

    @OneToMany(mappedBy = "manager")
    private Collection<Team> teamManagers;

    @OneToMany(mappedBy = "rh")
    private Collection<Team> teamRHs;

    @OneToMany(mappedBy = "members")
    private Collection<Team> teamMembers;

    @OneToMany(mappedBy = "filler")
    private Collection<Alert> alertFillers;

    @OneToMany(mappedBy = "reviewer")
    private Collection<Alert> alertReviewers;

    @OneToMany(mappedBy = "sender")
    private Collection<Message> messages;

    @OneToMany(mappedBy = "creator")
    private Collection<FormTemplate> formTemplates;

}
