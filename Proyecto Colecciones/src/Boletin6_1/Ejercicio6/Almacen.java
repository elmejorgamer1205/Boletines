package Boletin6_1.Ejercicio6;

/**
 * Clase que gestiona el conjunto de cajas del almacén y el generador de tickets para clientes.
 */
public class Almacen {
    private Caja[] cajas;          // Arreglo (array) que contendrá las 20 cajas
    private int siguienteCliente;  // Contador global para asignar el número a los clientes

    /**
     * Constructor: Crea el almacén, inicializa el array de 20 posiciones
     * y crea una instancia de la clase Caja para cada posición.
     */
    public Almacen() {
        this.cajas = new Caja[20];

        // Recorremos el array creando las 20 cajas (numeradas del 1 al 20)
        for (int i = 0; i < 20; i++) {
            cajas[i] = new Caja(i + 1);
        }
        this.siguienteCliente = 1; // El primer cliente será el número 1
    }

    /**
     * Recupera el objeto Caja correspondiente al número indicado.
     * @param numeroCaja El número de la caja que queremos (1 al 20).
     * @return El objeto Caja.
     */
    public Caja getCaja(int numeroCaja) {
        // Restamos 1 porque el usuario pide la caja 1, pero en el array está en la posición 0
        return cajas[numeroCaja - 1];
    }

    /**
     * Algoritmo principal: Busca entre todas las cajas abiertas cuál es la que
     * tiene menos clientes esperando. En caso de empate, al recorrer el array de
     * izquierda a derecha, se queda con la de menor numeración.
     * * @return La Caja con menos clientes, o null si todas están cerradas.
     */
    public Caja obtenerMejorCaja() {
        Caja mejorCaja = null;
        // Inicializamos con el valor máximo posible para asegurar que la primera caja abierta lo supere
        int minClientes = Integer.MAX_VALUE;

        // Recorremos todas las cajas del almacén
        for (Caja caja : cajas) {
            if (caja.isAbierta()) { // Solo nos interesan las cajas abiertas
                if (caja.getCantidadClientes() < minClientes) {
                    // Si encontramos una caja con menos clientes, actualizamos el mínimo y guardamos la caja
                    minClientes = caja.getCantidadClientes();
                    mejorCaja = caja;
                }
            }
        }
        return mejorCaja;
    }

    /**
     * Genera un nuevo número de cliente y prepara el contador para el siguiente.
     * @return El número asignado al cliente actual.
     */
    public int generarNuevoCliente() {
        return siguienteCliente++; // Devuelve el valor actual y luego le suma 1 (post-incremento)
    }
}
