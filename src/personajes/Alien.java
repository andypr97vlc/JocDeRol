package personajes;

import teclado.Teclado;

public class Alien extends Jugador{

    public Alien(String nombre, int ataque, int defensa, int vidas) {
        super(nombre, ataque, defensa, vidas);
    }

    public String toString() {
        return "\uD83D\uDC7D️ " + super.toString();
    }

    // El alien aumenta su daño (+3) y disminuye su defensa (-3) cuando se encuentra por encima de 20 de vida
    @Override
    public void ataca(Jugador jugador) {
        if (this.getVidas() > 20) { // Saber si el alien tiene más de 20 de vida
            String pasivaDe = "----------- Habilidad pasiva de " + this.getNombre() + " -----------";
            int cantidadLetras = pasivaDe.length();

            System.out.println(pasivaDe);
            System.out.println("\t\uD83D\uDCA2 " + this.getNombre() + " enloquece! (+3 ATAC, -3 DEFENSA)");
            System.out.println("- Anteriores estadísticas: Daño: " + this.getAtaque() + ", Defensa: " + this.getDefensa());
            System.out.println("+ Nuevas estadísticas: Daño: " + (this.getAtaque() + 3) + ", Defensa: " + (this.getDefensa() - 3));

            this.setAtaque(this.getAtaque() + 3);
            this.setDefensa(Math.max(this.getDefensa() - 3, 0)); // Evita defensa negativa

            Teclado.imprimirLinea(cantidadLetras, '-');
            System.out.println();
        }

        super.ataca(jugador);
    }
}
