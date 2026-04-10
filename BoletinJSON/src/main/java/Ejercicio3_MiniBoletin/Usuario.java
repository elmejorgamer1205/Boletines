package Ejercicio3_MiniBoletin;

import com.google.gson.annotations.Expose;

public class Usuario {
    @Expose
    private String username;
    @Expose(serialize = false)
    private String password;
    @Expose
    private String email;
    @Expose
    private Direccion direccion;

    public Usuario(Direccion direccion, String email, String password, String username) {
        this.direccion = direccion;
        this.email = email;
        this.password = password;
        this.username = username;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "direccion=" + direccion +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
