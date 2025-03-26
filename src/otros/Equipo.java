package otros;

import personajes.Jugador;

import java.util.ArrayList;

public class Equipo {
    private String nombre;
    private ArrayList<Jugador> jugadores = new ArrayList<>();

    public Equipo(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Equipo [" + this.nombre + "]\n");
        for (Jugador j : jugadores) {
            sb.append("\t - ").append(j).append("\n");
        }
        return sb.toString();
    }

    public void poner(Jugador jugador) {
        if (!jugadores.contains(jugador)) {
            jugadores.add(jugador);
            jugador.setEquipo(this);
            System.out.println("\u001B[32m\u2713 " + jugador.getNombre() + " se ha unido al equipo: [" + this.getNombre() + "]\u001B[0m");
        } else {
            System.out.println("\u001B[33m\u26A0 " + jugador.getNombre() + " ya está en el equipo: [" + this.getNombre() + "]\u001B[0m");
        }
    }

    public void quitar (Jugador jugador){
        if (jugadores.contains(jugador)){
            jugadores.remove(jugador);
            jugador.setEquipo(null);
            System.out.println("\u001B[36m\uD83D\uDEAA " + jugador.getNombre() + " ha abandonado el equipo: [" + this.nombre + "]\u001B[0m");
        } else {
            System.out.println("\u001B[33m\u26A0 " + jugador.getNombre() + " no se encuentra en el equipo: [" + this.nombre + "]\u001B[0m");
        }
    }
}
