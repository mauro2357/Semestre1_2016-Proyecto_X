<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>ManagerFitness | Entrenador</title>
<meta charset="utf-8">
<link rel="stylesheet" href="css/reset.css" type="text/css" media="screen">
<link rel="stylesheet" href="css/style.css" type="text/css" media="screen">
<link rel="stylesheet" href="css/grid.css" type="text/css" media="screen">

</head>
<body id="page4">
  <!--==============================header=================================-->
  <header>
    <div class="menu-row">
      <div class="main">
        <nav>
          <ul class="menu wrapper">
            <li><a href="VistaHome.jsp">Cliente</a></li>
            <li><a href="VistaEventos.jsp">Actualidad</a></li>
            <li><a href="VistaAdministrador.jsp">Administrador</a></li>
            <li><a class="active" href="VistaEntrenador.jsp">Entrenador</a></li>
            <li><a href="VistaSugerencias.jsp">Sugerencias</a></li>
          </ul>
        </nav>
      </div>
    </div>
    <div class="main">
      <div class="wrapper p3">
        <h1><a href="VistaHome.jsp">Manager Fitness</a></h1>
      </div>
    </div>
  </header>
    <ul class="tabs">
      <li><a href="#tab1">Agregar un Evento</a></li>
    </ul>
        <div class="tab_container">
        <div class="main">
          <div align="center" class="wrapper">
            <form id="contact-form" action="Eventoscontrolador" method="get">
              <fieldset>
              <br>
                 <span class="text-form"></span><span>
                 <br>
                 <br>
                  <input type="text" placeholder = "Fecha del evento" name = "fechaE">
                  </span>
                <span class="text-form"></span><span>
                <br>
                <br>
                  <input type="text" placeholder = "cedula entrenador" name = "idu">
                  </span>
                 <span class="text-form"></span><span >
                 <br>
                 <br>
                  <input type="text" placeholder = "Descripcion del evento" name ="nombre">
                  </span> 
                  <br>
                  <br>
                  <br>
                   <button type="submit" name="formulario" value="evento" class="button-2">Crear Evento </button>
                  </fieldset>
                  </form>
          <div class="wrapper">
            <div class="extra-wrap">
              </div>
            </div>
          </div>
        </div>
      </div>