package EjercicioAvion;

import Exceptions.AvionException;

/**
 * Clase que representa un depósito de combustible.
 * Contiene una capacidad máxima fija y una cantidad actual variable.
 */
public class Deposito {

    /** Capacidad máxima del depósito (valor fijo una vez creado) */
    private final int CAPACIDAD_MAX;

    /* Cantidad actual de combustible almacenada en el depósito */
    private double cantidadActual;

    /**
     * Constructor del depósito. Verifica que la capacidad máxima sea válida
     * e inicializa la cantidad actual mediante un setter que incluye validación.
     *
     * @param capacidadMaxima capacidad total del depósito, debe ser mayor a 0
     * @param cantidadActual cantidad inicial de combustible
     * @throws AvionException si los valores no cumplen las restricciones
     */
    public Deposito(int capacidadMaxima, double cantidadActual) throws AvionException {
        if (capacidadMaxima <= 0) {
            throw new AvionException("La capacidad maxima debe ser mayor a 0");
        }
        this.CAPACIDAD_MAX = capacidadMaxima;
        setCantidadActual(cantidadActual); // Usa el setter para validar
    }

    /**
     * Establece la cantidad actual de combustible validando:
     *  - que no sea negativa
     *  - que no supere la capacidad máxima
     *
     * @param cantidadActual nueva cantidad de combustible
     * @throws AvionException si el valor es inválido
     */
    private void setCantidadActual(double cantidadActual) throws AvionException {
        // Comprueba que la cantidad no sea negativa
        if (cantidadActual < 0) {
            throw new AvionException("La cantidad debe ser mayor a 0");
        }
        // Comprueba que no supere el tamaño del depósito
        if (cantidadActual > CAPACIDAD_MAX) {
            throw new AvionException("No puedes meter esa cantidad, no cabe en el deposito");
        }
        this.cantidadActual = cantidadActual;
    }

    /**
     * Representación en texto del depósito.
     */
    @Override
    public String toString() {
        return "DepositoCombustible{" +
                "cantidadActual=" + cantidadActual +
                '}';
    }

    /**
     * Devuelve la cantidad actual de combustible.
     *
     * @return cantidad actual en el depósito
     */
}


