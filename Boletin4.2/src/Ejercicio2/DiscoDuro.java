package Ejercicio2;

public class DiscoDuro {
    // Atributos
    private String marca;
    private String tipo;
    private int capacidad;
    //Constructor
    public DiscoDuro(String marca, String tipo, int capacidad) {
        setMarca(marca);
        setTipo(tipo);
        setCapacidad(capacidad);
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "DiscoDuro{" +
                "marca='" + marca + '\'' +
                ", tipo='" + tipo + '\'' +
                ", capacidad=" + capacidad +
                '}';
    }

    public void componentes(){
        System.out.println(toString());
    }
}
