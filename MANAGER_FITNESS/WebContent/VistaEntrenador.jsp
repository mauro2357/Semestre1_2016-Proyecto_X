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
            <li><a href="VistaAdministrador.jsp">Administrador</a></li>
            <li><a class="active" href="VistaEntrenador.jsp">Entrenador</a></li>
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
      <li><a href="#tab1">Crear Evento</a></li>
      <li><a href="#tab2">Crear Proceso </a></li>
    </ul>
    <div class="tab_container">
      <div id="tab1" class="tab_content">
        <div class="main">
          <div class="wrapper">
          <figure class="img-indent-r"><img src="images/page3-img3.jpg" alt=""></figure>
          <div class="extra-wrap">
            <div class="indent1"><form id="contact-form" action="EventosControlador" method="get">
              <fieldset>
                <span class="text-form"></span><span>
                  <input type="text" placeholder = "Fecha del Evento" name = "fechaE">
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
      <div id="tab2" class="tab_content">
        <div class="main">
          <div class="wrapper">
            <figure class="img-indent-r"><img src="images/page1-img3.jpg" alt=""></figure>
            <div class="extra-wrap">
              <div class="indent"> <form id="contact-form" action="ProcesoControlador" method="get">
              <fieldset>
                 <span class="text-form"></span><span>
                  <input type="text" placeholder = "Cedula Cliente" name ="nombre">
                  </span> 
                  <br></br>
                  <span class="text-form"></span><span>
                  <input type="text" placeholder = "Peso" name ="peso">
                  </span> 
                  <br></br>
                  <span class="text-form"></span><span>
                  <input type="text" placeholder = "Rutina" name ="rutina">
                  </span> 
                  <br></br>
                  <span class="text-form"></span><span>
                  <input type="text" placeholder = "Observacion" name ="observacion">
                  </span> 
                  <br></br>
                  <span class="text-form"></span><span>
                  <input type="text" placeholder = "Tipo de Proceso" name ="tip_proceso">
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
       </div>
      </header>
      
      <section id="content">
       
  	</section>
 </div>
      
      
      
      
    