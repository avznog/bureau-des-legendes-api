package com.bureaudeslegendes.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bureaudeslegendes.api.dto.Alert.AlertCreationDTO;
import com.bureaudeslegendes.api.model.Alert;
import com.bureaudeslegendes.api.service.AlertService;

@RequestMapping("/alerts")
@RestController
public class AlertController {
    @Autowired
    private AlertService alertService;

    @GetMapping
    public List<Alert> getAlerts() {
        return alertService.getAlerts();
    }

    @GetMapping("/{id}")
    public Alert getAlert(@PathVariable Long id) {
        return alertService.getAlert(id);
    }

    @PostMapping
    public Alert createAlert(@RequestBody AlertCreationDTO alertCreationDTO) {
        return alertService.createAlert(alertCreationDTO);
    }

    @PutMapping("/{id}")
    public Alert updateAlert(@PathVariable Long id, @RequestBody AlertCreationDTO alertCreationDTO) {
        return alertService.updateAlert(id, alertCreationDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteAlert(@PathVariable Long id) {
        alertService.deleteAlert(id);
    }
}
