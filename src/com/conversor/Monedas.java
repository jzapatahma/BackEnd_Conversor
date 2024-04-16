package com.conversor;

import java.util.HashMap;
import java.util.Map;

public class Monedas {

    Map<String, Integer> hmMonedas = new HashMap<>();
    Map<Integer, String> hmListaConvertir = new HashMap<>();
    public void monedas(){
        hmMonedas.put("Dolar",1);
        hmMonedas.put("Peso Argentino",2);
        hmMonedas.put("Real Brasileño",3);
        hmMonedas.put("Peso Colombiano",4);
    }

    public Map<Integer, String>  listaMonedas() {
        hmListaConvertir.put(1, "USD/ARS *** de Dolar a Peso Argentino ");
        hmListaConvertir.put(2, "ARS/USD *** de Peso Argentino a Dolar ");
        hmListaConvertir.put(3, "USD/BRL *** de Dolar a Real Brasileño ");
        hmListaConvertir.put(4, "BRL/USD *** de Real Brasileño a Dolar ");
        hmListaConvertir.put(5, "USD/COP *** de Dolar a Peso Colombiano ");
        hmListaConvertir.put(6, "COP/USD *** de Peso Colombiano a Dolar ");
        hmListaConvertir.put(7, "* Salir *");
        return hmListaConvertir;
    }

    public String tipoConversionElegida(int clave){
        return hmListaConvertir.get(clave);
    }
}
