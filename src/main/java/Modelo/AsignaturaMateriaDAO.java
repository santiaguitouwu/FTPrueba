package Modelo;

import Config.Conexion;
import Controlador.Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class AsignaturaMateriaDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int respuesta;
    private static final Logger LOGGER = Logger.getLogger(AsignarMateria.class.getName());

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
    public List<AsignarMateria> readXestudiante(String id){
        String sql = "SELECT\n" +
                "\tasig.id_estudiante AS id_estudiante,\n" +
                "\tasig.id_materia AS id_materia,\n" +
                "    estu.nombre AS nombre_estudiante,\n" +
                "    estu.apellido AS apellido_estudiante,\n" +
                "    mate.nombre AS nombre_asignatura,\n" +
                "    mate.departamento AS departamento_asignatura\n" +
                "FROM\n" +
                "    estudiante_materia asig\n" +
                "    INNER JOIN estudiante estu ON asig.id_estudiante = estu.id_estudiante\n" +
                "    INNER JOIN materia mate ON asig.id_materia = mate.id_materia\n" +
                "WHERE asig.id_estudiante=" + "'"+ id +"'";
        List <AsignarMateria> lista = new ArrayList<>();
        try {
            con = cn.conexion();
            ps = con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                AsignarMateria asignarMateria = new AsignarMateria();
                asignarMateria.setID_Estudiante(rs.getString(1));
                asignarMateria.setID_Asignatura(rs.getString(2));
                asignarMateria.setNombreEstudiante(rs.getString(3));
                asignarMateria.setApellidoEstudiante(rs.getString(4));
                asignarMateria.setNombreAsignatura(rs.getString(5));
                asignarMateria.setNombreDepartamento(rs.getString(6));
                lista.add(asignarMateria);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public List<AsignarMateria> readXasignatura(String id){
        String sql = "SELECT\n" +
                "\tasig.id_estudiante AS id_estudiante,\n" +
                "\tasig.id_materia AS id_materia,\n" +
                "    estu.nombre AS nombre_estudiante,\n" +
                "    estu.apellido AS apellido_estudiante,\n" +
                "    mate.nombre AS nombre_asignatura,\n" +
                "    mate.departamento AS departamento_asignatura\n" +
                "FROM\n" +
                "    estudiante_materia asig\n" +
                "    INNER JOIN estudiante estu ON asig.id_estudiante = estu.id_estudiante\n" +
                "    INNER JOIN materia mate ON asig.id_materia = mate.id_materia\n" +
                "WHERE asig.id_materia=" + "'"+ id +"'";

        List <AsignarMateria> lista = new ArrayList<>();

        try {
            con = cn.conexion();
            ps = con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                AsignarMateria asignarMateria = new AsignarMateria();
                asignarMateria.setID_Estudiante(rs.getString(1));
                asignarMateria.setID_Asignatura(rs.getString(2));
                asignarMateria.setNombreEstudiante(rs.getString(3));
                asignarMateria.setApellidoEstudiante(rs.getString(4));
                asignarMateria.setNombreAsignatura(rs.getString(5));
                asignarMateria.setNombreDepartamento(rs.getString(6));
                lista.add(asignarMateria);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public void delete(String id_estudiante, String id_materia){
        String sql = "DELETE FROM estudiante_materia WHERE id_estudiante = ? AND id_materia = ?";
        try {
            con = cn.conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1,id_estudiante);
            ps.setString(2,id_materia);
            ps.executeUpdate();
            LOGGER.info("Se elimina correctamente");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
