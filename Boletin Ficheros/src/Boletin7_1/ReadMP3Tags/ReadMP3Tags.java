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

        // Abrimos el canal en modo lectura. Excelente uso del try-with-resources.
        try (FileChannel canal = FileChannel.open(path, StandardOpenOption.READ)){

            long tamano = canal.size();

            // 1. Saltamos a los últimos 128 bytes.
            // 🌟 MAGIA PURA: El estándar ID3v1 dicta que la información de la canción
            // SIEMPRE está escondida exactamente en los últimos 128 bytes del archivo.
            canal.position(tamano - 128);

            // 2. Preparamos el Buffer (nuestro "vagón")
            // Los 3 primeros bytes de esos 128 siempre deben decir "TAG" si el archivo tiene metadatos.
            ByteBuffer buffer = ByteBuffer.allocate(3);
            canal.read(buffer);
            buffer.flip(); // ¡Paso crítico! Cambiar a modo lectura para extraer los datos del buffer.

            byte[] bytesTag = new byte[3];
            buffer.get(bytesTag);
            String tag = new String(bytesTag);

            // Verificación de seguridad. Si no pone "TAG", es que el archivo no tiene metadatos ID3v1
            // (podría tener ID3v2, que van al principio del archivo, pero eso es más complejo).
            if (!"TAG".equals(tag)) {
                System.out.println("Este archivo no soporta ID3v1");
                return;
            }

            // 3. Leer los campos secuencialmente.
            // Como el canal recuerda dónde se quedó (el "puntero" va avanzando solo),
            // solo tenemos que ir pidiendo los bytes en el orden exacto del estándar ID3v1.
            System.out.println("Canción: " + leerCampo(canal, 30));
            System.out.println("Artista: " + leerCampo(canal, 30));
            System.out.println("Álbum:   " + leerCampo(canal, 30));
            System.out.println("Año:     " + leerCampo(canal, 4));
            System.out.println("Comentario: " + leerCampo(canal, 30));
            // Faltaría 1 byte al final que corresponde al "Género" musical (es un código numérico).

        } catch (IOException ex) {
            System.err.println("Error de E/S: " + ex);
        }
    }

    // Método auxiliar para limpiar el código (¡Excelente decisión arquitectónica!)
    private static String leerCampo(FileChannel canal, int longitud) throws IOException {
        // Asigna un buffer del tamaño exacto que necesitamos (ej: 30 bytes)
        ByteBuffer buffer = ByteBuffer.allocate(longitud);
        canal.read(buffer);
        buffer.flip();

        byte[] datos = new byte[longitud];
        buffer.get(datos);

        // 💡 TRUCO ESTRELLA: .trim()
        // Cuando un título es más corto de 30 letras, el resto se rellena con bytes nulos (\0) o espacios.
        // String.trim() en Java es capaz de eliminar todos esos caracteres invisibles del final,
        // dejando el texto perfectamente limpio.
        return new String(datos).trim();
    }

    public static void main(String[] args) {
        testReadMP3("src/files/0103. Fun Time - AShamaluevMusic.mp3");
    }
}