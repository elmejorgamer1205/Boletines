package interfaces;

import exceptions.JugueteException;
import models.Juguete;

public interface Apilable {
    //public void apilar(Juguete a);

    public default void apilar(Juguete a) throws JugueteException {
        if (this == a) {
            throw new JugueteException("No puedes apilar un juguete consigo mismo");
        }
        if (!(a instanceof Apilable)) {
            throw new JugueteException("El juguete " + a.getNombre() + " no es apilable");
        }

        //Comprobamos ahora que sea del mismo tipo
        if (this.getClass() != a.getClass()) {
            throw new JugueteException("No puedo apilar un juguete de tipo " + this.getClass().getCanonicalName()
                    + " con uno de tipo " + a.getClass().getCanonicalName());
        }
    }
}
