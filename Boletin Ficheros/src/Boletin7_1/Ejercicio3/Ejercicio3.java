package Boletin7_1.Ejercicio3;

import java.io.*;

public class Ejercicio3 {
    static void main(String[] args) {

        File salida = new File("src/Boletin7_1/Ejercicio3/salidaEj3.txt");

        try(BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pw = new PrintWriter(new FileWriter(salida, true))){

            String linea;

            while ((linea = bf.readLine()) != null && !linea.equalsIgnoreCase("fin")){
                //pw.write(linea);
                pw.println(linea);
            }

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
