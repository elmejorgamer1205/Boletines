package Ejercicio1;

import Exceptions.BibliotecaException;

import java.util.Arrays;

public class BibliotecaDePeliculas {

    public final static int TAMAÑO = 20;
    private Peliculas[] peliculas = new Peliculas[TAMAÑO];

    public BibliotecaDePeliculas() {
    }

    public void añadirPelicula(Peliculas pelicula) throws BibliotecaException {
        for (int i = 0; i < peliculas.length; i++) {
            if (peliculas[i] == null) {
                peliculas[i] = pelicula;
                return;
            }
        }
    }

    public String buscarPeliculaEtiqueta(String etiqueta) throws BibliotecaException {
        StringBuilder devolver = new StringBuilder();
        for (int i = 0; i < peliculas.length; i++) {
            if (peliculas[i] != null) {
                String[] etiquetas = peliculas[i].getEtiquetas().split(",");
                for (int j = 0; j < etiquetas.length; j++) {
                    if (etiquetas[j].equalsIgnoreCase(etiqueta)) {
                        devolver.append(peliculas[i].getTitulo());
                    }
                }
            } else if (peliculas[i] == null) {
                break;
            }
        }
        if (devolver.toString().isEmpty()) {
            throw new BibliotecaException("No hay ninguna película con esa etiqueta");
        }
        return devolver.toString();
    }

    public String buscarPeliculaTitulo(String titulo) throws BibliotecaException {
        for (int i = 0; i < peliculas.length; i++) {
            if (peliculas[i] != null) {
                if (titulo.equalsIgnoreCase(peliculas[i].getTitulo())) {
                    return peliculas[i].toString();
                }
            } else if (peliculas[i] == null) {
                break;
            }
        }
        throw new BibliotecaException("Esa película no esta en la biblioteca");
    }

    public String buscarPeliculaPresupuestoMax(double presupuestoMaximo) throws BibliotecaException {
        StringBuilder devolver = new StringBuilder();
        for (int i = 0; i < peliculas.length; i++) {
            if (peliculas[i] != null) {
                if (peliculas[i].getPresupuesto() <= presupuestoMaximo) {
                    devolver.append(peliculas[i].getTitulo());
                }
            }
            else if (peliculas[i] == null) {
                break;
            }
        }
        if (devolver.toString().isEmpty()) {
            throw new BibliotecaException("No hay ninguna pelicula con ese presupuesto máximo");
        }
        return devolver.toString();
    }

    public String mostrarBiblioteca(){
        StringBuilder devolver = new StringBuilder();
        for (Peliculas pelicula : peliculas) {
            if (pelicula != null) {
                devolver.append(pelicula.toString());
            }
            if (pelicula == null) {
                break;
            }
        }
        return devolver.toString();
    }
    @Override
    public String toString() {
        return "Biblioteca{" +
                "peliculas=" + Arrays.toString(peliculas) +
                '}';
    }
}
