package Ejercicio1;

import utils.MiEntradaSalida;

import Exceptions.MiEntradaSalidaExceptions;
import Exceptions.BibliotecaException;

public class Main {

    public static void main(String[] args) {

        Peliculas p = new Peliculas();

        System.out.print("\nBienvenido a tu biblioteca de películas Blex\n");
        boolean opciones = true;

        while (opciones) {

            String comando = MiEntradaSalida.leerLinea("¿Qué desea realizar?: ");

            switch (comando.toLowerCase()) {

                case "introducir película":
                    break;
                case "buscar película por etiqueta":
                    break;
                case "buscar película por título":
                    break;
                case "buscar película por presupuesto máximo":
                    break;
                case "valoraciones":
                    break;
                case "tu biblioteca":
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
        System.out.print("> introduccir película\n");
        System.out.print("> buscar película por etiqueta\n");
        System.out.print("> buscar película por título\n");
        System.out.print("> buscar película por presupuesto máximo\n");
        System.out.print("> valoraciones\n");
        System.out.print("> tu biblioteca\n");
        System.out.print("> salir\n");
        System.out.print("=============================================\n \n");
    }
}
