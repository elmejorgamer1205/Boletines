package Ejercicio1;

import Exceptions.MiEntradaSalidaExceptions;
import utils.MiEntradaSalida;

public class Persona {

    public static void main(String[] args) {

        MétodoPersona p = null;

        System.out.println("\nHola buenos días, cree su cuenta personal\n");
        boolean opciones = true;

        MiEntradaSalida.solicitarCadena("Introduzca su nombre: ");
        try {
            MiEntradaSalida.fecha("Introduce los siguintes datos de los");
        }catch (MiEntradaSalidaExceptions e){
            System.out.println(e.getMessage());
        }
        MiEntradaSalida.solicitarEntero("Introduzca su DNI: ");
        MiEntradaSalida.solicitarCaracter("Introduzca su sexo: ");
        MiEntradaSalida.solicitarFloat("Introduzca su altura (en cm): ");
        MiEntradaSalida.solicitarFloat("Introduzca su peso: ");


        while (opciones) {

            String comando = MiEntradaSalida.leerLinea("¿Qué deseas hacer ahora?: ");

            switch (comando.toLowerCase()) {

                case "ver datos personales":

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
        System.out.print("> ver datos personales\n");
        System.out.print("> salir\n");
        System.out.print("=============================================\n \n");
    }
}

