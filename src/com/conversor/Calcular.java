package com.conversor;

public class Calcular implements ProcesarConversion {
    public HistorialConversion convertirMetodoMap(double cantidaAConvertir, int opcionElegida, String monedaAConvertir )
            throws NoSuchFieldException, IllegalAccessException {
        HistorialConversion hc = new HistorialConversion();
        hc = ConexionAPIs.apiMap(monedaAConvertir);
        Double valor = hc.getConversion_rate();
        //
        Double conversion = 0.0;
        switch (opcionElegida){
            case 1: // Dolar a Peso Argentino.
                conversion = getConversion(cantidaAConvertir, valor);
                break;
            case 2: // Peso Argentino a Dolar.
                conversion = getConversion(cantidaAConvertir, valor);
                break;
            case 3: // Dolar a Real Basileño.
                conversion = getConversion(cantidaAConvertir, valor);
                break;
            case 4: // Real Brasileño a Dolar.
                conversion = getConversion(cantidaAConvertir, valor);
                break;
            case 5: // Dolar a Peso Colombiano.
                conversion = getConversion(cantidaAConvertir, valor);
                break;
            case 6: // Peso Colombiano a Dolar.
                conversion = getConversion(cantidaAConvertir, valor);
                break;
            default:
                System.out.println("default");
                break;
        }
        hc.setConversion_total(conversion);
        return hc;
    }

    @Override
    public double getConversion(double valor1, double valor2) {
        return valor1*valor2;
    }
}