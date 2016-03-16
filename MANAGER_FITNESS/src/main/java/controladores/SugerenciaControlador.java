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

import LogicaNegocio.Sugerencias;
import LogicaNegocio.Usuarios;
import repositorios.SugerenciaRepositorio;
import repositorios.UsuariosRepositorio;
import repositorios.conexion;


@WebServlet("/SugerenciaControlador")
public class SugerenciaControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd;
	private conexion con= new conexion();
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
	    response.setContentType("text/html;charset=UTF-8");
        
        	if(request.getParameter("formulario").equals("sugerencia")){
        		System.out.println("hola");
        		String fecha =request.getParameter("fecha");
                String descripcion =request.getParameter("descripcion");
                int id = Integer.parseInt(request.getParameter("id"));
	            Sugerencias sugerencia= new Sugerencias(fecha, descripcion, id);
	            
	            if(SugerenciaRepositorio.agregar(sugerencia)){
	            	 System.out.println(descripcion);
	            	 rd= request.getRequestDispatcher("VistaHome.jsp");
	            	 rd.forward(request, response);
	            	 out.close();
	             }
	             else{
	            	 rd=request.getRequestDispatcher("redireccion.html");
	            	 rd.forward(request, response);
	            	 
	             }
        	}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
