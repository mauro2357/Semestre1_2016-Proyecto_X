<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
<title>ManagerFitness | Administrador</title>
<meta charset="utf-8">
<link rel="stylesheet" href="css/reset.css" type="text/css" media="screen">
<link rel="stylesheet" href="css/style.css" type="text/css" media="screen">
<link rel="stylesheet" href="css/grid.css" type="text/css" media="screen">

</head>
<body id="page3">
<div class="bg">
  <!--==============================header=================================-->
  <header>
    <div class="menu-row">
      <div class="main">
        <nav>
          <ul class="menu wrapper">      
            <li><a href="VistaHome.jsp">Cliente</a></li>
            <li><a href="VistaEventos.jsp">Actualidad</a></li>
            <li><a class="active" href="VistaAdministrador.jsp">Administrador</a></li>
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
      <li><a href="#tab1">Registar Usuarios</a></li>
      <li><a href="#tab2">Recibos de pago </a></li>
    </ul>
    <div class="tab_container">
      <div id="tab1" class="tab_content">
        <div class="main">
          <div class="wrapper">
          <div class="extra-wrap">
            <div class="indent1"><form id="contact-form" action="UsuariosControlador" method="get">
              <fieldset>
                <span class="text-form"></span><span>
                  <input type="text" placeholder = "C�dula" name = "id">
                  </span>
                  <br></br>
                 <span class="text-form"></span><span>
                  <input type="text" placeholder = "Nombre" name ="nombre">
                  </span> 
                  <br></br>
                <span class="text-form"></span><span>
                  <input type="text" placeholder = "Fecha de Nacimiento" name = "fechaN">
                  </span>
                  <br></br>
                <span class="text-form"></span><span>
                  <input type="text" placeholder = "Direcci�n" name = "direccion">
                  </span>  
                 <br></br>
                <span class="text-form"></span><span>
                  <input type="text" placeholder = "Telefono" name = "tel">
                  </span>
                <br></br>
                <span class="text-form"></span><span>
                  <input type="text" placeholder = "Email" name = "email">
                  </span>
                <br></br>
                <span class="text-form"></span><span>
                  <input type="text" placeholder = "Contrase�a" name = "password">
                  </span>
                 <br></br>
                <span class="text-form"></span>
                  <select name="tipou">
                  	<option value="CLIN">Cliente</option>
                  	<option value="ADMI">Administrador</option>
                  	<option value="ENTR">Entrenador</option>
                  </select>
                  <span class="text-form"></span><span class="buttons">
                  <button type="submit" name="formulario" value="registrar" class="button-2"> Registrar </button>
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
              <div class="indent"> <form id="contact-form" action="inicio" method="get">
              <fieldset>
                 <span class="text-form"></span><span>
                  <input type="text" placeholder = "Nombre" name ="nombre">
                  </span> 
                  <br></br>
                  <span class="text-form"></span><span class="buttons">
                  <button type="submit" name="formulario" value="registrar" class="button-2"> Imprimir </button>
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
            <h3>Otras Opciones</h3>
             <ul class="list-1">
              <li><a href="#">Conocer el numero de clientes</a></li>
              </ul>
              <form method= "get" action="UsuariosControlador" >
              <span class="text-form"></span><span>
               <input type="text" placeholder = "cantidad de usuarios" name = "cantidad" value= "<% if (request.getAttribute("resultado")!= null)out.println(request.getAttribute("resultado"));else out.println(" "); %>" disabled="disabled" />
              </span>
      		  <button type="submit" name="formulario" value="cantidad" class="button-2">Ver</button>
            
      		  </form>
          </article>
        </div>
      </div>
     </div>
  	</section>
 </div>
      
      
      
      
    