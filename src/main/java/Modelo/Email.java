package Modelo;

import Config.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Email {
    String pais;
    String dominio;
    String Email;
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    private static final Logger LOGGER = Logger.getLogger(Email.class.getName());
    public Email() {
    }

    public String generarEmail(String nombre, String apellido, String pais) throws SQLException {
        Email email = new Email();
        List <String> listaEmails = new ArrayList<>();
        dominio=obtenerDominio(pais);
        nombre = nombre.toLowerCase();
        apellido = apellido.toLowerCase();
        String nuevoEmail = nombre + "." + apellido + "@fasttrack.com." + dominio;
        listaEmails = email.readEmail();
        if (listaEmails.contains(nuevoEmail)){
            LOGGER.info("El email ya existe");
            nuevoEmail = nombre + "." + apellido + "1@fasttrack.com." + dominio;
        } else {
            LOGGER.info("El email no existe");
        }
        return nuevoEmail;
    }

    public String obtenerDominio(String pais) throws SQLException {
        String paiss = "'" + pais + "'";
        String sql = "SELECT * FROM paises WHERE pais =" + paiss;

        con = cn.conexion();
        ps = con.prepareStatement(sql);
        rs=ps.executeQuery();
        while (rs.next()){
            dominio = rs.getString(2);
        }
    return dominio;
    }

    public List<Email> read(){
        String sql = "SELECT * FROM paises";
        List <Email> listaPaises = new ArrayList<>();
        try {
            con = cn.conexion();
            ps = con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Email email = new Email();
                email.setPais(rs.getString(1));
                listaPaises.add(email);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaPaises;
    }
    public List<String> readEmail(){
        String sql = "SELECT email FROM estudiante";
        List <String> listaEmails = new ArrayList<>();
        try {
            con = cn.conexion();
            ps = con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                String email = rs.getString(1);
                listaEmails.add(email);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaEmails;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
