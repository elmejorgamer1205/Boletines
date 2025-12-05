package EjercicioExtra;

import Exceptions.DadoException;

public class Jugador {

    private String nombre;
    private Dado dado;

    public Jugador(){
        this.nombre = "";
        this.dado = new Dado();
    }

    public Jugador(String nombre){
        this.nombre = nombre;
        this.dado = new Dado();
    }

    public int lanzarDado(){
        return this.dado.lanzar();
    }

    public void setCarasDado(int numCaras) throws DadoException {
        this.dado.setNumCaras(numCaras);
    }
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Jugador jugador = (Jugador) o;
        return nombre.equals(jugador.nombre);
    }

    @Override
    public int hashCode() {
        return nombre.hashCode();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Jugador{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

