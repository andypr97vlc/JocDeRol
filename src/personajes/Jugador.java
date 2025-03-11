package personajes;

import otros.Equipo;
import otros.Poder;
import teclado.Teclado;

import java.util.ArrayList;

/**
 * La clase {@code Jugador} representa a un jugador en el juego, con atributos como nombre, ataque, defensa y vidas.
 *
 * <p>Esta clase es la base para crear diferentes tipos de jugadores o personajes en el juego. Proporciona
 * los atributos básicos y métodos comunes que pueden ser heredados o extendidos por subclases.
 *
 * @see Alien Para un ejemplo de una subclase que extiende {@code Jugador}.
 */
public class Jugador {
    private String nombre;
    private int ataque;
    private int defensa;
    private int vidas;
    private Equipo equipo;
    private ArrayList<Poder> poderes = new ArrayList<>();

    public Jugador(String nombre, int ataque, int defensa, int vidas){
        this.nombre = nombre;
        this.ataque = ataque;
        this.defensa = defensa;
        this.vidas = vidas;

        System.out.println("Soy el constructor de Jugador pero estoy creando un " + this.getClass().getSimpleName());
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

    public void setEquipo(Equipo equipo) {
        if (this.getEquipo() == equipo && equipo != null){
            System.out.println("\u001B[33m\u26A0 " + this.getNombre() + " ya está en el equipo: [" + equipo.getNombre() + "]\u001B[0m");
        }
        if (this.equipo == null && equipo == null){
            System.out.println("\u001B[33m\u26A0 " + this.getNombre() + " no se encuentra en ningún equipo.\u001B[0m");
        }

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

    // Resto de funciones
    public String toString() {
        String nombreEquipo = (this.getEquipo() != null) ? this.getEquipo().getNombre() : "Sin equipo";
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
                ", PV:" + this.getVidas() + ")" +
                poderes;
    }

    /**
     * Procesa el daño recibido por el personaje, aplicando la defensa para reducir el daño
     * y actualizando la vida restante del personaje.
     *
     * <p>El daño recibido se reduce restando la defensa del personaje. Si el daño resultante
     * es negativo, se ajusta a 0 para evitar que el personaje "se cure" al recibir daño.
     *
     * <p>La vida del personaje se actualiza restando el daño defendido. Si la vida restante
     * es menor que 0, se ajusta a 0 para evitar valores negativos.
     *
     * <p>El método imprime por consola un mensaje detallado que incluye:
     * <ul>
     *   <li>El nombre del personaje.</li>
     *   <li>El daño recibido.</li>
     *   <li>La defensa aplicada.</li>
     *   <li>La vida inicial y la vida restante después del golpe.</li>
     * </ul>
     *
     * @param dmg El daño recibido antes de aplicar la defensa. Debe ser un valor no negativo.
     * @see #getDefensa() Para obtener el valor de defensa del personaje.
     * @see #getVidas() Para obtener la vida actual del personaje.
     * @see #setVidas(int) Para establecer la nueva vida del personaje después del golpe.
     */
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

    protected Integer[] estadisticasPoderes(){

        Integer[] estadisticas = {0, 0};
        for (Poder p : this.getPoderes()){
            estadisticas[0] += p.getBonusAtaque();
            estadisticas[1] += p.getBonusDefensa();
        }

        String pasivaDe = "--------------- Poderes de " + this.getNombre() + " ---------------";
        int cantidadLetras = pasivaDe.length();

        System.out.println(pasivaDe);
        System.out.println("- Anteriores estadísticas: Daño: " + this.getAtaque() + ", Defensa: " + this.getDefensa());
        System.out.println("+ Nuevas estadísticas: Daño: " + (this.getAtaque() + estadisticas[0]) + ", Defensa: " + (this.getDefensa()  + estadisticas[1]));
        Teclado.imprimirLinea(cantidadLetras);
        System.out.println();

        this.setAtaque(this.getAtaque() + estadisticas[0]);
        this.setDefensa(this.getDefensa() + estadisticas[1]);
        return estadisticas;
    }

    /**
     * Realiza un combate entre el jugador actual (atacante) y otro jugador (atacado).
     * El procedimiento consta de dos fases: ataque y contraataque.
     *
     * <p>El método imprime por consola el estado de los jugadores antes y después del combate,
     * así como los mensajes descriptivos de cada acción realizada durante el combate.
     *
     * @param jugador El jugador objetivo que será atacado. No debe ser {@code null}.
     * @see Jugador#esGolpeadoCon(int) Para más detalles sobre cómo se calcula el daño recibido.
     */
    public void ataca(Jugador jugador){

        Integer[][] dmg_def = {{0, 0}, {0, 0}};
        if (!getPoderes().isEmpty()) {
            dmg_def[0] = estadisticasPoderes();
        }

        if (!jugador.getPoderes().isEmpty()){
            dmg_def[1] = jugador.estadisticasPoderes();
        }

        System.out.println("\u001B[32m===== INICIO DEL COMBATE =====\u001B[0m");
        System.out.println("ANTES DEL ATAQUE:");
        System.out.println("\tAtacante: " + this);
        System.out.println("\tAtacado: " + jugador);

        System.out.println("\n>>> " + this.getNombre() + " ataca a " + jugador.getNombre() + "!");
        jugador.esGolpeadoCon(this.getAtaque());
        System.out.println("\n>>> " + jugador.getNombre() + " contraataca!");
        this.esGolpeadoCon(jugador.getAtaque());

        System.out.println("\nDESPUÉS DEL ATAQUE:");
        System.out.println("\tAtacante: " + this);
        System.out.println("\tAtacado: " + jugador);
        System.out.println("\u001B[91m===== FIN DEL COMBATE =====\u001B[0m");

        this.setAtaque(this.getAtaque() - dmg_def[0][0]);
        this.setDefensa(this.getDefensa() - dmg_def[0][1]);
        jugador.setAtaque(jugador.getAtaque() - dmg_def[1][0]);
        jugador.setDefensa(jugador.getDefensa() - dmg_def[1][1]);
    }

    @Override
    public boolean equals(Object objeto) {
        Jugador jugador = (Jugador) objeto;
        return this.nombre.equalsIgnoreCase(jugador.nombre);
    }

    public void poner(Poder poder){
        if (!poderes.contains(poder)) {
            poderes.add(poder);
        } else System.out.println(this.getNombre() + " ya tiene ese poder!");
    }

    public void quitar(Poder poder){
        if (poderes.contains(poder)) {
            poderes.remove(poder);
        } else System.out.println(this.getNombre() + " no tiene ese poder!");
    }
}
