package Boletin7_1.Invertir_Imagen;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class InvertirImagen {

    // Una vez más, recuerda el 'public' (public static void main) para que compile y ejecute.
    static void main(String[] args) {

        // Rutas de los archivos de origen (la imagen a leer) y destino (la imagen a crear)
        Path rutaImagen = Path.of("src/Boletin7_1/Invertir_Imagen/pradera.bmp");
        Path rutaDestino = Path.of("src/Boletin7_1/Invertir_Imagen/destino.bmp");

        // try-with-resources abriendo canales de archivos (FileChannel).
        // FileChannel es la forma más rápida en Java de leer/escribir datos binarios puros.
        try(
                // Canal de lectura
                FileChannel canal = FileChannel.open(rutaImagen, StandardOpenOption.READ);
                // Canal de escritura (crea el archivo si no existe, si existe lo sobrescribe por defecto)
                FileChannel canal2 = FileChannel.open(rutaDestino, StandardOpenOption.WRITE, StandardOpenOption.CREATE)
        ){

            // 🌟 ¡MAGIA AQUÍ!
            // Las imágenes BMP sin compresión tienen exactamente 54 bytes de "cabecera" (metadata).
            // Esa cabecera dice cosas como el tamaño, ancho, alto, etc. ¡NO se puede invertir o romperás la imagen!
            ByteBuffer buffer = ByteBuffer.allocate(54);

            // Buffer de 3 bytes para procesar los colores de cada píxel (Azul, Verde, Rojo - BGR).
            ByteBuffer buffer1 = ByteBuffer.allocate(3);

            // 1. Leemos los primeros 54 bytes (la cabecera)
            canal.read(buffer);
            // flip() prepara el buffer para pasar de modo "escritura" (llenarlo con datos del archivo)
            // a modo "lectura" (escribir esos datos en el nuevo archivo).
            buffer.flip();
            // 2. Escribimos la cabecera intacta en el nuevo archivo.
            canal2.write(buffer);

            // Bucle para leer el resto de la imagen (los píxeles), de 3 en 3 bytes.
            while (canal.read(buffer1) > 0 ){
                buffer1.flip(); // Prepara el buffer de 3 bytes para poder leer qué colores entraron.

                // Extrae los valores de los colores originales.
                byte azul = buffer1.get(0);
                byte verde = buffer1.get(1);
                byte rojo = buffer1.get(2);

                // 🧠 OPERADOR BITWISE NOT (~)
                // En lugar de hacer la resta matemática (255 - valor), usas el operador '~' que invierte
                // todos los bits (0s por 1s y 1s por 0s). Es la forma más rápida de calcular el negativo.
                byte inverso1 = (byte) ~azul;
                byte inverso2 = (byte) ~verde;
                byte inverso3 = (byte) ~rojo;

                // Sobrescribe el buffer con los nuevos colores invertidos.
                buffer1.put(0, inverso1);
                buffer1.put(1, inverso2);
                buffer1.put(2, inverso3);

                // Escribe el píxel invertido en el archivo de destino.
                // IMPORTANTE: Como usaste put() con índice absoluto, el puntero del buffer no se movió,
                // por lo que al escribir, escribirá los 3 bytes correctamente desde la posición 0.
                canal2.write(buffer1);

                // Limpia el buffer para que vuelva a la posición inicial y pueda recibir los siguientes 3 bytes.
                buffer1.clear();
            }

        } catch (IOException e){
            System.out.printf("%s \n", e.getMessage());
        }
    }
}