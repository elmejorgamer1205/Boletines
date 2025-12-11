package EjercicioAvion;

import Exceptions.AvionException;

import java.time.LocalDate;
import java.util.Arrays;

/**
 * Clase que representa un avión con información básica,
 * su depósito de combustible y un historial de revisiones.
 */
public class Avion {

    /**
     * Número máximo de registros de revisiones que puede almacenar el avión
     */
    private final static int NUM_REGISTROS = 5;

    /* Marca del avión*/
    private String marca;

    /* Modelo del avión*/
    private String modelo;

    /* Consumo de combustible del avión*/
    private double consumo;

    /* Objeto que representa el depósito de combustible */
    private Deposito combustible;

    /* Array que almacena las revisiones realizadas al avión */
    private Registros[] registros;

    /**
     * Constructor del avión. Inicializa los atributos principales y el array de registros.
     *
     * @param marca       marca del avión
     * @param modelo      modelo del avión
     * @param consumo     consumo de combustible, debe ser mayor que 0
     * @param combustible depósito asociado al avión
     * @throws AvionException si el consumo es inválido
     */

    public Avion(String marca, String modelo, double consumo, Deposito combustible) throws AvionException {
        this.marca = marca;
        this.modelo = modelo;
        setConsumo(consumo);     // Valida antes de asignar
        this.combustible = combustible;
        this.registros = new Registros[NUM_REGISTROS]; // Inicializa array vacío
    }

    /**
     * Establece el consumo del avión validando que sea mayor que 0.
     *
     * @param consumo valor del consumo
     * @throws AvionException si el consumo es <= 0
     */

    public void setConsumo(double consumo) throws AvionException {
        if (consumo <= 0) {
            throw new AvionException("El consumo no puede ser negativo o 0");
        }
        this.consumo = consumo;
    }

    /**
     * Indica si el avión está listo para viajar.
     * Un avión está listo si:
     * - Tiene al menos una revisión registrada.
     * - La última revisión está en estado válido.
     * - La revisión no ha caducado con respecto a la fecha actual.
     *
     * @return true si el avión está listo; false en caso contrario.
     */

    public boolean estaListo() {
        try {
            Registros ultimaRevision = getUltimaRevision();

            // Comprueba que la revisión sea válida y no esté caducada
            return ultimaRevision.isEstado() &&
                    !ultimaRevision.getFecha()
                            .plus(ultimaRevision.getPeriodoValidez())
                            .isBefore(LocalDate.now());
        } catch (AvionException e) {
            // Si no existe ninguna revisión registrada
            return false;
        }
    }

    /**
     * Obtiene la última revisión realizada al avión.
     * Recorre el array desde el final hacia el inicio buscando la más reciente.
     *
     * @return la última revisión registrada
     * @throws AvionException si no hay ninguna revisión registrada
     */

    private Registros getUltimaRevision() throws AvionException {
        for (int i = registros.length - 1; i >= 0; i--) {
            if (registros[i] != null) { // Si encuentra una revisión válida, la devuelve
                return registros[i];
            }
        }
        // Si no hay ninguna revisión registrada
        throw new AvionException("ERROR: El avión no tiene registros de revisiones realizadas actualmente");
    }

    /**
     * Devuelve una representación en texto del avión.
     * Nota: imprime el array de registros, no el estado "listo para viajar".
     */

    @Override
    public String toString() {
        return "Avion{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", consumo=" + consumo +
                ", combustible=" + combustible +
                ", ¿Listo para viajar? " + Arrays.toString(registros) +
                '}';
    }
}

