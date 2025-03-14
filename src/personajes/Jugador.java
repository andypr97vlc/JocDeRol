package personajes;
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

    /**
     * Constructor de la clase {@code Jugador} que inicializa un nuevo jugador con los atributos proporcionados.
     *
     * <p>Este constructor asigna los valores de nombre, ataque, defensa y vidas a los atributos correspondientes
     * del objeto {@code Jugador}. Además, imprime un mensaje por consola indicando que se está creando una instancia
     * de la clase {@code Jugador} o de una subclase de esta.
     *
     * @param nombre   El nombre del jugador. No debe ser {@code null}.
     * @param ataque   El valor de ataque del jugador. Debe ser un valor no negativo.
     * @param defensa  El valor de defensa del jugador. Debe ser un valor no negativo.
     * @param vidas    El número de vidas del jugador. Debe ser un valor no negativo.
     * @see #getClass() Para obtener la clase del objeto en tiempo de ejecución.
     * @see Class#getSimpleName() Para obtener el nombre simple de la clase.
     */
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

    // Resto de funciones
    public String toString() {
        return this.getNombre() +
                " (" + this.getClass().getSimpleName().toUpperCase() +
                ", PA:" + this.getAtaque() +
                ", PD:" + this.getDefensa() +
                ", PV:" + this.getVidas() + ")";
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

        System.out.println(this.getNombre() +
                " es golpeado con " + dmg +
                " puntos de daño y se defiende con " + this.getDefensa() + ". "
                + "Vidas: " + vidaInicial + " - " + dmgDefendido + " = " + vidaRestante);

        this.setVidas(vidaRestante);
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
        System.out.println("\n===== INICIO DEL COMBATE =====");
        System.out.println("\nANTES DEL ATAQUE:");
        System.out.println("\tAtacante: " + this);
        System.out.println("\tAtacado: " + jugador);

        System.out.println("\n>>> " + this.getNombre() + " ataca a " + jugador.getNombre() + "!");
        jugador.esGolpeadoCon(this.getAtaque());
        System.out.println("\n>>> " + jugador.getNombre() + " contraataca!");
        this.esGolpeadoCon(jugador.getAtaque());

        System.out.println("\nDESPUÉS DEL ATAQUE:");
        System.out.println("\tAtacante: " + this);
        System.out.println("\tAtacado: " + jugador);
        System.out.println("===== FIN DEL COMBATE =====");
    }
}
