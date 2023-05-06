package com.bureaudeslegendes.api.model;

import java.io.Serializable;
import java.util.Collection;

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
public class Team implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne()
    @JoinColumn(name = "managerId")
    private Person manager;

    @ManyToOne()
    @JoinColumn(name = "rhId")
    private Person rh;

    @ManyToOne()
    @JoinColumn(name = "membersId")
    private Collection<Person> members;

    @OneToMany(mappedBy = "team")
    private Collection<Person> people;

    @OneToMany(mappedBy = "team")
    private Collection<FormTemplate> formTemplates;
}
