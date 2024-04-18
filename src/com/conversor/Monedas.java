package com.conversor;

import java.util.HashMap;
import java.util.Map;

public class Monedas {
    private String pais;
    private String codigo;
    private String descripcion;

    public Monedas(String pais, String codigo, String descripcion) {
        this.pais = pais;
        this.codigo = codigo;
        this.descripcion = descripcion;
    }
    public Monedas() {
    }

    public String getPais() { return pais; }
    public String getCodigo() { return codigo; }
    public String getDescripcion() { return descripcion; }

    Map<Integer, String> lc = new HashMap<>();
    public Map<Integer, String> listaConversion(){
        lc.put(1, "USD/ARS *** de Dolar a Peso Argentino ");
        lc.put(2, "ARS/USD *** de Peso Argentino a Dolar ");
        lc.put(3, "USD/BRL *** de Dolar a Real Brasileño ");
        lc.put(4, "BRL/USD *** de Real Brasileño a Dolar ");
        lc.put(5, "USD/COP *** de Dolar a Peso Colombiano ");
        lc.put(6, "COP/USD *** de Peso Colombiano a Dolar ");
        lc.put(7, "* Salir *");
        return lc;
    }
    public String conversionElegida(int clave){
        return listaConversion().get(clave);
    }
}