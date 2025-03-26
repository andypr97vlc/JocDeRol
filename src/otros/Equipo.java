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
        final StringBuffer sb = new StringBuffer("Equipo " + this.nombre + ":\n");
        for (Jugador j : jugadores) {
            sb.append("\t - ").append(j).append("\n");
        }
        return sb.toString();
    }

    public void poner(Jugador jugador) {
        if (!jugadores.contains(jugador)) {
            jugador.setEquipo(this);
            jugadores.add(jugador);
            System.out.println(jugador.getNombre() + " se ha unido al equipo " + this.getNombre() + "!");
        } else {
            System.out.println(jugador.getNombre() + " ya está en el equipo " + this.getNombre() + "!");
        }
    }

    public void quitar (Jugador jugador){
        if (jugadores.contains(jugador)){
            jugadores.remove(jugador);
            jugador.setEquipo(null);
            System.out.println("El jugador " + jugador.getNombre() + " ha sido eliminado del equipo " + this.nombre + ".");
        } else {
            System.out.println("El jugador " + jugador.getNombre() + " no se encuentra en ningún equipo.");
        }
    }
}
