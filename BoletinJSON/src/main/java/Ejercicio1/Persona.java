package Ejercicio1; // Nota: Las convenciones de Java recomiendan que los paquetes vayan en minúsculas (ejercicio1)

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Persona {

    // Los atributos de la clase. Gson es lo suficientemente inteligente como para
    // leer estos campos privados usando "Reflexión" sin necesitar métodos 'getters'.
    private String nombre;
    private String dni;
    private int telefono;

    // Constructor para inicializar los objetos Persona
    public Persona(String nombre, String dni, int telefono) {
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
    }

    // ⚠️ Faltaba el modificador 'public' para que la JVM pueda arrancar el programa.
    public static void main(String[] args) {

        // Instanciamos 5 objetos de tipo Persona
        Persona p1 = new Persona("Jose", "12345678T", 123456789);
        Persona p2 = new Persona("Juan", "92823864L", 254145562);
        Persona p3 = new Persona("Moisés", "78373987H", 698589654);
        Persona p4 = new Persona("Lolo", "353544636M", 333696654);
        Persona p5 = new Persona("Carlos", "36572383X", 999999999);

        // Creamos la instancia de Gson.
        // .setPrettyPrinting() formatea el JSON con saltos de línea y tabulaciones,
        // en lugar de escupir todo en una sola línea incomprensible.
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // Agrupamos las personas en una lista inmutable (muy limpio y directo).
        List<Persona> clientes = List.of(p1, p2, p3, p4, p5);

        // ¡La magia de Gson! Convierte toda la lista de objetos en un String con formato JSON.
        String json = gson.toJson(clientes);

        // Definimos dónde queremos guardar el archivo.
        // (Curioso que la carpeta se llame "Videojuego", pero la ruta es perfectamente válida).
        Path path = Path.of("src/main/java/Videojuego/salidas.json");

        try {
            // Escribimos el String JSON en el archivo.
            // 💡 TRUCO TÉCNICO: Si no pones opciones en Files.writeString, por defecto usa CREATE, TRUNCATE_EXISTING y WRITE.
            // Si fuerzas solo CREATE, podría dar problemas si el archivo ya existe. Lo ideal es dejarlo vacío
            // o añadir explícitamente TRUNCATE_EXISTING para que sobrescriba el archivo limpio cada vez.
            Files.writeString(path, json, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

            System.out.println("¡Archivo JSON generado con éxito!");

        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }
}