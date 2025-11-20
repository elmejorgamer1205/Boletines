package Ejercicio3;

import Ejercicio2.Cuenta;
import Exceptions.CuentaExceptions;
import utils.MiEntradaSalida;

public class Principal {
    public static void main(String[] args) {

        MáquinaCafé m = new MáquinaCafé();
        m.getMonedero();

        System.out.println("\nVas a tomar café\n");
        boolean servicio = true;

        while (servicio) {

            String comando = MiEntradaSalida.leerLinea("¿Qué vas a hacer?: ");

            switch (comando.toLowerCase()) {

                case "Pedir café solo":

                    break;
                case "Pedir leche":

                    break;
                case "Pedir café con leche":

                    break;
                case "Estado de la máquina":

                    break;
                case "Vaciar monedero":
                    System.out.println("Has vaciado "+ m.getMonedero() +" € del monedero");
                    break;
                case "Opciones":
                    opciones();
                    break;
                default:
                    opciones();
                    break;
                case "Salir":
                    servicio = false;
                    System.out.println("\n!!!Vuelva pronto!!!");
                    break;
            }
        }
    }
    static void opciones() {
        System.out.print("\n============Mis Opciones=============\n");
        System.out.print("> Vaciar monedero\n");
        System.out.print("> Mirar estado de la máquina\n");
        System.out.print("====================================\n \n");
        System.out.print("\n=========Opciones de la máquina de café=========\n");
        System.out.print("> Pedir café solo\n");
        System.out.print("> Pedir leche\n");
        System.out.print("> Pedir café con leche\n");
        System.out.print("> Salir\n");
        System.out.print("==============================================\n \n");
    }
}



