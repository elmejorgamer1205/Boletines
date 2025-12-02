package Ejercicio8;

public class Equipo {
    private String nombre;
    private int partidosGanados;
    private String estadio;
    private String ciudad;

    public Equipo(String nombre, int partidosGanados, String estadio, String ciudad) {
        setNombre(nombre);
        setPartidosGanados(partidosGanados);
        setEstadio(estadio);
        setCiudad(ciudad);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPartidosGanados() {
        return partidosGanados;
    }

    private void setPartidosGanados(int partidosGanados) {
        this.partidosGanados = partidosGanados;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void sumarPartidoGanados(int suma){
        partidosGanados+=suma;
    }
}
