package Ejercicio5;

import Exceptions.LineaException;
import Exceptions.MiEntradaSalidaExceptions;
import utils.MiEntradaSalida;


public class Main {
    public final static int TAMAÑO = 5;

    public static void main(String[] args) {
        boolean activo = true;
        Linea[] lineas = new Linea[3];
        int contador = 0;
        System.out.println("Opciones:\n" +
                "Mover en el ejeX \n" +
                "Mover en en ejeY \n" +
                "Comparar lineas \n" +
                "Crear lineas \n" +
                "Salir\n");

        while (activo) {
            int linea;
            double distancia;
            String comando = MiEntradaSalida.leerLinea("¿Que desea hacer?\n");
            switch (comando.toLowerCase()) {
                case "mover en el ejex":
                    if (hayLineasCreadas(lineas)) {
                        MiEntradaSalida.mostrarOpcionesSinNulos("Opciones: \n", lineas);
                        linea = pedirLinea(lineas);
                        distancia = MiEntradaSalida.solicitarDouble("¿Cuanto lo quieres mover?");
                        lineas[linea].moverEjeX(distancia);
                    } else {
                        System.out.println("No hay lineas creadas.\n");
                    }
                    break;
                case "mover en el ejey":
                    if (hayLineasCreadas(lineas)) {
                        MiEntradaSalida.mostrarOpcionesSinNulos("Opciones: \n", lineas);
                        linea = pedirLinea(lineas);
                        distancia = MiEntradaSalida.solicitarDouble("¿Cuanto lo quieres mover?");
                        lineas[linea].moverEjeY(distancia);
                    } else {
                        System.out.println("No hay lineas creadas.\n");
                    }
                    break;
                case "crear lineas":
                    int cantidad;
                    try {
                        cantidad = MiEntradaSalida.solicitarEnteroEnRango("\n¿Cuantas lineas quieres crear?", 1, lineas.length);
                        for (int i = 0; i < cantidad; i++) {
                            if (contador < lineas.length) {
                                if (lineas[i] == null) {
                                    lineas[i] = crearLinea(i + 1);
                                    contador++;
                                } else if (lineas[i] != null) {
                                    cantidad++;
                                }

                            } else {
                                System.out.println("No puedes crear mas lineas.\n");
                                break;
                            }
                        }
                        break;
                    } catch (MiEntradaSalidaExceptions e) {
                        System.out.println(e.getMessage());
                    }
                case "comparar lineas":
                    if (contarLineasCreadas(lineas) >= 2) {
                        MiEntradaSalida.mostrarOpcionesSinNulos("Opciones: ", lineas);
                        int pedirLinea1 = pedirLinea(lineas);
                        int pedirLinea2 = pedirLinea(lineas);
                        if (lineas[pedirLinea1].equals(lineas[pedirLinea2])) {
                            System.out.println("Las lineas son iguales.\n");
                        } else {
                            System.out.println("Las lineas no son iguales\n");
                        }
                    } else {
                        System.out.println("No hay suficientes lineas");
                    }
                    break;
                case "salir":
                    activo = false;
                    break;
                default:
                    System.out.println("Opciones:\n" +
                            "Mover en el ejeX \n" +
                            "Mover en en ejeY \n" +
                            "Comparar lineas \n" +
                            "Crear lineas \n" +
                            "Salir\n");
                    break;
            }
        }
    }

    public static Punto crearPunto(String mensaje) {
        System.out.println(mensaje);
        int x = MiEntradaSalida.solicitarEntero("Introduzca la coordenada x: ");
        int y = MiEntradaSalida.solicitarEntero("Introduzca la coordenada y: ");
        return new Punto(x, y);
    }

    public static Linea crearLinea(int indice) {
        System.out.println("\nLinea numero " + indice);
        boolean lineaValida = false;
        Punto puntoA = null;
        Punto puntoB = null;
        while (!lineaValida) {
            puntoA = crearPunto("Punto A");
            puntoB = crearPunto("Punto B");
            Linea prueba = new Linea(puntoA, puntoB);
            try {
                prueba.comprobarSiEsPunto();
                lineaValida = true;
            } catch (LineaException e) {
                System.out.println(e.getMessage());
            }
        }
        return new Linea(puntoA, puntoB);
    }

    public static boolean hayLineasCreadas(Linea[] lineas) {
        for (int i = 0; i < lineas.length; i++) {
            if (lineas[i] != null) {
                return true;
            }

        }
        return false;
    }

    public static int pedirLinea(Linea[] lineas) {
        try {
            return MiEntradaSalida.solicitarEnteroEnRango("¿Que linea quieres usar? (Introduce el numero): ", 1, lineas.length) - 1;
        } catch (MiEntradaSalidaExceptions e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public static int contarLineasCreadas(Linea[] lineas) {
        int contador = 0;
        for (int i = 0; i < lineas.length; i++) {
            if (lineas[i] != null) {
                contador++;
            }
        }
        return contador;
    }

}
