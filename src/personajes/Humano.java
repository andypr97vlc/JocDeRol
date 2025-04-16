package personajes;


public class Humano extends Jugador{

    // El humano no puede sobrepasar 100 de vida
    public Humano(String nombre, int ataque, int defensa, int vidas) {
        super(nombre, ataque, defensa, Math.min(vidas, 100)); // Evita que tenga más de 100 de vida
    }

    public String toString() {
        return "\uD83E\uDDD1 " + super.toString();
    }
}
