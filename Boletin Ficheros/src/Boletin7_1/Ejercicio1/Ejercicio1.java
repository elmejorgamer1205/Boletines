package Boletin7_1.Ejercicio1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Ejercicio1 {
    // Metodo principal. Faltaría el modificador 'public' (public static void main) para que compile y ejecute.
    static void main(String[] args) throws FileNotFoundException {
        // Se define un objeto File con la ruta relativa del archivo usando la API clásica (java.io).
        File f = new File("Boletin7_1/Ejercicio1/leeme.txt");

        // Bloque try-with-resources. Se encarga de cerrar automáticamente 'fr' y 'br' al terminar.
        // Ojo: Se abren recursos de lectura que la "Tercera forma" (la que está activa abajo) no utiliza.
        try (FileReader fr = new FileReader(f);
             BufferedReader br = new BufferedReader(fr)){

            /* Primera forma: Enfoque clásico (Pre-Java 8)
               Se usa un bucle para leer iterativamente el archivo línea a línea.
               Es muy eficiente en memoria ya que solo carga un String a la vez.

            int contador = 0;

            while(br.readLine() != null){
                contador++;
            }

            System.out.printf("Había %d líneas", contador);
            */

            /* Segunda forma: Enfoque declarativo con Streams (Java 8+)
               Usa el método lines() de BufferedReader que devuelve un Stream de Strings
               y aplica .count() para contar los elementos del flujo.

            System.out.printf("Había %d líneas", br.lines().count());
            */

            // Tercera forma (Código activo): Enfoque moderno con API NIO (java.nio.file)
            // Se declara una ruta distinta al objeto 'f' del principio.
            Path fichero = Path.of("./src/leeme.txt");

            // Genera un Stream directamente desde el Path y cuenta sus líneas.
            // (Nota técnica: Files.lines() devuelve un Stream que idealmente debe cerrarse para no dejar el archivo bloqueado).
            System.out.printf("Había %d líneas", Files.lines(fichero).count());

        } catch (IOException e){
            // Captura excepciones en caso de que el archivo no exista o no se pueda leer
            System.out.println(e.getMessage());
        }
    }
}