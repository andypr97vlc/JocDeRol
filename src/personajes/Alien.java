package personajes;

public class Alien extends Jugador{

    public Alien(String nombre, int ataque, int defensa, int vidas) {
        super(nombre, ataque, defensa, vidas);
        System.out.println("Soy el constructor de Alien pero estoy creando un " + this.getClass().getSimpleName());
    }

    public String toString() {
        return super.toString();
    }

    @Override
    public void ataca(Jugador jugador) {
        super.ataca(jugador);
    }
}
