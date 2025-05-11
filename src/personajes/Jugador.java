package personajes;

import otros.Equipo;
import otros.Poder;
import teclado.Teclado;

import java.io.Serializable;
import java.util.ArrayList;

public class Jugador implements Serializable, Comparable<Jugador> {
    private String nombre;
    private int ataque;
    private int defensa;
    private int vidas;
    public static int vidaInicial = 200;
    private Equipo equipo;
    private final ArrayList<Poder> poderes = new ArrayList<>();

    public Jugador(String nombre, int ataque, int defensa, int vidas){
        this.nombre = nombre;
        this.ataque = ataque;
        this.defensa = defensa;
        this.vidas = vidas;
    }

    // Setters
    protected void setNombre(String nombre){
        this.nombre = nombre;
    }

    protected void setAtaque(int ataque){
        this.ataque = ataque;
    }

    protected void setDefensa(int defensa){
        this.defensa = defensa;
    }

    protected void setVidas(int vidas){
        this.vidas = vidas;
    }

    // Modificado el setter para que sea bidireccional con el equipo
    public void setEquipo(Equipo equipo) {
        if (this.getEquipo() == equipo && equipo != null){
            System.out.println("\u001B[33m⚠ " + this.getNombre() + " ya está en el equipo: [" + equipo.getNombre() + "]\u001B[0m");
        }
        if (this.equipo == null && equipo == null){
            System.out.println("\u001B[33m⚠ " + this.getNombre() + " no se encuentra en ningún equipo.\u001B[0m");
        }

        // Añade el equipo al jugador o lo elimina de forma bidireccional
        if (equipo != null) {
            this.equipo = equipo;
            if (!equipo.getJugadores().contains(this)) {
                equipo.poner(this);
            }
        } else {
            if(this.equipo != null){
                if (this.equipo.getJugadores().contains(this)){
                    this.equipo.quitar(this);
                }
            }
            this.equipo = null;
        }
    }

    // Getters
    public String getNombre(){
        return nombre;
    }

    public int getAtaque(){
        return ataque;
    }

    public int getDefensa(){
        return defensa;
    }

    public int getVidas(){
        return vidas;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public ArrayList<Poder> getPoderes() {
        return poderes;
    }

    public static int getVidaInicial() {
        return vidaInicial;
    }

    // Resto de funciones y procedimientos
    public String toString() {
        // Comprueba que tenga equipo para añadirlo al string o poner que no tiene equipo
        String nombreEquipo = this.getEquipo() != null ? this.getEquipo().getNombre() : "Sin equipo";
        // Saber si se encuentra muerto o vivo para añadirlo al string
        String muerto = this.getVidas() == 0 ? "Está muerto. \u2620\uFE0F" : "";
        // En un principio era una lista con los poderes, pero el IDE me recomendaba poner esto.
        final StringBuilder poderes = new StringBuilder();
        if (!this.getPoderes().isEmpty()){
            poderes.append("\n\t\tTiene los poderes:");
            for (Poder p : this.getPoderes()){
                poderes.append("\n\t\t- ").append(p);
            }
        }

        return this.getNombre() +
                " [" + nombreEquipo + "]" +
                " (" + this.getClass().getSimpleName().toUpperCase() +
                ", PA:" + this.getAtaque() +
                ", PD:" + this.getDefensa() +
                ", PV:" + this.getVidas() + ") " +
                muerto +
                poderes;
    }

    // Procedimiento para que un jugador golpee con el daño asignado
    protected void esGolpeadoCon(int dmg){
        // Cálculo del daño real después de defenderse
        int dmgDefendido = dmg - this.getDefensa();
        if (dmgDefendido < 0) dmgDefendido = 0; // No puede curarse con la defensa

        // Cálculo del daño hecho después del golpe
        int vidaInicial = this.getVidas();
        int vidaRestante = Math.max(vidaInicial - dmgDefendido, 0);

        System.out.println("\t" + this.getNombre() +
                " es golpeado con " + dmg +
                " puntos de daño y se defiende con " + this.getDefensa() + ". "
                + "Vidas: " + vidaInicial + " - " + dmgDefendido + " = " + vidaRestante);

        this.setVidas(vidaRestante);
    }

    // Funcion para sacar la suma total del daño y defensa de los poderes para añadirlo posteriormente a la hora de atacar
    protected Integer[] estadisticasPoderes(){
        Integer[] estadisticas = {0, 0};
        // Recorre los poderes y guarda la suma total del daño y la defensa
        for (Poder p : this.getPoderes()){
            estadisticas[0] += p.getBonusAtaque();
            estadisticas[1] += p.getBonusDefensa();
        }

        String pasivaDe = "--------------- Poderes de " + this.getNombre() + " ---------------";
        int cantidadLetras = pasivaDe.length();

        System.out.println(pasivaDe);
        System.out.println("- Anteriores estadísticas: Daño: " + this.getAtaque() + ", Defensa: " + this.getDefensa());
        System.out.println("+ Nuevas estadísticas: Daño: " + (this.getAtaque() + estadisticas[0]) + ", Defensa: " + (this.getDefensa()  + estadisticas[1]));
        Teclado.imprimirLinea(cantidadLetras, '-');
        System.out.println();

        // Añadir estadísticas a los jugadores
        this.setAtaque(this.getAtaque() + estadisticas[0]);
        this.setDefensa(this.getDefensa() + estadisticas[1]);
        return estadisticas;
    }

    // Procedimiento para atacar a otro jugador
    public void ataca(Jugador jugador){
        // Recoger los datos de los poderes de ambos jugadores
        Integer[][] dmg_def = {{0, 0}, {0, 0}};
        if (!getPoderes().isEmpty()) {
            dmg_def[0] = estadisticasPoderes();
        }
        if (!jugador.getPoderes().isEmpty()){
            dmg_def[1] = jugador.estadisticasPoderes();
        }

        // Estadísticas anteriores al combate
        System.out.println("\u001B[32m===== INICIO DEL COMBATE =====\u001B[0m");
        System.out.println("ANTES DEL ATAQUE:");
        System.out.println("\tAtacante: " + this);
        System.out.println("\tAtacado: " + jugador);

        System.out.println("\n>>> " + this.getNombre() + " ataca a " + jugador.getNombre() + "!");
        jugador.esGolpeadoCon(this.getAtaque());

        // Evitar que el jugador que ha muerto contraataque
        if(jugador.getVidas() == 0) System.out.println(jugador.getNombre() + " ha muerto! \u2620\uFE0F");
        else{
            System.out.println("\n>>> " + jugador.getNombre() + " contraataca!");
            this.esGolpeadoCon(jugador.getAtaque());
        }

        // Estadísticas posteriores al combate
        System.out.println("\nDESPUÉS DEL ATAQUE:");
        System.out.println("\tAtacante: " + this);
        System.out.println("\tAtacado: " + jugador);
        System.out.println("\u001B[91m===== FIN DEL COMBATE =====\u001B[0m");

        // Restar los datos de los poderes para que vuelva a la normalidad
        this.setAtaque(this.getAtaque() - dmg_def[0][0]);
        this.setDefensa(this.getDefensa() - dmg_def[0][1]);
        jugador.setAtaque(jugador.getAtaque() - dmg_def[1][0]);
        jugador.setDefensa(jugador.getDefensa() - dmg_def[1][1]);
    }

    // Sobrescrita la funcion para comprobar solo el nombre del jugador
    @Override
    public boolean equals(Object objeto) {
        Jugador jugador = (Jugador) objeto;
        return this.getNombre().equalsIgnoreCase(jugador.getNombre());
    }

    // Procedimiento que añade un poder a la lista de poderes del jugador
    public void poner(Poder poder){
        if (!poderes.contains(poder)) {
            poderes.add(poder);
        } else System.out.println("\u001B[33m⚠ " + this.getNombre() + " ya tiene ese poder!\u001B[0m");
    }

    // Procedimiento que elimina un poder a la lista de poderes del jugador
    public void quitar(Poder poder){
        if (poderes.contains(poder)) {
            poderes.remove(poder);
        } else System.out.println("\u001B[33m⚠ " + this.getNombre() + " no tiene ese poder!\u001B[0m");
    }

    // Este comparador ordena por clases y lo hace de forma automática cada vez que se consultan los jugadores o se inicia la partida
    @Override
    public int compareTo(Jugador otroJugador) {
        // Comparar por nombres de clases para ordenar por tipos de jugador
        int compararClase = this.getClass().getSimpleName().compareTo(otroJugador.getClass().getSimpleName());

        if (compararClase != 0) return compararClase;

        // Si tienen la misma clase se compara el nombre
        return this.getNombre().compareTo(otroJugador.getNombre());
    }
}
