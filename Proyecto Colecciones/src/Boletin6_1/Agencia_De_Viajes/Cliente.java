package Boletin6_1.Agencia_De_Viajes;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Cliente {

    // --- ATRIBUTOS ---
    private String nombre;
    private String id;

    // Se utiliza un Map (Diccionario) donde la CLAVE es el nombre de la ruta (String)
    // y el VALOR es el objeto Ruta completo. Esto permite buscar rutas rápidamente por su nombre.
    private Map<String, Ruta> rutas;

    // --- CONSTRUCTOR ---
    /**
     * Crea un nuevo cliente con nombre e ID, e inicializa su catálogo de rutas.
     */
    public Cliente(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
        // Excelente: Inicialización del HashMap para evitar NullPointerException.
        this.rutas = new HashMap<>();
    }

    // --- GETTERS ---
    public String getNombre() {
        return nombre;
    }

    // --- MÉTODOS DE COMPORTAMIENTO ---

    /**
     * Añade una nueva ruta al catálogo del cliente.
     * @param nuevaRuta El objeto Ruta que se desea añadir.
     */
    public void annadirRuta(Ruta nuevaRuta){
        // Verificamos si la clave (el nombre de la ruta) ya existe en el mapa
        if(rutas.containsKey(nuevaRuta.getNombre())){
            // Lanzar una excepción es la forma correcta de detener la ejecución y avisar del error
            throw new IllegalArgumentException("El cliente ya tiene ruta con el nombre: " + nuevaRuta.getNombre());
        }
        // Si no existe, la añadimos al mapa
        rutas.put(nuevaRuta.getNombre(), nuevaRuta);
    }

    /**
     * Elimina una ruta completa del catálogo del cliente buscándola por su nombre.
     * @param nombreRuta El nombre de la ruta a eliminar.
     */
    public void eliminarRuta(String nombreRuta){
        // Si el mapa NO contiene la clave, lanzamos error
        if(!rutas.containsKey(nombreRuta)){
            throw new IllegalArgumentException("No existe una ruta con ese nombre");
        }
        // Eliminamos la entrada correspondiente del mapa
        rutas.remove(nombreRuta);
    }

    /**
     * Añade una parada a una ruta específica del cliente.
     * @param nombreRuta El nombre de la ruta a la que añadir la parada.
     * @param nuevaParada El nombre de la ciudad/lugar de la parada.
     */
    public void annadirParadaRuta(String nombreRuta, String nuevaParada){
        if (!rutas.containsKey(nombreRuta)){
            throw new IllegalArgumentException("El cliente no tiene ruta con ese nombre.");
        }

        // Rescatamos el objeto Ruta del mapa usando su nombre como llave
        Ruta rutaEncontrada = rutas.get(nombreRuta);

        // Delegamos la acción de añadir al método de la propia clase Ruta
        rutaEncontrada.annadirParada(nuevaParada);
    }

    /**
     * Devuelve un texto con la información de todas las rutas del cliente.
     */
    public String obtenerInfoRutas() {
        // Si el mapa está vacío, devolvemos un aviso temprano
        if (rutas.isEmpty()) {
            return "El cliente no tiene rutas asignadas.";
        }

        // El uso de StringBuilder es excelente aquí. Es mucho más eficiente en memoria
        // y rápido que concatenar Strings en un bucle (info += ...).
        StringBuilder info = new StringBuilder();

        // Recorremos solo los VALORES del mapa (los objetos Ruta)
        for (Ruta rutaActual : rutas.values()) {
            // Aprovechamos tu método toString() de la clase Ruta y añadimos un salto de línea (\n)
            info.append(rutaActual.toString()).append("\n");
        }

        return info.toString();
    }

    /**
     * Comprueba si el cliente visita una parada en concreto en CUALQUIERA de sus rutas.
     * @param paradaBuscada Nombre de la parada a buscar.
     * @return true si la encuentra, false si no.
     */
    public boolean tieneParada(String paradaBuscada) {
        for (Ruta rutaActual : rutas.values()) {
            // getParadas() nos da el TreeSet, y contains() comprueba si está dentro.
            // La búsqueda dentro de un Set es muy rápida.
            if (rutaActual.getParadas().contains(paradaBuscada)) {
                return true; // Encontrada, interrumpimos el bucle y devolvemos true
            }
        }
        return false; // Terminó de mirar todas las rutas y no la encontró
    }

    /**
     * Recopila absolutamente todas las paradas de todas las rutas del cliente,
     * sin duplicados y ordenadas alfabéticamente.
     */
    public TreeSet<String> obtenerTodasLasParadas() {
        // Creamos nuestro Set principal que se ordenará automáticamente
        TreeSet<String> todasLasParadas = new TreeSet<>();

        // Recorremos todas las rutas del cliente
        for (Ruta rutaActual : rutas.values()) {
            // addAll() es súper eficiente: vuelca de golpe todos los elementos
            // del Set de la ruta al Set general. Como es un Set, si hay repetidas las ignorará solas.
            todasLasParadas.addAll(rutaActual.getParadas());
        }

        return todasLasParadas;
    }
}
