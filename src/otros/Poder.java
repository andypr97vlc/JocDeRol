package otros;

public class Poder {
    private String nombre;
    private int bonusAtaque;
    private int bonusDefensa;

    public Poder(String nombre, int bonusAtaque, int bonusDefensa) {
        this.nombre = nombre;
        this.bonusAtaque = bonusAtaque;
        this.bonusDefensa = bonusDefensa;
    }

    @Override
    public String toString() {
        return nombre +
                " (BA: " + bonusAtaque +
                ", BD: " + bonusDefensa +
                ')';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getBonusAtaque() {
        return bonusAtaque;
    }

    public void setBonusAtaque(int bonusAtaque) {
        this.bonusAtaque = bonusAtaque;
    }

    public int getBonusDefensa() {
        return bonusDefensa;
    }

    public void setBonusDefensa(int bonusDefensa) {
        this.bonusDefensa = bonusDefensa;
    }
}
