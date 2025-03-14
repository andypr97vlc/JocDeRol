package personajes;

public class Guerrero extends Humano{

    public Guerrero(String nombre, int ataque, int defensa, int vidas){
        super(nombre, ataque, defensa, vidas);

        System.out.println("Soy el constructor de Guerrero pero estoy creando un " + this.getClass().getSimpleName());
    }

    @Override
    public void ataca(Jugador jugador) {
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
