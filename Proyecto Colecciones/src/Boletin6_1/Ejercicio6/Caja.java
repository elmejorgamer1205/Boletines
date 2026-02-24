package Boletin6_1.Ejercicio6;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Clase que representa una caja individual dentro del almacén.
 * Se encarga de gestionar su estado (abierta/cerrada) y la cola de clientes.
 */
public class Caja {
    private int numero;          // Identificador de la caja (1, 2, 3...)
    private boolean abierta;     // Estado de la caja: true si está abierta, false si está cerrada
    private Queue<Integer> clientes; // Cola de clientes (FIFO: el primero en entrar es el primero en salir)

    /**
     * Constructor: Inicializa una caja con su número correspondiente.
     * Por defecto, todas las cajas nacen cerradas y con una cola vacía.
     */
    public Caja(int numero) {
        this.numero = numero;
        this.abierta = false;
        this.clientes = new LinkedList<>(); // LinkedList es la implementación estándar para una Queue en Java
    }

    // --- MÉTODOS GETTER (Para consultar el estado de la caja) ---

    public int getNumero() {
        return numero;
    }

    public boolean isAbierta() {
        return abierta;
    }

    public int getCantidadClientes() {
        return clientes.size(); // Devuelve cuánta gente hay esperando en esta caja
    }

    // --- MÉTODOS DE ACCIÓN (Modifican el estado de la caja) ---

    /**
     * Abre la caja y se asegura de que la cola de clientes esté vacía.
     */
    public void abrir() {
        this.abierta = true;
        this.clientes.clear();
    }

    /**
     * Cierra la caja. La validación de si tiene clientes se hace desde fuera (en Main).
     */
    public void cerrar() {
        this.abierta = false;
    }

    /**
     * Añade un nuevo cliente al final de la cola.
     * @param idCliente El número de ticket del cliente.
     */
    public void agregarCliente(int idCliente) {
        this.clientes.offer(idCliente); // offer() inserta el elemento al final de la cola
    }

    /**
     * Atiende al cliente que lleva más tiempo esperando (el primero de la cola).
     * @return El número del cliente atendido, o null si la cola estaba vacía.
     */
    public Integer atenderCliente() {
        // poll() saca y devuelve al primer cliente de la cola. Si está vacía, devuelve null.
        return this.clientes.poll();
    }
}


