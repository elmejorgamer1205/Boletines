package Examen2022;

// import java.util.HashSet; // (Puedes borrar esta línea, ya que no usamos HashSet en esta clase)

// Usamos la palabra reservada 'extends' para aplicar la HERENCIA.
// Esto significa que un 'Escudo' ES UN 'Cromo', y por tanto hereda automáticamente
// el 'id' y el 'nombre', además de los métodos equals() y hashCode() que definimos en el padre.
public class Escudo extends Cromo {

    // Atributos específicos del Escudo.
    // Los declaramos 'final' para garantizar la inmutabilidad: el año de fundación
    // y el número de jugadores de un equipo histórico no van a cambiar en mitad de la ejecución.
    private final int numeroJugadores;
    private final int annoDeFundacion;

    // Constructor de la clase hija
    public Escudo(int id, String nombre, int annoDeFundacion, int numJugadores) {
        // La llamada a super() DEBE ser siempre la primera línea del constructor.
        // Sirve para enviarle al constructor de la clase padre (Cromo) los datos
        // que él necesita para inicializar el 'id' y el 'nombre'.
        super(id, nombre);

        // Inicializamos los atributos propios de esta clase
        this.annoDeFundacion = annoDeFundacion;
        this.numeroJugadores = numJugadores;
    }

    // Métodos consultores (Getters) para acceder a los atributos privados desde fuera
    public int getAnnoDeFundacion() {
        return annoDeFundacion;
    }

    public int getNumeroJugadores() {
        return numeroJugadores;
    }

    // Sobrescribimos el metodo toString() del padre.
    // Usamos getNombre() (que heredamos de Cromo) para montar un texto descriptivo.
    // Así, si imprimimos este objeto, en lugar de poner solo "Real Madrid",
    // pondrá claramente "Escudo: Real Madrid".
    @Override
    public String toString() {
        return "Escudo: " + getNombre();
    }
}