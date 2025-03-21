package personajes;

/**
 * La clase {@code Alien} representa un tipo específico de jugador en el juego.
 *
 * <p>Esta clase extiende la clase {@code Jugador}, heredando sus atributos y comportamientos,
 * y puede ser utilizada para definir características o funcionalidades adicionales propias de un alien.
 *
 * <p>Al ser una subclase de {@code Jugador}, un objeto de tipo {@code Alien} puede acceder y utilizar
 * los métodos y atributos definidos en la clase padre, como el nombre, ataque, defensa y vidas.
 *
 * <p>Esta clase puede ser extendida para crear tipos más específicos de aliens con comportamientos únicos.
 *
 * @see Jugador Para más detalles sobre la clase padre y sus funcionalidades.
 */
public class Alien extends Jugador{

    public Alien(String nombre, int ataque, int defensa, int vidas) {
        super(nombre, ataque, defensa, vidas);

        System.out.println("Soy el constructor de Alien pero estoy creando un " + this.getClass().getSimpleName());
    }

    public String toString() {
        return "\uD83D\uDC7D️ " + super.toString();
    }

    // He entendido en el enunciado que el alien debe mantener las estadísticas después del combate
    // y una vez tenga la vida por debajo de 20 ya no use su habilidad
    @Override
    public void ataca(Jugador jugador) {
        System.out.println("\n===== INICIO DEL COMBATE =====");
        System.out.println("ANTES DEL ATAQUE:");
        System.out.println("\tAtacante: " + this);
        System.out.println("\tAtacado: " + jugador);

        // Saber si el alien tiene más de 20 de vida
        if (this.getVidas() > 20) {
            System.out.println("\n⚠️ " + this.getNombre() + " enloquece! (+3 ATAC, -3 DEFENSA)");
            this.setAtaque(this.getAtaque() + 3);
            this.setDefensa(Math.max(this.getDefensa() - 3, 0)); // Evita defensa negativa
        }

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
