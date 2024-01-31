<%--@elvariable id="asignatura" type="Modelo.Asignatura"--%>
<%--@elvariable id="asignaturas" type="java.util.List"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="Modelo.Asignatura" %>

<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <title>Administrar Estudiantes</title>
</head>
<body>
<% if (request.getAttribute("error") != null) { %>
<div class="alert alert-danger alert-dismissible fade show" role="alert">
    <strong>Error!</strong> Ha ocurrido un error con los datos ingresados, por favor verificar
    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
</div>
<% } %>
<div class="d-flex">
    <div class="card col-sm-4" style="height: fit-content; margin-right: 60px">
        <div class="card-body">
            <form action="Controlador?menu=AdmonAsignaturas" method="POST">
                <div class="form-group" style="margin-top: 20px">
                    <input type="text" value="${Asignatura.getId_Asignatura()}" name="textID_asignatura" class="form-control" placeholder="ID Asignatura">
                </div>
                <div class="form-group" style="margin-top: 20px">
                    <input type="text" value="${Asignatura.getNombre()}" name="textNombre" class="form-control" placeholder="Nombre">
                </div>
                <div class="form-group" style="margin-top: 20px">
                    <input type="text" value="${Asignatura.getDepartamento()}" name="textDepartamento" class="form-control" placeholder="Departamento">
                </div>
                <div style="text-align: center; margin-top: 20px">
                    <button style="border: none; margin-right: 40px" class="btn btn-success" type="submit" name="accion" value="CREATE">CREAR</button>
                    <button style="border: none" class="btn btn-primary" type="submit" name="accion" value="UPDATE">ACTUALIZAR</button>
                </div>
            </form>
        </div>
    </div>
    <div class="col-sm-7">
        <table class="table table-hover" style="margin-right: 50px">
            <thead>
            <th>ID Asignatura</th>
            <th>NOMBRE</th>
            <th>DEPARTAMENTO</th>
            </thead>
            <tbody>
            <td>

                <c:forEach var="asig" items="${asignaturas}">
                <tr>
            <td>${asig.id_Asignatura}</td>
            <td>${asig.nombre}</td>
            <td>${asig.departamento}</td>
            <td>
                <form action="Controlador?menu=AdmonAsignaturas" method="POST">
                    <input type="hidden" name="menu" value="AdmonAsignaturas">
                    <input type="hidden" name="id" value="${asig.id_Asignatura}">
                    <button style="border: none;" class="btn btn-warning" type="submit" name="accion" value="EDIT">EDITAR</button>
                    <button style="border: none;" class="btn btn-danger" type="submit" name="accion" value="DELETE">ELIMINAR</button>
                </form>
            </td>
            </tr>
            </c:forEach>
            </td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
</body>
</html>