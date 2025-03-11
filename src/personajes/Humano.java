package personajes;

public class Humano extends Jugador{

    public Humano(String nombre, int ataque, int defensa, int vidas) {
        super(nombre, ataque, defensa, vidas > 100 ? 100 : vidas);

        System.out.println("Soy el constructor de Humano pero estoy creando un " + this.getClass().getSimpleName());
    }

    public String toString() {
        return super.toString();
    }
}
