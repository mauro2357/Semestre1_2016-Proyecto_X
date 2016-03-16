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

import LogicaNegocio.Usuarios;
import repositorios.UsuariosRepositorio;
import repositorios.ConsultasRepositorio;

@WebServlet("/LoginControlador")
public class LoginControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
			PrintWriter out= response.getWriter();
		    response.setContentType("text/html;charset=UTF-8");
	        try{
	        	if(request.getParameter("formulario").equals("registrar")){
	        		System.out.println("hola");
		        	 int id = Integer.parseInt(request.getParameter("id"));
		             String nombre =request.getParameter("nombre");
		             Usuarios miusuario=new Usuarios(id,nombre,dir,tel,email,pass, fechan,tipoUsuario);
		             if(UsuariosRepositorio.agregar(miusuario)){
		            	 System.out.println(nombre);
		            	 rd= request.getRequestDispatcher("VistaAdministrador.jsp");
		            	 rd.forward(request, response);
		            	 out.close();
		             }
		             else{
		            	 rd=request.getRequestDispatcher("redireccion.html");
		            	 rd.forward(request, response);
		            	 
		             }
	        	}
		        else if(request.getParameter("formulario").equals("cantidad")) {
		        	int resultado=ConsultasRepositorio.consultarCantidad();
		        	System.out.println(resultado);
		        	request.setAttribute("resultado",Integer.toString(resultado));
		             rd = request.getRequestDispatcher("VistaAdministrador.jsp");
		             rd.forward(request, response);
		            	 
		             }
	        }catch(NumberFormatException e) {
	            request.setAttribute("estado", "error");
	        }finally{
	        	rd = request.getRequestDispatcher("redireccion.html");
                rd.forward(request, response);
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
