package Examen2023.Models;

import Examen2023.Exception.EquipoException;
import Examen2023.Exception.LigaException;

import java.util.List;

public class Liga {

    private List<Equipo> listaEquipos;

    public void annadirEquipo(Equipo e) throws EquipoException {
        if(e.getConjuntoJugadores().isEmpty()){
            throw new EquipoException("El equipo no tiene jugadores");
        }
        if (listaEquipos.contains(e)){
            throw new EquipoException("El equipo ya pertenece a la liga");
        }

        listaEquipos.add(e);
    }

    public void eliminarEquipo(Equipo e) throws LigaException {
        if (!listaEquipos.contains(e)) {
            throw new LigaException("El equipo que buscas no juega en esta liga");
        }

        listaEquipos.remove(e);
    }

    public void unirEquipos(Equipo equipo1, Equipo equipo2) throws LigaException{
        if(!listaEquipos.contains(equipo1) || !listaEquipos.contains(equipo2)){
            throw new LigaException("Uno o ambos de esos equipo no existe");
        }

        equipo1.getConjuntoJugadores().addAll(equipo2.getConjuntoJugadores());
    }
}
