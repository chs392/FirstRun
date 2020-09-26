package com.learn.docker.firstrun.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {

    @Value("${service.identifier}")
    private String serviceIdentifier;

    @GetMapping("/healthCheck")
    public ResponseEntity checkHealth() {
        return ResponseEntity.ok().body("Service identifier is: " + this.serviceIdentifier);
    }
}