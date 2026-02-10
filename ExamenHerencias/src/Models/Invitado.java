package Models;

import Exceptions.EstadoException;
import Interfaces.Abrible;


public abstract class Invitado implements Abrible {

    /** Aburrimiento máximo que puede tener un invitado */
    private static final int MAX_ABURRIMIENTO = 100;

    /** Hambre máxima que puede tener un invitado */
    private static final int MAX_HAMBRE = 100;
    /** Hambre que tienen los invitados */
    private int hambre;
    /** Aburrimiento de los invitados */
    private int aburrimento;

    /** Nombre del inivitado*/
    private String nombre;

    /**
     * Constructor principal del Invitado
     *
     * @param aburrimento
     * @param hambre
     * @param nombre
     */
    public Invitado(int aburrimento, int hambre, String nombre) {
        this.aburrimento = aburrimento;
        this.hambre = hambre;
        this.nombre = nombre;
    }

    /**
     *
     * @param aburrimento
     * @throws EstadoException
     */
    public void setAburrimento(int aburrimento) throws EstadoException {
        if (aburrimento > MAX_ABURRIMIENTO) {
            throw new EstadoException("No puedes estar tan aburrido");
        }
        this.aburrimento = aburrimento;
    }

    /**
     *
     * @param hambre
     * @throws EstadoException
     */
    public void setHambre(int hambre) throws EstadoException {
        if (hambre > MAX_HAMBRE) {
            throw new EstadoException("No puedes estar con tan hambre");
        }
        this.hambre = hambre;
    }

    /**
     * @return Nombre actual del invitado
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo para que el Invitado pase hambre cada ronda
     */
    private void pasarHambre() {

    }

    /**
     * Metodo para que el Invitado se divierta
     */
    private void Divertirse() {
    }
}
