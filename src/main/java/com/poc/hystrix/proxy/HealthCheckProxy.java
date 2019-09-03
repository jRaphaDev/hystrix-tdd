package com.poc.hystrix.proxy;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.poc.hystrix.model.HealthCheck;
import com.poc.hystrix.proxy.json.HealthJsonResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HealthCheckProxy implements HealthCheckProxyInterface {

    private static final String URL = "http://localhost:3000/status";

    private RestTemplate restTemplate;

    public HealthCheckProxy() {
        this.restTemplate = new RestTemplate();
    }

    @HystrixCommand(fallbackMethod = "defaultRequest")
    @Override
    public HealthCheck doRequest() {
        return adapter(restTemplate
                .getForEntity(URL, HealthJsonResponse.class));
    }

    private HealthCheck adapter(ResponseEntity<HealthJsonResponse> entity) {
        return new HealthCheck(entity.getBody().getCode(),
                entity.getBody().getMessagem());
    }

    private HealthCheck defaultRequest(){
        return null;
    }

}
