package Ejercicio2;

import Exceptions.AppException;
import io.MiEntradaSalida;
import io.PropertiesReader;

import java.sql.*;


public class Ejercicio2 {

    static void main(String[] args) {

        PropertiesReader pop;

        try {
            pop = PropertiesReader.getInstance();

            double precioLim = MiEntradaSalida.leerDouble("Introduce el precio máximo: ");
            String sqlPrepared = "Select * from products where buyPrice < ? order by buyPrice";

            try (Connection con = DriverManager.getConnection(pop.get("url"),pop.get("usuario"),pop.get("password"));
                 Statement statement = con.createStatement(); PreparedStatement pr = con.prepareStatement(sqlPrepared)) {

                String sql = "Select * from products where buyPrice < 400 order by buyPrice";

                ResultSet rs = statement.executeQuery(sql);

                System.out.println("Resultados con Statement (Precio máximo 400):" );
                System.out.println();
                while (rs.next()){
                    String nombre = rs.getString("productName");
                    double precio = rs.getDouble("buyPrice");

                    System.out.printf("El producto %s tiene precio %.2f %n", nombre,precio);
                }

                System.out.println();
                System.out.println("=================================================");
                System.out.println();

                System.out.println("Resultados con PreparedStatement (Precio pedido al usuario)");
                System.out.println();

                pr.setDouble(1,precioLim);

                ResultSet rs2 = pr.executeQuery();

                while (rs2.next()){
                    String nombre = rs2.getString("productName");
                    double precio = rs2.getDouble("buyPrice");

                    System.out.printf("El producto %s tiene precio %.2f" + System.lineSeparator(), nombre,precio);
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } catch (AppException e) {
            System.out.println(e.getMessage());
        }
    }
}
