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

import LogicaNegocio.Entrenador;
import LogicaNegocio.Horario;

import repositorios.HorarioRepositorio;

@WebServlet("/HorarioControlador")
public class HorarioControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd;
       
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		PrintWriter out= response.getWriter();
	    response.setContentType("text/html;charset=UTF-8");
        try{
        	if(request.getParameter("formulario").equals("agregarHorario")){
	        	 int id = Integer.parseInt(request.getParameter("id"));
	             int descripcion =Integer.parseInt(request.getParameter("horario"));
	             String tipoEntrenador = request.getParameter("tipoEntrenador");
	             Horario horario = new Horario(id,descripcion);
	             Entrenador entrenador = new Entrenador(id, tipoEntrenador);
	             if(HorarioRepositorio.agregar(entrenador)){
	            	 if(HorarioRepositorio.agregar(horario)){
		            	 rd= request.getRequestDispatcher("VistaAdministrador.jsp");
		            	 rd.forward(request, response);
		            	 out.close();
		             }
		             else{
		            	 out.print("<p style=\"color:red\">NO SE PUDO AGREGAR EL HORARIO</p>");    
		            	 rd=request.getRequestDispatcher("VistaAuxEntrenador.jsp"); 
		            	 rd.include(request,response);
		            	 out.close();	 
		             }
	             }
	             else{
	            	 out.print("<p style=\"color:red\">NO SE PUDO AGREGAR EL ENTRENADOR</p>");    
	            	 rd=request.getRequestDispatcher("VistaAuxEntrenador.jsp"); 
	            	 rd.include(request,response);
	            	 out.close();	 
	             }
	         
	             
        	}
        }catch(NumberFormatException e) {
            request.setAttribute("estado", "error");
        }finally{
        	out.print("<p style=\"color:blue\">POR FAVOR INGRESE SU USUARIO Y COTRASEÑA</p>");    
       	 	rd=request.getRequestDispatcher("VistaLogin.jsp"); 
       	 	rd.include(request,response);
       	 	out.close();
        }
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
