package Ejercicio3;

import Ejercicio2.DiscoDuro;
import Ejercicio2.Microprocesador;
import Ejercicio2.PlacaBase;
import Ejercicio2.TarjetaGrafica;

public class Ordenador {
    private DiscoDuro discoDuro;
    private Microprocesador microprocesador;
    private PlacaBase placaBase;
    private TarjetaGrafica tarjetaGrafica;


    public Ordenador(DiscoDuro discoDuro, Microprocesador microprocesador, PlacaBase placaBase, TarjetaGrafica tarjetaGrafica) {
        this.discoDuro = discoDuro;
        this.microprocesador = microprocesador;
        this.placaBase = placaBase;
        this.tarjetaGrafica = tarjetaGrafica;
    }

    public String compatibilidad(Videojuego videojuego) {
        StringBuilder mensaje = new StringBuilder();
        if (microprocesador.getNumNucleos() < videojuego.getNUCLEOS_PROCESADOR()) {
            mensaje.append("Error: La CPU no tiene los suficientes núcleos.\n");
        }
        if (microprocesador.getVelBase() < videojuego.getVELOCIDAD_MINIMA_CPU()) {
            mensaje.append("Error: La CPU no tiene suficiente velocidad.\n");
        }
        if (discoDuro.getCapacidad() < videojuego.getCAPACIDAD_MINIMA_DISCO()) {
            mensaje.append("Error: El disco duro no tiene suficiente espacio\n");
        }
        if (tarjetaGrafica.getNumNucleos() < videojuego.getMINIMOS_NUCLEOS_GPU()) {
            mensaje.append("Error: La GPU no tiene suficientes núcleos.\n");
        }
        if (tarjetaGrafica.getCapacidad() < videojuego.getMINIMA_MEMORIA_GPU()) {
            mensaje.append("Error: La GPU no tiene suficiciente memoria.\n");
        }
        return mensaje.toString();
    }
}