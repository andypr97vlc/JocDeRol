package otros;

import java.io.Serializable;

public class Poder implements Serializable {
    private String nombre;
    private int bonusAtaque;
    private int bonusDefensa;

    public Poder(String nombre, int bonusAtaque, int bonusDefensa) {
        this.nombre = nombre;
        this.bonusAtaque = bonusAtaque;
        this.bonusDefensa = bonusDefensa;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getBonusAtaque() {
        return bonusAtaque;
    }

    public int getBonusDefensa() {
        return bonusDefensa;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setBonusAtaque(int bonusAtaque) {
        this.bonusAtaque = bonusAtaque;
    }

    public void setBonusDefensa(int bonusDefensa) {
        this.bonusDefensa = bonusDefensa;
    }

    // Resto de funciones y procedimientos
    @Override
    public String toString() {
        return getNombre() +
                " (BA: " + getBonusAtaque() +
                ", BD: " + getBonusDefensa() + ')';
    }

    // Sobrescrita la funcion para comprobar solo el nombre del poder
    @Override
    public boolean equals(Object objeto) {
        Poder poder = (Poder) objeto;
        return this.getNombre().equalsIgnoreCase(poder.getNombre());
    }
}
