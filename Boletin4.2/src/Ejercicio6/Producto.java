package Ejercicio6;

import Exceptions.ProductoException;

public class Producto {
    private String nombre;
    private static int contador = 1;
    private int código;
    private String descripciones;
    private double precioSinIVA;
    public static double precioConIVA = 0.2;

    public Producto(String nombre, String descripcion, double precioSinIVA) throws ProductoException {
        this.código = contador++;
        setNombre(nombre);
        setDescripciones(descripcion);
        setPrecioSinIVA(precioSinIVA);
    }

    public String getDescripciones() {
        return descripciones;
    }

    public void setDescripciones(String descripciones) {
        this.descripciones = descripciones;
    }

    public double getPrecioSinIVA() {
        return precioSinIVA;
    }

    public void setPrecioSinIVA(double precioSinIVA) throws ProductoException{
        if (precioSinIVA < 0){
            throw new ProductoException("Error: El precio no puede ser menor que 0");
        }
        this.precioSinIVA = precioSinIVA;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void cambiarNombre(String nuevoNombre){
        setNombre(nuevoNombre);
    }

    public static double getPrecioConIVA() {
        return precioConIVA;
    }

    public static void setPrecioConIVA(double precioConIVA) {
        Producto.precioConIVA = precioConIVA;
    }

    public void cambiarPrecioSinIva(double nuevoPrecio)throws ProductoException{
        if(nuevoPrecio<0){
            throw new ProductoException("Error: El precio no puede ser menor que 0");
        }
    }

    public double precioConIVA(){
        double total;
        total=(getPrecioSinIVA()* precioConIVA)+getPrecioSinIVA();
        return total;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Producto{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", codigo=").append(código);
        sb.append(", descripcion='").append(descripciones).append('\'');
        sb.append(", precioSinIVA=").append(precioSinIVA);
        sb.append('}');
        return sb.toString();
    }
}
