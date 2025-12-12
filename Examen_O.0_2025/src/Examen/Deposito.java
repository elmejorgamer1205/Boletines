package Examen;

import Exceptions.NaveException;

/**
 * Clase que representa un depósito de combustible recargado con cartuchos
 *
 */
public class Deposito {
    private final static int TAMAÑO = 5;
    private Cartucho[] cartuchos ;
    private Cartucho peso;
    private Cartucho potencia;

    public Deposito(Cartucho cartucho){
        Cartucho[] cartuchos =new Cartucho[TAMAÑO];
    }

    /**
     * Metodo para añadir cartuchos al depósito
     *
     * @param cartucho cartucho que se va a añadir
     * @return devueleve verdadero si hay huecos, si no hay huecos devuelve
     */
    public boolean añadirCartucho(Cartucho cartucho) {
        for (int i = 0; i < cartuchos.length; i++) {
            if (cartuchos[i] == null) {
                return false;
            }
        }
        return true;
    }

    /**
     * Metodo para calcular la potencia total de la nave
     *
     * @param potencia
     * @return
     */
    public int calcularLaPotencia(Cartucho potencia){
        int potenciaTotal = 0;
        return potenciaTotal;
    }

    /**
     * Metodo para calcular el peso total de la nave
     *
     * @param peso
     * @return
     */
    public int calcularPesoTotal(Cartucho peso) {
        int pesoTotal = 0;
        return pesoTotal;
    }

    /**
     * Metodo para calcular el peso total de un cartucho
     *
     * @param pesoTotal
     * @param potenciaTotal
     * @return devuelve el Peso total del cartucho
     */
    public int calcularPesoTotalDeCartucho(int pesoTotal, int potenciaTotal){
        int calcularPesoDelCartucho = pesoTotal + potenciaTotal;
        return calcularPesoDelCartucho;
    }

    public void contarCartuchos(){

    }

}

