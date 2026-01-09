package ejercicio1;

import Exceptions.CuentaExceptions;

public class Cuenta {

    /** Saldo actual de la cuenta */
    private double saldo;

    /** Número total de ingresos realizados */
    private int numeroIngresos;

    /** Número total de reintegros realizados */
    private int numeroReintegros;

    /**
     * Constructor de la cuenta.
     *
     * @param saldoInicial saldo con el que se crea la cuenta
     * @throws CuentaExceptions si el saldo inicial es negativo
     */
    public Cuenta(double saldoInicial) throws CuentaExceptions{
        setSaldo(saldoInicial);
        setNumeroIngresos();
        setNumeroReintegros();
    }

    /**
     * Devuelve el saldo actual de la cuenta.
     *
     * @return saldo de la cuenta
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Establece el saldo inicial de la cuenta.
     * Solo se permite un saldo mayor o igual a cero.
     *
     * @param saldoInicial saldo a asignar
     * @throws CuentaExceptions si el saldo es negativo
     */
    private void setSaldo(double saldoInicial) throws CuentaExceptions {
        if (saldoInicial < 0){
            throw new CuentaExceptions("Error: El saldo inicial no puede ser negativo");
        }
        this.saldo = saldoInicial;
    }

    /**
     * Devuelve el número de ingresos realizados.
     *
     * @return número de ingresos
     */
    public int getNumeroIngresos() {
        return numeroIngresos;
    }

    /**
     * Inicializa el contador de ingresos a cero.
     */
    private void setNumeroIngresos() {
        this.numeroIngresos = 0;
    }

    /**
     * Devuelve el número de reintegros realizados.
     *
     * @return número de reintegros
     */
    public int getNumeroReintegros() {
        return numeroReintegros;
    }

    /**
     * Inicializa el contador de reintegros a cero.
     */
    private void setNumeroReintegros() {
        this.numeroReintegros = 0;
    }

    /**
     * Devuelve una representación en texto del estado de la cuenta.
     *
     * @return información de la cuenta en formato String
     */
    @Override
    public String toString() {
        return "ejercicio1.Cuenta{" +
                "saldo=" + saldo +
                ", numeroIngresos=" + numeroIngresos +
                ", numeroReintegros=" + numeroReintegros +
                '}';
    }

    /**
     * Realiza un reintegro de dinero de la cuenta.
     *
     * @param dineroASacar cantidad a retirar
     * @throws CuentaExceptions si la cantidad es negativa
     *                          o si no hay saldo suficiente
     */
    public void reintegro(double dineroASacar) throws CuentaExceptions {

        // No se permiten cantidades negativas
        if (dineroASacar < 0) {
            throw new CuentaExceptions("El saldo no puede ser negativo");
        }

        // Se comprueba que hay saldo suficiente
        if (dineroASacar > this.saldo) {
            throw new CuentaExceptions("No tienes suficiente saldo");
        }

        // Se descuenta el dinero del saldo
        saldo -= dineroASacar;
        numeroReintegros++;
    }

    /**
     * Realiza un ingreso en la cuenta.
     *
     * @param dineroAIngresar cantidad a ingresar
     * @throws CuentaExceptions si la cantidad es negativa
     */
    public void ingreso(double dineroAIngresar) throws CuentaExceptions {

        // Validación de cantidad positiva
        if (dineroAIngresar < 0) {
            throw new CuentaExceptions("El saldo no puede ser negativo");
        }

        // Se añade el dinero al saldo
        saldo += dineroAIngresar;
        numeroIngresos++;
    }

    /**
     * Muestra por pantalla el estado actual de la cuenta.
     */
    public void consulta() {
        System.out.println(toString());
    }
}

