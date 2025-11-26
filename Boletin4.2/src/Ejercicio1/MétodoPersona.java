package Ejercicio1;

import java.time.LocalDate;

public class MétodoPersona {

    private String nombre;
    private LocalDate fechaDeNacimiento;
    private int dni;
    private char  sexo;
    private float altura;
    private float peso;

    public MétodoPersona(){
        setNombre(nombre);
        setFechaDeNacimiento(fechaDeNacimiento);
        setDni(dni);
        setSexo(sexo);
        setAltura(altura);
        setPeso(peso);

    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public int getDni() {

        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    @Override

    public String toString(){
        return "MétodoPersona{" +
                "nombre= " + nombre +
                ", fecha de nacimiento= " + fechaDeNacimiento +
                ", DNI= " + dni +
                ", sexo= " + sexo +
                ", altura= " + altura +
                ", peso= " + peso + "}";
    }

    public void consultarDatos(){
        System.out.println(toString());
    }
}
