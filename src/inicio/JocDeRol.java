package inicio;

import otros.Equipo;
import personajes.Alien;
import personajes.Guerrero;
import personajes.Humano;
import personajes.Jugador;

public class JocDeRol {
    public static void main(String[] args) {

        pruebaFase4();
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
        Jugador alien = new Alien("Alien", 14, 5, 40);
        Jugador guerrero = new Guerrero("Guerrero", 20, 13, 120);

        // Cada vez que atacan el alien le aumenta el ataque permanentemente.
        // Cada vez que atacan el alien le baja la defensa permanentemente.
        // Si ataca por debajo de 20 PV no usa su habilidad.
        // ¿Se puede tener defensa negativa? No.

        alien.ataca(guerrero);
        alien.ataca(guerrero);
    }

    public static void pruebaFase4(){
        Equipo equip1 = new Equipo("Padalustro");

        Jugador j1 = new Guerrero("Miguel", 30, 20, 100);
        Jugador j2 = new Alien("Manolo", 25, 10, 50);
        Jugador j3 = new Alien("Miguel", 35, 10, 50); // Mismo nombre que j1
        Jugador j4 = new Alien("Lucia", 15, 30, 150);

        equip1.poner(j1);
        equip1.poner(j2);
        equip1.poner(j3);
        equip1.poner(j4);

        equip1.quitar(j2);
        equip1.quitar(j2);

        System.out.println(equip1);

        equip1.quitar(j4);

        System.out.println(equip1);
    }
}
