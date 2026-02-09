package models;

public abstract class Juguete {
    private String nombre, marca;

    public Juguete(String nombre, String marca) {
        super();
        this.nombre = nombre;
        this.marca = marca;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMarca() {
        return marca;
    }


}
