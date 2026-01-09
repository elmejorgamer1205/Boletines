package ejercicio2;

public class Empresa {

    /** Número máximo de vehículos que la empresa puede tener */
    private final static int NUM_VEHICULOS = 200;

    /** Array que almacena los vehículos de la empresa */
    Vehiculo[] vehiculos;

    /**
     * Constructor de la clase Empresa.
     * Inicializa el array de vehículos con la capacidad máxima.
     */
    public Empresa() {
        // Se crea un array de vehículos con tamaño NUM_VEHICULOS
        vehiculos = new Vehiculo[NUM_VEHICULOS];
    }

    /**
     * Añade un vehículo al array de vehículos.
     * Si hay un hueco disponible (null) se coloca el vehículo en la primera posición libre.
     *
     * @param v vehículo a añadir
     */
    public void addVehiculo(Vehiculo v){
        // Recorre el array buscando la primera posición vacía
        for (int i = 0; i < vehiculos.length; i++) {
            if (vehiculos[i] == null){
                vehiculos[i] = v; // Inserta el vehículo
                return;           // Sale del metodo tras añadirlo
            }
        }
        // Si no hay hueco, no hace nada (podría mejorarse lanzando una excepción)
    }
}
