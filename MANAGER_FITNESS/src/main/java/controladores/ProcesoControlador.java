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

import repositorios.conexion;
import LogicaNegocio.Usuarios;


@WebServlet("/ProcesoControlador")
public class ProcesoControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd;
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			PrintWriter out= response.getWriter();
		    response.setContentType("text/html;charset=UTF-8");
	        try{
	        	if(request.getParameter("formulario").equals("imc")){
	        		System.out.println("hola");
		        	 int talla = Integer.parseInt(request.getParameter("talla"));
		             int peso =Integer.parseInt(request.getParameter("peso"));
		             int resultado = talla/peso*peso;
		             System.out.println(resultado);
		             }
		          else{
		        	  rd=request.getRequestDispatcher("VistaHome.jsp");
		              rd.forward(request, response);
		            	 
		             }
	        	
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
