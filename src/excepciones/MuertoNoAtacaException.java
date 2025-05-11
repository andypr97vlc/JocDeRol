package excepciones;

public class MuertoNoAtacaException extends Exception {

    // Constructor pasándole el mensaje de error
    public MuertoNoAtacaException(String message) {
        super(message);
    }

    // Constructor con el mensaje de error
    public MuertoNoAtacaException() {
        super("\u001B[33m⚠ Un muerto no puede atacar. \u2620\uFE0F \u001B[0m");
    }
}
