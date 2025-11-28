package Ejercicio6;

import Exceptions.ProductoException;
import utils.MiEntradaSalida;

public class Main {
    public static void main(String[] args) {
        System.out.println("Producto 1 \n");
        Producto p1 = crearProducto();
        System.out.println("\nProducto 2 \n");
        Producto p2 = crearProducto();
        System.out.println();
        System.out.println(p1.toString()+"\n");
        System.out.println(p2.toString()+"\n");
        System.out.println("El precio con iva es "+ p1.precioConIVA());
        System.out.println("El precio con iva es "+ p2.precioConIVA());

    }

    public static Producto crearProducto(){
        boolean productoCreado=false;
        String nombre;
        String descripcion;
        double precioSinIVA;
        Producto producto=null;
        while (!productoCreado){
            nombre = MiEntradaSalida.leerLinea("Nombre del producto: \n");
            descripcion = MiEntradaSalida.leerLinea("Descripcion del producto: \n");
            precioSinIVA = MiEntradaSalida.solicitarDouble("Precio del producto (sin IVA): ");
            try {
                producto = new Producto(nombre,descripcion,precioSinIVA);
                productoCreado=true;
            } catch (ProductoException e) {
                System.out.println(e.getMessage());
            }
        }
        return producto;
    }
}
