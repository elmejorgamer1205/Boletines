package EjercicioAvion2;

import Exceptions.AvionException;

/**
 * Clase que representa un depósito con una capacidad máxima fija
 * y una capacidad (cantidad) actual variable.
 */
public class Deposito2 {

    /** Capacidad máxima del depósito; no puede modificarse después de la construcción */
    public final double CAPACIDAD_MAX;

    /* Cantidad actual almacenada en el depósito */
    private double capacidadActual;

    /**
     * Constructor del depósito. Valida y asigna la capacidad máxima,
     * y luego inicializa la capacidad actual usando el setter.
     *
     * @param capacidadMax capacidad máxima del depósito (debe ser mayor que 0)
     * @param capacidadActual cantidad inicial almacenada
     * @throws AvionException si algún valor es inválido
     */
    public Deposito2(double capacidadMax, double capacidadActual) throws AvionException {
        if (capacidadMax <= 0) {
            throw new AvionException("Capacidad máxima invalida");
        }
        this.CAPACIDAD_MAX = capacidadMax;
        setCapacidadActual(capacidadActual);  // Se valida mediante el setter
    }

    /**
     * Establece la capacidad actual del depósito, verificando:
     *  - que no sea negativa
     *  - que no supere la capacidad máxima
     *
     * @param capacidadActual nueva cantidad almacenada
     * @throws AvionException si la cantidad es inválida
     */
    public void setCapacidadActual(double capacidadActual) throws AvionException {
        // No puede ser menor que 0
        if (capacidadActual < 0) {
            throw new AvionException("La capacidad actual...");
        }

        // No puede ser mayor que la capacidad máxima
        if (capacidadActual > CAPACIDAD_MAX) {
            throw new AvionException("La capacidad actual maxima invalida");
        }

        this.capacidadActual = capacidadActual;
    }

    /**
     * Devuelve la capacidad actual del depósito.
     *
     * @return cantidad actual almacenada
     */
    public double getCapacidadActual() {
        return capacidadActual;
    }

    /**
     * Representación en texto del depósito.
     */
    @Override
    public String toString() {
        return "Deposito{" +
                "capacidadActual=" + capacidadActual +
                '}';
    }
}


