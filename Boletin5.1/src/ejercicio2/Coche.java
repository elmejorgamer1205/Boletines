package ejercicio2;

import Exceptions.VehiculoException;

public class Coche extends Vehiculo {

    /**
     * Constructor de la clase Coche.
     *
     * @param gama tipo o gama del coche
     * @param matricula matrícula del vehículo
     * @param combustible tipo de combustible utilizado
     * @throws VehiculoException si alguno de los datos no es válido
     */
    public Coche(String gama, String matricula, String combustible) throws VehiculoException {
        // Llamada al constructor de la clase padre Vehiculo
        super(gama, matricula, combustible);
    }

    /**
     * Devuelve una representación en texto del coche.
     * Reutiliza el metodo toString() de la clase Vehiculo.
     *
     * @return información del coche en formato String
     */
    @Override
    public String toString() {
        // Se concatena el toString() de la clase padre
        return "Coche{" +
                super.toString() + "}";
    }
}
