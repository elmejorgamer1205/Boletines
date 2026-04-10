package Ejercicio1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Persona {

    private String nombre;
    private String dni;
    private int telefono;

    public Persona(String nombre, String dni, int telefono) {
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
    }

    static void main(String[] args) {
        Persona p1 = new Persona("Jose", "12345678T",123456789);
        Persona p2 = new Persona("Juan", "92823864L",254145562);
        Persona p3 = new Persona("Moisés", "78373987H",698589654);
        Persona p4 = new Persona("Lolo", "353544636M",333696654);
        Persona p5 = new Persona("Carlos", "36572383X",999999999);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        List<Persona> clientes = List.of(p1,p2,p3,p4,p5);

        String json = gson.toJson(clientes);

        Path path = Path.of("src/main/java/Videojuego/salidas.json");

        try {
            Files.writeString(path,json,StandardOpenOption.CREATE);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }
}
