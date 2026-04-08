package Boletin7_1.ReadMP3Tags;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ReadMP3Tags {
    static void testReadMP3(String filePath) {
        Path path = Paths.get(filePath);

        try (FileChannel canal = FileChannel.open(path, StandardOpenOption.READ)){

            long tamano = canal.size();

            // 1. Saltamos a los últimos 128 bytes (donde empieza el tag ID3v1)
            canal.position(tamano - 128);

            // 2. Preparamos el Buffer (nuestro "vagón")
            // El primer tag "TAG" mide 3 bytes
            ByteBuffer buffer = ByteBuffer.allocate(3);
            canal.read(buffer);
            buffer.flip(); // ¡Paso crítico! Cambiar a modo lectura

            byte[] bytesTag = new byte[3];
            buffer.get(bytesTag);
            String tag = new String(bytesTag);

            if (!"TAG".equals(tag)) {
                System.out.println("Este archivo no soporta ID3v1");
                return;
            }

            // 3. Leer los campos (usamos una función auxiliar para no repetir código)
            System.out.println("Canción: " + leerCampo(canal, 30));
            System.out.println("Artista: " + leerCampo(canal, 30));
            System.out.println("Álbum:   " + leerCampo(canal, 30));
            System.out.println("Año:     " + leerCampo(canal, 4));
            System.out.println("Comentario: " + leerCampo(canal, 30));

        } catch (IOException ex) {
            System.err.println("Error de E/S: " + ex);
        }
    }

    // Método auxiliar para limpiar el código
    private static String leerCampo(FileChannel canal, int longitud) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(longitud);
        canal.read(buffer);
        buffer.flip();
        byte[] datos = new byte[longitud];
        buffer.get(datos);
        return new String(datos).trim(); // trim() para quitar espacios vacíos al final
    }

    public static void main(String[] args) {
        testReadMP3("src/files/0103. Fun Time - AShamaluevMusic.mp3");
    }
}
