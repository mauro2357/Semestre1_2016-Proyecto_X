<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>ManagerFitness | Contactanos</title>
<meta charset="utf-8">
<link rel="stylesheet" href="css/reset.css" type="text/css" media="screen">
<link rel="stylesheet" href="css/style.css" type="text/css" media="screen">
<link rel="stylesheet" href="css/grid.css" type="text/css" media="screen">
<%HttpSession s = request.getSession(true); %>
</head>

<body id="page5">
<div class="bg">
  <!--==============================header=================================-->
  <header>
    <div class="menu-row">
      <div class="main">
        <nav>
          <ul class="menu wrapper">
           <%if(s.getAttribute("tipousuario") != null){
        	  if (s.getAttribute("tipousuario").equals("CLIN") || s.getAttribute("tipousuario").equals("ADMI")){%>
            		<li><a href="VistaHome.jsp">Cliente</a></li>
             <%}if (s.getAttribute("tipousuario").equals("ENTR") || s.getAttribute("tipousuario").equals("ADMI")){ %>
             		<li><a href="VistaEntrenador.jsp">Entrenador</a></li>
             <%}if (s.getAttribute("tipousuario").equals("ADMI")){ %>
             		<li><a href="VistaAdministrador.jsp">Administrador</a></li>
             <%}} %>
            <li><a href="VistaEventos.jsp">Actualidad</a></li>
            <li><a class="active"  href="VistaSugerencias.jsp">Sugerencias</a></li>
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
                  <button type="submit" name="formulario" value="logout" class="button-2" > Cerrar Sesión </button>
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
        <div class="wrapper">
          <article class="grid_8">
            <h3>Sugerencias, Quejas, Preguntas y Reclamos</h3>
            <form id="contact-form" action="SugerenciaControlador" method="get" enctype="multipart/form-data">
              <fieldset>
                  <div class="wrapper">
                  <span class="text-form"></span>
                  	<select name="tipo">
                  	<option>Seleccione un tipo</option>
                  	<option value="SUGERENCIA">Sugerencia</option>
                  	<option value="PREGUNTA">Pregunta</option>
                  	<option value="QUEJA">Queja</option>
                  	<option value="RECLAMO">Reclamo</option>
                  </select>
                  <br>
                  <div class="text-form">Descripción:</div>
                  <div class="extra-wrap">
                    <div class="border">
                      <textarea name="descripcion"></textarea>
                    </div>
                    <div class="clear"></div>
                    <div class="buttons">
                    <button name = "formulario" value = "sugerencia" class ="button-2">Enviar</button>
                     </div>
                  </div>
                </div>
              </fieldset>
            </form>
          </article>
          <article class="grid_4">
            <div class="indent-left2">
              <h3>Información de Contacto</h3>
              <!-- <figure class="img-indent-bot">
                <iframe width="240" height="180" src="http://maps.google.com/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=&amp;q=Brooklyn,+New+York,+NY,+United+States&amp;aq=0&amp;sll=37.0625,-95.677068&amp;sspn=61.282355,146.513672&amp;ie=UTF8&amp;hq=&amp;hnear=Brooklyn,+Kings,+New+York&amp;ll=40.649974,-73.950005&amp;spn=0.01628,0.025663&amp;z=14&amp;iwloc=A&amp;output=embed"></iframe>
              </figure>-->
              <dl>
                <dt>Rionegro</dt>
                <dd><span>Celular:</span> 311 721 97 71</dd>
                <dd><span>Telefono:</span> 869 43 94</dd>
                <dd><span>Email:</span> <a href="#">info@managerfitness.com</a></dd>
              </dl>
            </div>
          </article>
        </div>
      </div>
    </div>
  </section>
</div>
    