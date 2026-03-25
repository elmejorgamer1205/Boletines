package Boletin7_1.Ejercicio6;

import io.MiEntradaSalida;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Ejercicio6 {
    static void main(String[] args) {

        String nombreDirectorio = MiEntradaSalida.leerLinea("Introduce el nombre del directorio /n");

        Path p = Path.of(nombreDirectorio);

        if (Files.exists(p)){
            if (Files.isDirectory(p)){
                try {
                    Files.list(p).forEach(path ->{
                        if (Files.isDirectory(path)){
                            System.out.printf("%s - directorio %n", path.getFileName());
                        }else{
                            try {
                                System.out.printf("%s %.2f kb", path.getFileName(), Files.size(path)/1024.0);
                            } catch (IOException e){
                                System.out.println(e.getMessage());
                            }
                        }
                    });
                }catch (IOException e){
                    throw new RuntimeException(e);
                }
            }
            else {
                System.out.println("No existe, sorry");
            }
        }
    }
}
