package Modelo;

import Config.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            // Buscar el último número existente en los correos electrónicos con el mismo formato
            String patronCorreoExistente = nombre + "." + apellido + "(\\d*)@fasttrack.com." + dominio;
            Pattern patron = Pattern.compile(patronCorreoExistente);
            int maxNumero = 0;
            for (String correo : listaEmails) {
                Matcher matcher = patron.matcher(correo);
                if (matcher.matches()) {
                    String numeroStr = matcher.group(1);
                    int numero = 0;
                    if (!numeroStr.isEmpty()) {
                        numero = Integer.parseInt(numeroStr);
                    }
                    maxNumero = Math.max(maxNumero, numero); //compara los dos números y escoge el más grande
                }
            }
            // Incrementar el número y modificar el correo generado existente
            nuevoEmail = nombre + "." + apellido + (maxNumero + 1) + "@fasttrack.com." + dominio;
        } else {
            LOGGER.info("El email no existe");
        }
        return nuevoEmail;
    }

    //consulta BD y trae el dominio del pais ingresado
    public String obtenerDominio(String pais) throws SQLException {
        String paiss = "'" + pais + "'";
        String sql = "SELECT * FROM paises WHERE pais =" + paiss;

        try {
            con = cn.conexion();
            ps = con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                dominio = rs.getString(2);
            }
        } catch (SQLException e){
            new RuntimeException(e);
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

    //realiza una lista de todos los emails existentes en BD, será usada en la genración del correo
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
