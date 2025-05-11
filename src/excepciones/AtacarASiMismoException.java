package excepciones;

public class AtacarASiMismoException extends Exception {

    // Constructor pasándole el mensaje de error
    public AtacarASiMismoException(String message) {
        super(message);
    }

    // Constructor con el mensaje de error
    public AtacarASiMismoException() {
        super("\u001B[33m⚠ No te puedes atacar a ti mismo. \u001B[0m");
    }
}
