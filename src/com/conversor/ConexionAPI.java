package com.conversor;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class ConexionAPI {
    public Map<String, Double> ConsumirServicio() {
        String dos = "conversion_rates";

        Map<String, Double> lista = new HashMap<>();
        //Map<String, Double> rates;

        // Setting URL lista todo el archivo
        //String url_str = "https://v6.exchangerate-api.com/v6/807d2718da24424737a4e2ef/latest/USD";
        String url_str ="https://v6.exchangerate-api.com/v6/807d2718da24424737a4e2ef/pair/USD/COP";

        URI direccion = URI.create(url_str);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            //System.out.println(response.body());
            //ExchangeRatesResponse exchangeRatesResponse = new Gson().fromJson(response.toString(), ExchangeRatesResponse.class);
            //return exchangeRatesResponse.toString();
            return new Gson().fromJson(response.body(),  lista.getClass());
        } catch (Exception e) {
            throw new RuntimeException("No encontré esa película.");
        }
    }
}


//https://v6.exchangerate-api.com/v6/807d2718da24424737a4e2ef/latest/USD