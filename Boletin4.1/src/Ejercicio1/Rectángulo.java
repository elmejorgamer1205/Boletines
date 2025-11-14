package Ejercicio1;

import java.util.Scanner;

public class Rectángulo {

    private int longitud, ancho;

    public Rectángulo() {
        longitud = 1;
        ancho = 1;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        if (longitud > 0 && longitud < 20) {
            this.longitud = longitud;
        }
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        if (ancho > 0 && ancho < 20) {
            this.ancho = ancho;
        }
    }

    public int areaRectangulo() {
        return ancho * longitud;
    }

    public int perimetroRectangulo() {
        return 2 * (ancho + longitud);
    }

    public static void main(String[] args) {
        Rectángulo r = new Rectángulo();
        Scanner sc = new Scanner(System.in);
        int ancho = MiEntradaSalida.solicitarEnteroEnRango("Dime el ancho de tú rectángulo: ", 0, 20);
        int longitud = MiEntradaSalida.solicitarEnteroEnRango("Dime la longitud de tú rectángulo: ", 0, 20);


        r.setAncho(ancho);
        r.setLongitud(longitud);
        System.out.println("\nEl área del rectángulo sería: " + r.areaRectangulo());
        System.out.println("\nEl perímetro del rectángulo sería: " + r.perimetroRectangulo());

    }
}