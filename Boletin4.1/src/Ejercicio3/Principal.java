package Ejercicio3;

import Ejercicio2.Cuenta;
import Exceptions.CuentaExceptions;
import Exceptions.MaquinaCafeException;
import utils.MiEntradaSalida;

public class Principal {
    public static void main(String[] args) throws MaquinaCafeException {

        MáquinaCafé m = new MáquinaCafé();

        System.out.println("\nBuenos días\n");
        boolean servicio = true;

        while (servicio) {

            String comando = MiEntradaSalida.leerLinea("¿Qué desea tomar o hacer?: ");

            switch (comando.toLowerCase()) {

                case "pedir café solo":
                    try {
                        double cafeSolo = MiEntradaSalida.solicitarEntero("Introduzca el dinero: ");
                        System.out.println("Su cambio es: " + m.cafeSolo(cafeSolo));
                    }catch (MaquinaCafeException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "pedir leche":
                    try {
                        double leche = MiEntradaSalida.solicitarEntero("Introduzca el dinero: ");
                        System.out.println("Su cambio es: " + m.leche(leche));
                    }catch (MaquinaCafeException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "pedir café con leche":
                    try {
                        double cafeConLeche = MiEntradaSalida.solicitarEntero("Introduzca el dinero: ");
                        System.out.println("Su cambio es: "+ m.cafeConLeche(cafeConLeche));
                    } catch (MaquinaCafeException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "estado de la máquina":
                        m.consultarMaquina();
                    break;
                case "rellenar máquina":
                    m.rellenarMaquina();
                    break;
                case "vaciar monedero":
                    System.out.println("Has vaciado "+ m.vaciarMonedero() +" € del monedero");
                    break;
                case "opciones":
                    opciones();
                    break;
                default:
                    opciones();
                    break;
                case "salir":
                    servicio = false;
                    System.out.println("\n!!!Vuelva pronto!!!");
                    break;
            }
        }
    }
    static void opciones() {
        System.out.print("\n=========Opciones de la máquina de café=========\n");
        System.out.print("> Pedir café solo\n");
        System.out.print("> Pedir leche\n");
        System.out.print("> Pedir café con leche\n");
        System.out.print("> Vaciar monedero\n");
        System.out.print(">Estado de la máquina\n");
        System.out.print("> Salir\n");
        System.out.print("==============================================\n \n");
    }
}



