package personajes;

public class Guerrero extends Humano{

    public Guerrero(String nombre, int ataque, int defensa, int vidas){
        super(nombre, ataque, defensa, vidas);

        System.out.println("Soy el constructor de Guerrero pero estoy creando un " + this.getClass().getSimpleName());
    }

    @Override
    public void ataca(Jugador jugador) {
        // Almaceno el ataque que tiene el jugador que ataca para devolvérselo después
        int ataque = jugador.getAtaque();
        // Si el daño resultante es menor a 5 su ataque pasa a ser 0
        if (jugador.getAtaque() - this.getDefensa() < 5) jugador.setAtaque(0);

        super.ataca(jugador);

        // Una vez realizado el daño, le devolvemos sus puntos de ataque
        jugador.setAtaque(ataque);
    }
}
