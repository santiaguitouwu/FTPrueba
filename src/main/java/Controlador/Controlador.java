package Controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.ServerErrorException;

import java.io.IOException;
import java.util.logging.Logger;

@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(Validar.class.getName());
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
            String accion = request.getParameter("accion");
            LOGGER.info("La acción es: "+accion);
            switch (accion){
                case "Principal":
                    request.getRequestDispatcher("Principal.jsp").forward(request,response);
                    break;
                default:
                    throw new AssertionError();
            }
    }

}
