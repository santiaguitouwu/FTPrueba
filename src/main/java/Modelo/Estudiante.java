package Modelo;

import jakarta.servlet.annotation.WebServlet;

@WebServlet("/Estudiante")
public class Estudiante{
    String ID_Estudiante;
    String Nombre;
    String Apellido;
    String telefono;
    String email;

    public Estudiante() {
    }

    public Estudiante(String ID_Estudiante, String nombre, String apellido, String telefono, String email) {
        this.ID_Estudiante = ID_Estudiante;
        Nombre = nombre;
        Apellido = apellido;
        this.telefono = telefono;
        this.email = email;
    }

    public String getID_Estudiante() {
        return ID_Estudiante;
    }

    public void setID_Estudiante(String ID_Estudiante) {
        this.ID_Estudiante = ID_Estudiante;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGetID_Estudiante() {
        return ID_Estudiante;
    }
}
