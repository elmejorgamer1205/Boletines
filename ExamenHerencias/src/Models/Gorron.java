package Models;

import java.util.Random;

public class Gorron {

    /** El hambre inicial que tiene un Familiar al principio de la fiesta */
    private static final int HAMBRE_INICIAL_GORRON = 90;

    /** El aburrimiento inicial que tiene un familiar */
    private static final int ABURRIMENTO_INICIAL_GORRON = new Random().nextInt(0, 50);

    /** Regalo que le va a dar Familiar a Lolo*/
    private int regaloGorron;

    public Gorron(int regaloGorron) {
        this.regaloGorron = 0;
    }

    public int getRegaloGorron() {
        return regaloGorron;
    }
}
