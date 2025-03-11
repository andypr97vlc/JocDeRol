package personajes;

/**
 * La clase {@code Humano} representa un tipo específico de jugador en el juego, que hereda de la clase {@code Jugador}.
 *
 * <p>Esta clase extiende la funcionalidad de {@code Jugador} y define un comportamiento específico para los humanos.
 * En particular, el constructor de esta clase asegura que el número de vidas de un humano no exceda un límite máximo de 100.
 * Si el valor de vidas proporcionado es mayor que 100, se ajusta automáticamente a 100.
 *
 * @see Jugador Para más detalles sobre la clase padre y sus funcionalidades.
 */
public class Humano extends Jugador{

    public Humano(String nombre, int ataque, int defensa, int vidas) {
        super(nombre, ataque, defensa, vidas > 100 ? 100 : vidas);

        System.out.println("Soy el constructor de Humano pero estoy creando un " + this.getClass().getSimpleName());
    }

    public String toString() {
        return "\uD83E\uDDD1 " + super.toString();
    }
}
