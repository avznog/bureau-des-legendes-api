package com.bureaudeslegendes.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bureaudeslegendes.api.model.Alert;
import com.bureaudeslegendes.api.repository.AlertRepository;

@RequestMapping("/alerts")
@RestController
public class AlertController {
    @Autowired
    private AlertRepository alertRepository;

    @GetMapping
    public List<Alert> getAlerts() {
        return alertRepository.findAll();
    }

    @GetMapping("/{id}")
    public Alert getAlert(@PathVariable Long id) {
        return alertRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public ResponseEntity<Alert> createAlert(@RequestBody Alert alert) {
        alertRepository.save(alert);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alert> updateAlert(@PathVariable Long id, @RequestBody Alert alert) {
        Alert updateAlert = alertRepository.findById(id).orElseThrow(RuntimeException::new);
        updateAlert.setCreationDate(alert.getCreationDate());
        updateAlert.setFiller(alert.getFiller());
        updateAlert.setReviewer(alert.getReviewer());
        updateAlert.setForm(alert.getForm());
        updateAlert.setAnonymous(alert.getAnonymous());
        updateAlert.setSendMail(alert.getSendMail());
        updateAlert.setStatus(alert.getStatus());

        alertRepository.save(updateAlert);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Alert> deleteAlert(@PathVariable Long id) {
        alertRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
