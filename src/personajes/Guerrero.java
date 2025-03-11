package personajes;

/**
 * La clase {@code Guerrero} representa un tipo específico de humano en el juego, que hereda de la clase {@code Humano}.
 *
 * <p>Esta clase extiende la funcionalidad de {@code Humano} y puede ser utilizada para definir características o
 * comportamientos adicionales propios de un guerrero. Al ser una subclase de {@code Humano}, un objeto de tipo
 * {@code Guerrero} hereda los atributos y métodos de la clase padre, como el nombre, ataque, defensa y vidas.
 *
 * @see Humano Para más detalles sobre la clase padre y sus funcionalidades.
 */
public class Guerrero extends Humano{

    public Guerrero(String nombre, int ataque, int defensa, int vidas){
        super(nombre, ataque, defensa, vidas);

        System.out.println("Soy el constructor de Guerrero pero estoy creando un " + this.getClass().getSimpleName());
    }

    public String toString() {
        return "\uD83D\uDDE1️ " + super.toString();
    }

    @Override
    protected void esGolpeadoCon(int dmg) {
        // Cálculo del daño real después de defenderse
        int dmgDefendido = dmg - this.getDefensa();
        if (dmgDefendido < 0) dmgDefendido = 0; // No puede curarse con la defensa

        // Ignorar golpes menores de 5 de daño
        if (dmgDefendido < 5) {
            System.out.println("\t\uD83D\uDEE1️ Daño recibido menor de 5. Activada la habilidad pasiva del guerrero.\n\t" +
                    this.getNombre() + " bloquea el ataque y no pierde vidas!");
            return;
        }

        // Cálculo del daño hecho después del golpe
        int vidaInicial = this.getVidas();
        int vidaRestante = Math.max(vidaInicial - dmgDefendido, 0);

        System.out.println("\t" + this.getNombre() +
                " es golpeado con " + dmg +
                " puntos de daño y se defiende con " + this.getDefensa() + ". "
                + "Vidas: " + vidaInicial + " - " + dmgDefendido + " = " + vidaRestante);

        this.setVidas(vidaRestante);
    }
}
