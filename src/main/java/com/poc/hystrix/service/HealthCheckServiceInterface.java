package com.poc.hystrix.service;

import com.poc.hystrix.model.HealthCheck;

public interface HealthCheckServiceInterface {
    HealthCheck execute();
}
