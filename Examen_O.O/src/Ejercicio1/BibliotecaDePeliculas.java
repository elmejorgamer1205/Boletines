package Ejercicio1;

import Exceptions.BibliotecaException;

import java.util.Scanner;

public class BibliotecaDePeliculas {

    private String[] peliculas = new String[20];
    private String[] etiquetas = new String[20];
    private String[] titulo = new String[20];
    private double[] presupuestoMax = new double[20];

    public BibliotecaDePeliculas(){
        setPeliculas(peliculas);
        setEtiquetas(etiquetas);
        setTitulo(titulo);
        setPresupuestoMax(presupuestoMax);
    }

    public void setPeliculas(String[] peliculas) {
        this.peliculas = peliculas;
    }

    public void setEtiquetas(String[] etiquetas) {
        this.etiquetas = etiquetas;
    }

    public void setTitulo(String[] titulo) {
        this.titulo = titulo;
    }

    public void setPresupuestoMax(double[] presupuestoMax) {
        this.presupuestoMax = presupuestoMax;
    }

    public void consultarBiblioteca(){
        System.out.println(toString());
    }

    public void añadirPelicula()throws BibliotecaException {
        for (int i = 0; i < peliculas.length; i++) {
        }
    }

    public void buscarPeliculaEtiqueta()throws BibliotecaException{
        for (int i = 0; i < etiquetas.length; i++) {

        }
    }

    public void buscarPeliculaTitulo()throws BibliotecaException{
        for (int i = 0; i < titulo.length; i++) {

        }
    }

    public void buscarPeliculaPresupuestoMax()throws BibliotecaException{
        for (int i = 0; i < presupuestoMax.length; i++) {

        }
    }

    public void calcularValoracion()throws BibliotecaException{

    }

}
