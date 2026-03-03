package Boletin6_1.Agencia_De_Viajes;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Cliente {
    private String nombre;
    private String id;
    private Map<String, Ruta> rutas; // Nombre de ruta -> Objeto Ruta

    public Cliente(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
        this.rutas = new HashMap<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void annadirRuta(Ruta nuevaRuta){
        if(rutas.containsKey(nuevaRuta.getNombre())){
            throw new IllegalArgumentException("El cliente ya tiene ruta con el nombre: " + nuevaRuta.getNombre());
        }
        rutas.put(nuevaRuta.getNombre(), nuevaRuta);
    }

    public void eliminarRuta(String nombreRuta){
        if(!rutas.containsKey(nombreRuta)){
            throw new IllegalArgumentException("No existe una ruta con ese nombre");
        }
        rutas.remove(nombreRuta);
    }

    public void annadirParadaRuta(String nombreRuta, String nuevaParada){
        if (!rutas.containsKey(nombreRuta)){
            throw new IllegalArgumentException("El cliente no tiene ruta con ese nombre.");
        }

        Ruta rutaEncontrada = rutas.get(nombreRuta);

        rutaEncontrada.annadirParada(nuevaParada);
    }

    public boolean obtenerInfoRutas() {
        // Si el cliente no tiene rutas, devolvemos un aviso
        if (rutas.isEmpty()) {
            return "El cliente no tiene rutas asignadas.";
        }

        StringBuilder info = new StringBuilder();
        // Recorremos todas las rutas guardadas en el mapa
        for (Ruta rutaActual : rutas.values()) {
            // Aprovechamos tu metodo toString() de la clase Ruta y añadimos un salto de línea (\n)
            info.append(rutaActual.toString()).append("\n");
        }

        return info.toString();
    }

    public boolean tieneParada(String paradaBuscada) {
        for (Ruta rutaActual : rutas.values()) {
            // getParadas() nos da el TreeSet, y contains() comprueba si está dentro
            if (rutaActual.getParadas().contains(paradaBuscada)) {
                return true; // Encontrada, no hace falta seguir buscando
            }
        }
        return false; // Terminó de mirar todas las rutas y no la encontró
    }

    public TreeSet<String> obtenerTodasLasParadas() {
    }
}
