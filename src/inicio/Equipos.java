package inicio;

import otros.Equipo;
import otros.Poder;
import teclado.Teclado;

import java.util.ArrayList;

public class Equipos {
    static ArrayList<Equipo> lista = new ArrayList<>();

    public static ArrayList<Equipo> getLista() {
        return lista;
    }

    public static void setLista(ArrayList<Equipo> lista) {
        Equipos.lista = lista;
    }

    protected static void menu(){
        boolean salir = false;
        while (!salir){
            System.out.println("""
                   -------- EQUIPOS --------
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

    // Procedimiento para crear un equipo
    protected static void crear(){
        Teclado.sc.nextLine(); // Limpiar buffer
        System.out.println("Dime el nombre del equipo.");
        String nombre = Teclado.capitalizar(Teclado.leerString());


        Equipo equipo = new Equipo(nombre);

        if (!lista.contains(equipo)){ // Comprobar si existe el equipo
            lista.add(equipo);
        } else {
            System.out.println("\u001B[33m⚠ El equipo que intenta crear ya existe\u001B[0m");
        }
    }

    // Procedimiento para consultar la lista de equipos
    protected static void consultar(){
        for (Equipo e : lista) {
            System.out.println(e);
        }
    }

    // Procedimiento para eliminar un equipo
    protected static void eliminar(){
        Teclado.sc.nextLine(); // Limpiar buffer
        System.out.println("Dime el nombre del equipo.");
        String nombre = Teclado.leerString();

        // Crear objeto auxiliar para obtener el índice
        Equipo equipoAuxiliar = new Equipo(nombre);

        if (lista.contains(equipoAuxiliar)){ // Comprobar si existe el equipo
            int indexEquipo = lista.indexOf(equipoAuxiliar);
            Equipo equipo = lista.get(indexEquipo);
            lista.remove(equipo);
        } else {
            System.out.println("\u001B[33m⚠ El equipo que intenta eliminar no existe\u001B[0m");
        }
    }
}
