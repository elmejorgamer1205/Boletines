package Ejercicio1;

import utils.MiEntradaSalida;

import Exceptions.MiEntradaSalidaExceptions;
import Exceptions.BibliotecaException;

public class Main {

    public static void main(String[] args) {
        public static void main (String[]args){
            boolean peliculeando = true;
            boolean opcionEscogida = false;
            BibliotecaDePeliculas biblioteca = new BibliotecaDePeliculas();


            System.out.print("Bienvenido a Anciont filmography\n");

            while (peliculeando) {
                System.out.print("Esto es lo que puedes hacer\n");
                System.out.print("\t1. Añadir película\n");
                System.out.print("\t2. Consultar biblioteca\n");
                System.out.print("\t3. Buscar películas por etiquetas\n");
                System.out.print("\t4. Buscar película por título\n");
                System.out.print("\t5. Buscar película con presupuesto máximo\n");
                System.out.print("\t6. Salir\n");
                int opcion = 0;
                try {
                    opcion = MiEntradaSalida.solicitarEnteroEnRango("¿Qué quieres hacer? (Introduce el numero)", 1, 6);
                } catch (MiEntradaSalidaExceptions e) {
                    throw new RuntimeException(e);
                }

                switch (opcion) {
                    case 1:
                        biblioteca.añadirPelicula(crearPelicula());
                        System.out.println("¡Añadida!\n");
                        break;
                    case 2:
                        System.out.println(biblioteca.mostrarBiblioteca());
                        System.out.println();
                        break;
                    case 3:
                        String etiqueta = MiEntradaSalida.leerLinea("Introduce la etiqueta que quieras buscar: \n");
                        try {
                            System.out.println(biblioteca.buscarPeliculaPorEtiquetas(etiqueta));
                        } catch (BibliotecaException e) {
                            System.out.println(e.getMessage());
                        }
                        System.out.println();
                        break;
                    case 4:
                        String titulo = MiEntradaSalida.leerLinea("Introduce el título que quieras buscar: \n");
                        try {
                            System.out.println(biblioteca.buscarPeliculaPorTitulo(titulo));
                        } catch (BibliotecaException e) {
                            System.out.println(e.getMessage());
                        }
                        System.out.println();
                        break;
                    case 5:
                        double presupuestoMax = MiEntradaSalida.solicitarDouble("Introduce el presupuesto máximo: ");
                        try {
                            System.out.println(biblioteca.buscarPeliculaPorPresupuestoMaximo(presupuestoMax));
                        } catch (BibliotecaException e) {
                            System.out.println(e.getMessage());
                        }
                        System.out.println();
                        break;
                    case 6:
                        System.out.println("Gracias por confiar en anciont filmography");
                        peliculeando = false;
                        break;
                }
            }
        }


        public static Peliculas crearPelicula () {
            boolean crearPelicula = false;
            Peliculas aux = null;
            while (!crearPelicula) {
                String titulo = MiEntradaSalida.leerLinea("Introduce el titulo: \n");
                int año = MiEntradaSalida.solicitarEntero("Introduce el año: ");
                String director = MiEntradaSalida.leerLinea("Introduce el director: \n");
                double presupuesto = MiEntradaSalida.solicitarDouble("Introduce el presupuesto: ");
                double recaudacion = MiEntradaSalida.solicitarDouble("Introduce la recaudación: ");
                String sinopsis = MiEntradaSalida.leerLinea("Introduce la sinopsis: \n");
                String etiquetas = MiEntradaSalida.leerLinea("Introduce las etiquetas (separadas por comas): \n");

                try {
                    aux = new Peliculas(titulo, año, director, presupuesto, recaudacion, sinopsis, etiquetas);
                    crearPelicula = true;
                } catch (BibliotecaException e) {
                    System.out.printf(e.getMessage() + "\n");
                }
            }
            return aux;
        }
    }

