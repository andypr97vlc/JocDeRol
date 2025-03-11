package inicio;

import personajes.Humano;
import personajes.Jugador;

public class JocDeRol {
    public static void main(String[] args) {

        pruebaFase2();
    }

    public static void pruebaFase1(){
        Jugador andy = new Jugador("Andy", 7, 13, 25);
        System.out.println(andy.toString());

    }

    public static void pruebaFase2(){
        Jugador andy = new Jugador("Andy", 7, 13, 25);
        Jugador guillem = new Jugador("Guillem", 15, 5, 10);

        andy.ataca(guillem);

    }

    public static void pruebaFase3(){
        Humano andy = new Humano("Andy", 7, 13, 120);

        System.out.println(andy.toString());
    }
}
