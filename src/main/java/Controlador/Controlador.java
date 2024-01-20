package Controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.ServerErrorException;

import java.io.IOException;

public class Controlador extends HttpServlet {
    protected void ProcessRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
            String accion = request.getParameter("accion");
            switch (accion){
                case "Principal":
                    request.getRequestDispatcher("Principal.jsp").forward(request,response);
                    break;
            }
    }

}
