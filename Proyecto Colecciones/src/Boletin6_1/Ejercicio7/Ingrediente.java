package Boletin6_1.Ejercicio7;

public class Ingrediente {

    private String nombre;
    private double cantidad;

    public Ingrediente(double cantidad, String nombre) {
        this.cantidad = cantidad;
        this.nombre = nombre;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingrediente that = (Ingrediente) o;
        return nombre.equalsIgnoreCase(that.nombre);
    }
}
