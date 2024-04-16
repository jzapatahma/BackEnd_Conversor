package com.conversor;

import java.util.Map;

public class zop1ExchangeRatesResponse {
    private String base;
    private Map<String, Double> rates;

    // Getters y setters

    @Override
    public String toString() {
        return "ExchangeRatesResponse{" +
                "base='" + base + '\'' +
                ", rates=" + rates +
                '}';
    }
}
