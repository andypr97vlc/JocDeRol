package personajes;

import teclado.Teclado;

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

    // El alien aumenta su daño y disminuye su defensa cuando se encuentra por encima de 20 de vida
    @Override
    public void ataca(Jugador jugador) {
        boolean pasiva = false;
        if (this.getVidas() > 20) { // Saber si el alien tiene más de 20 de vida
            String pasivaDe = "----------- Habilidad pasiva de " + this.getNombre() + " -----------";
            int cantidadLetras = pasivaDe.length();

            System.out.println(pasivaDe);
            System.out.println("\t\uD83D\uDCA2 " + this.getNombre() + " enloquece! (+3 ATAC, -3 DEFENSA)");
            System.out.println("- Anteriores estadísticas: Daño: " + this.getAtaque() + ", Defensa: " + this.getDefensa());
            System.out.println("+ Nuevas estadísticas: Daño: " + (this.getAtaque() + 3) + ", Defensa: " + (this.getDefensa() - 3));
            this.setAtaque(this.getAtaque() + 3);
            this.setDefensa(Math.max(this.getDefensa() - 3, 0)); // Evita defensa negativa
            Teclado.imprimirLinea(cantidadLetras);
            System.out.println();

            pasiva = true;
        }

        super.ataca(jugador);

        if(pasiva){
            this.setAtaque(this.getAtaque() - 3);
            this.setDefensa(this.getDefensa() + 3);
        }
    }
}
