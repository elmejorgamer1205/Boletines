package Ejercicio1;

import io.PropertiesReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://127.0.0.1:3306/classicmodels?serverTimezone=UTC";
        String usuario, password;

        PropertiesReader p = PropertiesReader.getInstance();

        // La conexión se cerrará automáticamente al salir del try
        try (Connection conexion = DriverManager.getConnection(url, p.get("usuario"), p.get("password"))) {

            System.out.println("¡Conexión establecida con éxito! (se cerrará automáticamente)");
            // ... usar la conexión ...

        } catch (SQLException e) {
            System.err.println("Error durante la operación con la base de datos:");
            e.printStackTrace();
        } // No se necesita finally para cerrar 'conexion'

    }
}