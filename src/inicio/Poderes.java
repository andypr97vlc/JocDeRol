package inicio;

import otros.Poder;
import personajes.Alien;
import personajes.Guerrero;
import personajes.Humano;
import personajes.Jugador;
import teclado.Teclado;

import java.util.ArrayList;

public class Poderes {
    static ArrayList<Poder> lista = new ArrayList<>();

    public static ArrayList<Poder> getLista() {
        return lista;
    }

    public static void setLista(ArrayList<Poder> lista) {
        Poderes.lista = lista;
    }

    protected static void menu(){
        boolean salir = false;
        while (!salir){
            System.out.println("""
                   -------- PODERES --------
                   1. Crear\s
                   2. Consultar\s
                   3. Eliminar\s
                   0. Salir\s
                   ------------------------""");

            int opcion = Teclado.leerEntero();
            switch (opcion){
                case 0:
                    salir = true;
                    break;
                case 1:
                    crear();
                    break;
                case 2:
                    consultar();
                    break;
                case 3:
                    eliminar();
                    break;
                default:
                    System.out.println("\u001B[33m⚠ No existe la opción elegida \u001B[0m");
            }
        }
    }

    // Procedimiento para crear un poder y añadirlo a la lista de poderes
    protected static void crear(){
        Teclado.sc.nextLine(); // Limpiar buffer
        System.out.println("Dime el nombre del poder.");
        String nombre = Teclado.capitalizar(Teclado.leerString());

        System.out.println("\uD83D\uDDE1 Dime el ataque del poder.");
        int dmg = Teclado.leerEntero();

        System.out.println("\uD83D\uDEE1 Dime el la defensa del poder.");
        int def = Teclado.leerEntero();

        Poder poder = new Poder(nombre, dmg, def);

        if (!lista.contains(poder)){ // Comprobar si existe el poder
            lista.add(poder);
        } else {
            System.out.println("\u001B[33m⚠ El poder que intenta crear ya existe\u001B[0m");
        }
    }
    // Procedimiento para consultar los poderes creados
    protected static void consultar(){
        for (Poder p : lista) {
            System.out.println(p);
        }
    }

    // Procedimiento para eliminar un poder y añadirlo a la lista de poderes
    protected static void eliminar(){
        Teclado.sc.nextLine(); // Limpiar buffer
        System.out.println("Dime el nombre del poder.");
        String nombre = Teclado.leerString();

        // Crear objeto auxiliar para obtener el índice
        Poder poderAuxiliar = new Poder(nombre, 0, 0);

        if (lista.contains(poderAuxiliar)){ // Comprobar si existe el poder
            int indexPoder = lista.indexOf(poderAuxiliar);
            Poder poder = lista.get(indexPoder);
            lista.remove(poder);
        } else {
            System.out.println("\u001B[33m⚠ El poder que intenta eliminar no existe\u001B[0m");
        }
    }
}
