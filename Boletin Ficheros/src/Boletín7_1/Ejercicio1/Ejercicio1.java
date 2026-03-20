package Boletín7_1.Ejercicio1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Ejercicio1 {
    static void main(String[] args) throws FileNotFoundException {
        File f = new File("Boletín7_1/Ejercicio1/leeme.txt");

        try (FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr)){
            /* Primera forma:

            int contador = 0;

            while(br.readLine() != null){
                contador++;
            }

            System.out.printf("Había %d líneas", contador);
            */

            /*Segunda forma:

            System.out.printf("Había %d líneas", br.lines().count());
            */

            Path fichero = Path.of("./src/leeme.txt");

            System.out.printf("Había %d líneas", Files.lines(fichero).count());

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
