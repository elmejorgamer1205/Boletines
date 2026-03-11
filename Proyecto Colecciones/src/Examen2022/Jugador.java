package Examen2022;

// import java.util.HashSet; // Borramos esta línea porque no hace falta

// Al igual que Escudo, Jugador hereda de Cromo usando 'extends'.
// Esto significa que un Jugador adquiere automáticamente el 'id', el 'nombre'
// y la forma de compararse (equals/hashCode) que definimos en la clase padre.
public class Jugador extends Cromo {

    // Atributos específicos del Jugador.
    // Los hacemos 'final' para mantener la coherencia con el resto del proyecto:
    // los datos del cromo vienen impresos de fábrica y no se modifican.
    private final String equipo;
    private final int altura;

    // Constructor de la clase hija
    public Jugador(int id, String nombre, String equipo, int altura) {
        // super() llama al constructor de la clase Cromo.
        // Es obligatorio que sea la primera línea porque antes de poder crear
        // la "parte de Jugador", Java necesita construir la "parte genérica de Cromo".
        super(id, nombre);

        // Asignamos los atributos propios de esta clase
        this.equipo = equipo;
        this.altura = altura;
    }

    // Métodos consultores (Getters) para que otras clases (como el Mazo)
    // puedan leer en qué equipo juega o cuánto mide para calcular medias.
    public String getEquipo() {
        return equipo;
    }

    public int getAltura() {
        return altura;
    }

    // Sobrescribimos el metodo toString() para darle un formato bonito por consola.
    // Usamos getNombre() (heredado de Cromo) y concatenamos su equipo entre paréntesis.
    // Ejemplo de salida: "Jugador: Modric (Real Madrid)"
    @Override
    public String toString() {
        return "Jugador: " + getNombre() + " (" + equipo + ")";
    }
}