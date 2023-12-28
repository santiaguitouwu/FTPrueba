<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
  <title>JSP FIle</title>
</head>
<body>
<div class="container mt-4  col-lg-4">
  <div class="card col-sm-10">
    <div class="card-body text-center">
      <form class="form-sign" action="Validar" method="post">
        <div class="form-group text-center">
          <h3>Aquí va una imagen</h3>
          <label>Bienvenido!</label>
        </div>
        <div class="form-group">
          <label>Usuario</label>
          <input type="text"name="txtuser" class="form-control">
        </div>
        <div class="form-group">
          <label>Contraseña</label>
          <input type="password"name="txtpass" class="form-control">
        </div>
        <input type="submit" name="accion" value="Ingresar" class="btn btn-primary btn-b">
      </form>
    </div>
  </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
</body>
</html>