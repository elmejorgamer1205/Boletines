package Ejercicio1;

public class carta {
    private String palo;
    private int número;

    public carta(String palo, int numero) {
        setPalo(palo);
        setNúmero(numero);
    }

    private void setNúmero(int número) {
        this.número = número;
    }

    private void setPalo(String palo) {
        this.palo = palo;
    }

    @Override
    public String toString() {
        return número +" de "+palo;
    }
}

