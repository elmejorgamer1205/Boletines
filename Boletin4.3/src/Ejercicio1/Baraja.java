package Ejercicio1;

import Exceptions.BarajaException;
import utils.MiEntradaSalida;

import java.util.Arrays;

public class Baraja {
        public final int TAMAÑO_BARAJA = 40;
        private carta[] baraja = new carta[TAMAÑO_BARAJA];
        private int cartasRepartidas;

        public Baraja() {
            crearBaraja();
        }

        public void crearBaraja() {
            String[] palo = {"Oros", "Bastos", "Copas", "Espadas"};
            int posicionBaraja = 0;
            for (int i = 0; i < palo.length; i++) {
                for (int j = 1; j <= 12; j++) {
                    if (j == 8 || j == 9) {
                        continue;
                    }
                    baraja[posicionBaraja] = new carta(palo[i], j);
                    posicionBaraja++;
                }
            }
        }

        public void mostrarBaraja() {
            System.out.println(toString());
        }

        public void barajar() {
            for (int i = 0; i < baraja.length; i++) {
                int primeraPosicion = MiEntradaSalida.generaAleatorioEntre(0, baraja.length, false);
                int segundaPosicion = MiEntradaSalida.generaAleatorioEntre(0, baraja.length, false);
                carta aux = baraja[segundaPosicion];
                baraja[segundaPosicion] = baraja[primeraPosicion];
                baraja[primeraPosicion] = aux;
            }
        }

        public void repartir(int numJugadores, int numCartas) throws BarajaException {
            int reparto = numJugadores * numCartas;
            if (reparto > TAMAÑO_BARAJA-cartasRepartidas) {
                throw new BarajaException("No hay suficientes cartas en la baraja");
            } else cartasRepartidas += reparto;

        }

        public String cartasRestantes(){
            return String.valueOf(TAMAÑO_BARAJA-cartasRepartidas);
        }

        @Override
        public String toString() {
            return "Baraja={" +
                    Arrays.toString(baraja) +
                    '}';
        }

    }
