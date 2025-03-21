package otros;

import personajes.Jugador;

import java.util.ArrayList;

public class Equipo {
    private String nombre;
    private ArrayList<Jugador> jugadores;

    public Equipo(String nombre) {
        this.nombre = nombre;
        this.jugadores = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void poner(Jugador jugador) {
        if (jugadores.contains(jugador)) {
            System.out.println(jugador.getNombre() + " ya está en el equipo " + this.nombre + "!");
        } else {
            jugadores.add(jugador);
            System.out.println(jugador.getNombre() + " se ha unido al equipo " + this.nombre + "!");
        }
    }
}
