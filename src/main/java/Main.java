import Config.Conexion;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Conexion conn = new Conexion();
        System.out.println(conn.conexion());
    }
}
