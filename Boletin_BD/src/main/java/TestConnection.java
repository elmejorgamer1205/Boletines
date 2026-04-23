import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class TestConnection {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/classicmodels?serverTimezone=UTC";
        String usuario = "";
        String password = "";

        Properties propiedades = new Properties();
        Path rutaConfig = Path.of("config.properties");

        if (!Files.exists(rutaConfig)) {
            throw new Exception("❌ ERROR: El archivo config.properties no se encuentra en la ruta: " + rutaConfig.toAbsolutePath());
        }

        // Usamos try-with-resources para asegurar que el archivo se cierra
        try (BufferedReader lector = Files.newBufferedReader(rutaConfig, StandardCharsets.UTF_8)) {
            // ¡La magia! Carga todo el archivo en el objeto Properties
            propiedades.load(lector);

            // Extraemos los valores como si fuera un HashMap usando getProperty()
            usuario = propiedades.getProperty("usuario");
            password = propiedades.getProperty("password");

        } catch (IOException e) {
            System.out.println("❌ ERROR: No se ha podido leer el archivo config.properties. Detalles técnicos: " + e.getMessage());
            throw e;
        }

        // La conexión se cerrará automáticamente al salir del try
        try (Connection conexion = DriverManager.getConnection(url, usuario, password)) {

            System.out.println("¡Conexión establecida con éxito! (se cerrará automáticamente)");
            // ... usar la conexión ...

        } catch (SQLException e) {
            System.err.println("Error durante la operación con la base de datos:");
            e.printStackTrace();
        } // No se necesita finally para cerrar 'conexion'

    }
}
