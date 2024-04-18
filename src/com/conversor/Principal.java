package com.conversor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Principal {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        //
        Scanner entrada = new Scanner(System.in);
        Monedas money = new Monedas();
        List<HistorialConversion> historicoConversiones = new ArrayList<>();
        // *** Saludamos al Usuario
        System.out.println("\n *** Bienvenido al Sistema para convertir su moneda *** \n ");
        //
        int salir = 1;
        while (salir == 1) {
            // Presentamos las lista con las opciones de conversion hasta el momento
            money.listaConversion().forEach((key, value) -> System.out.println("  " + key + " : " + value));
            // *** Validamos que la opcion entre las que presentamos en el menu.
            System.out.println("\n-->Ingresa la opcion seleccionada: ");
            int opcionElegida = entrada.nextInt();
            //
            if(opcionElegida >= 1 && opcionElegida <= 6) {
                String seleccion = money.conversionElegida(opcionElegida);
                int indiceTexto = seleccion.indexOf("***");
                String seleccionMoneda = seleccion.substring(0, indiceTexto).trim();
                System.out.println("-->Seleccionaste la opcion: " + seleccion);
                System.out.println("-->Digite la cantidad en: ");
                double cantidadMoneda = entrada.nextInt();
                //
                Calcular cal = new Calcular();
                HistorialConversion hc = cal.convertirMetodoMap(cantidadMoneda, opcionElegida, seleccionMoneda);
                hc.setFecha(LocalDate.now());
                hc.setHora(LocalDateTime.now());
                //
                System.out.println("La conversion de " + seleccion + " es: " + hc.getConversion_total() + "\n");
                historicoConversiones.add(hc);
                //
            } else if (opcionElegida==7) {
                System.out.println(" Muchas gracias por preferir nuestro servicio, hasta pronto\n");
                break;
            }else {
                System.out.println(" * La opcion que elegiste no esta en la lista *\n");
            }
            System.out.println(" *** Desea continuar Pulsa = 1 *** De lo contrario Pulsa = 0");
            salir = entrada.nextInt();
            if(salir == 0){
                System.out.println(" Muchas gracias por preferir nuestro servicio, hasta pronto\n");
                System.out.println(" *** Este es su historico de conversiones hasta el momento *** ");
                historicoConversiones.forEach(System.out::println);
            }
        }
    }
}