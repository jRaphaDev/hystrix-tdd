package com.poc.hystrix.service;

import com.poc.hystrix.model.HealthCheck;
import com.poc.hystrix.proxy.HealthCheckProxy;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class HealthCheckServiceTest {

    private HealthCheckService healthCheckService;
    private HealthCheckProxy healthCheckProxy;

    @Before
    public void setUP() {
        healthCheckProxy = mock(HealthCheckProxy.class);
        healthCheckService = new HealthCheckService(healthCheckProxy);
    }

    @Test
    public void Should_Do_Request_On_Proxy_And_Return_200_OK(){

        HealthCheck healthCheck = new HealthCheck(200, "Service is avaiable!");
        when(healthCheckProxy.doRequest()).thenReturn(healthCheck);

        HealthCheck result = healthCheckService.execute();

        assertEquals(result.getMessage(), healthCheck.getMessage());
        assertEquals("Service is avaiable!", healthCheck.getMessage());
        assertEquals(200, healthCheck.getStatusCode());

    }
}
