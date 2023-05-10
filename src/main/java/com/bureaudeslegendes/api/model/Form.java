package com.bureaudeslegendes.api.model;

import java.sql.Date;
import java.util.Collection;

import com.bureaudeslegendes.api.enumList.FormType;

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
public class Form {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date creationDate;

    private FormType type;

    @OneToMany(mappedBy = "form")
    private Collection<Alert> alerts;
    
    @ManyToOne()
    @JoinColumn()
    private Team team;
    
    @ManyToOne()
    @JoinColumn()
    private Person creator;

    @OneToMany(mappedBy = "form")
    private Collection<Question> questions;
}
