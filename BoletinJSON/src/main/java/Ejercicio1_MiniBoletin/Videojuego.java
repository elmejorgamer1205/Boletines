package Ejercicio1_MiniBoletin;

public class Videojuego {

    private String titulo;
    private String desarrolladora;
    private int anioLanzamiento;

    public Videojuego(int anioLanzamiento, String desarrolladora, String titulo) {
        this.anioLanzamiento = anioLanzamiento;
        this.desarrolladora = desarrolladora;
        this.titulo = titulo;
    }

    public int getAnioLanzamiento() {
        return anioLanzamiento;
    }

    public void setAnioLanzamiento(int anioLanzamiento) {
        this.anioLanzamiento = anioLanzamiento;
    }

    public String getDesarrolladora() {
        return desarrolladora;
    }

    public void setDesarrolladora(String desarrolladora) {
        this.desarrolladora = desarrolladora;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Videojuego{" +
                "anioLanzamiento=" + anioLanzamiento +
                ", titulo='" + titulo + '\'' +
                ", desarrolladora='" + desarrolladora + '\'' +
                '}';
    }
}
