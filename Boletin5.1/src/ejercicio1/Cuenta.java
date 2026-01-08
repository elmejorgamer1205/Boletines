package ejercicio1;

import Exceptions.CuentaExceptions;

public class Cuenta {
    private double saldo;
    private int numeroIngresos;
    private int numeroReintegros;

    public Cuenta(double saldoInicial) throws CuentaExceptions{
        setSaldo(saldoInicial);
        setNumeroIngresos();
        setNumeroReintegros();
    }

    public double getSaldo() {
        return saldo;
    }

    private void setSaldo(double saldoInicial) throws CuentaExceptions {
        if (saldoInicial < 0){
            throw new CuentaExceptions("Error: El saldo inicial no puede ser negativo");
        }
        this.saldo=saldoInicial;
    }

    public int getNumeroIngresos() {
        return numeroIngresos;
    }

    private void setNumeroIngresos() {
        this.numeroIngresos = 0;
    }

    public int getNumeroReintegros() {
        return numeroReintegros;
    }

    private void setNumeroReintegros() {
        this.numeroReintegros = 0;
    }

    @Override
    public String toString() {
        return "ejercicio1.Cuenta{" +
                "saldo=" + saldo +
                ", numeroIngresos=" + numeroIngresos +
                ", numeroReintegros=" + numeroReintegros +
                '}';
    }

    public void reintegro(double dineroASacar) throws CuentaExceptions {
        if (dineroASacar < 0) {
            throw new CuentaExceptions("El saldo no puede ser negativo");
        }
        if (dineroASacar > this.saldo) {
            throw new CuentaExceptions("No tienes suficiente saldo");
        }
        saldo -= dineroASacar;
        numeroReintegros++;
    }

    public void ingreso(double dineroAIngresar) throws CuentaExceptions {
        if (dineroAIngresar < 0) {
            throw new CuentaExceptions("El saldo no puede ser negativo");
        }
        saldo += dineroAIngresar;
        numeroIngresos++;
    }



    public void consulta() {
        System.out.println(toString());
    }


}
