package com.poc.hystrix.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class HealthCheck implements Serializable {

    private int statusCode;
    private String message;
    private LocalDateTime datetime;

    public HealthCheck(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
        this.datetime = LocalDateTime.now();
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

}
