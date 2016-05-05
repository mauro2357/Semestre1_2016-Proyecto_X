package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LogicaNegocio.Eventos;
import LogicaNegocio.Usuarios;
import repositorios.EventosRepositorio;
import repositorios.UsuariosRepositorio;
import repositorios.conexion;


@WebServlet("/EventosControlador")
public class EventosControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd;
	

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			PrintWriter out= response.getWriter();
		    response.setContentType("text/html;charset=UTF-8");
		    String str = request.getSession().getAttribute("usuario").toString();
		    int id= Integer.parseInt(str);
	        try{
	        	if(request.getParameter("formulario").equals("evento")){
		        	 String fecha = request.getParameter("fechaE");
		             String descripcion =request.getParameter("nombre");
		             Eventos evento= new Eventos(fecha, descripcion, id);
		             if(EventosRepositorio.agregar(evento)){
		            	 out.print("<p style=\"color:red\">EL EVENTO SE HA CREADO EXITOSAMENTE</p>");    
		            	 rd=request.getRequestDispatcher("VistaEntrenador.jsp");    
		            	 rd.include(request,response);
	            	     out.close();
		             }
		             else{
		            	 out.print("<p style=\"color:red\">NO SE PUDO CREAR EL EVENTO</p>");    
		            	 rd=request.getRequestDispatcher("VistaEntrenador.jsp");    
		            	 rd.include(request,response);
	            	     out.close();
		            	 
		             }
	        	}
	        	
	        }catch(NumberFormatException e) {
	            request.setAttribute("estado", "error");
	        }finally{
	        }
	}
	
	
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
