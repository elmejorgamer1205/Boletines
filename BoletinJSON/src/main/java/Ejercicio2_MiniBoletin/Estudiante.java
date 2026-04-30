package Ejercicio2_MiniBoletin;

public class Estudiante {

    // Atributos encapsulados.
    // Gson leerá exactamente estos nombres ('nombre', 'curso', 'notaMedia')
    // para crear las claves (keys) dentro de tu archivo JSON.
    private String nombre;
    private String curso;
    private double notaMedia;

    // Constructor completo para inicializar los objetos fácilmente
    public Estudiante(String curso, String nombre, double notaMedia) {
        this.curso = curso;
        this.nombre = nombre;
        this.notaMedia = notaMedia;
    }

    // Getters y Setters: La vía oficial de acceso a los datos
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

    // Sobrescritura del método toString() para poder imprimir los objetos por consola
    // de forma legible, tal y como hiciste en tu Main con el .forEach(System.out::println)
    @Override
    public String toString() {
        return "Estudiante{" +
                "curso='" + curso + '\'' +
                ", nombre='" + nombre + '\'' +
                ", notaMedia=" + notaMedia +
                '}';
    }
}