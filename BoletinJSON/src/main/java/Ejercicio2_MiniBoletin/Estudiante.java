package Ejercicio2_MiniBoletin;

public class Estudiante {

    private String nombre;
    private String curso;
    private double notaMedia;

    public Estudiante(String curso, String nombre, double notaMedia) {
        this.curso = curso;
        this.nombre = nombre;
        this.notaMedia = notaMedia;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getNotaMedia() {
        return notaMedia;
    }

    public void setNotaMedia(double notaMedia) {
        this.notaMedia = notaMedia;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "curso='" + curso + '\'' +
                ", nombre='" + nombre + '\'' +
                ", notaMedia=" + notaMedia +
                '}';
    }
}
