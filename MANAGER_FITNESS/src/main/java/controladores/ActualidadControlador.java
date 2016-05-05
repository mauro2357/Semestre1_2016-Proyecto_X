package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LogicaNegocio.Eventos;
import repositorios.EventosRepositorio;



@WebServlet("/EventosControlador")
public class ActualidadControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			PrintWriter out= response.getWriter();
		    response.setContentType("text/html;charset=UTF-8");
		    RequestDispatcher rd= request.getRequestDispatcher("VistaEventos.jsp");
	        try{
	        	 		
	        }catch(NumberFormatException e) {
	            request.setAttribute("estado", "error");
	        }finally{
	        	LinkedList<Eventos> listaEventos=EventosRepositorio.getEventos();
	    	    request.setAttribute("lista", listaEventos);
	    	    rd.forward(request, response);
	        	   
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
