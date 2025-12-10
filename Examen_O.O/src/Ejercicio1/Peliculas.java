package Ejercicio1;

import Exceptions.BibliotecaException;

public class Peliculas {

    private String titulo;
    private int añoDeEstreno;
    private String direcctor;
    private double presupuesto;
    private double recaudacion;
    private String sinopsis;
    private String etiquetas;
    private double valoracion;

    public Peliculas() throws BibliotecaException {
        setTitulo(titulo);
        setAñoDeEstreno(añoDeEstreno);
        setDirecctor(direcctor);
        setPresupuesto(presupuesto);
        setRecaudacion(recaudacion);
        setSinopsis(sinopsis);
        setEtiquetas(etiquetas);
        setValoracion(valoracion);
    }

    public void setAñoDeEstreno(int añoDeEstreno) {
        this.añoDeEstreno = añoDeEstreno;
    }

    public void setDirecctor(String direcctor) {
        this.direcctor = direcctor;
    }

    public void setEtiquetas(String etiquetas) {
        this.etiquetas = etiquetas;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setValoracion(double valoracion) {
        this.valoracion = valoracion;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public String getEtiquetas() {
        return etiquetas;
    }

    public String getTitulo() {
        return titulo;
    }

    private void setRecaudacion(double recaudacion) throws BibliotecaException {
        if (recaudacion<0){
            throw new BibliotecaException("La recaudacion no puede ser negativo");
        }
        this.recaudacion = recaudacion;
    }

    public double calcularValoracion() {
        double valoracion = (recaudacion*5)/presupuesto;

        if (valoracion>10.0){
            return 10.0;
        }
        return valoracion;
    }
}
