<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.util.LinkedList"%>  
    <%@ page import = "LogicaNegocio.*"%>
    <%@ page import = "repositorios.ConsultasRepositorio"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
<title>ManagerFitness | Login</title>
<meta charset="utf-8">
<link rel="stylesheet" href="css/reset.css" type="text/css" media="screen">
<link rel="stylesheet" href="css/style.css" type="text/css" media="screen">
<link rel="stylesheet" href="css/grid.css" type="text/css" media="screen">

</head>
<body id="page3">
<div class="bg">
  <!--==============================header=================================-->
  <header>
 
    
   <div class="main">
      <div class="wrapper p3">
        <h1><a>ManagerFitness</a></h1>
      </div>
    </div>
 
    
      <div id="tab1" class="tab_content">
        <div class="main">
          <div class="wrapper">
          <div class="extra-wrap">
            <div class="indent1"><form id="contact-form" action="UsuariosControlador" method="get">
              <fieldset>
                <span class="text-form"></span><span>
                  <input type="text" placeholder = "Cédula" name = "id">
                  </span>
                  <br></br>
                 <span class="text-form"></span><span>
                  <input type="text" placeholder = "Estatura" name ="estatura">
                  </span> 
                  <br></br>
                  <span class="text-form"></span><span>
                  <input type="text" placeholder = "Peso" name ="peso">
                  </span> 
                  <br></br>
                  <span class="text-form"></span><span>
                  <input type="text" placeholder = "Prueba de Esfuerzo" name ="pruebaEsfuerzo">
                  </span> 
                  <br></br>
                  Enfermedades:  
                    <%LinkedList<Enfermedades> lista = ConsultasRepositorio.getEnfermedad();
                        for (int i=0;i<lista.size();i++) {
                    %>
						<%=lista.get(i).getEnfermedad()%><input type="checkbox" name="enfermedad" value="<%=lista.get(i).getCodigo()%>" />
						<%} %>                                      
                  <br></br>
                  <span class="text-form"></span><span class="buttons">
                  <button type="submit" name="formulario" value="inscribir" class="button-2"> Inscribir </button>
                  </span>
              </fieldset>
            </form>
            </div>
          </div>
        </div>
      </div>
      </div>
 
    </header>
      
 </div>
      
      
      
      
    