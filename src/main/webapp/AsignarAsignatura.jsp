<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="Asignatura" type="Modelo.Asignatura"--%>
<%--@elvariable id="Estudiante" type="Modelo.Estudiante"--%>
<%--@elvariable id="listaAsignatura" type="java.util.List"--%>
<%--
  Created by IntelliJ IDEA.
  User: M
  Date: 22/01/2024
  Time: 8:31 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Modelo.Estudiante" %>
<%@ page import="Modelo.Asignatura" %>
<%@ page import="Modelo.AsignarMateria" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <title>Asignar Asignaturas</title>
</head>
<body>
    <div class="d-flex">
        <div class="col-sm-4"style="margin-right: 30px">
            <div class="card">
                <form action="Controlador?menu=Asignar_Asignaturas" method="POST">
                    <div class="card-body">
                        <div class="form-group">
                            <label>Datos del Estudiante</label>
                        </div>
                        <div class="form-group d-flex" style="margin-top: 10px">
                            <div class="col-sm-6 d-flex" style="margin-right: 20px">
                                <input type="text" name="id_estudiante" class="form-control" placeholder="ID">
                                <input type="submit" name="accion" value="BuscarEstudiante" class="btn btn-primary btn-sm">
                            </div>
                            <div class="col-sm-5">
                                <input type="text" name="nombreEstudiante" value="${Estudiante.nombre} ${Estudiante.apellido}" class="form-control" disabled>
                            </div>
                        </div>
                        <div class="form-group" style="margin-top: 20px;">
                            <label>Datos Asignatura</label>
                        </div>
                        <div class="form-group d-flex" style="margin-top: 10px">
                            <div class="col-sm-6 d-flex" style="margin-right: 20px">
                                <input type="text" name="id_asignatura" class="form-control" placeholder="ID">
                                <input type="submit" name="accion" value="BuscarAsignatura" class="btn btn-primary btn-sm">
                            </div>
                            <div class="col-sm-5">
                                <input type="text" name="nombreAsignatura" value="${Asignatura.nombre}" class="form-control" disabled>
                            </div>
                        </div>
                        <div style="margin-top: 20px; text-align: center">
                            <input type="submit" name="accion" value="Agregar" class="btn btn-outline-primary">
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <div class="col-sm-7">
            <div class="card">
                <div class="card-body">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>ID ASIGNATURA</th>
                                <th>
                                    NOMBRE
                                    ASIGNATURA
                                </th>
                                <th>DEPARMENTO</th>
                                <th>ID ESTUDIANTE</th>
                                <th>NOMBRE ESTUDIANTE</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="dato" items="${listaAsignatura}">
                                <tr>
                                    <td>${dato.ID_Asignatura}</td>
                                    <td>${dato.nombreAsignatura}</td>
                                    <td>${dato.nombreDepartamento}</td>
                                    <td>${dato.ID_Estudiante}</td>
                                    <td>${dato.nombreEstudiante} ${dato.apellidoEstudiante}</td>
                                    <td><input type="hidden" name="menu" value="AdmonEstudiantes">
                                        <button style="border: none;" class="btn btn-danger" type="submit" name="accion" value="DELETE">ELIMINAR</button>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="card-footer">
                    <div>
                        <form action="Controlador?menu=Asignar_Asignaturas" method="POST">
                            <input type="submit" name="accion" value="Matricular" class="btn btn-success">
                            <input type="submit" name="accion" value="Cancelar" class="btn btn-danger">
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
</body>
</html>
