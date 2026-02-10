package models;

public abstract class JugueteMadera extends Juguete {
    private String origen;
    private int anoTala;

    public JugueteMadera(String nombre, String marca, String origen, int anoTala) {
        super(nombre, marca);
        this.origen = origen;
        this.anoTala = anoTala;
    }

    public String getOrigen() {
        return origen;
    }

    public int getAnoTala() {
        return anoTala;
    }


}
