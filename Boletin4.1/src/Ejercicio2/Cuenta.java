package Ejercicio2;

import Exceptions.CuentaExceptions;

public class Cuenta {

    public int saldoInicial;
    public int saldoActual;
    public int retirarSaldo;
    public  int contadorReintegros;
    public int contadorIngresos;

    public Cuenta() {
        saldoInicial = 1500;
        saldoActual = saldoInicial;
        retirarSaldo = 0;
        contadorReintegros = 0;
        contadorIngresos =0;
    }

    public int getSaldoInicial() {

        return saldoInicial;
    }

    public int getSaldoActual() {

        return saldoActual;
    }

    public int getRetirarSaldo() {

        return retirarSaldo;
    }

    public int getContadorIngresos() {
        return contadorIngresos;
    }

    public void setContadorIngresos(int contadorIngresos) {

        this.contadorIngresos = contadorIngresos;
    }

    public int getContadorReintegros() {
        return contadorReintegros;
    }

    public void setContadorReintegros(int contadorReintegros) {

        this.contadorReintegros = contadorReintegros;
    }

    public void ingresarDinero(int cantidad) throws CuentaExceptions {
        if (cantidad < 0 || cantidad > 2500) {
            throw new CuentaExceptions("Error, no puede ingresar dinero negativo o mayor a 2500€");
        }
        saldoActual += cantidad;
        contadorIngresos++;
    }

    public void retirarDinero(int cantidad) throws CuentaExceptions{
        if (cantidad > 0 || cantidad < 2500 || cantidad <= saldoActual) {
            throw new CuentaExceptions("Error, no puedes retirar dinero porque no tienes suficiente saldo");
        }
        saldoActual -= cantidad;
        retirarSaldo += cantidad;
        contadorReintegros++;
    }
}


