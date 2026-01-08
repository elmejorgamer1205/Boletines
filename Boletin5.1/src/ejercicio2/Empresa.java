package ejercicio2;

public class Empresa {
    private final static int NUM_VEHICULOS = 200;
    Vehiculo[] vehiculos;

    public Empresa() {
        vehiculos = new Vehiculo[NUM_VEHICULOS];
    }

    /**
     * Añadir el vehículo al arrays de vehículos
     * @param v El vehículo pasado por parámetros
     */
    public void addVehiculo(Vehiculo v){
        for (int i = 0; i < vehiculos.length; i++) {
            if (vehiculos[i] == null){
                vehiculos[i] = v;
                return;
            }
        }
    }
}
