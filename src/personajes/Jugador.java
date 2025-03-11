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
        return nombre +
                " (" +
                this.getClass().getSimpleName().toUpperCase() +
                ", PA:" + ataque +
                ", PD:" + defensa +
                ", PV:" + vidas +
                ')';
    }

    protected void esGolpeadoCon(int daño){
        int dañoResultado;
        int dañoDefendido = daño - this.defensa;

        if (dañoDefendido > 0) dañoResultado = daño - this.defensa;
        else dañoResultado = 0;

        System.out.println(this.nombre +
                " es golpeado con " + daño +
                " puntos de daño y se defiende con " + this.defensa + ". "
                + "Vidas: " + this.vidas + " - " + dañoResultado + " = " + (this.vidas - dañoResultado));

        this.vidas -= dañoResultado;
    }

    public void ataca(Jugador jugador){
        System.out.println("\nANTES DEL ATAQUE:");
        System.out.println("\tAtacante: " + this.toString());
        System.out.println("\tAtacado: " + jugador.toString());

        System.out.println("\nATAQUE:");
        jugador.esGolpeadoCon(this.ataque);
        this.esGolpeadoCon(jugador.ataque);

        System.out.println("\nDESPUÉS DEL ATAQUE:");
        System.out.println("\tAtacante: " + this.toString());
        System.out.println("\tAtacado: " + jugador.toString());
    }
}
