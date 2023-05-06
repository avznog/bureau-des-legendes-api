package com.bureaudeslegendes.api.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;

import com.bureaudeslegendes.api.enumList.Status;

import jakarta.persistence.CascadeType;
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
public class Alert implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "creationDate")
    private Date creationDate;

    @ManyToOne()
    @JoinColumn(name = "fillerId")
    private Person filler;

    @ManyToOne()
    @JoinColumn(name = "reviewerId")
    private Person reviewer;

    @ManyToOne()
    @JoinColumn(name = "formTemplateId")
    private FormTemplate formTemplate;

    @Column(name = "anonymous")
    private Boolean anonymous;

    @Column(name = "sendMail")
    private Boolean sendMail;

    @Column(name = "status")
    private Status status;

    @OneToMany(mappedBy = "alert", cascade = CascadeType.ALL)
    private Collection<Message> messages;

}
