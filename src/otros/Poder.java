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
        final StringBuffer sb = new StringBuffer();
        sb.append(nombre);
        sb.append(" (BA: ").append(bonusAtaque);
        sb.append(", BD: ").append(bonusDefensa);
        sb.append(')');
        return sb.toString();
    }


}
