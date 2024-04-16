package com.conversor;

import static com.conversor.ConsultarMonedaM1.ConsultarMap;

public class Calcular implements ProcesarConversion {
    public double convertirMoneda(double cantidaAConvertir, int opcionElegida, String monedaAConvertir ){
        // Asignamos a una variable el valor de la moneda en la API del sitio https://www.exchangerate-api.com/docs/java-currency-api
        Double valor = ConsultarMap(monedaAConvertir).get("conversion_rate");
        //System.out.println("conversion_rate xxxx" + valor + "ddddddd");//ConsultarMap().get("conversion_rate"));

        double conversion = 0.0;
        switch (opcionElegida){
            case 1: // Dolar a Peso Argentino.
                conversion = getConversion(cantidaAConvertir, valor);
                //System.out.println("Dolar a Peso Argentino. " + conversion);
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
        return conversion;
    }

    @Override
    public double getConversion(double valor1, double valor2) {
        return valor1*valor2;
    }
}
