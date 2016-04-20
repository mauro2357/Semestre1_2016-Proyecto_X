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
 
    
   <div class="main">
      <div class="wrapper p3">
        <h1><a>ManagerFitness</a></h1>
      </div>
    </div>
 
    
      <div id="tab1" class="tab_content">
        <div class="main">
          <div class="wrapper">
          <div class="extra-wrap">
            <div class="indent1"><form id="contact-form" action="HorarioControlador" method="get">
              <fieldset>
                <span class="text-form"></span><span>
                  <input type="text" placeholder = "Cédula" name = "id">
                </span>
                  <br></br>
                  <span class="text-form"></span><span>
                  TIPO DE ENTRENADOR:<select name="tipoEntrenador" >
                  	<option value="PRIN">Principiante</option>
                  	<option value="PRAC">Practicante</option>
                  	<option value="ANX">Animalex</option>
                  </select>
                  </span>
                  <br></br>
                  <span class="text-form"></span><span>
                  HORARIO:<select name="horario" >
                  	<option value="1">mañana, 6:00 am-12:00 m</option>
                  	<option value="2">tarde, 12:00 m - 6:00 pm</option>
                  	<option value="3">noche, 6:00 pm-10:00 pm</option>
                  	<option value="4">fin de semana y festivos, 8:00 am - 2:00 pm</option>
                  </select>
                  </span>
                  <br></br>
                  <span class="text-form"></span><span>
                  <input type="checkbox" name="archivo" value="1"/> Generar Archivo:
				  </span>
                  <br></br>
                  <span class="text-form"></span><span class="buttons">
                  <button type="submit" name="formulario" value="agregarHorario" class="button-2"> Agregar </button>
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