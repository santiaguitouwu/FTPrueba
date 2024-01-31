<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
  <title>Login</title>
</head>
<body>
<div class="container mt-4  col-lg-4">
  <div class="card col-sm-10" style="margin-top: 180px">
    <div class="card-body text-center">
      <form class="form-sign" action="Validar" method="POST">
        <div class="form-group text-center">
          <img src="img/logo_fasttrack.png" alt="300" width="300">
        </div>
        <div class="form-group" style="margin-top: 20px">
            <input type="text" name="txtuser" class="form-control" placeholder="Usuario">
        </div>
        <div class="form-group" style="margin-top: 20px">
            <input type="password" name="txtpass" class="form-control" placeholder="Contraseña">
        </div>
        <input type="submit" name="accion" value="Ingresar" class="btn btn-primary btn-b" style="margin-top: 20px;">
      </form>
    </div>
  </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
</body>
</html>