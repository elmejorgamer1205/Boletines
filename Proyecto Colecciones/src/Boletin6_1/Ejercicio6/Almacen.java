package Boletin6_1.Ejercicio6;

public class Almacen {
    private Caja[] cajas;
    private int siguienteCliente;

    public Almacen() {
        this.cajas = new Caja[20];
        // Inicializamos las 20 cajas con sus respectivos números (1 al 20)
        for (int i = 0; i < 20; i++) {
            cajas[i] = new Caja(i + 1);
        }
        this.siguienteCliente = 1;
    }

    // Metodo para obtener una caja específica (restando 1 para el índice del array)
    public Caja getCaja(int numeroCaja) {
        return cajas[numeroCaja - 1];
    }

    // Busca la caja abierta que tenga menos clientes
    public Caja obtenerMejorCaja() {
        Caja mejorCaja = null;
        int minClientes = Integer.MAX_VALUE;

        for (Caja caja : cajas) {
            if (caja.isAbierta()) {
                if (caja.getCantidadClientes() < minClientes) {
                    minClientes = caja.getCantidadClientes();
                    mejorCaja = caja;
                }
            }
        }
        return mejorCaja; // Retornará null si no hay ninguna caja abierta
    }

    // Genera el número de cliente y lo incrementa para el próximo
    public int generarNuevoCliente() {
        return siguienteCliente++;
    }
}
