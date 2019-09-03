package com.poc.hystrix.proxy.json;

public class HealthJsonResponse {

    private int code;
    private String messagem;

    public HealthJsonResponse() {
    }

    public int getCode() {
        return code;
    }

    public String getMessagem() {
        return messagem;
    }

}
