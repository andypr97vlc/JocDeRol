package personajes;

public class Alien extends Jugador{

    public Alien(String nombre, int ataque, int defensa, int vidas) {
        super(nombre, ataque, defensa, vidas);

        System.out.println("Soy el constructor de Alien pero estoy creando un " + this.getClass().getSimpleName());
    }

    public String toString() {
        return super.toString();
    }

    @Override
    protected void setDefensa(int defensa) {
        super.setDefensa(defensa);
    }

    @Override
    protected void setVidas(int vidas) {
        if (vidas > 20){
            super.setVidas(vidas + 3);
        } else super.setVidas(vidas);

    }

    @Override
    public int getDefensa() {
        return super.getDefensa();
    }

    @Override
    public int getVidas() {
        return super.getVidas();
    }
}
