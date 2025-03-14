package personajes;

public class Jugador {
    private String nombre;
    private int ataque;
    private int defensa;
    private int vidas;

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

    public String toString() {
        return this.getNombre() +
                " (" + this.getClass().getSimpleName().toUpperCase() +
                ", PA:" + this.getAtaque() +
                ", PD:" + this.getDefensa() +
                ", PV:" + this.getVidas() + ")";
    }

    protected void esGolpeadoCon(int dmg){
        // Comprobar que el daño defendido no sea negativo y como resultado cure
        int dmgDefendido = dmg - this.getDefensa();
        if (dmgDefendido <= 0) dmgDefendido = 0;

        // Comprobar que el daño resultado no sea negativo para que nunca tenga vidas negativas
        int dmgResultado;
        if (this.getVidas() - dmgDefendido < 0) dmgResultado = 0;
        else dmgResultado = this.getVidas() - dmgDefendido;

        System.out.println(this.getNombre() +
                " es golpeado con " + dmg +
                " puntos de daño y se defiende con " + this.getDefensa() + ". "
                + "Vidas: " + this.getVidas() + " - " + dmgDefendido + " = " + dmgResultado);

        if (this.getVidas() - dmgDefendido < 0) this.setVidas(0);
        else this.setVidas(this.getVidas() - dmgDefendido );

    }

    public void ataca(Jugador jugador){
        System.out.println("\nANTES DEL ATAQUE:");
        System.out.println("\tAtacante: " + this);
        System.out.println("\tAtacado: " + jugador);

        System.out.println("\nATAQUE:");
        jugador.esGolpeadoCon(this.getAtaque());
        this.esGolpeadoCon(jugador.getAtaque());

        System.out.println("\nDESPUÉS DEL ATAQUE:");
        System.out.println("\tAtacante: " + this);
        System.out.println("\tAtacado: " + jugador);
    }
}
