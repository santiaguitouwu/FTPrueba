package Controlador;

import Modelo.Asignatura;
import Modelo.AsignaturaDAO;
import Modelo.Estudiante;
import Modelo.EstudianteDAO;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.ServerErrorException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(Controlador.class.getName());
    Estudiante estudiante = new Estudiante();
    EstudianteDAO estudianteDAO = new EstudianteDAO();
    Asignatura asignatura = new Asignatura();
    AsignaturaDAO asignaturaDAO = new AsignaturaDAO();
    String ID_Estu;
    String ID_Asig;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        LOGGER.info("La acción es: "+accion);
        LOGGER.info("el menu es: " +menu);
        if (menu.equals("Principal")){
            request.getRequestDispatcher("Principal.jsp").forward(request,response);
        }
        if (menu.equals("AdmonEstudiantes")){
            LOGGER.info("Entra a AdmonEstudiantes");
            switch (accion){
                case "CREATE":
                    LOGGER.info("Entra a CREATE");
                    String ID_Estudiante = request.getParameter("textID_estudiante");
                    String Nombre = request.getParameter("textNombre");
                    String Apellido = request.getParameter("textApellido");
                    String Telefono = request.getParameter("textTelefono");
                    String Email = request.getParameter("textEmail");
                    estudiante.setID_Estudiante(ID_Estudiante);
                    estudiante.setNombre(Nombre);
                    estudiante.setApellido(Apellido);
                    estudiante.setTelefono(Telefono);
                    estudiante.setEmail(Email);
                    estudianteDAO.create(estudiante);
                    LOGGER.info("va a despachar el request");
                    request.getRequestDispatcher("Controlador?menu=AdmonEstudiantes&accion=READ").forward(request,response);
                    break;
                case "READ":
                    LOGGER.info("Comenzara el proceso de consulta (READ)");
                    List<Estudiante> lista = estudianteDAO.read();
                    request.setAttribute("estudiantes", lista);
                    LOGGER.info("se envia la lista"+lista);
                    break;
                case "EDIT":
                    LOGGER.info("Entra al UPDATE");
                    ID_Estu = request.getParameter("id");
                    try {
                        LOGGER.info("el ID a modificar es "+ ID_Estu);
                        Estudiante estudiante = estudianteDAO.listarID(ID_Estu);
                        if (estudiante != null){
                            LOGGER.info("Se obtiene algo de la consulta");
                            String id = estudiante.getGetID_Estudiante();
                            LOGGER.info("ID: "+ id);
                        } else {LOGGER.info("no se obtienen nada");}
                        LOGGER.info("Estudiante:" + estudiante);
                        request.setAttribute("Estudiante", estudiante);
                        request.getRequestDispatcher("Controlador?menu=AdmonEstudiantes&accion=READ").forward(request,response);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "UPDATE":
                    LOGGER.info("Entra a UPDATE");
                    String ID_Estudiante1 = request.getParameter("textID_estudiante");
                    String Nombre1 = request.getParameter("textNombre");
                    String Apellido1 = request.getParameter("textApellido");
                    String Telefono1 = request.getParameter("textTelefono");
                    String Email1 = request.getParameter("textEmail");
                    estudiante.setID_Estudiante(ID_Estudiante1);
                    estudiante.setNombre(Nombre1);
                    estudiante.setApellido(Apellido1);
                    estudiante.setTelefono(Telefono1);
                    estudiante.setEmail(Email1);
                    LOGGER.info("Empleado a actualizar" + estudiante);
                    estudianteDAO.update(estudiante);
                    request.getRequestDispatcher("Controlador?menu=AdmonEstudiantes&accion=READ").forward(request,response);
                case "DELETE":
                    LOGGER.info("Entra al DELETE");
                    ID_Estu = request.getParameter("id");
                    LOGGER.info("el ID a modificar es "+ ID_Estu);
                    estudianteDAO.delete(ID_Estu);
                    request.getRequestDispatcher("Controlador?menu=AdmonEstudiantes&accion=READ").forward(request,response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("AdmonEstudiantes.jsp").forward(request,response);
        }
        if (menu.equals("AdmonAsignaturas")){
            LOGGER.info("Entra a AdmonAsignaturas");
            switch (accion){
                case "CREATE":
                    LOGGER.info("Entra a CREATE");
                    String ID_Asignatura = request.getParameter("textID_asignatura");
                    String Nombre = request.getParameter("textNombre");
                    String Departamento = request.getParameter("textDepartamento");
                    LOGGER.info("Datos: " + ID_Asignatura+Nombre+Departamento);
                    asignatura.setId_Asignatura(ID_Asignatura);
                    asignatura.setNombre(Nombre);
                    asignatura.setDepartamento(Departamento);
                    asignaturaDAO.create(asignatura);
                    LOGGER.info("va a despachar el request");
                    request.getRequestDispatcher("Controlador?menu=AdmonAsignaturas&accion=READ").forward(request,response);
                    break;
                case "READ":
                    LOGGER.info("Comenzara el proceso de consulta (READ)");
                    List<Asignatura> lista = asignaturaDAO.read();
                    request.setAttribute("asignaturas", lista);
                    LOGGER.info("se envia la lista"+lista);
                    break;
                case "EDIT":
                    LOGGER.info("Entra al EDIT");
                    ID_Asig = request.getParameter("id");
                    try {
                        LOGGER.info("el ID a modificar es "+ ID_Asig);
                        Asignatura asignatura = asignaturaDAO.listarID(ID_Asig);
                        if (asignatura != null){
                            LOGGER.info("Se obtiene algo de la consulta");
                            String id = asignatura.getId_Asignatura();
                            LOGGER.info("ID: "+ id);
                        } else {LOGGER.info("no se obtienen nada");}
                        LOGGER.info("Asignatura:" + asignatura);
                        request.setAttribute("Asignatura", asignatura);
                        request.getRequestDispatcher("Controlador?menu=AdmonAsignaturas&accion=READ").forward(request,response);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "UPDATE":
                    LOGGER.info("Entra a UPDATE");
                    String ID_Asignatura1 = request.getParameter("textID_asignatura");
                    String Nombre1 = request.getParameter("textNombre");
                    String Departamento1 = request.getParameter("textDepartamento");
                    asignatura.setId_Asignatura(ID_Asignatura1);
                    asignatura.setNombre(Nombre1);
                    asignatura.setDepartamento(Departamento1);
                    LOGGER.info("Asignatura a actualizar" + asignatura);
                    asignaturaDAO.update(asignatura);
                    request.getRequestDispatcher("Controlador?menu=AdmonAsignaturas&accion=READ").forward(request,response);
                case "DELETE":
                    LOGGER.info("Entra al DELETE");
                    ID_Asig = request.getParameter("id");
                    LOGGER.info("el ID a modificar es "+ ID_Asig);
                    asignaturaDAO.delete(ID_Asig);
                    request.getRequestDispatcher("Controlador?menu=AdmonAsignaturas&accion=READ").forward(request,response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("AdmonAsignaturas.jsp").forward(request,response);
        }
        if (menu.equals("Asignar_Asignaturas")) {
            request.getRequestDispatcher("AsignarAsignatura.jsp").forward(request, response);
        }
    }
}
