package teclado;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Teclado {
    public static Scanner sc = new Scanner(System.in);

    // Función para leer enteros por teclado
    public static int leerEntero(){
        while (true) {
            try {
                System.out.print("--> ");
                return sc.nextInt();
            } catch (Exception e) {
                System.out.println("\u001B[33m⚠ Introduce un número \u001B[0m");
                sc.nextLine();
            }
        }
    }

    // Función para leer string por teclado
    public static String leerString(){
        System.out.print("--> ");
        return sc.nextLine();
    }

    // Función para leer un carácter por teclado
    public static String leerChar(){
        while (true){
            System.out.print("--> ");
            String c = sc.nextLine();
            if(c.length() == 1){
                return c;
            } else {
                System.out.println("\u001B[33m⚠ Introduce solo un carácter \u001B[0m");
            }
        }
    }

    // Procedimiento recursivo para imprimir una cantidad de símbolos
    public static void imprimirLinea(int cantidad, char simbolo) {
        if (cantidad > 0) {
            System.out.print(simbolo);
            imprimirLinea(cantidad - 1, simbolo);
        }
    }

    // Función que generá un número aleatorio dentro de un rango
    public static int randomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }

    // Funcion para capitalizar la primera letra y poner el resto en minúsculas
    public static String capitalizar(String texto) {
        if (texto == null || texto.isEmpty()) {
            return texto; // Devuelve el texto en caso de nulo o vacío
        }
        return texto.substring(0, 1).toUpperCase() +
                texto.substring(1).toLowerCase();
    }
}