package com.bureaudeslegendes.api.model;

import java.io.Serializable;
import java.util.Collection;

import com.bureaudeslegendes.api.enumList.Role;

import jakarta.persistence.Column;
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
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role")
    private Role role;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "phone")
    private String phone;

    @ManyToOne()
    @JoinColumn(name = "teamId", referencedColumnName = "id")
    private Team team;

    @Column(name = "photo")
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
