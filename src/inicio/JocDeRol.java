package inicio;

import personajes.Alien;
import personajes.Guerrero;
import personajes.Humano;
import personajes.Jugador;

public class JocDeRol {
    public static void main(String[] args) {

        pruebaFase3();
    }

    public static void pruebaFase1(){
        Jugador jugador = new Jugador("Andy", 7, 13, 25);
        System.out.println(jugador.toString());
    }

    public static void pruebaFase2(){
        Jugador jugador1 = new Jugador("Andy", 5, 0, 25);
        Jugador jugador2 = new Jugador("Guillem", 15, 10, 10);

        jugador1.ataca(jugador2);
        jugador1.ataca(jugador2);
    }

    public static void pruebaFase3(){
        Humano humano = new Humano("Humano", 20, 13, 120);
        Alien alien = new Alien("Alien", 14, 5, 45);
        Guerrero guerrero = new Guerrero("Guerrero", 20, 13, 120);

        // ¿Cada vez que atacan el alien les aumenta la vida permanentemente o solo en ese ataque?.
        // ¿Y si el alien baja a 20 de vida se les debe restar el ataque que han ganado?

        // ¿Se puede tener defensa negativa?
        guerrero.ataca(alien);
        alien.ataca(guerrero);
    }
}
