package Ejercicio3_MiniBoletin;

import com.google.gson.annotations.Expose;

public class Usuario {

    // Se incluirá tanto al leer como al escribir el JSON
    @Expose
    private String username;

    // 🌟 LA JOYA DE LA CORONA
    // serialize = false: Le dice a Gson "NO escribas esto en el archivo JSON".
    // Como no has puesto 'deserialize', por defecto es 'true'. Eso significa que si
    // recibieras un JSON desde internet que SÍ tiene contraseña, Gson sí la leería y la guardaría aquí.
    @Expose(serialize = false)
    private String password;

    @Expose
    private String email;

    // Aquí ocurre la "Composición". Gson verá esto, entrará en la clase Direccion
    // y aplicará las reglas de @Expose que definiste allí.
    @Expose
    private Direccion direccion;

    public Usuario(Direccion direccion, String email, String password, String username) {
        this.direccion = direccion;
        this.email = email;
        this.password = password;
        this.username = username;
    }

    // Getters y Setters...
    public Direccion getDireccion() { return direccion; }
    public void setDireccion(Direccion direccion) { this.direccion = direccion; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    @Override
    public String toString() {
        return "Usuario{" +
                "direccion=" + direccion + // 💡 Esto imprimirá un código de memoria a menos que le añadas un toString() a la clase Direccion
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}