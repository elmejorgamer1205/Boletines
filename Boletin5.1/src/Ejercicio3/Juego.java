package Ejercicio3;
import Exceptions.MiEntradaSalidaExceptions;
import Exceptions.PersonajeException;
import utils.MiEntradaSalida;

import java.util.Arrays;
import java.util.Comparator;

public class Juego {

    // Tamaño máximo del array de jugadores
    static final int TAM_ARRAY_JUGADORES = 100;

    /**
     * Metodo principal del programa.
     * Controla el menú y la interacción con el usuario.
     *
     * @param args argumentos de línea de comandos
     */
    public static void main(String[] args) {

        // Array donde se almacenan los personajes del juego
        Personaje[] jugadores = new Personaje[TAM_ARRAY_JUGADORES];

        // Controla el bucle principal del menú
        boolean interactuando = true;

        // Variables auxiliares para elecciones del usuario
        int magoElegido;
        String hechizo;
        int jugadorElegido;
        int clerigoElegido;

        System.out.println("Bienvenido al juego. Estas son tus opciones: ");

        // Bucle principal del menú
        while (interactuando) {
            try {
                System.out.println("""
                        \t 1. Alta de personaje
                        \t 2. Mago aprende hechizo
                        \t 3. Mago lanza hechizo
                        \t 4. Clérigo cura al mago
                        \t 5. Mostrar el listado de personajes
                        \t 6. Mostrar el listado de personajes ordenados por puntos actuales de mayor a menor
                        \t 7. Salir
                        """);

                // Solicita la opción al usuario
                int opcion = MiEntradaSalida.solicitarEnteroEnRango(
                        "¿Que quieres hacer?", 1, 7);

                switch (opcion) {

                    // Alta de personaje
                    case 1:
                        String personaje = MiEntradaSalida.leerLinea(
                                "¿A que personaje deseas crear? (Mago o Clérigo)\n");

                        // Creación del personaje según el tipo
                        Personaje p = switch (personaje.toLowerCase()) {
                            case "mago" -> crearMago();
                            case "clérigo" -> crearClerigo();
                            default -> null;
                        };

                        // Se guarda el personaje en la primera posición libre
                        for (int i = 0; i < jugadores.length; i++) {
                            if (jugadores[i] == null) {
                                jugadores[i] = p;
                                break;
                            }
                        }
                        break;

                    // Enseñar hechizo a un mago
                    case 2:
                        mostrarMagos(jugadores);
                        magoElegido = MiEntradaSalida.solicitarEntero(
                                "Introduce el numero del mago a el cual quieras enseñarle el hechizo: ");
                        hechizo = MiEntradaSalida.leerLinea(
                                "¿Que hechizo quieres enseñarle?\n");

                        // Comprobamos que el personaje es un mago
                        if (jugadores[magoElegido] instanceof Mago m) {
                            m.aprenderHechizo(hechizo);
                            System.out.println("Hecho!\n");
                        } else {
                            System.out.println("¡Eso no es un mago!");
                        }
                        break;

                    // Lanzar hechizo
                    case 3:
                        mostrarMagos(jugadores);
                        magoElegido = MiEntradaSalida.solicitarEntero(
                                "Introduce el numero del mago el cual quieras que use un hechizo: ");

                        if (jugadores[magoElegido] instanceof Mago m) {

                            // Mostrar hechizos del mago
                            m.mostrarHechizos();
                            hechizo = MiEntradaSalida.leerLinea(
                                    "¿Que hechizo quieres utilizar?");

                            // Mostrar posibles objetivos
                            for (int i = 0; i < jugadores.length; i++) {
                                if (jugadores[i] != null) {
                                    System.out.println(i + ". " + jugadores[i]);
                                } else {
                                    System.out.println("No quedan mas jugadores por mostrar");
                                    break;
                                }
                            }

                            jugadorElegido = MiEntradaSalida.solicitarEntero(
                                    "Introduce el índice del personaje al cual quieres atacar: ");

                            // Evita que el mago se ataque a sí mismo
                            if (m.equals(jugadores[jugadorElegido])) {
                                System.out.println("¡No puedes atacarte a ti mismo, Tonto!");
                            } else {
                                m.lanzarHechizos(jugadores[jugadorElegido], hechizo);
                                System.out.println("Hecho!");
                            }
                        } else {
                            System.out.println("¡Eso no es un mago!");
                        }
                        break;

                    // Curar a un mago con un clérigo
                    case 4:
                        mostrarClerigos(jugadores);
                        clerigoElegido = MiEntradaSalida.solicitarEntero(
                                "Introduce el índice del mago que quieras utilizar: ");

                        if (jugadores[clerigoElegido] instanceof Clerigo c) {

                            // Se muestran magos y personajes muertos
                            mostrarMagosYMuertos(jugadores);
                            magoElegido = MiEntradaSalida.solicitarEntero(
                                    "Introduce el numero del mago al cual quieras curar: ");

                            c.curar(jugadores[magoElegido]);
                            System.out.println("¡Hecho!");
                        } else {
                            System.out.println("¡Eso no es un Clérigo!");
                        }
                        break;

                    // Mostrar personajes
                    case 5:
                        MiEntradaSalida.mostrarOpcionesSinNulos(
                                "Aquí tienes todos los jugadores activos: ", jugadores);
                        break;

                    // Mostrar personajes ordenados por vida
                    case 6:
                        Personaje[] copia = Arrays.copyOf(jugadores, TAM_ARRAY_JUGADORES);

                        /*
                         * Ordenamos el array por vida actual
                         * de mayor a menor
                         */
                        Arrays.sort(copia,
                                Comparator.comparingInt(Personaje::getVidaActual).reversed());

                        int contador = 0;
                        for (Personaje pe : copia) {
                            if (pe != null) {
                                System.out.println(contador++ + " " + pe.getNombre());
                            }
                        }
                        break;

                    // Salir del juego
                    case 7:
                        interactuando = false;
                        break;
                }

            } catch (MiEntradaSalidaExceptions | PersonajeException e) {
                // Captura de errores del juego
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Crea un mago solicitando los datos al usuario.
     *
     * @return Mago creado
     */
    public static Mago crearMago() {

        Mago aux = null;
        boolean creado = false;

        while (!creado) {

            // Solicitud de datos del mago
            String nombre = MiEntradaSalida.leerLinea("Introduzca el nombre del mago: \n");
            String raza = MiEntradaSalida.leerLinea("Introduzca la raza (Humano, enano, orco o elfo): \n");
            int fuerza = MiEntradaSalida.solicitarEntero("Introduce la fuerza del mago (<15): ");
            int inteligencia = MiEntradaSalida.solicitarEntero("Introduce la inteligencia del mago (>17 y <20): ");
            int vidaMax = MiEntradaSalida.solicitarEntero("Introduzca la vida máxima: ");

            try {
                aux = new Mago(nombre, raza, fuerza, inteligencia, vidaMax);
                creado = true;
            } catch (PersonajeException e) {
                System.out.println(e.getMessage());
            }
        }
        return aux;
    }

    /**
     * Crea un clérigo solicitando los datos al usuario.
     *
     * @return Clerigo creado
     */
    public static Clerigo crearClerigo() {

        Clerigo aux = null;
        boolean creado = false;

        while (!creado) {

            // Solicitud de datos del clérigo
            String nombre = MiEntradaSalida.leerLinea("Introduzca el nombre del Clérigo: \n");
            String raza = MiEntradaSalida.leerLinea("Introduzca la raza (Humano, enano, orco o elfo): \n");
            int fuerza = MiEntradaSalida.solicitarEntero("Introduce la fuerza del Clérigo (>18): ");
            int inteligencia = MiEntradaSalida.solicitarEntero("Introduce la inteligencia del Clérigo (>12 y <16): ");
            int vidaMax = MiEntradaSalida.solicitarEntero("Introduzca la vida máxima: ");
            String dios = MiEntradaSalida.leerLinea("Introduce el nombre de tu dios: \n");

            try {
                aux = new Clerigo(nombre, raza, fuerza, inteligencia, vidaMax, dios);
                creado = true;
            } catch (PersonajeException e) {
                System.out.println(e.getMessage());
            }
        }
        return aux;
    }

    /**
     * Muestra todos los magos del array.
     */
    public static void mostrarMagos(Personaje[] jugadores) {
        for (int i = 0; i < jugadores.length; i++) {
            if (jugadores[i] instanceof Mago) {
                System.out.println(i + ". " + jugadores[i].getNombre());
            }
        }
    }

    /**
     * Muestra todos los clérigos del array.
     */
    public static void mostrarClerigos(Personaje[] jugadores) {
        for (int i = 0; i < jugadores.length; i++) {
            if (jugadores[i] instanceof Clerigo) {
                System.out.println(i + ". " + jugadores[i].getNombre());
            }
        }
    }

    /**
     * Muestra magos y personajes muertos.
     */
    public static void mostrarMagosYMuertos(Personaje[] jugadores) {
        for (int i = 0; i < jugadores.length; i++) {
            if (jugadores[i] != null) {
                if (jugadores[i] instanceof Mago || jugadores[i].getVidaActual() <= 0) {
                    System.out.println(i + ". " + jugadores[i].getNombre());
                }
            }
        }
    }

    /**
     * Ordena los personajes por vida actual de mayor a menor.
     *
     * @param jugadores array de personajes
     */
    public static void ordenarPorVida(Personaje[] jugadores) {

        // TODO: Evitar ordenar posiciones null
        Arrays.sort(jugadores,
                Comparator.comparingInt(Personaje::getVidaActual).reversed());
    }
}

