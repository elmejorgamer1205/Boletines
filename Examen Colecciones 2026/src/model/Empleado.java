package model;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Empleado {
    private String nombre;
    private String apellido;
    private String dni;
    private TDepartamento departamento;
    private List<Nomina> nominas;

    public Empleado(String nombre, String apellido, String dni, TDepartamento departamento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.departamento = departamento;
        this.nominas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    public TDepartamento getDepartamento() {
        return departamento;
    }

    public List<Nomina> getNominas() {
        return nominas;
    }

    @Override
    public String toString() {
        return "%s %s (%s) - Departamento: %s".formatted(nombre, apellido, dni, departamento);
    }

    public YearMonth fechaPrimeraNomina() {
        return null;
    }

    /**
     *
     * @return primera nómina
     */
    public Nomina getUltimaNomina() {
        return nominas.getFirst();
    }

}
