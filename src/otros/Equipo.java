package otros;

import personajes.Jugador;

import java.util.ArrayList;

public class Equipo {
    private String nombre;
    private ArrayList<Jugador> jugadores = new ArrayList<>();

    public Equipo(String nombre) {
        this.nombre = nombre;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Equipo [" + this.nombre + "]");
        if(jugadores.isEmpty()){
            sb.append(" está vacío. \uD83D\uDD73\uFE0F");
        } else{
            for (Jugador j : jugadores) {
                sb.append("\n").append("\t - ").append(j);
            }
        }

        return sb.toString();
    }

    public void poner(Jugador jugador) {
        if (!jugadores.contains(jugador)) {
            jugadores.add(jugador);
            if(jugador.getEquipo() != this){
                jugador.setEquipo(this);
            }
            System.out.println("\u001B[32m\u2713 " + jugador.getNombre() + " se ha unido al equipo: [" + this.getNombre() + "]\u001B[0m");
        } else {
            System.out.println("\u001B[33m\u26A0 " + jugador.getNombre() + " ya está en el equipo: [" + this.getNombre() + "]\u001B[0m");
        }
    }

    public void quitar(Jugador jugador) {
        if (jugadores.contains(jugador)) {
            jugadores.remove(jugador);
            if(jugador.getEquipo() != null){
                jugador.setEquipo(null);
            }
            System.out.println("\u001B[36m\uD83D\uDEAA " + jugador.getNombre() + " ha abandonado el equipo: [" + this.nombre + "]\u001B[0m");
        } else {
            System.out.println("\u001B[33m\u26A0 " + jugador.getNombre() + " no se encuentra en el equipo: [" + this.nombre + "]\u001B[0m");
        }
    }

}
