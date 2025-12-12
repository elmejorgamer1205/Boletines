package Examen;

import Exceptions.NaveException;

/**
 * Clase que representa los cartuchos que se añaden a los depósitos
 * Incluye id de la nave, el tipo de nave que es,
 * la potencia de la nave y el peso.
 */
public class Cartucho {

    /* Identificador de la nave */
    private String id;
    /* El tipo de nave */
    private String tipo;
    /* Potencia de la nave */
    private double potencia;
    /* Peso de la nave */
    private double peso;

    /**
     * Constructor que inicializa los detalles de Cartucho
     *
     * @param id identificador de la nave
     * @param peso peso total de la nave
     * @param potencia potencia total de la nave
     * @param tipo tipo de nave
     */
    public Cartucho(String id, double peso, double potencia, String tipo) {
        this.id = id;
        this.peso = peso;
        this.potencia = potencia;
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
