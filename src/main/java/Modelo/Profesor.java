package Modelo;

import jakarta.servlet.annotation.WebServlet;

@WebServlet("/Profesor")
public class Profesor {
    String ID_Profesor;
    String Nombre;
    String Contrasena;

    public Profesor() {
    }

    public Profesor(String ID_Profesor, String nombre, String contrasena) {
        this.ID_Profesor = ID_Profesor;
        Nombre = nombre;
        Contrasena = contrasena;
    }

    public String getID_Profesor() {
        return ID_Profesor;
    }

    public void setID_Profesor(String ID_Profesor) {
        this.ID_Profesor = ID_Profesor;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String contrasena) {
        Contrasena = contrasena;
    }

    public String getGetNombre() {
        return Nombre;
    }

    public String getGetID_Profesor() {
        return ID_Profesor;
    }
}
