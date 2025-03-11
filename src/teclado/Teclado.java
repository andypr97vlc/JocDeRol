package teclado;

import java.util.Scanner;

public class Teclado {
    static Scanner sc = new Scanner(System.in);

    public static void imprimirLinea(int cantidad) {
        if (cantidad > 0) {
            System.out.print("-");
            imprimirLinea(cantidad - 1);
        }
    }
}