<jsp:useBean id="Usuario" scope="request" type="Modelo.Profesor"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--@elvariable id="Usuario" type="Modelo.Profesor"--%>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <title>Dashboard</title>
</head>
<body>
    <nav class="navbar navbar-expand-lg" style="background-color: #0A1D56">
        <div class="container-fluid">
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item" style="margin-top: 5px">
                        <form action="Controlador" method="POST">
                            <input type="hidden" name="menu" value="Principal">
                            <input type="hidden" name="accion" value="">
                                <img src="img/fasttrack-logo2.png" alt="50" width="140">
                        </form>
                    </li>
                    <li class="nav-item" style="margin-top: 10px">
                        <form action="Controlador" method="POST" target="myFrame">
                            <input type="hidden" name="menu" value="Asignar_Asignaturas">
                            <input type="hidden" name="accion" value="DEFAULT">
                            <button style="margin-left: 10px; border: none" class="btn btn-outline-light" type="submit">Asignar Asignaturas</button>
                        </form>
                    </li>
                    <li class="nav-item" style="margin-top: 10px">
                        <form action="Controlador" method="POST" target="myFrame">
                            <input type="hidden" name="menu" value="AdmonEstudiantes">
                            <input type="hidden" name="accion" value="READ">
                            <button style="margin-left: 10px; border: none" class="btn btn-outline-light" type="submit">Administrar Estudiantes</button>
                        </form>
                    </li>
                    <li class="nav-item" style="margin-top: 10px">
                        <form action="Controlador" method="POST" target="myFrame">
                            <input type="hidden" name="menu" value="AdmonAsignaturas">
                            <input type="hidden" name="accion" value="READ">
                            <button style="margin-left: 10px; border: none" class="btn btn-outline-light" type="submit">Administrar Asignaturas</button>
                        </form>
                    </li>
                    <li class="nav-item" style="margin-top: 10px">
                        <form action="Controlador" method="POST" target="myFrame">
                            <input type="hidden" name="menu" value="AdmonMatricula">
                            <input type="hidden" name="accion" value="READ">
                            <button style="margin-left: 10px; border: none" class="btn btn-outline-light" type="submit">Administrar Matriculas</button>
                        </form>
                    </li>
                </ul>
                <div class="dropdown" style="margin-right: 30px">
                    <button style="border: none; margin-left: 20px" class="btn btn-outline-light dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                        ${Usuario.getNombre()}
                    </button>
                    <ul class="dropdown-menu text-center">
                        <li><a class="dropdown-item" href="#">
                            <img src="img/user.png" alt="60" width="60">
                            </a>
                        </li>
                        <li><a class="dropdown-item" href="#">${Usuario.getID_Profesor()}</a></li>
                        <div class="dropdown-divider"></div>
                        <form action="Validar" method="POST">
                            <button name="accion" value="salir" class="dropdown-item" href="#">Salir</button>
                        </form>
                    </ul>
                </div>
            </div>
        </div>
    </nav>
    <div class="m-4" style="height: 550px;">
        <iframe name="myFrame" style="height: 100%; width: 100%"></iframe>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
</body>
</html>
