package Ejercicio1;

public class Peliculas {

    private String titulo;
    private int añoDeEstreno;
    private String direcctor;
    private double presupuesto;
    private double recaudacion;
    private String sinopsis;
    private String etiquetas;
    private double valoracion;

    public Peliculas() {
        setTitulo(titulo);
        setAñoDeEstreno(añoDeEstreno);
        setDirecctor(direcctor);
        setPresupuesto(presupuesto);
        setRecaudacion(recaudacion);
        setSinopsis(sinopsis);
        setEtiquetas(etiquetas);
        setValoracion(valoracion);
    }

    public void setAñoDeEstreno(int añoDeEstreno) {
        this.añoDeEstreno = añoDeEstreno;
    }

    public void setDirecctor(String direcctor) {
        this.direcctor = direcctor;
    }

    public void setEtiquetas(String etiquetas) {
        this.etiquetas = etiquetas;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public void setRecaudacion(double recaudacion) {
        this.recaudacion = recaudacion;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setValoracion(double valoracion) {
        this.valoracion = valoracion;
    }
}
