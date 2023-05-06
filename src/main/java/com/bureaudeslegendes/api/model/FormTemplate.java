package com.bureaudeslegendes.api.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;

import com.bureaudeslegendes.api.enumList.Type;

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
public class FormTemplate implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "creationDate")
    private Date creationDate;

    @Column(name = "type")
    private Type type;

    @ManyToOne()
    @JoinColumn(name = "teamId")
    private Team team;

    @ManyToOne()
    @JoinColumn(name = "creatorId")
    private Person creator;

    @OneToMany(mappedBy = "formTemplate")
    private Collection<Alert> alerts;

    @OneToMany(mappedBy = "formTemplate")
    private Collection<Question> questions;
}
