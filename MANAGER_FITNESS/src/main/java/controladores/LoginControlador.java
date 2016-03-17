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
import javax.servlet.http.HttpSession;
import LogicaNegocio.Login;
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
			HttpSession s = request.getSession(true); 
			s.setAttribute("usuario", request.getParameter("id"));
	        try{
	        	if(request.getParameter("formulario").equals("login")){
		        	 int id = Integer.parseInt(request.getParameter("id"));
		             String pass =request.getParameter("pass");
		             Login entrar = new Login(id,pass);
		             if(ConsultasRepositorio.autenticar(entrar)){
		            	 rd= request.getRequestDispatcher("VistaHome.jsp");
		            	 rd.forward(request, response);
		            	 out.close();
		             }
		             else{
		            	 rd=request.getRequestDispatcher("VistaLogin.jsp");
		            	 rd.forward(request, response);
		            	 
		             }
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
