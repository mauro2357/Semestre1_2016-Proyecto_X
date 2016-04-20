<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "LogicaNegocio.Eventos"%> 
<%@ page import = "repositorios.EventosRepositorio"%> 
<%@ page import = "java.util.LinkedList"%> 
<!DOCTYPE html>
<html lang="en">
<head>
<title>ManagerFitness | Actualidad</title>
<meta charset="utf-8">
<link rel="stylesheet" href="css/reset.css" type="text/css" media="screen">
<link rel="stylesheet" href="css/style.css" type="text/css" media="screen">
<link rel="stylesheet" href="css/grid.css" type="text/css" media="screen">

</head>
<body id="page2">
<div class="bg">
  <!--==============================header=================================-->
  <header>
    <div class="menu-row">
      <div class="main">
        <nav>        
          <ul class="menu wrapper">
            <li><a href="VistaHome.jsp">Cliente</a></li>
            <li><a class="active" href="VistaEventos.jsp">Actualidad</a></li>
            <li><a href="VistaAdministrador.jsp">Administrador</a></li>
            <li><a href="VistaEntrenador.jsp">Entrenador</a></li>
            <li><a href="VistaAdministrador.jsp">Sugerencias</a></li>
          </ul>
        </nav>
      </div>
    </div>
    <div class="main">
      <div class="wrapper p3">
        <h1><a href="VistaHome.jsp">ManagerFitness</a></h1>
        <form id="search-form" action="LoginControlador" method="post" enctype="multipart/form-data">
          <fieldset>
              <span class="text-form"></span><span class="buttons">
                  <button type="submit" name="formulario" value="logout" class="button-2" > Cerrar Sesi�n </button>
              </span>
          </fieldset>
        </form>
      </div>
    </div>
    <div class="row-bot"></div>
  </header>
  <!--==============================content================================-->
  <section id="content">
    <div class="main">
      <div class="container_12">
        <div class="wrapper margin-bot">
        <article class="grid_8">
            <h3>Eventos</h3>
            <table border="1">
				<tr>
				<td>Fecha</td>
				<td>Descripcion</td>
				<td>Entrenador</td>
				<td>telefono</td>
				</tr>
				<%
				LinkedList<Eventos> lista = EventosRepositorio.getEventos();
				for (int i=0;i<lista.size();i++)
				{
				   out.println("<tr>");
				   out.println("<td>"+lista.get(i).getId()+"</td>");
				   out.println("<td>"+lista.get(i).getNombre()+"</td>");
				   out.println("<td>"+lista.get(i).getApellido()+"</td>");
				   out.println("<td>"+lista.get(i).getTelefono()+"</td>");
				   out.println("</tr>");
				}
				%>
				</table>
          </article>
        </div>
      </div>
    </div>
  </section>
</div>