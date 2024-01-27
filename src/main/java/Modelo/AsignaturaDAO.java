package Modelo;

import Config.Conexion;
import jakarta.servlet.annotation.WebServlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@WebServlet("/AsignaturaDAO")
public class AsignaturaDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int respuesta;
    private static final Logger LOGGER = Logger.getLogger(AsignaturaDAO.class.getName());
    public List<Asignatura> read(){
        String sql = "SELECT * FROM materia";
        List <Asignatura> lista = new ArrayList<>();
        try {
            con = cn.conexion();
            ps = con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Asignatura asignatura = new Asignatura();
                asignatura.setId_Asignatura(rs.getString(1));
                asignatura.setNombre(rs.getString(2));
                asignatura.setDepartamento(rs.getString(3));
                lista.add(asignatura);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public int create(Asignatura asignatura){
        String sql = "INSERT INTO materia(id_materia, nombre, departamento) VALUES(?,?,?)";
        try {
            con = cn.conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1,asignatura.getId_Asignatura());
            ps.setString(2,asignatura.getNombre());
            ps.setString(3,asignatura.getDepartamento());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return respuesta;
    }

    public Asignatura listarID(String id) throws SQLException {
        Asignatura asignatura = new Asignatura();
        String sql = "SELECT * FROM materia WHERE id_materia ="+ "'"+id +"'";
        LOGGER.info("consulta " +sql);
        try {
            con = cn.conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                asignatura.setId_Asignatura(rs.getString(1));
                asignatura.setNombre(rs.getString(2));
                asignatura.setDepartamento(rs.getString(3));
            }
        return asignatura;
        } catch (SQLException ignored){

        }
        return asignatura;
    }
    public int update(Asignatura asignatura){
        String sql = "UPDATE materia SET Nombre=?, departamento=? WHERE id_materia = ?";
        try {
            con = cn.conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1,asignatura.getNombre());
            ps.setString(2,asignatura.getDepartamento());
            ps.setString(3,asignatura.getId_Asignatura());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return respuesta;
    }
    public void delete(String id){
        String sql = "DELETE FROM materia WHERE id_materia = ?";
        try {
            con = cn.conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Asignatura buscar(String id){
        String sql = "SELECT * FROM materia WHERE id_materia=" + "'"+id +"'";
        Asignatura asignatura = new Asignatura();
        try {
            con = cn.conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                asignatura.setId_Asignatura(rs.getString(1));
                asignatura.setNombre(rs.getString(2));
                asignatura.setDepartamento(rs.getString(3));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return asignatura;
    }
}
