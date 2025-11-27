package Ejercicio2;

public class TarjetaGrafica {
    //Atrinutos
    private String marca;
    private String modelo;
    private int numNucleos;
    private float velocidad;
    private int capacidad;
    //Constructor
    public TarjetaGrafica(String marca, String modelo, int numNucleos, float velocidad, int capacidad) {
        setMarca(marca);
        setModelo(modelo);
        setNumNucleos(numNucleos);
        setVelocidad(velocidad);
        setCapacidad(capacidad);
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getNumNucleos() {
        return numNucleos;
    }

    public void setNumNucleos(int numNucleos) {
        this.numNucleos = numNucleos;
    }

    public float getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(float velocidad) {
        this.velocidad = velocidad;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "TarjetaGrafica{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", numNucleos=" + numNucleos +
                ", velocidad=" + velocidad +
                ", capacidad=" + capacidad +
                '}';
    }

    public void componentes(){
        System.out.println(toString());
    }
}
