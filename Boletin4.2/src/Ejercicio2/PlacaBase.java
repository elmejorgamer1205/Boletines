package Ejercicio2;

import Exceptions.MontarPCException;

public class PlacaBase {
    // Atributos
    private String marca;
    private String chipset;
    private String socket;
    // Constructor
    public PlacaBase(String marca, String chipset, String socket) {
        setMarca(marca);
        setChipset(chipset);
        setSocket(socket);
    }

    public void setMicroprocesador(Microprocesador m) throws MontarPCException{
        if (!esCompatible(m)){
            throw new MontarPCException("Error: Los sockets no coinciden");
        }
    }

    public boolean esCompatible(Microprocesador m){
        return this.socket.equals(m.getSocket());
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getChipset() {
        return chipset;
    }

    public void setChipset(String chipset) {
        this.chipset = chipset;
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    @Override
    public String toString() {
        return "PlacaBase{" +
                "marca='" + marca + '\'' +
                ", chipset='" + chipset + '\'' +
                ", socket='" + socket + '\'' +
                '}';
    }

    public void componentes(){
        System.out.println(toString());
    }

}
