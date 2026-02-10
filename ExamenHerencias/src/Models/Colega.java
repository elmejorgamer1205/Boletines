package Models;

import java.util.Random;

public class Colega {

    /** El hambre inicial que tiene un Familiar al principio de la fiesta */
    private static final int HAMBRE_INICIAL_COLEGA = new Random().nextInt(50, 70);

    /** El aburrimiento inicial que tiene un familiar */
    private static final int ABURRIMENTO_INICIAL_COLEGA = new Random().nextInt(0, 50);

    /** Regalo que le va a dar Familiar a Lolo*/
    private int regaloColega;

    /**
     * Constructor de Colega
     * @param regaloColega
     */
    public Colega(int regaloColega) {
        this.regaloColega = 1;
    }

    public int getRegaloColega() {
        return regaloColega;
    }
}
