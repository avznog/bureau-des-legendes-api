package com.bureaudeslegendes.api.model;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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

    @JsonManagedReference
    @OneToMany(mappedBy = "team")
    private Collection<Person> members;

    @JsonIgnore
    @OneToMany(mappedBy = "team")
    private Collection<Form> forms;
}