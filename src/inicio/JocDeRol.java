package inicio;

import otros.Equipo;
import otros.Poder;
import personajes.Alien;
import personajes.Guerrero;
import personajes.Humano;
import personajes.Jugador;

public class JocDeRol {
    public static void main(String[] args) {

        pruebaFase5();
    }

    public static void pruebaFase1(){
        Jugador jugador = new Jugador("Andy", 7, 13, 25);
        System.out.println(jugador);
    }

    public static void pruebaFase2(){
        Jugador jugador1 = new Jugador("Andy", 5, 0, 25);
        Jugador jugador2 = new Jugador("Guillem", 15, 10, 10);

        jugador1.ataca(jugador2);
        jugador1.ataca(jugador2);
    }

    public static void pruebaFase3(){
        Jugador humano = new Humano("Humano", 20, 13, 120);
        Jugador alien = new Alien("Alien", 14, 5, 30);
        Jugador guerrero = new Guerrero("Guerrero", 20, 13, 120);

        alien.ataca(guerrero);
        alien.ataca(guerrero);
    }

    public static void pruebaFase4(){
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

    public static void pruebaFase5(){
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
