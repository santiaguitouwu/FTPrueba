package Controlador;

import Modelo.Profesor;
import Modelo.ProfesorDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.GET;

import java.io.IOException;

public class Validar extends HttpServlet {
    ProfesorDAO profesorDAO = new ProfesorDAO();
    Profesor profesor = new Profesor();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("Estoy en el get");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accion = req.getParameter("accion");
        if (accion.equals("Ingresa")){
            String user = req.getParameter("txtuser"); //se obtienen los datos de ingreso del usuario
            String pass = req.getParameter("txtpass");
            profesor = profesorDAO.validar(user,pass);
            if (profesor.getID_Profesor()!=null){
                req.getRequestDispatcher("Controlador?accion=Principal").forward(req,resp); //si el usuario existe se redirecciona al controlador
            }else{
                req.getRequestDispatcher("index.jso").forward(req,resp); //si no existe se direcciona a la misma página de login
            }
        }
        else{req.getRequestDispatcher("index.jso").forward(req,resp);}
    }
}
