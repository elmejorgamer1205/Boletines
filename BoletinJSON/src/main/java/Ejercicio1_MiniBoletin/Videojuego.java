package Ejercicio1_MiniBoletin; // Nota de estilo: en Java, los paquetes suelen ir completamente en minúsculas (ejercicio1_miniboletin).

public class Videojuego {

    // 1. Atributos privados (Encapsulación).
    // Nadie desde fuera puede modificarlos directamente, tienen que pasar por los 'setters'.
    private String titulo;
    private String desarrolladora;
    private int anioLanzamiento;

    // 2. Constructor.
    // Obliga a que cuando alguien cree un 'Videojuego', tenga que darle estos 3 datos sí o sí.
    public Videojuego(int anioLanzamiento, String desarrolladora, String titulo) {
        this.anioLanzamiento = anioLanzamiento;
        this.desarrolladora = desarrolladora;
        this.titulo = titulo;
    }

    // 3. Getters y Setters.
    // La puerta de entrada y salida oficial para leer o cambiar los datos.
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

    // 4. Método toString().
    // Sin esto, si intentas imprimir un Videojuego (ej: System.out.println(miJuego)),
    // Java imprimiría un código raro de memoria (ej: Videojuego@7a81197d).
    // Al sobrescribirlo (@Override), le dices a Java exactamente cómo quieres que se lea.
    @Override
    public String toString() {
        return "Videojuego{" +
                "anioLanzamiento=" + anioLanzamiento +
                ", titulo='" + titulo + '\'' +
                ", desarrolladora='" + desarrolladora + '\'' +
                '}';
    }
}