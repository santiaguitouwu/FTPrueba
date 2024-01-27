<%--@elvariable id="Asignatura" type="Modelo.Asignatura"--%>
<%--@elvariable id="Estudiante" type="Modelo.Estudiante"--%>
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
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <title>Asignar Asignaturas</title>
</head>
<body>
    <div class="d-flex">
        <div class="col-sm-4">
            <div class="card">
                <form action="Controlador?menu=Asignar_Asignaturas" method="POST">
                    <div class="card-body">
                        <div class="form-group">
                            <label>Datos del Estudiante</label>
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-6 d-flex" style="margin-right: 20px">
                                <input type="text" name="id_estudiante" class="form-control" placeholder="ID Estudiante">
                                <input type="submit" name="accion" value="BuscarEstudiante" class="btn btn-outline-info">
                            </div>
                            <div class="col-sm-6">
                                <input type="text" name="nombreEstudiante" value="${Estudiante.nombre} ${Estudiante.apellido}" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label>Datos Asignatura</label>
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-6 d-flex" style="margin-right: 20px">
                                <input type="text" name="id_asignatura" class="form-control" placeholder="ID Asignatura">
                                <input type="submit" name="accion" value="BuscarAsignatura" class="btn btn-outline-info">
                            </div>
                            <div class="col-sm-6">
                                <input type="text" name="nombreAsignatura" value="${Asignatura.nombre}" class="form-control">
                            </div>
                        </div>
                        <div>
                            <input type="submit" name="action" value="Agregar" class="btn btn-outline-info">
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <div class="col-sm-7">
            <div class="card">
                <div class="card-body">
                    <div class="d-flex col-sm-5 ml-auto">
                        <label>id estudiante: </label>
                        <input type="text" name="id_estudiante" class="form-control" placeholder="ID Estudiante">
                    </div>
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>ID Estudiante</th>
                                <th>Nombre</th>
                                <th>Apellido</th>
                                <th>ID Materia</th>
                                <th>Materia</th>
                                <th>Departamento</th>
                            </tr>
                        </thead>
                    </table>
                </div>
                <div class="card-footer">
                    <div>
                        <input type="submit" name="accion" value="Matricular" class="btn btn-success">
                        <input type="submit" name="accion" value="Cancelar" class="btn btn-danger">
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
</body>
</html>
