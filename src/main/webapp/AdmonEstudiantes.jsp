<%--@elvariable id="estudiante" type="Modelo.Estudiante"--%>
<%--@elvariable id="estudiantes" type="java.util.List"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="Modelo.Estudiante" %>

<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <title>Administrar Estudiantes</title>
</head>
<body>
<div class="d-flex">
    <div class="card col-sm-4">
        <div class="card-body">
            <form action="Controlador?menu=AdmonEstudiantes" method="POST">
                    <div class="form-group">
                        <label>IDENTIFICACIÓN 1</label>
                        <input type="text" value="${Estudiante.getID_Estudiante()}" name="textID_estudiante" class="form-control">
                    </div>
                <div class="form-group">
                    <label>NOMBRE</label>
                    <input type="text" value="${Estudiante.getNombre()}" name="textNombre" class="form-control">
                </div>
                <div class="form-group">
                    <label>APELLIDO</label>
                    <input type="text" value="${Estudiante.getApellido()}" name="textApellido" class="form-control">
                </div>
                <div class="form-group">
                    <label>TELEFONO</label>
                    <input type="text" value="${Estudiante.getTelefono()}" name="textTelefono" class="form-control">
                </div>
                <div class="form-group">
                    <label>EMAIL</label>
                    <input type="text" value="${Estudiante.getEmail()}" name="textEmail" class="form-control">
                </div>
                <div style="margin-top: 20px" class="d-flex justify-content-between">
                    <div class="d-flex justify-content-center">
                        <form>
                            <input type="hidden" name="accion" value="CREATE">
                            <button style="border: none; width: 120px; height: 40px; background-color: darkslateblue" class="btn btn-danger" type="submit">CREAR</button>
                        </form>
                    </div>
                    <div class="d-flex justify-content-center">
                        <form>
                            <input type="hidden" name="accion" value="UPDATE">
                            <button style="border: none; width: 120px; height: 40px; background-color: darkcyan" class="btn btn-danger" type="submit">ACTUALIZAR</button>
                        </form>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div style="margin-right: 20px" class="col-sm-8">
        <table class="table table-hover">
            <thead>
            <th>IDENTIFICACIÓN</th>
            <th>NOMBRE</th>
            <th>APELLIDO</th>
            <th>TELEFONO</th>
            <th>EMAIL</th>
            </thead>
            <tbody>
            <td>

                <c:forEach var="estu" items="${estudiantes}">
                    <tr>
                         <td>${estu.ID_Estudiante}</td>
                         <td>${estu.nombre}</td>
                         <td>${estu.apellido}</td>
                         <td>${estu.telefono}</td>
                         <td>${estu.email}</td>
                         <td>
                             <form action="Controlador" method="POST">
                                 <input type="hidden" name="menu" value="AdmonEstudiantes">
                                 <input type="hidden" name="accion" value="EDIT">
                                 <input type="hidden" name="id" value="${estu.ID_Estudiante}">
                                 <button style="border: none" class="btn btn-warning" type="submit">EDITAR</button>
                             </form>
                             <form action="Controlador" method="POST">
                                 <input type="hidden" name="menu" value="AdmonEstudiantes">
                                 <input type="hidden" name="accion" value="DELETE">
                                 <input type="hidden" name="id" value="${estu.ID_Estudiante}">
                                 <button style="border: none" class="btn btn-danger" type="submit">ELIMINAR</button>
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