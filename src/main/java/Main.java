import Modelo.Email;
import Modelo.Estudiante;
import Modelo.EstudianteDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        Email email = new Email();
        String emailgenerado = email.generarEmail("Santiago", "Jimenez", "Colombia");
        System.out.println(emailgenerado);

    }
}
