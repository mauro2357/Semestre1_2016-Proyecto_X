<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>ManagerFitness</title>
<meta charset="utf-8">
<link rel="stylesheet" href="css/reset.css" type="text/css" media="screen">
<link rel="stylesheet" href="css/style.css" type="text/css" media="screen">
<link rel="stylesheet" href="css/grid.css" type="text/css" media="screen">
<script src="js/jquery-1.6.3.min.js" type="text/javascript"></script>
<script src="js/tabs.js" type="text/javascript"></script>

</head>
<body id="page1">
<div class="bg">
  <!--==============================header=================================-->
  <header>
    <div class="menu-row">
      <div class="main">
        <nav>
          <ul class="menu wrapper">
            <li><a class="active" href="VistaHome.jsp">Cliente</a></li>
            <li><a href="VistaEventos.jsp">Actualidad</a></li>
            <li><a href="VistaAdministrador.jsp">Administrador</a></li>
            <li><a href="VistaEntrenador.jsp">Entrenador</a></li>
            <li><a href="VistaSugerencias.jsp">Sugerencias</a></li>
          </ul>
        </nav>
      </div>
    </div>
    <div class="main">
      <div class="wrapper p3">
        <h1><a href="VistaHome.jsp">ManagerFitness</a></h1>
      </div>
    </div>
    
    <ul class="tabs">
      <li><a href="#tab1">Manager Fitness</a></li>
      <li><a href="#tab2">Tus Rutinas y Dietas </a></li>
      <li><a href="#tab3">Conoce Tu Proceso</a></li>
    </ul>
    <div class="tab_container">
      <div id="tab1" class="tab_content">
        <div class="main">
          <div class="wrapper">
            <figure class="img-indent-r"><img src="images/page1-img1.jpg" alt=""></figure>
            <div class="extra-wrap">
              <div class="indent"> <strong class="title">TU MEJOR OPCI�N</strong>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div id="tab2" class="tab_content">
        <div class="main">
          <div class="wrapper">
            <figure class="img-indent-r"><img src="images/page1-img2.jpg" alt=""></figure>
            <div class="extra-wrap">
              <div class="indent"> <strong class="title">Ejercicio y Dieta</strong>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div id="tab3" class="tab_content">
        <div class="main">
          <div class="wrapper">
            <figure class="img-indent-r"><img src="images/page1-img3.jpg" alt=""></figure>
            <div class="extra-wrap">
              <div class="indent"> <strong class="title">Qu� Has Logrado</strong>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <section id="content">
    <div class="main">
      <div class="container_12">
        <div class="wrapper img-indent-bot">
          <article class="grid_4">
            <h3>Otras Opciones</h3>
            <ul class="list-1">
              <li>Conocer el IMC</li>
              <form method ="get" action = "ProcesoControlador">
              <span class="text-form"></span><span class="border">
                  <input type="text" placeholder = "Talla" name = "talla">
                  </span>
                  <span class="text-form"></span><span class="border">
                  <input type="text" placeholder = "Peso" name = "peso">
                  </span>
      				<button type="submit" name="formulario" value="imc" class="button-2">Resultado</button>
      				<span class="text-form"></span><span class="border">
                  <input id="demo" type="text" name="resultado" value="<% if (request.getAttribute("resultado")!= null)out.println(request.getAttribute("resultado"));%>" disabled="disabled" />
                  </span>
                  </form>
            </ul>
          </article>
         </div>
        </div>
    </div>
  </section>
  </header>
</div>
    