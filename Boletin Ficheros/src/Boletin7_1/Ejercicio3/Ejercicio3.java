package Boletin7_1.Ejercicio3;

import java.io.*;

public class Ejercicio3 {
    // Falta el modificador 'public' (public static void main) para que pueda ser ejecutado.
    static void main(String[] args) {

        // Se define un objeto File que apunta al archivo donde se va a escribir la información.
        File salida = new File("src/Boletin7_1/Ejercicio3/salidaEj3.txt");

        // Bloque try-with-resources para manejar el cierre automático de los flujos de entrada y salida.
        try(
                // BufferedReader envuelve a InputStreamReader, que a su vez envuelve a System.in.
                // Esto permite leer cadenas de texto directamente desde el teclado (entrada estándar).
                BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

                // PrintWriter envuelve a FileWriter.
                // El parámetro 'true' en FileWriter indica modo "append" (añadir).
                // Si el archivo ya tiene texto, lo nuevo se escribirá al final sin borrar lo anterior.
                PrintWriter pw = new PrintWriter(new FileWriter(salida, true))
        ){

            String linea;

            // Lee líneas desde el teclado iterativamente.
            // El bucle continúa mientras no se alcance el final del flujo (null)
            // Y la palabra escrita NO sea "fin" (ignorando mayúsculas y minúsculas).
            while ((linea = bf.readLine()) != null && !linea.equalsIgnoreCase("fin")){

                // pw.write(linea); -> Esta línea comentada escribiría el texto pero sin añadir un salto de línea al final.

                // Imprime la línea leída en el archivo de texto y añade un salto de línea automáticamente.
                pw.println(linea);
            }

        } catch (IOException e){
            // Captura y muestra errores de entrada/salida (ej. no se tienen permisos para escribir en la ruta).
            System.out.println(e.getMessage());
        }
    }
}