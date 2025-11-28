package utils;

import Exceptions.MiEntradaSalidaExceptions;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class MiEntradaSalida {

    // 1. El Scanner se hace PRIVADO para protegerlo.
    // Solo esta clase puede usarlo.
    private static Scanner sc = new Scanner(System.in);

    public static int solicitarEntero(String mensaje) {
        // Variable que almacenará el entero introducido por teclado.
        int integer = 0;
        // Variable que almacenará un booleano que indicará si se le debe volver a pedir el dato al usuario.
        boolean flag = true;

        while (flag) {
            // Pedimos el entero por pantalla.
            System.out.println(mensaje);
            // Comprobamos si el usuario está introduciendo algo correcto usando la excepción del método parseInt.
            try {
                integer = Integer.parseInt(sc.nextLine());
                // Si llegamos hasta aquí, es porque el usuario ha introducido un dato correcto.
                flag = false;
            }
            // Si se lanza la excepción, informamos al usuario de su error.
            catch (NumberFormatException e) {
                // 2. Mensaje de error específico.
                System.out.println("Error: Debe introducir un número entero.");
            }

        }

        return integer;
    }

    public static int solicitarEnteroPositivo(String mensaje, boolean b) {
        // Variable que almacenará el entero introducido por teclado.
        int integer = 0;
        // Variable que almacenará un booleano que indicará si se le debe volver a pedir el dato al usuario.
        boolean flag = true;

        while (flag) {
            // Pedimos el entero por pantalla.
            System.out.println(mensaje);
            // Comprobamos si el usuario está introduciendo algo correcto.
            try {
                integer = Integer.parseInt(sc.nextLine());

                // Comprobamos la segunda condición: que sea positivo.
                if (integer >= 0) {
                    // Si llegamos hasta aquí, el dato es correcto.
                    flag = false;
                } else {
                    // 2. Mensaje de error específico (error de lógica, no de formato).
                    System.out.println("Error: El número debe ser positivo o cero.");
                }
            }
            // Si se lanza la excepción, informamos al usuario de su error.
            catch (NumberFormatException e) {
                // 2. Mensaje de error específico (error de formato).
                System.out.println("Error: Debe introducir un número entero.");
            }

        }

        return integer;
    }

    public static int solicitarEnteroEnRango(String mensaje, int limiteInferior, int limiteSuperior) throws MiEntradaSalidaExceptions{
        // Variable que almacenará el entero introducido por teclado.
        int integer = 0;
        // Variable que almacenará un booleano que indicará si se le debe volver a pedir el dato al usuario.
        boolean flag = true;

        while (flag) {
            // Pedimos el entero por pantalla.
            System.out.println(mensaje);
            // Comprobamos si el usuario está introduciendo algo correcto.
            try {
                integer = Integer.parseInt(sc.nextLine());

                // Comprobamos la segunda condición: el rango.
                if (integer >= limiteInferior && integer <= limiteSuperior) {
                    // Si llegamos hasta aquí, el dato es correcto.
                    flag = false;
                } else {
                    // 2. Mensaje de error específico (error de lógica).
                    System.out.println("Error: El número debe estar entre " + limiteInferior + " y " + limiteSuperior + ".");
                }
            }
            // Si se lanza la excepción, informamos al usuario de su error.
            catch (NumberFormatException e) {
                // 2. Mensaje de error específico (error de formato).
                System.out.println("Error: Debe introducir un número entero.");
            }

        }

        return integer;
    }

    public static char solicitarCaracter(String mensaje) {
        char c = '0';
        // Variable que almacenará un booleano que indicará si se le debe volver a pedir el dato al usuario.
        boolean flag = true;

        while (flag) {
            // Pedimos el carácter por pantalla.
            System.out.println(mensaje);

            try {
                // Obtenemos el primer carácter de la línea.
                c = sc.nextLine().charAt(0);
                // Si llegamos hasta aquí, es porque el usuario ha introducido un dato correcto.
                flag = false;
            }
            // Si se lanza la excepción (porque el usuario no escribió nada).
            catch (StringIndexOutOfBoundsException e) { // Es más específico que IndexOutOfBoundsException
                // 2. Mensaje de error específico.
                System.out.println("Error: No ha introducido bien los caracteres. Inténtelo de nuevo.");
            }

        }

        return c;
    }

    public static char solicitarCaracterSN(String mensaje) {
        char c = '0';
        // Variable que almacenará un booleano que indicará si se le debe volver a pedir el dato al usuario.
        boolean flag = true;

        while (flag) {
            // Pedimos el carácter por pantalla.
            System.out.println(mensaje);

            String cadena = sc.nextLine();

            // Comprobamos que la longitud sea de 1 solo carácter.
            if (cadena.length() == 1) {
                c = cadena.toUpperCase().charAt(0);

                // Comprobamos si es S o N.
                if (c == 'S' || c == 'N') {
                    // Si llegamos hasta aquí, el dato es correcto.
                    flag = false;
                } else {
                    // 2. Mensaje de error específico (carácter incorrecto).
                    System.out.println("Error: Respuesta no válida. Debe introducir 'S' o 'N'.");
                }
            } else {
                // 2. Mensaje de error específico (longitud incorrecta).
                System.out.println("Error: Debe introducir un solo carácter ('S' o 'N').");
            }
        }

        return c;
    }

    public static String solicitarCadena(String mensaje) {
        String cadena = "";
        // Variable que almacenará un booleano que indicará si se le debe volver a pedir el dato al usuario.
        boolean flag = true;

        while (flag) {
            // Pedimos el string por pantalla.
            System.out.println(mensaje);

            // 3. Usamos .trim() para eliminar espacios en blanco al inicio y al final.
            cadena = sc.nextLine().trim();

            // Comprobamos que la cadena no esté vacía después de quitarle los espacios.
            if (!cadena.isEmpty()) {
                // Si llegamos hasta aquí, el dato es correcto.
                flag = false;
            } else {
                // 2. Mensaje de error específico.
                System.out.println("Error: No puede introducir una cadena vacía.");
            }
        }

        return cadena;
    }

    public static String leerLinea(String mensaje) {
        System.out.print(mensaje);
        return sc.nextLine();

    }

    public static float solicitarFloat(String mensaje) {
        // Variable que almacenará el entero introducido por teclado.
        float integer2 = 0;
        // Variable que almacenará un booleano que indicará si se le debe volver a pedir el dato al usuario.
        boolean flag = true;

        while (flag) {
            // Pedimos el entero por pantalla.
            System.out.println(mensaje);
            // Comprobamos si el usuario está introduciendo algo correcto usando la excepción del método parseInt.
            try {
                integer2 = Float.parseFloat(sc.nextLine());
                // Si llegamos hasta aquí, es porque el usuario ha introducido un dato correcto.
                flag = false;
            }
            // Si se lanza la excepción, informamos al usuario de su error.
            catch (NumberFormatException e) {
                // 2. Mensaje de error específico.
                System.out.println("Error: Debe introducir un número entero.");
            }

        }
        return integer2;
    }

    public static LocalDate fecha(String mensaje) throws MiEntradaSalidaExceptions {
        int año = solicitarEnteroPositivo("Introduce el año: ", false);
        int mes = solicitarEnteroPositivo("Introduce el mes: ", false);
        int dia = solicitarEnteroPositivo("Introduce el día: ", false);
        try {
            return LocalDate.of(año, mes, dia);
        }catch (DateTimeException e){
            throw new MiEntradaSalidaExceptions("Error: debes poner una fecha real");
        }
    }

    public static double solicitarDouble(String mensaje) {
        // Variable que almacenará el entero introducido por teclado.
        double integer = 0;
        // Variable que almacenará un booleano que indicará si se le debe volver a pedir el dato al usuario.
        boolean flag = true;

        while (flag) {
            // Pedimos el entero por pantalla.
            System.out.println(mensaje);
            // Comprobamos si el usuario está introduciendo algo correcto usando la excepción del método parseDouble.
            try {
                integer = Double.parseDouble(sc.nextLine());
                // Si llegamos hasta aquí, es porque el usuario ha introducido un dato correcto.
                flag = false;
            }
            // Si se lanza la excepción, informamos al usuario de su error.
            catch (NumberFormatException e) {
                // 2. Mensaje de error específico.
                System.out.println("Error: Debe introducir un número entero.");
            }

        }

        return integer;
    }

    public static void mostrarOpcionesSinNulos(String mensaje, Object[] array) {
        System.out.println(mensaje);
        int posicion = 1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                System.out.println(posicion++ + "." + " " + array[i]);
            }
        }
        System.out.println();
    }
}
