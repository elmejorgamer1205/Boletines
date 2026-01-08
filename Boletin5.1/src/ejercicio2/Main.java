package ejercicio2;

import Exceptions.MiEntradaSalidaExceptions;
import Exceptions.VehiculoException;
import utils.MiEntradaSalida;

public class Main {
    public static void main(String[] args) {
        Empresa e1 = new Empresa();
        boolean usando = true;

        System.out.println("Bienvenido al alquilador de coches: \n");

        while (usando) {

            System.out.println("\t1. Dar de alta a un vehículo");
            System.out.println("\t2. Calcular alquiler de un vehículo");
            System.out.println("\t3. Salir\n");

            try {
                int opcion = MiEntradaSalida.solicitarEnteroEnRango("¿Qué deseas hacer?",1,3);
                switch (opcion){
                    case 1:
                        System.out.println("Coche, Microbus o Furgoneta \n");
                        String vehiculo = MiEntradaSalida.leerLinea("¿Que vehículo vas a dar de alta?\n");
                        e1.addVehiculo(crearVehiculo(vehiculo));
                        break;
                    case 2:
                        if (e1.vehiculos[0] == null){
                            System.out.println("No hay ningún vehículo dado de alta\n");
                            break;
                        }
                        int numDias = MiEntradaSalida.solicitarEnteroPositivo("¿Cuántos dias vas a alquilar el vehículo?",false);
                        MiEntradaSalida.mostrarOpcionesSinNulos("Vehículos dados de alta: \n",e1.vehiculos);
                        int eleccion = MiEntradaSalida.solicitarEntero("Introduce la posición del vehículo que quieras calcular el alquiler: \n")-1;
                        System.out.println("El alquiler te va a costar "+ e1.vehiculos[eleccion].calcularAlquilerVehiculo(numDias));
                        break;
                    case 3:
                        usando=false;
                        break;

                }
            } catch (MiEntradaSalidaExceptions | VehiculoException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static Vehiculo crearVehiculo(String vehiculo) throws VehiculoException {
        return switch (vehiculo.toLowerCase()) {
            case "coche" -> crearCoche();
            case "microbus" -> crearMicrobus();
            case "furgoneta" -> crearFurgoneta();
            default -> null;
        };
    }

    public static Coche crearCoche() throws VehiculoException {
        Coche c = null;
        String gama = MiEntradaSalida.leerLinea("Introduce la gama (Alta, Media o Baja): \n");
        String matricula = MiEntradaSalida.leerLinea("Introduce la matricula del vehiculo: \n");
        String combustible = MiEntradaSalida.leerLinea("Introduce el combustible (Diesel o Gasolina): \n");
        return c = new Coche(gama,matricula,combustible);
    }

    public static Microbus crearMicrobus() throws VehiculoException {
        Microbus m = null;
        String gama = MiEntradaSalida.leerLinea("Introduce la gama (Alta, Media o Baja): \n");
        String matricula = MiEntradaSalida.leerLinea("Introduce la matricula del vehiculo: \n");
        String combustible = MiEntradaSalida.leerLinea("Introduce el combustible (Diesel o Gasolina): \n");
        int plazas = MiEntradaSalida.solicitarEntero("Introduce el numero de plazas");
        return m = new Microbus(gama,matricula,combustible,plazas);
    }

    public static FurgonetaDeCarga crearFurgoneta() throws VehiculoException {
        FurgonetaDeCarga f = null;
        String gama = MiEntradaSalida.leerLinea("Introduce la gama (Alta, Media o Baja): \n");
        String matricula = MiEntradaSalida.leerLinea("Introduce la matricula del vehiculo: \n");
        String combustible = MiEntradaSalida.leerLinea("Introduce el combustible (Diesel o Gasolina): \n");
        int pma = MiEntradaSalida.solicitarEntero("Introduce el peso máximo autorizado");
        return f = new FurgonetaDeCarga(gama,matricula,pma,combustible);
    }

}
