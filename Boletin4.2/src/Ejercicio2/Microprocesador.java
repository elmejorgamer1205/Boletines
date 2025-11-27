package Ejercicio2;

public class Microprocesador {
    // Atributos
    private String marca;
    private String modelo;
    private int numNucleos;
    private float velBase;
    private String socket;
    // Constructor
    public Microprocesador(String marca, String modelo, int numNucleos, float velBase, String socket) {
        setMarca(marca);
        setModelo(modelo);
        setNumNucleos(numNucleos);
        setVelBase(velBase);
        setSocket(socket);
    }

    public String getMarca() {
        return marca;
    }

    private void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    private void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getNumNucleos() {
        return numNucleos;
    }

    private void setNumNucleos(int numNucleos) {
        this.numNucleos = numNucleos;
    }

    public float getVelBase() {
        return velBase;
    }

    private void setVelBase(float velBase) {
        this.velBase = velBase;
    }

    public String getSocket() {
        return socket;
    }

    private void setSocket(String socket){
        this.socket = socket;
    }

    @Override
    public String toString() {
        return "Microprocesador{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", numNucleos=" + numNucleos +
                ", velBase=" + velBase +
                ", socket='" + socket + '\'' +
                '}';
    }

    public void componentes(){
        System.out.println(toString());
    }
}
