<%@page import="repositorios.HorarioRepositorio"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "repositorios.HorarioRepositorio"%>
    <%@ page import = "java.util.LinkedList"%>
    <%@ page import = "LogicaNegocio.Horario"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
<title>ManagerFitness | Administrador</title>
<meta charset="utf-8">
<link rel="stylesheet" href="css/reset.css" type="text/css" media="screen">
<link rel="stylesheet" href="css/style.css" type="text/css" media="screen">
<link rel="stylesheet" href="css/grid.css" type="text/css" media="screen">
<%HttpSession s = request.getSession(true); %>
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
            		<li><a href="VistaEntrenador.jsp">Entrenador</a></li>
            <%}if (s.getAttribute("tipousuario").equals("ADMI")){ %>
            		<li><a class="active" href="VistaAdministrador.jsp">Administrador</a></li>
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
      <li><a href="#tab1">Registar Usuarios</a></li>
      <li><a href="#tab2">Recibos de pago </a></li>
      <li><a href="#tab3">Modificar Horarios </a></li>
    </ul>
    <div class="tab_container">
      <div id="tab1" class="tab_content">
        <div class="main">
          <div class="wrapper">
          <div class="extra-wrap">
            <div class="indent1"><form id="contact-form" action="UsuariosControlador" method="get" name= "registrar">
              <fieldset>
                <span class="text-form"></span><span>
                  <input type="text" placeholder = "Cédula" name = "id">
                  </span>
                  <br></br>
                 <span class="text-form"></span><span>
                  <input type="text" placeholder = "Nombre" name ="nombre">
                  </span> 
                  <br></br>
                <span class="text-form"></span><span>
                  <input type="date" placeholder = "Fecha de Nacimiento" name = "fechaN">
                  </span>
                  <br></br>
                <span class="text-form"></span><span>
                  <input type="text" placeholder = "Dirección" name = "direccion">
                  </span>  
                 <br></br>
                <span class="text-form"></span><span>
                  <input type="text" placeholder = "Telefono" name = "tel">
                  </span>
                <br></br>
                <span class="text-form"></span><span>
                  <input type="email" placeholder = "Email" name = "email">
                  </span>
                <br></br>
                <span class="text-form"></span><span>
                  <input type="text" placeholder = "Contraseña" name = "password">
                  </span>
                 <br></br>
                <span class="text-form"></span>
                  <select name="tipou">
                  	<option value="CLIN">Cliente</option>
                  	<option value="ADMI">Administrador</option>
                  	<option value="ENTR">Entrenador</option>
                  </select>
                  <span class="text-form"></span><span class="buttons">
                  <button type="submit" name="formulario" value="registrar" class="button-2" > Registrar </button>
                  </span>
                  
              </fieldset>
            </form>
            </div>
          </div>
        </div>
      </div>
      </div>
      
      <div id="tab2" class="tab_content">
        <div class="main">
          <div class="wrapper">
            <figure class="img-indent-r"><img src="images/page1-img3.jpg" alt=""></figure>
            <div class="extra-wrap">
              <div class="indent"> <form id="contact-form" action="RecibosControlador" method="get">
              <fieldset>
                 <span class="text-form"></span><span>
                  <input type="text" placeholder = "C.C. Cliente" name ="id">
                  </span> 
                  <br></br>
                  <span class="text-form"></span><span class="buttons">
                  <button type="submit" name="formulario" value="generar" class="button-2"> Generar </button>
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
            <figure class="img-indent-r"><img src="images/page1-img3.jpg" alt=""></figure>
            <div class="extra-wrap">
              <div class="indent"> <form id="contact-form" action="HorarioControlador" method="get">
              <fieldset>
                 <span class="text-form"></span><span>
                  <input type="text" placeholder = "Cédula Entrenador" name ="id">
                  </span>
                  <br></br>
                  <span class="text-form"></span><span>
                  <br>Horarios: <select name="Horario"> 
                    <%LinkedList<Horario> lista = HorarioRepositorio.getHorario();
                        for (int i=0;i<lista.size();i++) {
                    %>                    
                    <option value="<%=lista.get(i).getHor_id()%>"><%=lista.get(i).getDescripcion()%></option>                    
                    <%
                    }
                    %>
                    </select><br>	
                  </span>
                  <br></br>  
                  <span class="text-form"></span><span class="buttons">
                  <button type="submit" name="formulario" value="modificarHorario" class="button-2"> Modificar </button>
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
          <article class="grid_8">
            <h3 class="img-indent-right" >OTRAS OPCIONES!</h3>
            <br></br>
             <ul class="list-1">
              <a><li>Conocer el numero de clientes</li></a>
              </ul>
              <form method= "get" action="UsuariosControlador" >
              <span class="text-form"></span><span>
               <input type="text" placeholder = "cantidad de usuarios" name = "cantidad" value= "<% if (request.getAttribute("resultado")!= null)out.println(request.getAttribute("resultado"));else out.println(" "); %>" disabled="disabled" />
              </span>
      		  <button type="submit" name="formulario" value="cantidad" class="button-2">Ver</button>
            
      		  </form>
      		  
      		  <ul class="list-1">
              <a><li>Crear Anuncios</li></a>
              </ul>
              <form method= "get" action="ServicioUcoControlador" >
              <span class="text-form"></span><span>
               <input type="text" placeholder = "Titulo" name= "titulo" />
              </span>
              <span class="text-form"></span><span>
               <input type="text" placeholder = "Descripcion" name= "descripcion" />
              </span>
      		  <button type="submit" name="formulario" value="crearAnuncio" class="button-2">Ver</button>
            
      		  </form>
      		  
          </article>
        </div>
      </div>
     </div>
  	</section>
 </div>
      
      
      
      
    