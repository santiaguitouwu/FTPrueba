package Controlador;

import Modelo.Profesor;
import Modelo.ProfesorDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.logging.Logger;

@WebServlet("/Validar")
public class Validar extends HttpServlet {
    ProfesorDAO profesorDAO = new ProfesorDAO();
    Profesor profesor = new Profesor();
    private static final Logger LOGGER = Logger.getLogger(Validar.class.getName());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("Estoy en el get");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String accion = req.getParameter("accion");
        LOGGER.info(accion);
        if (accion.equals("Ingresar")){
            String user = req.getParameter("txtuser"); //se obtienen los datos de ingreso del usuario
            String pass = req.getParameter("txtpass");
            profesor = profesorDAO.validar(user,pass);
            LOGGER.info("Usuario: " + user + ", Contrasena: " + pass);
            if (profesor.getID_Profesor()!=null){
                req.setAttribute("Usuario",profesor); //se envian los datos a mostrar en el archivo Principal.jsp
                req.getRequestDispatcher("Controlador?menu=Principal").forward(req,resp); //si el usuario existe se redirecciona al controlador
                LOGGER.info("Se encuentra el usuario y contraseña en BD");
            }else{
                req.getRequestDispatcher("index.jsp").forward(req,resp); //si no existe se direcciona a la misma página de login
                LOGGER.info("No se encuentra el usuario y contraseña en BD");
            }
        }
        if (accion.equals("Reingresar")){
            LOGGER.info("Ingresa al segundo if de la funcion Validar");
            req.setAttribute("Usuario", profesor);
            req.getRequestDispatcher("Controlador?menu=Principal");
        }
        else{req.getRequestDispatcher("index.jsp").forward(req,resp);}//si se presiona algún otro botón retorna a la misma página
    }
}
