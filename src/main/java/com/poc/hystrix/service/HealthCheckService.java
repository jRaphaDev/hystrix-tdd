package com.poc.hystrix.service;

import com.poc.hystrix.model.HealthCheck;
import com.poc.hystrix.proxy.HealthCheckProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HealthCheckService implements HealthCheckServiceInterface {

    private HealthCheckProxy healthCheckProxy;

    @Autowired
    public HealthCheckService(HealthCheckProxy healthCheckProxy) {
        this.healthCheckProxy = healthCheckProxy;
    }

    @Override
    public HealthCheck execute() {
        return this.healthCheckProxy.doRequest();
    }
}
