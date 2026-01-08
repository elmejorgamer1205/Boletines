package ejercicio2;

public enum Combustible {
    DIESEL(2),
    GASOLINA(3.5);


    private final double PRECIO;

    Combustible(double precio) {
        this.PRECIO = precio;
    }

    public double getPrecio() {
        return PRECIO;
    }
}
