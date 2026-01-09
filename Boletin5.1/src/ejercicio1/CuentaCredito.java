package ejercicio1;

import Exceptions.CuentaExceptions;

public class CuentaCredito extends Cuenta {

    /** Saldo inicial por defecto de la cuenta */
    private static final double SALDO_INICIAL = 0;

    /** Crédito asignado por defecto */
    private static final double CREDITO_POR_DEFECTO = 100;

    /** Límite máximo de crédito permitido */
    private static final double CREDITO_MAX = 300;

    /** Crédito inicial con el que se crea la cuenta */
    private final double CREDITO_INICIAL;

    /** Crédito disponible actual */
    private double credito;

    /**
     * Constructor que recibe saldo inicial y crédito.
     *
     * @param saldoInicial saldo con el que se crea la cuenta
     * @param credito crédito inicial asignado
     * @throws CuentaExceptions si el crédito supera el máximo permitido
     */
    public CuentaCredito(double saldoInicial, double credito) throws CuentaExceptions {
        super(saldoInicial);
        CREDITO_INICIAL = credito;
        setCredito(CREDITO_INICIAL); // Valida que el crédito no exceda el máximo
    }

    /**
     * Constructor que recibe solo el saldo inicial.
     * El crédito se establece al valor por defecto.
     *
     * @param saldoInicial saldo con el que se crea la cuenta
     * @throws CuentaExceptions si ocurre un error en la cuenta base
     */
    public CuentaCredito(double saldoInicial) throws CuentaExceptions {
        super(saldoInicial);
        this.credito = CREDITO_POR_DEFECTO;
        CREDITO_INICIAL = CREDITO_POR_DEFECTO;
    }

    /**
     * Constructor por defecto.
     * Crea una cuenta con saldo 0 y crédito por defecto.
     *
     * @throws CuentaExceptions si ocurre un error en la cuenta base
     */
    public CuentaCredito() throws CuentaExceptions {
        super(SALDO_INICIAL);
        this.credito = CREDITO_POR_DEFECTO;
        CREDITO_INICIAL = CREDITO_POR_DEFECTO;
    }

    /**
     * Devuelve el crédito disponible actual.
     *
     * @return crédito disponible
     */
    public double getCredito() {
        return credito;
    }

    /**
     * Establece el crédito de la cuenta.
     *
     * @param credito nuevo crédito a asignar
     * @throws CuentaExceptions si el crédito supera el máximo permitido
     */
    public void setCredito(double credito) throws CuentaExceptions {
        if (credito > CREDITO_MAX ) {
            throw new CuentaExceptions("Crédito máximo excedido");
        }
        this.credito = credito;
    }

    /**
     * Retira dinero de la cuenta.
     * Puede utilizar el crédito si el saldo no es suficiente.
     *
     * @param dineroASacar cantidad a retirar
     * @throws CuentaExceptions si la cantidad es inválida o no hay fondos
     */
    @Override
    public void reintegro(double dineroASacar) throws CuentaExceptions {

        // Validación de cantidad positiva
        if (dineroASacar <= 0){
            throw new CuentaExceptions("Introduzca una cantidad positiva");
        }

        // Verifica si saldo + crédito es suficiente
        if (getSaldo() + credito < dineroASacar){
            throw new CuentaExceptions("No tienes fondos suficientes");
        }

        /*
         * Si el saldo no alcanza, se usa primero todo el saldo
         * y el resto se descuenta del crédito
         */
        if (dineroASacar > getSaldo()){
            double cantidadRestante = dineroASacar - getSaldo();
            super.reintegro(getSaldo()); // Deja el saldo en 0
            credito -= cantidadRestante; // Se descuenta del crédito
        }
        // Si el saldo es suficiente, se realiza el reintegro normal
        else {
            super.reintegro(dineroASacar);
        }
    }

    /**
     * Ingresa dinero en la cuenta.
     * Si el crédito ha sido utilizado, el ingreso se destina
     * primero a restaurar el crédito inicial.
     *
     * @param dineroAIngresar cantidad a ingresar
     * @throws CuentaExceptions si la cantidad es negativa
     */
    @Override
    public void ingreso(double dineroAIngresar) throws CuentaExceptions {

        // No se permiten ingresos negativos
        if (dineroAIngresar < 0){
            throw new CuentaExceptions("blablabla");
        }

        /*
         * Si el crédito ha sido reducido, se calcula cuánto dinero
         * hace falta para restaurarlo al valor inicial
         */
        if (credito < CREDITO_INICIAL){
            double dineroDeCredito = CREDITO_INICIAL - credito;

            // Lógica pendiente de implementación
        }
    }
}


