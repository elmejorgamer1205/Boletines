package Ejercicio1;

import Exceptions.MiEntradaSalidaExceptions;
import utils.MiEntradaSalida;

import java.time.LocalDate;

public class Persona {

    public static void main(String[] args) {

        MétodoPersona p = null;

        System.out.println("\nHola buenos días, cree su cuenta personal\n");

        String nombre = MiEntradaSalida.solicitarCadena("Introduzca su nombre: ");

        LocalDate fecha = null;
        boolean fechaValida = false;
        while (!fechaValida) {
            try {
                fecha = MiEntradaSalida.fecha("Introduce la fecha de nacimiento");
                fechaValida = true;
            } catch (MiEntradaSalidaExceptions e) {
                System.out.println(e.getMessage() + " Inténtelo de nuevo.");
            }
        }

        int dni = MiEntradaSalida.solicitarEntero("Introduzca su DNI: ");

        char sexo = ' ';
        boolean sexoValido = false;
        while (!sexoValido) {
            try {
                sexo = MiEntradaSalida.solicitarCaracter("Introduzca su sexo (M/F): ");
                sexo = Character.toUpperCase(sexo);
                if (sexo == 'M' || sexo == 'F') {
                    sexoValido = true;
                } else {
                    System.out.println("Error: Debe introducir 'M' o 'F'.");
                }
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Error: Debe introducir al menos un carácter.");
            }
        }

        float altura = MiEntradaSalida.solicitarFloat("Introduzca su altura (en m): ");
        float peso = MiEntradaSalida.solicitarFloat("Introduzca su peso (en kg): ");

        p = new MétodoPersona();
        p.setNombre(nombre);
        p.setFechaDeNacimiento(fecha);
        p.setDni(dni);
        p.setSexo(sexo);
        p.setAltura(altura);
        p.setPeso(peso);

        boolean opciones = true;

        while (opciones) {

            String comando = MiEntradaSalida.leerLinea("¿Qué deseas hacer ahora?: ");

            switch (comando.toLowerCase()) {

                case "ver datos personales":
                    p.consultarDatos();
                    break;

                case "ayuda":
                    ayuda();
                    break;

                case "salir":
                    opciones = false;
                    System.out.println("\n!!!Vuelva pronto!!!");
                    break;

                default:
                    System.out.println("Opción no reconocida.");
                    ayuda();
                    break;
            }
        }
    }

    static void ayuda() {
        System.out.println("=================Opciones===================");
        System.out.println("> ver datos personales");
        System.out.println("> salir");
        System.out.println("=============================================\n");
    }
}


