package com.conversor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ConexionAPIs {
    public static HistorialConversion apiMap(String opcionSeleccionada) throws NoSuchFieldException, IllegalAccessException {
        //
        HistorialConversion hc = new HistorialConversion();
        //
        Map<String, String> listaMap = new HashMap<>();
        String url_str ="https://v6.exchangerate-api.com/v6/807d2718da24424737a4e2ef/pair/" + opcionSeleccionada;
        //
        URI direccion = URI.create(url_str);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(direccion).build();
        //
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            /// Gson requiere la serializacion de las fechas para que los valores puedan  ser llevados a la clase hc.getClass()
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateSerializer());
            gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer());
            gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateDeserializer());
            gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer());
            Gson gson = gsonBuilder.setPrettyPrinting().create();
            ///
            hc = gson.fromJson(response.body(), hc.getClass());
            return  hc;
        } catch (Exception e){
            throw new RuntimeException("No hay registros para esta busqueda. " + e.getMessage() + e.getLocalizedMessage());
        }
    }
}
