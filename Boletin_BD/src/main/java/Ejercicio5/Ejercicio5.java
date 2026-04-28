package Ejercicio5;

import Exceptions.AppException;
import io.MiEntradaSalida;
import io.PropertiesReader;

import java.sql.*;

public class Ejercicio5 {



    static void main(String[] args) {

        PropertiesReader pop;

        try{
            pop = PropertiesReader.getInstance();

            try (Connection con = DriverManager.getConnection(pop.get("url"),pop.get("usuario"), pop.get("pass"));
                 PreparedStatement pr = con.prepareStatement("SELECT productName,productVendor as proveedor from products where productName = ?")){

                String nombre = MiEntradaSalida.leerLinea("Nombre del producto: \n");

                pr.setString(1,nombre);

                ResultSet rs = pr.executeQuery();

                while (rs.next()){
                    String nombreProducto = rs.getString("productName");
                    String proveedor = rs.getString("proveedor");

                    System.out.printf("El proveedor del producto %s es %s",nombreProducto,proveedor);

                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }catch (AppException e){
            System.out.println(e.getMessage());
        }
    }

}
