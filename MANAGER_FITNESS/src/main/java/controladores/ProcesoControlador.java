package controladores;

import java.io.IOException;
import java.io.PrintWriter;


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
		        	 double talla = Double.parseDouble(request.getParameter("talla"));
		             double peso =Double.parseDouble(request.getParameter("peso"));
		             double resultado = peso/(talla*talla);
		             System.out.println(resultado);
		             request.setAttribute("resultado",Double.toString(resultado));
		             rd = request.getRequestDispatcher("VistaHome.jsp");
		             rd.forward(request, response);
	        	}
	        	
	        	if (request.getParameter("formulario").equals("crearproceso")){
	        		int id= Integer.parseInt(request.getParameter("nombre"));
	        		double peso =Double.parseDouble(request.getParameter("peso"));
	        		int rutina=Integer.parseInt(request.getParameter("rutina"));
	        		String observacion=request.getParameter("observacion");
	        		int proceso= Integer.parseInt(request.getParameter("tip_proceso"));
	        		
	        	}
	        	
	        } catch (NumberFormatException e) {
	            request.setAttribute("estado", "error");
	        	
	        	}finally{
	        		rd = request.getRequestDispatcher("redireccion.html");
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
