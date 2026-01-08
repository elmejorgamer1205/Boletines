package ejercicio1;

import Exceptions.CuentaExceptions;

public class CuentaCredito extends Cuenta{
    private static final double SALDO_INICIAL = 0;
    private static final double CREDITO_POR_DEFECTO = 100;
    private static final double CREDITO_MAX = 300;
    private final double CREDITO_INICIAL;
    private double credito;

    public CuentaCredito(double saldoInicial, double credito) throws CuentaExceptions {
        super(saldoInicial);
        CREDITO_INICIAL = credito;
        setCredito(CREDITO_INICIAL);
    }

    public CuentaCredito(double saldoInicial) throws CuentaExceptions {
        super(saldoInicial);
        this.credito = CREDITO_POR_DEFECTO;
        CREDITO_INICIAL = CREDITO_POR_DEFECTO;
    }

    public CuentaCredito() throws CuentaExceptions {
        super(SALDO_INICIAL);
        this.credito = CREDITO_POR_DEFECTO;
        CREDITO_INICIAL = CREDITO_POR_DEFECTO;
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) throws CuentaExceptions {
        if (credito > CREDITO_MAX ) {
            throw new CuentaExceptions("Crédito máximo excedido");
        }
        this.credito = credito;
    }

    @Override
    public void reintegro(double dineroASacar) throws CuentaExceptions {
        if (dineroASacar <= 0){
            throw new CuentaExceptions("Introduzca una cantidad positiva");
        }
        if (getSaldo()+credito<dineroASacar){
            throw new CuentaExceptions("No tienes fondos suficientes");
        }
        if (dineroASacar > getSaldo()){
            double cantidadRestante = dineroASacar - getSaldo();
            super.reintegro(getSaldo());
            credito -= cantidadRestante;
        }
        else super.reintegro(dineroASacar);

    }

    @Override
    public void ingreso(double dineroAIngresar) throws CuentaExceptions {
        if (dineroAIngresar < 0){
            throw new CuentaExceptions("blablabla");
        }
        if (credito < CREDITO_INICIAL){
            double dineroDeCredito = CREDITO_INICIAL - credito;


        }
    }
}

