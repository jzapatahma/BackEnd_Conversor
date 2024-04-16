package com.conversor;

import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class ConsultarMonedaM1 {

    public static Map<String, Double> ConsultarMap(String opcionSeleccionada){ // Ojoo seguir investigarlo como hacerlo de la primer forma

        Map<String, Double> listaMap = new HashMap<>();
        String url_str ="https://v6.exchangerate-api.com/v6/807d2718da24424737a4e2ef/pair/" + opcionSeleccionada;

        URI direccion = URI.create(url_str);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try{
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(),  listaMap.getClass());
        } catch (Exception e){
            throw new RuntimeException("No encontré esa película." + e.getMessage() + e.getLocalizedMessage());
        }

    }
    public static ApiMonedas Consultar(){ // Ojoo seguir investigando como hacerlo de la primer forma
        String url_str ="https://v6.exchangerate-api.com/v6/807d2718da24424737a4e2ef/pair/USD/COP";

        URI direccion = URI.create(url_str);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try{
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(),  ApiMonedas.class);
        } catch (Exception e){
            throw new RuntimeException("No encontré esa película." + e.getMessage() + e.getLocalizedMessage());
        }
    }
}