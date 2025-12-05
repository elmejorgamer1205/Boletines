package EjercicioExtra;

import Exceptions.DadoException;

import java.util.Arrays;

public class Partida {
    public static final int NUMERO_RONDAS = 2;
    public static final int NUMERO_JUGADORES = 2;
    public static final int NUMERO_CARAS_DADO = 6;
    private Jugador[] jugadores = new Jugador[NUMERO_JUGADORES];
    private Jugador[] rondas = new Jugador[NUMERO_RONDAS];

    private Partida(){
        jugadores = new Jugador[NUMERO_JUGADORES];
        rondas = new Jugador[NUMERO_RONDAS];
    }

    public Jugador[] getRondas() {
        return rondas;
    }

    public Jugador[] getJugadores() {
        return jugadores;
    }

    private void addJugador(Jugador j){
        for (int i = 0; i < jugadores.length; i++) {
            if (jugadores[i] == null){
                jugadores[i] = j;
                return;
            }
        }
    }

    public static void main(String[] args) {
        Partida p = new Partida();

        for (int i = 0; i < p.jugadores.length; i++) {
            p.addJugador(new Jugador(("J" + (i + 1))));
        }

        for(Jugador j: p.getJugadores()){
            try {
                j.setCarasDado(NUMERO_CARAS_DADO);
            }catch (DadoException e){
                System.out.println(e.getMessage());
            }
        }

        int rondaActual = 0;

        while (rondaActual < NUMERO_RONDAS){
            Jugador ganadorRonda = null;
            int maxTirada = Integer.MIN_VALUE;

            for (Jugador j: p.getJugadores()){
                int lanzamiento = j.lanzarDado();
                if(lanzamiento > maxTirada){
                    maxTirada = lanzamiento;
                    ganadorRonda = j;
                }
            }
            p.rondas[rondaActual++] = ganadorRonda;
        }
    }

    public Jugador quienGana() throws DadoException{
        int[] rondasGanadasPorJugador = new int[NUMERO_JUGADORES];

        for (int i = 0; i < rondas.length; i++) {
            try {
                rondasGanadasPorJugador[indiceJugador(rondas[i])]++;
            }
            catch (DadoException e){
                System.out.println(e.getMessage());
            }
        }

        int indiceMayor = 0;

        for (int i = 1; i < rondasGanadasPorJugador.length; i++) {
            if(rondasGanadasPorJugador[i] > rondasGanadasPorJugador[indiceMayor]){
                indiceMayor = i;
            }
        }

        return jugadores[indiceMayor];
    }

    private int indiceJugador(Jugador j) throws DadoException {
        for (int i = 0; i < jugadores.length; i++) {
            if(j.equals((jugadores[i]))){
                return i;
            }
        }
        throw new DadoException("No encuentro al jugador");
    }
}
