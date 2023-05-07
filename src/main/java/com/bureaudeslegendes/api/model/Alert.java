package com.bureaudeslegendes.api.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;

import com.bureaudeslegendes.api.enumList.Status;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date creationDate;

    @ManyToOne()
    @JoinColumn()
    private Person filler;

    @ManyToOne()
    @JoinColumn()
    private Person reviewer;

    @ManyToOne()
    @JoinColumn()
    private FormTemplate formTemplate;

    private Boolean anonymous;

    private Boolean sendMail;

    private Status status;

    @OneToMany(mappedBy = "alert")
    private Collection<Message> messages;
}
