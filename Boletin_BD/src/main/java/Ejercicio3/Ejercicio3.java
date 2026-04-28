package Ejercicio3;

import Exceptions.AppException;
import io.MiEntradaSalida;
import io.PropertiesReader;

import java.sql.*;

public class Ejercicio3 {

    static void main(String[] args) {

        PropertiesReader pop;

        try {
            pop = PropertiesReader.getInstance();

            double precioMax = MiEntradaSalida.leerDouble("Precio máximo: ");
            String  letra = MiEntradaSalida.leerLinea("Letra por la que empieza el producto: \n")+'%';

            String sql = "Select LOWER(productName) as nombre, MSRP from products where MSRP < ? and productName like ? order by nombre";

            try(Connection con = DriverManager.getConnection(pop.get("url"),pop.get("usuario"), pop.get("pass"));
                PreparedStatement pr = con.prepareStatement(sql)) {

                pr.setDouble(1,precioMax);
                pr.setString(2,letra);

                ResultSet rs = pr.executeQuery();

                while (rs.next()){
                    String nombre = rs.getString("nombre");
                    double precio = rs.getDouble("MSRP");

                    System.out.printf("El producto %s tiene precio %.2f %n", nombre,precio);
                }

            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
        } catch (AppException e) {
            System.out.println(e.getMessage());
        }
    }
}
