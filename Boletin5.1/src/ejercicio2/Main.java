package ejercicio2;

import Exceptions.MiEntradaSalidaExceptions;
import Exceptions.VehiculoException;
import utils.MiEntradaSalida;

public class Main {

    /**
     * Metodo principal que ejecuta el menú de la aplicación.
     *
     * @param args argumentos de la línea de comandos (no usados)
     */
    public static void main(String[] args) {
        // Se crea la empresa
        Empresa e1 = new Empresa();
        boolean usando = true;

        System.out.println("Bienvenido al alquilador de coches: \n");

        // Bucle principal del menú
        while (usando) {

            System.out.println("\t1. Dar de alta a un vehículo");
            System.out.println("\t2. Calcular alquiler de un vehículo");
            System.out.println("\t3. Salir\n");

            try {
                // Solicita la opción del usuario
                int opcion = MiEntradaSalida.solicitarEnteroEnRango("¿Qué deseas hacer?",1,3);

                switch (opcion) {
                    case 1:
                        // Dar de alta un vehículo
                        System.out.println("Coche, Microbus o Furgoneta \n");
                        String vehiculo = MiEntradaSalida.leerLinea("¿Que vehículo vas a dar de alta?\n");
                        e1.addVehiculo(crearVehiculo(vehiculo));
                        break;

                    case 2:
                        // Calcular alquiler
                        if (e1.vehiculos[0] == null) {
                            System.out.println("No hay ningún vehículo dado de alta\n");
                            break;
                        }
                        int numDias = MiEntradaSalida.solicitarEnteroPositivo(
                                "¿Cuántos dias vas a alquilar el vehículo?", false);

                        // Mostrar vehículos dados de alta
                        MiEntradaSalida.mostrarOpcionesSinNulos("Vehículos dados de alta: \n", e1.vehiculos);

                        int eleccion = MiEntradaSalida.solicitarEntero(
                                "Introduce la posición del vehículo que quieras calcular el alquiler: \n") - 1;

                        // Mostrar precio del alquiler
                        System.out.println("El alquiler te va a costar " +
                                e1.vehiculos[eleccion].calcularAlquilerVehiculo(numDias));
                        break;

                    case 3:
                        // Salir del programa
                        usando = false;
                        break;
                }
            } catch (MiEntradaSalidaExceptions | VehiculoException e) {
                // Captura errores de entrada o creación de vehículos
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Crea un vehículo según el tipo indicado.
     *
     * @param vehiculo tipo de vehículo ("coche", "microbus" o "furgoneta")
     * @return instancia del vehículo creado o null si el tipo no existe
     * @throws VehiculoException si ocurre un error al crear el vehículo
     */
    public static Vehiculo crearVehiculo(String vehiculo) throws VehiculoException {
        return switch (vehiculo.toLowerCase()) {
            case "coche" -> crearCoche();
            case "microbus" -> crearMicrobus();
            case "furgoneta" -> crearFurgoneta();
            default -> null;
        };
    }

    /**
     * Solicita los datos para crear un Coche.
     *
     * @return objeto Coche creado
     * @throws VehiculoException si hay errores en los datos
     */
    public static Coche crearCoche() throws VehiculoException {
        String gama = MiEntradaSalida.leerLinea("Introduce la gama (Alta, Media o Baja): \n");
        String matricula = MiEntradaSalida.leerLinea("Introduce la matricula del vehiculo: \n");
        String combustible = MiEntradaSalida.leerLinea("Introduce el combustible (Diesel o Gasolina): \n");
        return new Coche(gama, matricula, combustible);
    }

    /**
     * Solicita los datos para crear un Microbus.
     *
     * @return objeto Microbus creado
     * @throws VehiculoException si hay errores en los datos
     */
    public static Microbus crearMicrobus() throws VehiculoException {
        String gama = MiEntradaSalida.leerLinea("Introduce la gama (Alta, Media o Baja): \n");
        String matricula = MiEntradaSalida.leerLinea("Introduce la matricula del vehiculo: \n");
        String combustible = MiEntradaSalida.leerLinea("Introduce el combustible (Diesel o Gasolina): \n");
        int plazas = MiEntradaSalida.solicitarEntero("Introduce el numero de plazas");
        return new Microbus(gama, matricula, combustible, plazas);
    }

    /**
     * Solicita los datos para crear una Furgoneta de carga.
     *
     * @return objeto FurgonetaDeCarga creado
     * @throws VehiculoException si hay errores en los datos
     */
    public static FurgonetaDeCarga crearFurgoneta() throws VehiculoException {
        String gama = MiEntradaSalida.leerLinea("Introduce la gama (Alta, Media o Baja): \n");
        String matricula = MiEntradaSalida.leerLinea("Introduce la matricula del vehiculo: \n");
        String combustible = MiEntradaSalida.leerLinea("Introduce el combustible (Diesel o Gasolina): \n");
        int pma = MiEntradaSalida.solicitarEntero("Introduce el peso máximo autorizado");
        return new FurgonetaDeCarga(gama, matricula, pma, combustible);
    }
}

