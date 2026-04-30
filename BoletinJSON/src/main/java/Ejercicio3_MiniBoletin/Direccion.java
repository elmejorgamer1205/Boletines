package Ejercicio3_MiniBoletin;

import com.google.gson.annotations.Expose;

public class Direccion {

    // La anotación @Expose le dice a Gson: "Por favor, incluye esta variable
    // cuando conviertas el objeto a JSON o cuando lo leas desde un JSON".
    @Expose
    private String calle;

    @Expose
    private String ciudad;

    @Expose
    private String codigoPostal;

    // Constructor habitual
    public Direccion(String calle, String ciudad, String codigoPostal) {
        this.calle = calle;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
    }

    // Getters y Setters
    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
}