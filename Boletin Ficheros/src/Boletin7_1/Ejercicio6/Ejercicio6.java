package Boletin7_1.Ejercicio6;

// Importa tu clase personalizada para leer datos por teclado
import io.MiEntradaSalida;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Ejercicio6 {
    // Al igual que en los anteriores, recuerda poner 'public' (public static void main)
    // para que la máquina virtual de Java lo pueda arrancar.
    static void main(String[] args) {

        // Pide al usuario que introduzca la ruta de un directorio (carpeta).
        String nombreDirectorio = MiEntradaSalida.leerLinea("Introduce el nombre del directorio \n");

        // Convierte el String ingresado en un objeto Path de NIO.
        Path p = Path.of(nombreDirectorio);

        // Primer filtro: Comprueba si la ruta introducida realmente existe en el disco duro.
        if (Files.exists(p)){

            // Segundo filtro: Comprueba si la ruta es una carpeta (directorio).
            if (Files.isDirectory(p)){
                try {
                    // ⚠️ NOTA TÉCNICA IMPORTANTE: Files.list() devuelve un Stream que debe ser cerrado.
                    // Lo ideal aquí sería usar un try-with-resources: try (Stream<Path> stream = Files.list(p)) { ... }
                    // Como está ahora, el Stream no se cierra explícitamente y podría dejar el recurso bloqueado.

                    Files.list(p).forEach(path -> {
                        // Por cada elemento ('path') dentro de la carpeta, comprueba si es otra carpeta
                        if (Files.isDirectory(path)){
                            // Si es carpeta, imprime su nombre y la etiqueta "- directorio"
                            System.out.printf("%s - directorio %n", path.getFileName());
                        } else {
                            // Si es un archivo, necesitamos capturar la posible excepción de Files.size()
                            try {
                                // Files.size() devuelve el tamaño en bytes.
                                // Al dividir entre 1024.0 (con decimales), lo pasamos a Kilobytes (KB).
                                // %.2f formatea el número para mostrar solo 2 decimales.
                                System.out.printf("%s %.2f kb %n", path.getFileName(), Files.size(path)/1024.0);

                            } catch (IOException e){
                                // Captura si hay error al leer el tamaño de ese archivo en concreto
                                System.out.println(e.getMessage());
                            }
                        }
                    });
                } catch (IOException e) {
                    // Si falla la lectura del directorio principal, lanza una excepción en tiempo de ejecución.
                    throw new RuntimeException(e);
                }
            }
            else {
                // ⚠️ PEQUEÑO FALLO LÓGICO: Si llega aquí, significa que la ruta SÍ existe (pasó el primer if),
                // pero NO es un directorio (es decir, es un archivo).
                // Por tanto, el mensaje "No existe, sorry" es engañoso. Debería ser: "Es un archivo, no un directorio".
                System.out.println("No existe, sorry");
            }
        }
        // 💡 Sugerencia: Faltaría un 'else' para el primer 'if' en caso de que la ruta realmente no exista.
    }
}