package Modelo;

import Config.Conexion;

import java.awt.geom.RectangularShape;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfesorDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public Profesor validar(String ID_Profesor, String contrasena){
        Profesor profesor = new Profesor();
        String sql = "SELECT * FROM Profesor WHERE ID_Profesor=? AND contrasena=?";
        try {
            con= cn.conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1,ID_Profesor);
            ps.setString(2,contrasena);
            rs=ps.executeQuery();
            while(rs.next()){
                profesor.setID_Profesor(rs.getString("ID_Profesor"));
                profesor.setContrasena(rs.getString("contrasena"));
                profesor.setNombre(rs.getString("Nombre"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return profesor;
    }
}
