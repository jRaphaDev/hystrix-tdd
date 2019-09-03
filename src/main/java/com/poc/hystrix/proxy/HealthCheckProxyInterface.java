package com.poc.hystrix.proxy;

import com.poc.hystrix.model.HealthCheck;

public interface HealthCheckProxyInterface {
    HealthCheck doRequest();
}
