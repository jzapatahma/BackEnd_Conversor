package com.conversor;

import java.util.Scanner;
public class Principal {
    public static void main(String[] args) {
        // *** Declaramos la entrada del teclado
        Scanner entrada = new Scanner(System.in);
        // *** Saludamos al Usuario
        System.out.println("\n *** Bienvenido al Sistema para convertir su moneda *** \n ");
        Monedas money = new Monedas();
        int seguir = 1;
        while (seguir == 1){
            // *** Prsentamos el menu al usuario
            money.listaMonedas().forEach((key, value) -> System.out.println("   " + key + " : " + value));
            // *** Validamos que la opcion entre las que presentamos en el menu.
            System.out.println("\n-->Ingresa la opcion seleccionada: ");
            int opcionElegida = entrada.nextInt();
            if (opcionElegida <= 6) {
                // *** Buscamos la opcion elegida y la presentamos en pantalla
                String seleccion = money.tipoConversionElegida(opcionElegida);
                int indiceTexto = seleccion.indexOf("***");
                String seleccionMoneda = seleccion.substring(0, indiceTexto).trim();
                System.out.println("-->Seleccionaste la opcion: " + seleccion);
                System.out.println("-->Digite la cantidad en: ");
                double cantidadMoneda = entrada.nextInt();
                // *** Despues que el usuario ingresa el total de moneda a convertir, ralizamos el calculo y presentamos en pantalla
                Calcular cal = new Calcular();
                double valorConvertido = cal.convertirMoneda(cantidadMoneda, opcionElegida, seleccionMoneda);
                System.out.println("La conversion de " + seleccion + " es: " + valorConvertido);
            } else if (opcionElegida == 7) {
                System.out.println("Gracias por utilizar nuestro servicio, hasta pronto.");
                break;
            } else {
                System.out.println("La opcion no esta en la lista anterior, intentalo de nuevo");
            }
            System.out.println("Para Continuar pulse (1) o para Salir (0)");
            seguir = entrada.nextInt();
            if(seguir==0){
               System.out.println("Gracias por utilizar nuestro servicio, hasta pronto.");
            }
            //Thread.sleep(20000);
            //Investigar como limpiar la ventana de presentacion cuando el usuario decida continuar con la conversion.
        }
    }
}