package controladores;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LogicaNegocio.Eventos;

import repositorios.EntrenadorRepositorio;



@WebServlet("/EntrenadorControlador")
public class EntrenadorControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd;
	

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
			PrintWriter out= response.getWriter();
		    response.setContentType("text/html;charset=UTF-8");
	        try{
	        	if(request.getParameter("formulario").equals("cancelarEvento")){
	        		int codigo = Integer.parseInt(request.getParameter("cancelar"));
	        		Eventos evento = new Eventos(codigo);
	        		if(EntrenadorRepositorio.modificar(evento)){
		            	 out.print("<p style=\"color:red\">SE CANCELO EL EVETO EXITOSAMENTE</p>");    
		            	 rd=request.getRequestDispatcher("VistaEntrenador.jsp");    
		            	 rd.include(request,response);
	            	     out.close();
		             }
		             else{
		            	 out.print("<p style=\"color:red\">NO SE PUDO CANCELAR EL EVENTO</p>");    
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
		try {
			processRequest(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
