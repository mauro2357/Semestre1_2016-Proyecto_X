<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "repositorios.EntrenadorRepositorio"%> 
<%@ page import = "java.util.LinkedList"%>  
<%@ page import = "repositorios.ProcesoRepositorio"%>
<%@ page import = "repositorios.RutinaRepositorio"%>
<%@ page import = "controladores.ProcesoControlador"%>
<%@ page import = "LogicaNegocio.*"%>
<%@ page import = "repositorios.ConsultasRepositorio"%>
<!DOCTYPE html>
<html lang="en">
<%HttpSession s = request.getSession(true); %>
<head>

<title>ManagerFitness | Entrenador</title>
<meta charset="utf-8">
<link rel="stylesheet" href="css/reset.css" type="text/css" media="screen">
<link rel="stylesheet" href="css/style.css" type="text/css" media="screen">
<link rel="stylesheet" href="css/grid.css" type="text/css" media="screen">
<style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
th, td {
    padding: 5px;
    text-align: left;
}
</style>

</head>
<body id="page3">
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
            		<li><a class="active" href="VistaEntrenador.jsp">Entrenador</a></li>
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
                  <button type="submit" name="formulario" value="logout" class="button-2" > Cerrar Sesión </button>
              </span>
          </fieldset>
        </form>
      </div>
    </div>
    
    <ul class="tabs">
    <%if(s.getAttribute("tipousuario") != null){
        	  if (s.getAttribute("tipousuario").equals("ENTR")){%>
      <li><a href="#tab1">Crear Evento</a></li>
      <%}} %>
      <li><a href="#tab2">Crear Proceso </a></li>
      <li><a href="#tab3">Cancelar Evento </a></li>
    </ul>
        <div class="tab_container">
        <%if(s.getAttribute("tipousuario") != null){
        	  if (s.getAttribute("tipousuario").equals("ENTR")){%>
        
      <div id="tab1" class="tab_content">
        <div class="main">
          <div class="wrapper">
          <figure class="img-indent-r"><img src="images/page3-img3.jpg" alt=""></figure>
          <div class="extra-wrap">
            <div class="indent1"><form id="contact-form" action="EventosControlador" method="get">
              <fieldset>
                <span class="text-form"></span><span>
                  <input type="date" placeholder = "Fecha del Evento" name = "fechaE">
                  </span>
                  <br></br>
                <span class="text-form"></span><span>
                  <input type="text" placeholder = "Descripcion del Evento" name = "nombre">
                  </span>
                  <br></br>
                  <span class="text-form"></span><span class="buttons">
                  <button type="submit" name="formulario" value="evento" class="button-2"> Crear </button>
                  </span>
              </fieldset>
            </form>
            </div>
          </div>
        </div>
      </div>
      </div>
      <%}} %>
      <div id="tab2" class="tab_content">
        <div class="main">
          <div class="wrapper">
            <figure class="img-indent-r"><img src="images/page1-img3.jpg" alt=""></figure>
            <div class="extra-wrap">
              <div class="indent"> <form id="contact-form" action="ProcesoControlador" method="get">
              <fieldset>
                 <span class="text-form"></span><span>
                  <input type="text" placeholder = "Cedula Cliente" name ="id">
                  </span> 
                  <br></br>
                  <span class="text-form"></span><span>
                  <input type="text" placeholder = "Peso" name ="peso">
                  </span> 
                  <br></br>
                  <span class="text-form"></span><span>
                  <input type="text" placeholder = "Estatura" name ="estatura">
                  </span> 
                  <span class="text-form"></span><span>
                  <br>Tipo Proceso: <select name="tipoProceso"> 
                    <%LinkedList<TipoProceso> lista = ProcesoRepositorio.getTipoProceso();
                        for (int i=0;i<lista.size();i++) {
                    %>                    
                    <option value="<%=lista.get(i).getCodigo()%>"><%=lista.get(i).getDescripcion()%></option>                    
                    <%
                    }
                    %>
                    </select><br>	
                  </span> 
                  <span class="text-form"></span><span>
                  <br>Rutina: <select name="rutina"> 
                    <%LinkedList<Rutinas> lista1 = RutinaRepositorio.getRutinas();
                        for (int i=0;i<lista1.size();i++) {
                    %>                    
                    <option value="<%=lista1.get(i).getCodigo()%>"><%=lista1.get(i).getNombre()%></option>                    
                    <%
                    }
                    %>
                    </select><br>	
                  </span> 
                  <span class="text-form"></span><span>
                  <input type="text" placeholder = "Observacion" name ="observacion">
                  </span> 
                  <br></br>
                  
                  <span class="text-form"></span><span class="buttons">
                  <button type="submit" name="formulario" value="crearproceso" class="button-2"> Crear </button>
                  </span>
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
          <figure class="img-indent-r"><img src="images/page3-img3.jpg" alt=""></figure>
          <div class="extra-wrap">
            <div class="indent1"><form id="contact-form" action="EventosControlador" method="get">
              <fieldset>
              <table style = "width:67%">
            <thead>
            	<tr>
				<th>Fecha</th> 
				<th>Descripcion</th>
				<th>Entrenador</th>
				<th>Código</th>
				</tr>
				      </thead>
				       <tbody>
				<%
				LinkedList<Eventos> listas = EntrenadorRepositorio.getEventos();
				for (int i=0;i<listas.size();i++)
				{
				   out.println("<tr>");
				   out.println("<td>"+listas.get(i).getFecha()+"</td>");
				   out.println("<td>"+listas.get(i).getDescripcion()+"</td>");
				   out.println("<td>"+listas.get(i).getNombreEntrenador()+"</td>");
				   out.println("<td>"+listas.get(i).getCodigo()+"</td>");
				   out.println("</tr>");
				}
				%>
				  </tbody>
				</table>
				<br></br>
				<span class="text-form"></span><span>
                  <input type="text" placeholder = "Codigo del Evento" name ="cancelar">
                  </span> 
              		<br></br>
                  <span class="text-form"></span><span class="buttons">
                  <button type="submit" name="formulario" value="cancelarEvento" class="button-2"> Cancelar </button>
                  </span>
              </fieldset>
            </form>
            </div>
          </div>
        </div>
      </div>
      </div>
       </div>
      </header>
  	 <section id="content">
       <div class="main">
        <div class="container_12">
        <div class="wrapper img-indent-bot">
          <article class="grid_4">
            <h3>Conocer Procesos</h3>
             <ul class="list-1">
              <li><a href="#">Ingrese cédula del cliente</a></li>
              </ul>
              <form method= "get" action="ProcesoControlador" >
              <span class="text-form"></span><span>
               <input type="text"  name = "idCliente"/>
              </span>
      		  <button type="submit" name="formulario" value="conocerProceso" class="button-2">Consultar</button>
      		  <br></br>
            <table style = "width:200%">
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
            <br></br>

          	<article class="grid_">
            <h3>Nuestros Clientes</h3>
            <table style = "width:200%">
            <thead>
            	<tr>
				<th>Identificación</th> 
				<th>Cliente</th>
				<th>Fecha de Inscripción</th>
				</tr>
				      </thead>
				       <tbody>
				<%
				LinkedList<Fidelizacion> listaFidelizacion = ConsultasRepositorio.getFidelizacion();
					for (int i=0;i<listaFidelizacion.size();i++)
					{
					   out.println("<tr>");
					   out.println("<td>"+listaFidelizacion.get(i).getId()+"</td>");
					   out.println("<td>"+listaFidelizacion.get(i).getNombre()+"</td>");
					   out.println("<td>"+listaFidelizacion.get(i).getFecha()+"</td>");
					   out.println("</tr>");
					}
				%>
				  </tbody>
				</table>
            	</article>
            	
      		  </form>
      		  
          </article>
        </div>
      </div>
     </div>
  	</section>
 </div>
      
      
      
      
    