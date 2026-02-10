package Models;

import java.util.Random;

public class Familiar {

    /** El hambre inicial que tiene un Familiar al principio de la fiesta */
    private static final int HAMBRE_INICIAL_FAMILIAR = new Random().nextInt(30, 60);

    /** El aburrimiento inicial que tiene un familiar */
    private static final int ABURRIMENTO_INICIAL_FAMILIAR = new Random().nextInt(0, 50);

    /** Regalo que le va a dar Familiar a Lolo*/
    private int regaloInvitado;

    public Familiar(int regaloInvitado) {
        this.regaloInvitado = 1;
    }

    public int getRegaloInvitado() {
        return regaloInvitado;
    }


}

