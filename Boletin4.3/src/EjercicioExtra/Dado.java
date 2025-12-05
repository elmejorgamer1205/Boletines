package EjercicioExtra;

import Exceptions.DadoException;

public class Dado {
    private int numCaras;

    public void setNumCaras(int numCaras) throws DadoException {
        if( numCaras <= 0){
            throw new DadoException("Error: un dado no tiene 0 caras pelele");
        }
        this.numCaras = numCaras;
    }

    public int getNumCaras(){
        return numCaras;
    }

    public int lanzar(){
        return (int)(Math.random() * numCaras) + 1;
    }
}
