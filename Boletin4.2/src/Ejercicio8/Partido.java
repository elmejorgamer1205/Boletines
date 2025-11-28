package Ejercicio8;

import Exceptions.PartidoExceptions;

public class Partido{

    private Equipo equipoLocal;
    private Equipo  equipoVisitante;
    private int jornada;
    private int golesEquipoLocal;
    private int golesEquipoVisitante;
    private  boolean jugado;
    private char quiniela;

    public Partido(Equipo equipoLocal, Equipo equipoVisitante, int jornada, int golesEquipoLocal, int golesEquipoVisitante, boolean jugado, char quiniela){
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.jornada = jornada;
        this.golesEquipoLocal = golesEquipoLocal;
        this.golesEquipoVisitante = golesEquipoVisitante;
        this.jugado = jugado;
        this.quiniela = quiniela;

    }

    public void  ponerResultado(String resultado) throws PartidoExceptions {
        String[] goles = resultado.split("-");
        int[] numGoles = new int[goles.length];
        for (int i = 0; i < goles.length; i++) {
            numGoles[i] = Integer.parseInt(goles[i]);
        }

        if(numGoles[0] < 0 || numGoles[1] <0){
            this.quiniela='1';
            golesEquipoLocal = numGoles[0];
            golesEquipoVisitante = numGoles[1];

        }
        else if (numGoles [0] == numGoles[1]){
            this.quiniela='X';
            golesEquipoVisitante = numGoles[0];
            golesEquipoLocal = numGoles [0];
        }else {
            this.quiniela = '2';
            golesEquipoLocal = numGoles[1];
            golesEquipoVisitante = numGoles[0];
            jugado = true;
        }
    }

}
