package inicio;

import otros.Equipo;
import otros.Poder;
import personajes.Alien;
import personajes.Guerrero;
import personajes.Humano;
import personajes.Jugador;
import teclado.Teclado;

import java.util.ArrayList;

public class Jugadores {
    static ArrayList<Jugador> lista = new ArrayList<>();

    protected static void menu(){
        boolean salir = false;
        while (!salir){
            System.out.println("""
                   ------- JUGADORES -------
                   1. Crear\s
                   2. Consultar\s
                   3. Eliminar\s
                   4. Asignar equipo\s
                   5. Quitar equipo\s
                   6. Asignar poder\s
                   7. Cambiar vidas iniciales\s
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
                case 4:
                    asignarEquipo();
                    break;
                case 5:
                    quitarDelEquipo();
                    break;
                case 6:
                    asignarPoder();
                    break;
                case 7:
                    cambiarVidaInicial();
                    break;
                default:
                    System.out.println("\u001B[33m⚠ No existe la opción elegida\u001B[0m");
            }
        }
    }

    protected static void crear(){
        Teclado.sc.nextLine(); // Limpiar buffer
        String tipo;
        while (true){ // Bucle para evitar introducir un tipo de jugador que no existe
            System.out.println("""
               ¿Qué tipo de jugador quieres ser?
               (H)\uD83E\uDDD1 Humano
               (G)\uD83D\uDDE1 Guerrero
               (A)\uD83D\uDC7D Alien""");
            tipo = Teclado.leerChar().toUpperCase();
            if(tipo.equals("H") || tipo.equals("G") || tipo.equals("A")){
                break;
            } else {
                System.out.println("\u001B[33m⚠ No existe la opción elegida\u001B[0m");
            }
        }

        System.out.println("Dime el nombre del jugador.");
        String nombre = Teclado.capitalizar(Teclado.leerString());


        System.out.println("Elige con cabeza. Tus puntos de defensa \uD83D\uDEE1 serán el resultado de 100 - tus PA");
        int dmg;
        while(true){ // Bucle para evitar el rango de ataque permitido
            System.out.println("Cuantos puntos de ataque \uD83D\uDDE1? (1-100): ");
            dmg = Teclado.leerEntero();
            if(dmg <= 100 && dmg > 0){
                break;
            } else {
                System.out.println("\u001B[33m⚠ Puntos de ataque fuera de rango\u001B[0m");
            }
        }

        int def = 100 - dmg;

        Jugador jugador = switch (tipo) { // Switch para crear el jugador
            case "H" -> new Humano(nombre, dmg, def, Jugador.getVidaInicial());
            case "G" -> new Guerrero(nombre, dmg, def, Jugador.getVidaInicial());
            case "A" -> new Alien(nombre, dmg, def, Jugador.getVidaInicial());
            default -> null;
        };

        if (!lista.contains(jugador)){ // Comprobar si ya existe o no
            lista.add(jugador);
        } else {
            System.out.println("\u001B[33m⚠ El jugador que intenta crear ya existe\u001B[0m");
        }

    }

    // Procedimiento para consultar los jugadores
    protected static void consultar(){
        for (Jugador j : lista) {
            System.out.println((lista.indexOf(j) + 1) + " - " + j);
        }
    }

    // Procedimiento para eliminar un jugador
    protected static void eliminar(){
        Teclado.sc.nextLine(); // Limpiar buffer
        System.out.println("Dime el nombre del jugador que desea eliminar");
        String nombre = Teclado.leerString();

        // Crear objeto auxiliar para obtener el índice
        Jugador jugAuxiliar = new Jugador (nombre, 0, 0,0);

        if (lista.contains(jugAuxiliar)){ // Comprobar si existe o no
            int indexJugador = lista.indexOf(jugAuxiliar);
            Jugador jugador = lista.get(indexJugador);
            lista.remove(jugador);
        } else{
            System.out.println("\u001B[33m⚠ El jugador que intenta eliminar no existe\u001B[0m");
        }
    }

    // Procedimiento para añadir un jugador a un equipo
    protected static void asignarEquipo() {
        Teclado.sc.nextLine(); // Limpiar buffer
        System.out.println("Dime el nombre del jugador que desea agregar al equipo");
        String nombre = Teclado.leerString();

        // Crear objeto auxiliar para obtener el índice
        Jugador jugAuxiliar = new Jugador (nombre, 0, 0,0);

        System.out.println("Dime el nombre del equipo");
        String nombreEquipo = Teclado.leerString();
        // Crear objeto auxiliar para obtener el índice
        Equipo eqAuxiliar = new Equipo (nombreEquipo);

        if (lista.contains(jugAuxiliar)){ // Comprobar si existe el jugador
            int indexJugador = lista.indexOf(jugAuxiliar);
            Jugador jugador = lista.get(indexJugador);
            if (Equipos.lista.contains(eqAuxiliar)){ // Comprobar si existe el equipo
                int indexEquipo = Equipos.lista.indexOf(eqAuxiliar);
                Equipo equipo = Equipos.lista.get(indexEquipo);
                jugador.setEquipo(equipo);
            } else System.out.println("\u001B[33m⚠ El equipo no existe\u001B[0m");
        } else{
            System.out.println("\u001B[33m⚠ El jugador no existe\u001B[0m");
        }
    }

    // Procedimiento para quitar a un jugador de un equipo
    protected static void quitarDelEquipo() {
        Teclado.sc.nextLine(); // Limpiar buffer
        System.out.println("Dime el nombre del jugador que desea eliminar del equipo");
        String nombre = Teclado.leerString();
        // Crear objeto auxiliar para obtener el índice
        Jugador jugAuxiliar = new Jugador (nombre, 0, 0,0);

        System.out.println("Dime el nombre del equipo");
        String nombreEquipo = Teclado.leerString();
        // Crear objeto auxiliar para obtener el índice
        Equipo eqAuxiliar = new Equipo (nombreEquipo);

        if (lista.contains(jugAuxiliar)){ // Comprobar si existe el jugador
            if (Equipos.lista.contains(eqAuxiliar)){ // Comprobar si existe el equipo
                jugAuxiliar.setEquipo(null);
            } else System.out.println("\u001B[33m⚠ El equipo no existe\u001B[0m");
        } else{
            System.out.println("\u001B[33m⚠ El jugador no existe\u001B[0m");
        }
    }

    // Procedimiento para asignar un poder a un jugador
    protected static void asignarPoder() {
        Teclado.sc.nextLine(); // Limpiar buffer
        System.out.println("Dime el nombre del jugador que desea añadir el poder");
        String nombre = Teclado.leerString();
        // Crear objeto auxiliar para obtener el índice
        Jugador jugAuxiliar = new Jugador (nombre, 0, 0,0);

        System.out.println("Dime el nombre del poder");
        String nombrePoder = Teclado.leerString();
        // Crear objeto auxiliar para obtener el índice
        Poder poderAuxiliar = new Poder (nombrePoder, 0,0);

        if (lista.contains(jugAuxiliar)){ // Comprobar si existe el jugador
            int indexJugador = lista.indexOf(jugAuxiliar);
            Jugador jugador = lista.get(indexJugador);
            if (Poderes.lista.contains(poderAuxiliar)){ // Comprobar si existe el poder
                int indexPoder = Poderes.lista.indexOf(poderAuxiliar);
                Poder poder = Poderes.lista.get(indexPoder);
                jugador.poner(poder);
            } else System.out.println("\u001B[33m⚠ El poder no existe\u001B[0m");
        } else{
            System.out.println("\u001B[33m⚠ El jugador no existe\u001B[0m");
        }
    }

    // Procedimiento para establecer la vida inicial de los jugadores antes de crearlos
    protected static void cambiarVidaInicial(){
        System.out.println("Con cuántos puntos de vida empezarán todos los jugadores ♥️?");
        Jugador.vidaInicial = Teclado.leerEntero();
    }
}
