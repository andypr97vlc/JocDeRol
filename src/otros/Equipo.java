package otros;

import personajes.Jugador;

import java.io.Serializable;
import java.util.ArrayList;

public class Equipo implements Serializable {
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

    // Resto de funciones y procedimientos
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Equipo [" + this.getNombre() + "]");
        if(jugadores.isEmpty()){
            sb.append(" está vacío. \uD83D\uDD73️");
        } else{
            for (Jugador j : jugadores) {
                sb.append("\n").append("\t - ").append(j);
            }
        }

        return sb.toString();
    }

    // Procedimiento que añade un jugador al equipo de forma bidireccional
    public void poner(Jugador jugador) {
        if (!jugadores.contains(jugador)) {
            jugadores.add(jugador);
            if(jugador.getEquipo() != this){
                jugador.setEquipo(this);
            }
            System.out.println("\u001B[32m✓ " + jugador.getNombre() + " se ha unido al equipo: [" + this.getNombre() + "]\u001B[0m");
        } else {
            System.out.println("\u001B[33m⚠ " + jugador.getNombre() + " ya está en el equipo: [" + this.getNombre() + "]\u001B[0m");
        }
    }

    // Procedimiento que elimina un jugador del equipo de forma bidireccional
    public void quitar(Jugador jugador) {
        if (jugadores.contains(jugador)) {
            jugadores.remove(jugador);
            if(jugador.getEquipo() != null){
                jugador.setEquipo(null);
            }
            System.out.println("\u001B[36m\uD83D\uDEAA " + jugador.getNombre() + " ha abandonado el equipo: [" + this.getNombre() + "]\u001B[0m");
        } else {
            System.out.println("\u001B[33m⚠ " + jugador.getNombre() + " no se encuentra en el equipo: [" + this.getNombre() + "]\u001B[0m");
        }
    }

    // Sobrescrita la funcion para comprobar solo el nombre del equipo
    @Override
    public boolean equals(Object objeto) {
        Equipo equipo = (Equipo) objeto;
        return this.getNombre().equalsIgnoreCase(equipo.getNombre());
    }
}
