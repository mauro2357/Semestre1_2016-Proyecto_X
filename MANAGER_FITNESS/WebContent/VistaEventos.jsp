<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "LogicaNegocio.Eventos"%> 
<%@ page import = "repositorios.EventosRepositorio"%>
<%@ page import = "LogicaNegocio.Programacion"%> 
<%@ page import = "repositorios.ProgramacionRepositorio"%> 
<%@ page import = "java.util.LinkedList"%> 
<!DOCTYPE html>
<html lang="en">
<%HttpSession s = request.getSession(true); %>
<head>
<title>ManagerFitness | Actualidad</title>
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
<body id="page2">
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
            <li><a class="active" href="VistaEventos.jsp">Actualidad</a></li>
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
    <div class="row-bot"></div>
  </header>
  <!--==============================content================================-->
  <section id="content">
    <div class="main">
      <div class="container_12">
        <div class="wrapper margin-bot">
        <article class="grid_8">
            <h3>Eventos</h3>
            <br></br>
            <table style = "width:100%">
            <thead>
            	<tr>
				<th>Fecha</th> 
				<th>Descripcion</th>
				<th>Entrenador</th>
				</tr>
				      </thead>
				       <tbody>
				<%
				LinkedList<Eventos> listaEventos = EventosRepositorio.getEventos();
				if(listaEventos!= null){	
				for (int i=0;i<listaEventos.size();i++)
				{
				   out.println("<tr>");
				   out.println("<td>"+listaEventos.get(i).getFecha()+"</td>");
				   out.println("<td>"+listaEventos.get(i).getDescripcion()+"</td>");
				   out.println("<td>"+listaEventos.get(i).getNombreEntrenador()+"</td>");
				   out.println("</tr>");
				}
				}
				%>
				  </tbody>
				</table>
				<br></br>
          </article>
          <article class="grid_8">
            <h3>Horarios</h3>
            <br></br>
            <table style = "width:100%">
            <thead>
            	<tr>
				<th>Entrenador</th> 
				<th>Horario</th>
				</tr>
				      </thead>
				       <tbody>
				<%
				LinkedList<Programacion> lista2 = ProgramacionRepositorio.getProgramacion();
				for (int i=0;i<lista2.size();i++)
				{
				   out.println("<tr>");
				   out.println("<td>"+lista2.get(i).getNombreEntrenador()+"</td>");
				   out.println("<td>"+lista2.get(i).getHorario()+"</td>");
				   out.println("</tr>");
				}
				%>
				  </tbody>
				</table>
          </article>
        </div>
        <div class="wrapper">
          <article class="grid_12">
            <h3 class="prev-indent-bot">Cuida tu salud!  Infórmate! </h3>
            <div class="wrapper">
              <figure class="img-indent2"><img src="images/espalda.jpg" alt="" /></figure>
              <div class="extra-wrap">
                <h5 class="p0">EJERCICIOS PARA PROBLEMAS DE LA ESPALDA</h5>
                <p class="p2">Los especialistas en rehabilitación sugieren que se concentre en hacer ejercicios de estiramiento a
                 fines de aumentar la flexibilidad de los músculos que brindan apoyo a la columna (los de la espalda, de las 
                 piernas, las nalgas y alrededor de la columna). Además, los ejercicios para reforzar el core (los músculos 
                 abdominales) previenen complicaciones mayores. En cuanto al ejercicio cardiovascular, las actividades de bajo 
                 impacto (como nadar y andar en bicicleta) lo protegerán a futuro.</div>
            </div>
          </article>
        </div>
       
        <div class="wrapper">
          <article class="grid_12">
            <div class="wrapper">
              <figure class="img-indent2"><img src="images/diabetes.jpg" alt="" /></figure>
              <div class="extra-wrap">
                <h5 class="p0">EJERCICIOS PARA DIABETICOS</h5>
                <p class="p2"> La Dra. Jan Hux, Jefa de Asesoría Científica de La Asociación Canadiense contra la Diabetes sugiere 
                que, junto con una alimentación saludable, los pacientes realicen 150 minutos semanales (unos 20 minutos al día) de 
                ejercicio aeróbico de moderado a vigoroso combinado con una rutina para aumentar la fuerza y la resistencia.</div>
            </div>
          </article>
        </div>
        
        <div class="wrapper">
          <article class="grid_12">
            <div class="wrapper">
              <figure class="img-indent2"><img src="images/artritis.jpg" alt="" /></figure>
              <div class="extra-wrap">
                <h5 class="p0">EJERCICIOS PARA LA ARTRITIS</h5>
                <p class="p2">La American College of Sports Medicine explica que el entrenamiento para las personas con artritis debe ser aeróbico, de bajo impacto, con una duración de 30 a 60 minutos 5 días a la semana y debe acompañarse con ejercicios para fortalecer y estirar los grupos musculares más importantes. </div>
            </div>
          </article>
        </div>
        
        <div class="wrapper">
          <article class="grid_12">
            <div class="wrapper">
              <figure class="img-indent2"><img src="images/cardiaca.jpg" alt="" /></figure>
              <div class="extra-wrap">
                <h5 class="p0">EJERCICIOS PARA LA SALUD CARDIACA</h5>
                <p class="p2">Los expertos en rehabilitación cardiaca prescriben diversos ejercicios para reducir la presión arterial y el ritmo cardiaco y para reforzar la capacidad aeróbica del paciente (es decir, la habilidad de administrar correctamente el oxígeno). Tanto la actividad aeróbica como el entrenamiento de fuerza favorecen la prevención y la recuperación de afecciones cardiacas (sin contar con los efectos adversos de los medicamentos). </div>
            </div>
          </article>
        </div>
       
        <div class="wrapper">
          <article class="grid_12">
            <div class="wrapper">
              <figure class="img-indent2"><img src="images/demencia.jpg" alt="" /></figure>
              <div class="extra-wrap">
                <h5 class="p0">EJERCICIOS PARA LA DEMENCIA</h5>
                <p class="p2">Puede que los pacientes en etapas iniciales no necesiten realizar cambios en su régimen de ejercicio habitual pero, según en qué fase de deterioro cognitivo se encuentren, existe una gran variedad de programas de actividad física para satisfacer sus necesidades. Desde actividades tranquilas, juegos con balones y tai-chi hasta natación y rutinas aeróbicas con música </div>
            </div>
          </article>
        </div>
        
        <div class="wrapper">
          <article class="grid_12">
            <div class="wrapper">
              <figure class="img-indent2"><img src="images/fibromialgia.jpg" alt="" /></figure>
              <div class="extra-wrap">
                <h5 class="p0">EJERCICIOS PARA LA FIBROMIALGIA</h5>
                <p class="p2">Los ejercicios incluyen rutinas de estiramiento para mejorar el rango de movimiento y clases de aeróbicas y de resistencia. La intensidad dependerá de las posibilidades de cada individuo. </div>
            </div>
          </article>
        </div>
        
        <div class="wrapper">
          <article class="grid_12">
            <div class="wrapper">
              <figure class="img-indent2"><img src="images/vejez.jpg" alt="" /></figure>
              <div class="extra-wrap">
                <h5 class="p0">EJERCICIOS PARA EL ENVEJECIMIENTO</h5>
                <p class="p2">El truco es elegir correctamente el tipo de actividad física que realizará, de modo que no cause lesiones permanentes o dolor crónico en nuestros años dorados. Los ejercicios de alto impacto en la tercera edad pueden causar agotamiento, molestias severas y lesiones. Un programa de caminata moderado combinado con actividades de resistencia y flexibilidad son clave para garantizar una vida saludable y libre de dolores sin importar la edad que tenga (o el nivel de madurez). </div>
            </div>
          </article>
        </div>
        
         <div class="wrapper margin-bot">
          <article class="grid_12">
            <ul class="list-1 img-indent-bot">
              <a>ENLACES EXTERNOS</a>
              <li><a>https://www.cardiosmart.org/~/media/Documents/Fact%20Sheets/es-US/tb1603.pdf </a></li>
              <li><a>http://enforma.salud180.com/nutricion-y-ejercicio/ejercicios-vs-enfermedades-cronicas </a></li>
              <li><a>http://www.activebeat.com/esp/fitness-y-nutricion/doce-ejercicios-exclusivamente-disenados-para-personas-con-enfermedades-cronicas/5/</a></li>
            </ul>
            </article>
         </div>
    </div>
  </section>
</div>