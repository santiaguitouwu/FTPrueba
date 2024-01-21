import Config.Conexion;
import Modelo.ProfesorDAO;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        ProfesorDAO profesor = new ProfesorDAO();
        profesor.validar("1193101605", "1193101605");
    }
}
