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
    <div class="col-sm-12">
        <div class="card">
            <div class="card-body">
                <form action="Controlador?menu=AdmonMatricula" method="POST">
                    <div class="d-flex col-sm-5 ml-auto">
                        <select name="tipoConsulta" class="form-select" aria-label="Default select example">
                            <option selected>Valor a Consultar</option>
                            <option value="Xestudiante">ID del Estudiante</option>
                            <option value="Xmateria">ID de la Materia</option>
                        </select>
                        <input type="text" name="id" class="form-control" placeholder="ID a consultar">
                        <input type="submit" name="accion" value="Consultar" class="btn btn-outline-info">
                    </div>
                </form>
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
                            <td>
                                <form action="Controlador?menu=AdmonMatricula" method="POST">
                                    <input type="hidden" name="menu" value="AdmonMatricula">
                                    <input type="hidden" name="id_estudiante" value="${dato.ID_Estudiante}">
                                    <input type="hidden" name="id_asignatura" value="${dato.ID_Asignatura}">
                                    <button style="border: none;margin-top: 10px;" class="btn btn-danger" type="submit" name="accion" value="DELETE">DESASIGNAR</button>
                                 </form>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
</body>
</html>