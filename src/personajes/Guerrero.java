package personajes;

public class Guerrero extends Humano{

    // El guerrero al heredad de humano tampoco podrá superar los 100 de vida
    public Guerrero(String nombre, int ataque, int defensa, int vidas){
        super(nombre, ataque, defensa, vidas);
    }

    public String toString() {
        return "\uD83D\uDDE1️ " + super.toString();
    }

    // Sobreescrito el procedimiento para evitar todo daño inferior a 5
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
