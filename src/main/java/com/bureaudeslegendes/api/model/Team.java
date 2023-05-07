package com.bureaudeslegendes.api.model;

import java.io.Serializable;
import java.util.Collection;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne()
    @JoinColumn()
    private Person manager;

    @ManyToOne()
    @JoinColumn()
    private Person rh;

    @ManyToOne()
    @JoinColumn()
    private Collection<Person> members;

    @OneToMany(mappedBy = "team")
    private Collection<Person> people;

    @OneToMany(mappedBy = "team")
    private Collection<FormTemplate> formTemplates;
}
