package Boletin6_1.Ejercicio6;

import java.util.LinkedList;
import java.util.Queue;

public class Caja {
    private int numero;
    private boolean abierta;
    private Queue<Integer> clientes;

    public Caja(int numero) {
        this.numero = numero;
        this.abierta = false;
        this.clientes = new LinkedList<>();
    }

    public int getNumero() {
        return numero;
    }

    public boolean isAbierta() {
        return abierta;
    }

    public int getCantidadClientes() {
        return clientes.size();
    }

    public void abrir() {
        this.abierta = true;
        this.clientes.clear(); // Por seguridad, nos aseguramos de que la cola esté vacía
    }

    public void cerrar() {
        this.abierta = false;
    }

    public void agregarCliente(int idCliente) {
        this.clientes.offer(idCliente);
    }

    public Integer atenderCliente() {
        // poll() devuelve y elimina al primer cliente, o devuelve null si está vacía
        return this.clientes.poll();
    }
}
