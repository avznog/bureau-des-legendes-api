package com.bureaudeslegendes.api.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;

import com.bureaudeslegendes.api.enumList.Category;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date creationDate;

    private Category category;

    @ManyToOne()
    @JoinColumn()
    private Team team;

    @ManyToOne()
    @JoinColumn()
    private Person creator;

    @OneToMany(mappedBy = "formTemplate")
    private Collection<Alert> alerts;

    @OneToMany(mappedBy = "formTemplate")
    private Collection<Question> questions;
}
