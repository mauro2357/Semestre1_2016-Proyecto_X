<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "repositorios.EntrenadorRepositorio"%> 
<%@ page import = "java.util.LinkedList"%>  
<%@ page import = "repositorios.ProcesoRepositorio"%>
<%@ page import = "repositorios.RutinaRepositorio"%>
<%@ page import = "controladores.ProcesoControlador"%>
<%@ page import = "LogicaNegocio.*"%>
<%@ page import = "java.sql.ResultSet"%>

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
<%HttpSession s = request.getSession(true);
Datos_Usuarios datos = new Datos_Usuarios();
if (s.getAttribute("datos_usuario") != null){
	datos = (Datos_Usuarios) s.getAttribute("datos_usuario");
	if (datos.getTipo_usuario().equals("CLIN") && datos.getMensualidad() != null ){%>
		<script type="text/javascript">alert("A tu suscripcion le restan: "+ <%out.println(datos.getDias_restantes());%>+ " dias");</script>
<%}if(datos.getTipo_usuario().equals("CLIN") && datos.getMensualidad() == null ){%>
	<script type="text/javascript">alert("No tienes suscripciones activas");</script>	
<%
		}}
%>
</head>

<body id="page1">
<div class="bg">
  <header>
    <div class="menu-row">
      <div class="main">
        <nav>
          <ul class="menu wrapper">
         
          <%if(s.getAttribute("tipousuario") != null){
        	  if (s.getAttribute("tipousuario").equals("CLIN")){
        		  
        		  %> <%
        	  }
        	  if (s.getAttribute("tipousuario").equals("CLIN") || s.getAttribute("tipousuario").equals("ADMI")){%>
            <li><a class="active" href="VistaHome.jsp">Cliente</a></li>
            <%}if (s.getAttribute("tipousuario").equals("ENTR") || s.getAttribute("tipousuario").equals("ADMI")){ %>
            <li><a href="VistaEntrenador.jsp">Entrenador</a></li>
            <%}if (s.getAttribute("tipousuario").equals("ADMI")){ %>
            <li><a href="VistaAdministrador.jsp">Administrador</a></li>
            <%}} %>
            <li><a href="VistaEventos.jsp">Actualidad</a></li>
            <li><a href="VistaSugerencias.jsp">Sugerencias</a></li>
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
                  <button type="submit" name="formulario" value="logout" class="button-2" > <%if(s.getAttribute("tipousuario") == null){ out.println("Login");}else{ out.println("Cerrar Sesión");} %> </button>
              </span>
          </fieldset>
        </form>
      </div>
    </div>
    
    <ul class="tabs">
      <li><a href="#tab1">Manager Fitness</a></li>
      <%if(s.getAttribute("tipousuario") != null){
        	  if (s.getAttribute("tipousuario").equals("CLIN")){%>
      <li><a href="#tab2">Rutinas y Dietas </a></li>
      <li><a href="#tab3">Conoce Tu Proceso</a></li>
      <%}} %>
    </ul>
    <div class="tab_container">
      <div id="tab1" class="tab_content">
        <div class="main">
          <div class="wrapper">
            <figure class="img-indent-r"><img src="images/page1-img1.jpg" alt=""></figure>
            <div class="extra-wrap">
              <div class="indent"> <strong class="title">TU MEJOR OPCIÓN</strong>
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
             <div class="indent1"><form id="contact-form" action="" method="get">
              <fieldset>
		            <table style = "width:100%">
		            <thead>
		            	<tr>
						<th>Rutina</th> 
						<th>Descripcion</th>
						<th>Calorías</th>
						</tr>
						      </thead>
						       <tbody>
						<%
						LinkedList<Rutinas> lista = datos.getLista();
							for (int i=0;i<lista.size();i++)
							{
							   out.println("<tr>");
							   out.println("<td>"+lista.get(i).getNombre()+"</td>");
							   out.println("<td>"+lista.get(i).getDescripcion()+"</td>");
							   out.println("<td>"+lista.get(i).getCalorias()+"</td>");
							   out.println("</tr>");
							}
						%>
						  </tbody>
						</table>
		              </fieldset>
		            </form>
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
             <div class="indent1"><form id="contact-form" action="ProcesoControlador" method="get">
              <fieldset>
                  <span class="text-form"></span><span class="buttons">
                  <button type="submit" name="formulario" value="proceso" class="button-2" > Conocer mi proceso </button>
                  </span>
                  <br></br>
		            <table style = "width:100%">
		            <thead>
		            	<tr>
						<th>Fecha</th> 
						<th>Peso</th>
						<th>Estatura</th>
						<th>Proceso</th>
						<th>Rutina</th>
						<th>Observación</th>
						</tr>
						      </thead>
						       <tbody>
						<%
						LinkedList<Proceso> listaProceso = (LinkedList<Proceso>)request.getAttribute("lista");
						if(listaProceso!= null){
							for (int i=0;i<listaProceso.size();i++)
							{
							   out.println("<tr>");
							   out.println("<td>"+listaProceso.get(i).getFecha()+"</td>");
							   out.println("<td>"+listaProceso.get(i).getPeso()+"</td>");
							   out.println("<td>"+listaProceso.get(i).getEstatura()+"</td>");
							   out.println("<td>"+listaProceso.get(i).getProceso()+"</td>");
							   out.println("<td>"+listaProceso.get(i).getNombreRutina()+"</td>");
							   out.println("<td>"+listaProceso.get(i).getObservacion()+"</td>");
							   out.println("</tr>");
							}
							
						}
						
						%>
						  </tbody>
						</table>
		              </fieldset>
		            </form>
            </div>
          </div>
        </div>
      </div>
      </div>
      </div>
   <%if(s.getAttribute("tipousuario") != null){
        	  if (s.getAttribute("tipousuario").equals("CLIN")){%>    
    <section id="content">
    <div class="main">
      <div class="container_12">
      
        <article class="grid_8">
            <h2 class="img-indent-right" >MEMBRECIAS!!</h2>
            <div class="wrapper prev-indent-bot">
              <figure class="img-indent-right" ><img src="images/page1-img4.jpg" alt=""></figure>
              <div class="extra-wrap">
            </div>
            </div>
        </article>
      
        <div class="wrapper margin-bot">
        <form action="MembreciaControlador" method="get">
          <article class="grid_4">
            <h3>Principiante</h3>
            <ul class="list-1 img-indent-bot">
              <a>INCLUYE </a>
              <li><a>Asesoría </a></li>
              <li><a>Médico </a></li>
              <li><a>1 Hora Diaria </a></li>
              <li><a>Nutricionista </a></li>
              <li><a>Bonos </a></li>
              <a>$80.000 </a>
            </ul>
            <span class="text-form"></span><span class="buttons">
               <button type="submit" name="formulario" value="comprarPrincipiante" class="button-2"> Comprar </button>
            </span>
            </article>
           <article class="grid_4">
            <h3>Practicante</h3>
            <ul class="list-1 img-indent-bot">
              <a>INCLUYE </a>
              <li><a>Entrenador Personal </a></li>
              <li><a>Medico </a></li>
              <li><a>3 Horas Diarias </a></li>
              <li><a>Nutricionista </a></li>
              <li><a>Hidratacion </a></li>
              <a>$90.000 </a>
            </ul>
             <span class="text-form"></span><span class="buttons">
               <button type="submit" name="formulario" value="comprarPracticante" class="button-2"> Comprar </button>
            </span>
            </article>
            <article class="grid_4">
            <h3>Animalex</h3>
            <ul class="list-1 img-indent-bot">
              <a>INCLUYE</a>
              <li><a>Medico </a></li>
              <li><a>6 Horas Diarias </a></li>
              <li><a>Eventos Gratuitos </a></li>
              <li><a>Entrenador Personal</a></li>
              <li><a>Hidratacion </a></li>
              <a>$120.000 </a>
            </ul>
             <span class="text-form"></span><span class="buttons">
               <button type="submit" name="formulario" value="comprarAnimalex" class="button-2"> Comprar </button>
            </span>
            </article>
            </form>
          	 </div>
           </div>
           
      <section id="content">
       <div class="main">
        <div class="container_12">
        <div class="wrapper img-indent-bot">
          <article class="grid_8"> 
          <article class="grid_8">
          <h3 class="img-indent-right" >OTRAS OPCIONES!</h3>
            <br></br>
            <ul class="list-1 img-indent-bot">
              <h3><a><li>Conocer el Imc</li></a></h3>
              <form method ="get" action = "ProcesoControlador">
              	 <span class="text-form"></span><span class="border">
                  <input type="text" name="resultado" value="<% if (request.getAttribute("resultado")!= null)
                                                                  out.println(request.getAttribute("resultado"));
                                                                  else out.println(" "); %>" disabled="disabled" />
                  </span>
      			  <button type="submit" name="formulario" value="imc" class="button-2">IMC</button>
      			  <br></br>
              </form>
              
              <h3><a><li >Estado Mensualidad</li></a></h3>
              <form method ="get" action = "RecibosControlador">
              	 <span class="text-form"></span><span class="border">
                 <input type="text" name="mensualidad" value="<% if (request.getAttribute("mensualidad")!= null)
                                                                  out.println(request.getAttribute("mensualidad"));
                                                                  else out.println(" "); %>" disabled="disabled" />
                  </span>
      			  <button type="submit" name="formulario" value="estado" class="button-2">MENSUALIDAD</button>
      			  
              </form>
              
            </ul>
          </article>
         </div>
         </div>
         </div>
         </section>
        </div>
    </div>
  </section>
  <%}} %>
  </header>
</div>
    