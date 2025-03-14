package personajes;

public class Guerrero extends Humano{

    public Guerrero(String nombre, int ataque, int defensa, int vidas){
        super(nombre, ataque, defensa, vidas);

        System.out.println("Soy el constructor de Guerrero pero estoy creando un " + this.getClass().getSimpleName());
    }


}
