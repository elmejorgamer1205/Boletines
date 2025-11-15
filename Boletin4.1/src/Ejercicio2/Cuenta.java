package Ejercicio2;

public class Cuenta {

    private int saldoInicial;
    private int saldoActual;
    private int retirarSaldo;

    public Cuenta() {
        saldoInicial = 1500;
        saldoActual = saldoInicial;
        retirarSaldo = 0;
    }

    public int getSaldoInicial() {
        return saldoInicial;
    }

    public int getSaldoActual() {
        return saldoActual;
    }

    public void ingresarDinero(int cantidad) {
        if (cantidad > 0 && cantidad < 2500) {
            saldoActual += cantidad;
        }
    }

    public void retirarDinero(int cantidad) {
        if (cantidad > 0 && cantidad < 2500 && cantidad <= saldoActual) {
            saldoActual -= cantidad;
            retirarSaldo += cantidad;
        }
    }

    public int getRetirarSaldo() {
        return retirarSaldo;
    }
}


