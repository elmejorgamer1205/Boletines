package EjercicioAvion;

public class Avion {
    private String marca;
    private String modelo;
    private double consumo;

    public Avion(double consumo, String marca, String modelo) {
        this.consumo = consumo;
        this.marca = marca;
        this.modelo = modelo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

}
