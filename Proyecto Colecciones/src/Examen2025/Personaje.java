package Examen2025;

import java.util.LinkedList;
import java.util.List;

/**
 * Representa a un personaje dentro del juego.
 * Gestiona sus estadísticas vitales (vida, ki), su raza y la lista de ataques que conoce.
 */
public class Personaje {

    // Atributos inmutables (estadísticas máximas que no deberían cambiar)
    private final int VIDA_MAX;
    private final int KI_MAX;

    // Atributos mutables (el estado actual del personaje durante el combate)
    private String nombre;
    private TRaza raza;
    private int vida;
    private int ki;

    // Lista de ataques que posee el personaje.
    // Se usa la interfaz List para mayor flexibilidad.
    private List<Ataque> ataques;

    /**
     * Constructor del personaje.
     * @param nombre Nombre del personaje (ej. "Goku").
     * @param raza Raza del personaje (ej. TRaza.SAIYAN).
     * @param VIDA_MAX Puntos máximos de salud.
     * @param vida Puntos de salud iniciales.
     * @param KI_MAX Puntos máximos de energía (Ki).
     * @param ki Puntos de energía iniciales.
     */
    public Personaje(String nombre, TRaza raza, int VIDA_MAX, int vida, int KI_MAX, int ki) {
        this.nombre = nombre;
        this.raza = raza;
        this.VIDA_MAX = VIDA_MAX;
        this.vida = vida;
        this.KI_MAX = KI_MAX;
        this.ki = ki;
        // Se inicializa como LinkedList. Es ideal si planeas añadir y eliminar ataques
        // frecuentemente (como haces en el método atacar de la clase Juego).
        ataques = new LinkedList<>();
    }

    /**
     * Añade un nuevo ataque al repertorio del personaje.
     */
    public void addAtaque(Ataque ataque) {
        ataques.add(ataque);
    }

    /**
     * Reduce la vida del personaje en base al daño recibido.
     * Incluye una validación de seguridad para evitar que la vida baje de 0.
     */
    public void recibirDaño(int daño) {
        if (daño > vida) {
            vida = 0; // El personaje muere (la vida no puede ser negativa)
        } else {
            vida -= daño; // Se resta el daño a la vida actual
        }
    }

    /**
     * Reduce el Ki del personaje cuando realiza un ataque o gasta energía.
     * Incluye una validación para evitar que el Ki baje de 0.
     */
    public void restarKi(int modificacionKi) {
        if (ki - modificacionKi <= 0) {
            ki = 0; // Se queda sin energía
        } else {
            ki -= modificacionKi; // Gasta el ki especificado
        }
    }

    /**
     * Busca la variante más poderosa de un ataque específico que el personaje pueda permitirse
     * con su Ki actual. (Por ejemplo, buscar el mejor "Kamehameha" disponible).
     * * @param nombre El nombre del ataque a buscar.
     * @return El objeto Ataque que cumpla las condiciones.
     * @throws DBException Si no encuentra el ataque o no tiene Ki suficiente.
     */
    public Ataque buscarMejorAtaque(String nombre) throws DBException {
        return ataques.stream()
                // 1. Filtra por el nombre exacto del ataque (ignorando mayúsculas/minúsculas)
                .filter(a -> a.getNombre().equalsIgnoreCase(nombre))
                // 2. Comprueba que el personaje tenga suficiente Ki para usarlo
                .filter(a -> a.getKI_NECESARIO() <= this.ki)
                // 3. Obtiene el que hace más daño usando el compareTo de la clase Ataque
                .max(Ataque::compareTo)
                // 4. Si no hay coincidencias, lanza nuestra excepción personalizada
                .orElseThrow(() -> new DBException("Moises friki 3.5"));
    }

    /**
     * Elimina un ataque de la lista del personaje.
     * (En tu lógica de Juego, esto simula que el personaje "gasta" o "olvida" el ataque tras usarlo).
     */
    public void eliminarAtaque(Ataque a) {
        ataques.remove(a);
    }

    // --- GETTERS ---

    public int getVida() {
        return vida;
    }

    public String getNombre() {
        return nombre;
    }

    public int getKi() {
        return ki;
    }

    public TRaza getRaza() {
        return raza;
    }

    public List<Ataque> getAtaques() {
        return ataques;
    }

    /**
     * Devuelve true si el personaje se ha quedado sin vida.
     */
    public boolean isMuerto() {
        return vida == 0;
    }

    /**
     * Devuelve la cantidad de ataques que el personaje conoce actualmente.
     */
    public int getNumeroAtaques() {
        return ataques.size();
    }

    /**
     * Representación en texto del estado actual del personaje.
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Personaje{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", raza=").append(raza);
        sb.append(", vida=").append(vida);
        sb.append(", ki=").append(ki);
        sb.append(", ataques=").append(ataques);
        sb.append('}');
        return sb.toString();
    }
}