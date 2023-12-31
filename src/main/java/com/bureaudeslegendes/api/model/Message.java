package com.bureaudeslegendes.api.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;
    
    private String content;
    
    @ManyToOne()
    @JoinColumn()
    private Alert alert;

    @ManyToOne()
    @JoinColumn()
    private Person sender;

}
