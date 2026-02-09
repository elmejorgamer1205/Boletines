package models;

import enums.TPlastico;

public abstract class JuguetePlastico extends Juguete {
    private TPlastico tipoPlastico;

    public JuguetePlastico(String nombre, String marca, TPlastico tipoPlastico) {
        super(nombre, marca);
        this.tipoPlastico = tipoPlastico;
    }

    public TPlastico getTipoPlastico() {
        return tipoPlastico;
    }

}
