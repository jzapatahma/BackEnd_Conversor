package com.conversor;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class zop2ExchangeRateAPIExample {
    public static void main(String[] args) {
        String baseURL = "https://v6.exchangerate-api.com/v6/807d2718da24424737a4e2ef/pair/EUR/GBP"; // Cambia USD por tu moneda base
        try {
            URL url = new URL(baseURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = reader.readLine()) != null) {
                response.append(inputLine);
            }
            reader.close();

            // Imprime la respuesta JSON
            System.out.println(response.toString());

            // Aquí puedes procesar la respuesta JSON según tus necesidades
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
