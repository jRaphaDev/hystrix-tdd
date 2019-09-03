package com.poc.hystrix.controller;

import com.poc.hystrix.model.HealthCheck;
import com.poc.hystrix.service.HealthCheckService;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class HealthCheckControllerTest {

    private HealthCheckController healthCheckController;
    private HealthCheckService healthCheckService;

    @Before
    public void setUP(){
        healthCheckService = mock(HealthCheckService.class);
        healthCheckController = new HealthCheckController(healthCheckService);
    }

    @Test
    public void Should_Return_200_0k(){

        HealthCheck healthCheck = new HealthCheck(200, "Service is avaiable!");
        when(healthCheckService.execute()).thenReturn(healthCheck);

        ResponseEntity<HealthCheck> response = healthCheckController.health();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(200, response.getBody().getStatusCode());
        assertEquals("Service is avaiable!", response.getBody().getMessage());

        assertNotNull(response.getBody().getDatetime());
    }
}
