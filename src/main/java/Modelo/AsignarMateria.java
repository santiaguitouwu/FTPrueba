package Modelo;

public class AsignarMateria {
    String ID_Estudiante;
    String nombreEstudiante;
    String apellidoEstudiante;
    String ID_Asignatura;
    String nombreAsignatura;
    String nombreDepartamento;

    public AsignarMateria() {
    }

    public AsignarMateria(String ID_Estudiante, String nombreEstudiante, String apellidoEstudiante, String ID_Asignatura, String nombreAsignatura) {
        this.ID_Estudiante = ID_Estudiante;
        this.nombreEstudiante = nombreEstudiante;
        this.apellidoEstudiante = apellidoEstudiante;
        this.ID_Asignatura = ID_Asignatura;
        this.nombreAsignatura = nombreAsignatura;
    }

    public String getID_Estudiante() {
        return ID_Estudiante;
    }

    public void setID_Estudiante(String ID_Estudiante) {
        this.ID_Estudiante = ID_Estudiante;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public String getApellidoEstudiante() {
        return apellidoEstudiante;
    }

    public void setApellidoEstudiante(String apellidoEstudiante) {
        this.apellidoEstudiante = apellidoEstudiante;
    }

    public String getID_Asignatura() {
        return ID_Asignatura;
    }

    public void setID_Asignatura(String ID_Asignatura) {
        this.ID_Asignatura = ID_Asignatura;
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }
}
