package com.poc.hystrix.controller;

import com.poc.hystrix.model.HealthCheck;
import com.poc.hystrix.service.HealthCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    private HealthCheckService healthCheckService;

    @Autowired
    public HealthCheckController(HealthCheckService healthCheckService) {
        this.healthCheckService = healthCheckService;
    }

    @GetMapping("/health")
    public ResponseEntity health() {
        HealthCheck healthCheck = this.healthCheckService.execute();
        return ResponseEntity.ok().body(healthCheck);
    }
}
