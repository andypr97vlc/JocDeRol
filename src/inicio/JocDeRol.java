package inicio;

import otros.Equipo;
import otros.Poder;
import personajes.Alien;
import personajes.Guerrero;
import personajes.Humano;
import personajes.Jugador;
import teclado.Teclado;

public class JocDeRol {
    public static void main(String[] args) {
        boolean salir = false;
        while (!salir){
            System.out.println("""
                    ----- JUEGO DE ROL -----
                    1. Configuración\s
                    2. Jugar\s
                    0. Salir\s
                    ------------------------""");
            int opcion = Teclado.leerEntero();

            switch (opcion){
                case 0:
                    salir = true;
                    break;
                case 1:
                    menuConfiguracion();
                    break;
                case 2:
                    menuJugar();
                    break;
                default:
                    System.out.println("\u001B[33m⚠ No existe la opción elegida \u001B[0m");
            }
        }
    }

    protected static void menuConfiguracion() {
        boolean salir = false;
        while (!salir) {
            System.out.println("""
                    ----- CONFIGURACIÓN -----
                    1. Jugadores\s
                    2. Equipos\s
                    3. Poderes
                    0. Salir\s
                    -------------------------""");
            int opcion = Teclado.leerEntero();

            switch (opcion) {
                case 0:
                    salir = true;
                    break;
                case 1:
                    Jugadores.menu();
                    break;
                case 2:
                    Equipos.menu();
                    break;
                case 3:
                    Poderes.menu();
                    break;
                default:
                    System.out.println("\u001B[33m⚠ No existe la opción elegida \u001B[0m");
            }
        }
    }

    protected static void menuJugar(){
        boolean salir = false;
        while (!salir){
            System.out.println("""
                --------- JUGAR ---------
                1. Automático\s
                2. Manual\s
                0. Salir\s
                -------------------------""");
            int opcion = Teclado.leerEntero();

            switch (opcion){
                case 0:
                    salir = true;
                    break;
                case 1:
                    jugarAuto();
                    break;
                case 2:
                    jugarManual();
                    break;
                default:
                    System.out.println("\u001B[33m⚠ No existe la opción elegida \u001B[0m");
            }
        }
    }

    // Procedimiento para jugar la partida de forma automática hasta que solo quede un jugador
    protected static void jugarAuto(){
        if (Jugadores.lista.size() > 1){
            Jugador ganador = Jugadores.lista.getFirst();

            while(true){
                // Saber cuantos jugadores siguen vivos
                int jugadoresVivos = 0;
                for (Jugador j : Jugadores.lista){
                    if(j.getVidas() > 0){
                        ganador = j;
                        jugadoresVivos++;
                    }
                }
                if (jugadoresVivos == 1) break;

                // Escoger a dos jugadores aleatorios
                int j1Random; int j2Random;
                do {
                    j1Random = Teclado.randomInt(0, Jugadores.lista.size());
                } while (Jugadores.lista.get(j1Random).getVidas() <= 0);

                // Elegir un personaje que no sea el mismo o esté muerto
                do {
                    j2Random = Teclado.randomInt(0, Jugadores.lista.size());
                } while (j1Random == j2Random || Jugadores.lista.get(j2Random).getVidas() <= 0);

                // Atacar
                Jugadores.lista.get(j1Random).ataca(Jugadores.lista.get(j2Random));
            }

            System.out.println("El ganador es: " + ganador);
        } else if (Jugadores.lista.isEmpty()){
            System.out.println("No hay jugadores en la lista");
        } else {
            System.out.println("Solo existe un jugador, así que gana automáticamente:\n" +
                    Jugadores.lista.getFirst());
        }
    }

    // Procedimiento para jugar la partida de forma manual
    protected static void jugarManual(){
        if (Jugadores.lista.size() > 1){
            Jugador ganador = Jugadores.lista.getFirst();

            while (true){
                // Saber cuantos jugadores siguen vivos
                int jugadoresVivos = 0;
                for (Jugador j : Jugadores.lista){
                    if(j.getVidas() > 0){
                        ganador = j;
                        jugadoresVivos++;
                    }
                }
                if (jugadoresVivos == 1) break;

                int jugadorElegido;
                // Bucle para que los jugadores ataquen en orden
                for (int i = 0; i < Jugadores.lista.size(); i++) {
                    // Si el jugador al que le toca se encuentra muerto, saltará al siguiente
                    if (Jugadores.lista.get(i).getVidas() > 0){
                        System.out.println("Le toca jugar a " + Jugadores.lista.get(i).getNombre());

                        /* Comprobar que el número de la elección este dentro del rango permitido,
                        que el jugador no esté muerto o sea el mismo.*/
                        do {
                            System.out.println("A que jugador quieres atacar?");
                            Jugadores.consultar();
                            jugadorElegido = Teclado.leerEntero();
                            if(Jugadores.lista.get(jugadorElegido - 1).getVidas() <= 0) System.out.println("\u001B[33m⚠ Ese jugador está muerto. \u2620\uFE0F \u001B[0m");
                            if(Jugadores.lista.indexOf(Jugadores.lista.get(i)) + 1 == jugadorElegido) System.out.println("\u001B[33m⚠ No puedes atacarte a ti mismo \u001B[0m");
                        } while (jugadorElegido < 1 || jugadorElegido > Jugadores.lista.size() || Jugadores.lista.get(jugadorElegido - 1).getVidas() <= 0 || Jugadores.lista.indexOf(Jugadores.lista.get(i)) + 1 == jugadorElegido);

                        Jugadores.lista.get(i).ataca(Jugadores.lista.get(jugadorElegido - 1));
                    }
                }
            }

            System.out.println("El ganador es: " + ganador);
        } else if (Jugadores.lista.isEmpty()){
            System.out.println("No hay jugadores en la lista");
        } else {
            System.out.println("Solo existe un jugador, así que gana automáticamente:\n" +
                    Jugadores.lista.getFirst());
        }
    }
    // Pruebas de las fases

    @SuppressWarnings("unused")
    public static void pruebaFase1() {
        Jugador jugador = new Jugador("Andy", 20, 15, Jugador.getVidaInicial());
        System.out.println(jugador);
    }

    @SuppressWarnings("unused")
    public static void pruebaFase2() {
        Jugador jugador1 = new Jugador("Andy", 5, 0, 25);
        Jugador jugador2 = new Jugador("Guillem", 15, 10, 10);

        jugador1.ataca(jugador2);
        jugador1.ataca(jugador2);
    }

    @SuppressWarnings("unused")
    public static void pruebaFase3() {
        Jugador humano = new Humano("Humano", 20, 13, 120);
        Jugador alien = new Alien("Alien", 14, 5, 30);
        Jugador guerrero = new Guerrero("Guerrero", 20, 13, 120);

        alien.ataca(guerrero);
        alien.ataca(guerrero);
    }

    @SuppressWarnings("unused")
    public static void pruebaFase4() {
        Equipo equipo1 = new Equipo("Akudo");
        Equipo equipo2 = new Equipo("Padalustro");

        Jugador j1 = new Alien("Miguel", 30, 20, 100);
        Jugador j2 = new Alien("Manolo", 25, 10, 50);
        Jugador j3 = new Alien("Miguel", 35, 10, 50); // Mismo nombre que J1
        Jugador j4 = new Guerrero("Lucia", 15, 30, 150);


        equipo1.poner(j1);
        j1.setEquipo(equipo1);

        equipo1.poner(j2);
        equipo1.poner(j3);
        equipo1.poner(j4);

        System.out.println(equipo1);
        System.out.println(j1);

        equipo1.quitar(j1);
        j1.setEquipo(null);

        System.out.println(equipo1);
        System.out.println(j1);

        equipo1.quitar(j2);
        equipo1.quitar(j2);

        System.out.println(equipo1);

        equipo1.quitar(j4);

        System.out.println(equipo1);

        equipo2.poner(j2);
        equipo2.poner(j1);

        equipo2.quitar(j4);

        System.out.println(j1);
        System.out.println(equipo2);

        equipo1.poner(j1);

        System.out.println(j1);
        System.out.println(equipo1);
    }

    @SuppressWarnings("unused")
    public static void pruebaFase5() {
        Poder poder1 = new Poder("Fuerza", 15, 5);
        Poder poder2 = new Poder("Vuelo", 20, 10);

        Jugador humano = new Humano("Humano", 20, 13, 120);
        Jugador alien = new Alien("Alien", 10, 5, 40);
        Jugador guerrero = new Guerrero("Guerrero", 20, 10, 120);

        alien.poner(poder1);
        alien.poner(poder2);

        alien.ataca(guerrero);
        alien.ataca(guerrero);
    }
}
