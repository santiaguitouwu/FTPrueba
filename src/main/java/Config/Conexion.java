package Config;

import java.sql.*;

public class Conexion {
    Connection conn;
    String url = "jdbc:postgresql://localhost:5432/PTFT";
    String user = "postgres";
    String pass = "1193101605";
    public Connection conexion(){
        try {
            conn = DriverManager.getConnection(url,user,pass);
            System.out.println("Conexión a BD Exitosa");
        } catch (Exception e){
            System.out.println(e);
        }
        return conn;
    }
}


