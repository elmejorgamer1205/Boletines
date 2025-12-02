package Ejercicio8;

import Exceptions.PartidoExceptions;

public class Partido {
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private int jornada;
    private int golesEquipoLocal;
    private int golesEquipoVisitante;
    private boolean jugado;
    private char quiniela;


    public Partido(Equipo equipoLocal, Equipo equipoVisitante, int jornada, int golesEquipoLocal,
                   int golesEquipoVisitante, boolean jugado, char quiniela) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.jornada = jornada;
        this.golesEquipoLocal = golesEquipoLocal;
        this.golesEquipoVisitante = golesEquipoVisitante;
        this.jugado = jugado;
        this.quiniela = quiniela;
    }

    public void ponerResultado(String resultado) throws PartidoExceptions {
        String[] goles = resultado.split("-",2);
        int[] numGoles = new int[] {
                Integer.parseInt(goles[0]),
                Integer.parseInt(goles[1])
        };
        if (numGoles[0]<numGoles[1]){
            this.quiniela='1';
            golesEquipoLocal=numGoles[0];
            golesEquipoVisitante=numGoles[1];
            jugado=true;
            equipoLocal.sumarPartidoGanados(1);
        }
        else if (numGoles[0]==numGoles[1]){
            this.quiniela='X';
            golesEquipoLocal=numGoles[0];
            golesEquipoVisitante=numGoles[1];
            jugado=true;
        }else {
            this.quiniela='2';
            golesEquipoLocal=numGoles[0];
            golesEquipoVisitante=numGoles[1];
            jugado=true;
            equipoVisitante.sumarPartidoGanados(1);
        }
    }

    @Override
    public String toString() {
        if (!jugado) {
            return "Partido{" +
                    "Partido entre equipo local" + equipoLocal.getNombre() +
                    "y equipo visitante" + equipoVisitante.getNombre() +
                    "todavía no se ha jugado”\n";
        }else
            return "Partido{" +
                    "Partido entre equipo local" + equipoLocal.getNombre() +
                    "y equipo visitante" + equipoVisitante.getNombre() +
                    "jugado en el estadio" +
                    " \n";
    }
}
