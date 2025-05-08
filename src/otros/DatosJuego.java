package otros;

import inicio.Equipos;
import inicio.Jugadores;
import inicio.Poderes;
import personajes.Jugador;

import java.io.*;
import java.util.ArrayList;

public class DatosJuego implements Serializable {
    private ArrayList<Jugador> jugadores;
    private ArrayList<Equipo> equipos;
    private ArrayList<Poder> poderes;

    public DatosJuego(ArrayList<Jugador> jugadores, ArrayList<Equipo> equipos, ArrayList<Poder> poderes) {
        this.jugadores = jugadores;
        this.equipos = equipos;
        this.poderes = poderes;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public ArrayList<Poder> getPoderes() {
        return poderes;
    }

    // Procedimiento para guardar partida
    public static void guardarPartida() {
        FileOutputStream fos;
        ObjectOutputStream oos;
        String ruta = "partidasGuardadas/datosJuego.obj";

        try {
            fos = new FileOutputStream(ruta);
            oos = new ObjectOutputStream(fos);

            DatosJuego datos = new DatosJuego(Jugadores.getLista(), Equipos.getLista(), Poderes.getLista());

            oos.writeObject(datos);
            System.out.println("\u001B[32m✔ Partida guardada con éxito.\u001B[0m");
        } catch (IOException ex) {
            System.out.println("\u001B[33m⚠ Error accediendo al fichero: " + ex.getMessage() + "\u001B[0m");
        }
    }

    // Procedimiento para cargar la partida
    public static void cargarPartida(){
        FileInputStream fis;
        ObjectInputStream ois;
        String ruta = "partidasGuardadas/datosJuego.obj";

        try {
            fis = new FileInputStream(ruta);
            ois = new ObjectInputStream(fis);

            DatosJuego datos = (DatosJuego) ois.readObject();

            // Acceder a las listas:
            Jugadores.setLista(datos.getJugadores());
            Equipos.setLista(datos.getEquipos());
            Poderes.setLista(datos.getPoderes());

            ois.close();
            System.out.println("\u001B[32m✔ Partida cargada con éxito.\u001B[0m");
        } catch (FileNotFoundException ex) {
            System.out.println("\u001B[33m⚠ Fichero no encontrado \u001B[0m");
        } catch (IOException ex) {
            System.out.println("\u001B[33m⚠ Error accediendo al fichero \u001B[0m");
        } catch (ClassNotFoundException ex) {
            System.out.println("\u001B[33m⚠ Classe no encontrada \u001B[0m");
        }
    }
}
