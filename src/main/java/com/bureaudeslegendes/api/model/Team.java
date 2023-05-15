package com.bureaudeslegendes.api.model;

import java.util.Collection;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne()
    @JoinColumn()
    private Person manager;

    @OneToOne()
    @JoinColumn()
    private Person rh;

    @OneToMany(mappedBy = "team")
    private Collection<Person> members;

    @OneToMany(mappedBy = "team")
    private Collection<Form> forms;
}
