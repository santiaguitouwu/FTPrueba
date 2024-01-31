package Modelo;

import Config.Conexion;
import Controlador.Validar;
import jakarta.persistence.Id;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class EstudianteDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int respuesta;
    private static final Logger LOGGER = Logger.getLogger(Estudiante.class.getName());
    public List<Estudiante> read(){
        String sql = "SELECT * FROM estudiante";
        List <Estudiante> lista = new ArrayList<>();
        try {
            con = cn.conexion();
            ps = con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Estudiante estudiante = new Estudiante();
                estudiante.setID_Estudiante(rs.getString(1));
                estudiante.setNombre(rs.getString(2));
                estudiante.setApellido(rs.getString(3));
                estudiante.setTelefono(rs.getString(4));
                estudiante.setEmail(rs.getString(5));
                lista.add(estudiante);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public String create(Estudiante estudiante){
        String sql = "INSERT INTO estudiante(id_estudiante, nombre, apellido, telefono, email) VALUES(?,?,?,?,?)";
        try {
            con = cn.conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1,estudiante.getID_Estudiante());
            ps.setString(2,estudiante.getNombre());
            ps.setString(3,estudiante.getApellido());
            ps.setString(4,estudiante.getTelefono());
            ps.setString(5,estudiante.getEmail());
            ps.executeUpdate();
            return null;
        } catch (SQLException e) {
            return "Error al crear el usuario " + e.getMessage();
        }
    }

    public Estudiante listarID(String id) throws SQLException {
            Estudiante estudiante = new Estudiante();
            String sql = "SELECT * FROM estudiante WHERE ID_Estudiante ="+ "'"+id +"'";
            LOGGER.info("consulta " +sql);
            try {
                con = cn.conexion();
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()){
                    estudiante.setID_Estudiante(rs.getString(1));
                    estudiante.setNombre(rs.getString(2));
                    estudiante.setApellido(rs.getString(3));
                    estudiante.setTelefono(rs.getString(4));
                    estudiante.setEmail(rs.getString(5));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        return estudiante;
    }
    public int update(Estudiante estudiante){
        String sql = "UPDATE estudiante SET Nombre=?, Apellido=?, Telefono=? WHERE ID_Estudiante = ?";
        try {
            con = cn.conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1,estudiante.getNombre());
            ps.setString(2,estudiante.getApellido());
            ps.setString(3,estudiante.getTelefono());
            ps.setString(4, estudiante.getID_Estudiante());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return respuesta;
    }
    public void delete(String id){
        String sql = "DELETE FROM estudiante WHERE ID_Estudiante = ?";
        try {
            con = cn.conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Estudiante buscar(String id){
        String sql = "SELECT * FROM estudiante WHERE id_estudiante=" + "'"+id +"'";
        Estudiante estudiante = new Estudiante();
        try {
            con = cn.conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                estudiante.setID_Estudiante(rs.getString(1));
                estudiante.setNombre(rs.getString(2));
                estudiante.setApellido(rs.getString(3));
                estudiante.setTelefono(rs.getString(4));
                estudiante.setEmail(rs.getString(5));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return estudiante;
    }
}
