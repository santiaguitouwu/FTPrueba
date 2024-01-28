package Modelo;

import Config.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AsignaturaMateriaDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int respuesta;

    public AsignaturaMateriaDAO() {
    }

    public int create(AsignarMateria asignarMateria){
        String sql = "INSERT INTO estudiante_materia(id_estudiante,id_materia) VALUES(?,?)";
        try {
            con = cn.conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1,asignarMateria.getID_Estudiante());
            ps.setString(2,asignarMateria.getID_Asignatura());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return respuesta;
    }
}
