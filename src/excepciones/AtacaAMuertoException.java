package excepciones;

public class AtacaAMuertoException extends Exception{

    // Constructor pasándole el mensaje de error
    public AtacaAMuertoException(String message) {
        super(message);
    }

    // Constructor con el mensaje de error
    public AtacaAMuertoException() {
        super("\u001B[33m⚠ No se puede atacar a un muerto. \u2620\uFE0F \u001B[0m");
    }
}
