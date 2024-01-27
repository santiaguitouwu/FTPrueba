package Modelo;

import jakarta.servlet.annotation.WebServlet;

@WebServlet("/Asignatura")
public class Asignatura {
    String id_Asignatura;
    String nombre;
    String departamento;

    public Asignatura() {
    }

    public Asignatura(String id_Asignatura, String nombre, String departamento) {
        this.id_Asignatura = id_Asignatura;
        this.nombre = nombre;
        this.departamento = departamento;
    }

    public String getId_Asignatura() {
        return id_Asignatura;
    }

    public void setId_Asignatura(String id_Asignatura) {
        this.id_Asignatura = id_Asignatura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
