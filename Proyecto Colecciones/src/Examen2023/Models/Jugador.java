package Examen2023.Models;

import Examen2023.Enums.Demarcacion;

import java.time.LocalDate;
import java.util.Objects;

public class Jugador {

    private String nombre;
    private LocalDate fechaNacimiento;
    private String pais;
    private Demarcacion demarcacion;

    public Jugador(Demarcacion demarcacion, LocalDate fechaNacimiento, String nombre, String pais) {
        this.demarcacion = demarcacion;
        this.fechaNacimiento = fechaNacimiento;
        this.nombre = nombre;
        this.pais = pais;
    }

    public Demarcacion getDemarcacion() {
        return demarcacion;
    }

    public void setDemarcacion(Demarcacion demarcacion) {
        this.demarcacion = demarcacion;
    }

    public LocalDate getFechaNacimineto() {
        return fechaNacimiento;
    }

    public void setFechaNacimineto(LocalDate fechaNacimineto) {
        this.fechaNacimiento = fechaNacimineto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jugador jugador = (Jugador) o;
        return Objects.equals(nombre, jugador.nombre) &&
                Objects.equals(fechaNacimiento, jugador.fechaNacimiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, fechaNacimiento);
    }
}
