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

import repositorios.ProcesoRepositorio;
import LogicaNegocio.Fecha;
import LogicaNegocio.Proceso;



@WebServlet("/ProcesoControlador")
public class ProcesoControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd;
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
			PrintWriter out= response.getWriter();
		    response.setContentType("text/html;charset=UTF-8");
		    String str = request.getSession().getAttribute("usuario").toString();
		    int id= Integer.parseInt(str);
	        try{
	        	if(request.getParameter("formulario").equals("imc")){
		             double resultado = ProcesoRepositorio.consultarImc(id);
		             request.setAttribute("resultado",Double.toString(resultado));
		             rd = request.getRequestDispatcher("VistaHome.jsp");
		             rd.forward(request, response);
	        	}
	        	if(request.getParameter("formulario").equals("crearproceso")){
		        	 int cedula = Integer.parseInt(request.getParameter("id"));
		        	 double peso = Double.parseDouble(request.getParameter("peso"));
		        	 double estatura = Double.parseDouble(request.getParameter("estatura"));
		             String tipoProceso = request.getParameter("tipoProceso");
		             int rutina = Integer.parseInt(request.getParameter("rutina"));
		             String observacion = request.getParameter("observacion");
		             String fecha=Fecha.ObtenerFecha();
		             Proceso proceso =new Proceso(cedula,peso,estatura,tipoProceso,rutina,observacion,fecha);
		             if(ProcesoRepositorio.agregarProceso(proceso)){
		            	 out.print("<p style=\"color:red\">SE HA CREADO EL PROCESO EXITOSAMENTE</p>");    
		            	 rd=request.getRequestDispatcher("VistaEntrenador.jsp");    
		            	 rd.include(request,response);
		             }
		             else {
		            	 out.print("<p style=\"color:red\">NO SE PUDO CREAR EL PROCESO</p>");    
		            	 rd=request.getRequestDispatcher("VistaEntrenador.jsp");    
		            	 rd.include(request,response);
		            	 
		             }
	        	}
	        	if(request.getParameter("formulario").equals("conocerProceso")){
	        		int idCliente = Integer.parseInt(request.getParameter("idCliente"));
	        	    LinkedList<Proceso> listaProceso=ProcesoRepositorio.getProceso(idCliente);
	        	    request.setAttribute("lista", listaProceso);
	        	    rd= request.getRequestDispatcher("VistaEntrenador.jsp");
	        	    rd.forward(request, response);
	        	}
	        	if(request.getParameter("formulario").equals("proceso")){
	        		int idCliente = id; 
	        		LinkedList<Proceso> listaProceso=ProcesoRepositorio.getProceso(idCliente);
	        	    request.setAttribute("lista", listaProceso);
	        	    rd= request.getRequestDispatcher("VistaHome.jsp");
	        	    rd.forward(request, response);
	        	}
	        	
	        } catch (NumberFormatException e) {
	            request.setAttribute("estado", "error");
	        	
	        	}finally{

	        	}
       
	        }
  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
