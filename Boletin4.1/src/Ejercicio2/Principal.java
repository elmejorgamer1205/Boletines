package Ejercicio2;

import Exceptions.CuentaExceptions;
import utils.MiEntradaSalida;

public class Principal {

    public static void main(String[] args) {

        Cuenta c = new Cuenta();
        c.getSaldoActual();
        c.getContadorIngresos();
        c.getContadorReintegros();

        System.out.println("\nBienvenido a C.S.S Bank's, nos alegra verle por aquí\n");
        boolean opciones = true;

        while (opciones) {

            String comando = MiEntradaSalida.leerLinea("¿Qué desea realizar?: ");

            switch (comando.toLowerCase()) {

                case "reintegro de dinero":
                    try {
                        int cantidad = MiEntradaSalida.solicitarEntero("\n ¿Cuánto quiere reintegrar?");
                        c.retirarDinero(cantidad);
                    }catch (CuentaExceptions e){
                        System.out.println(e.getMessage());
                    }
                    System.out.println("\nReintegro exitoso \n");
                    break;
                case "ingresar dinero":
                    c.ingresarDinero(MiEntradaSalida.solicitarEnteroEnRangoBanco("\n¿Cuánto quiere ingresar?", 1, 2500));
                    System.out.println("\n¡Ingreso exitoso \n");
                    break;
                case "mirar saldo de la cuenta":
                    System.out.println("\nSu cuenta actualmente tiene: " + c.getSaldoActual() + "€\n");
                    break;
                case "mirar número de reintegros e ingresos":
                    System.out.println("Ha realizado "+ c.getContadorReintegros() + " reintegros y "+ c.getContadorIngresos()+ " ingresos realizados");
                    break;
                case "ayuda":
                    ayuda();
                    break;
                default:
                    ayuda();
                    break;
                case "salir":
                    opciones = false;
                    System.out.println("\n!!!Vuelva pronto!!!");
                    break;
            }
        }
    }

    static void ayuda() {
        System.out.print("\n====================Opciones====================\n");
        System.out.print("> reintegro de dinero\n");
        System.out.print("> ingresar dinero\n");
        System.out.print("> mirar saldo de la cuenta\n");
        System.out.print("> mirar número de reintegros e ingresos\n");
        System.out.print("> salir\n");
        System.out.print("=============================================\n \n");
    }
}

