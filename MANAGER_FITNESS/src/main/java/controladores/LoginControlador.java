package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginControlador")
public class LoginControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
			PrintWriter out= response.getWriter();
		    response.setContentType("text/html;charset=UTF-8");
			HttpSession s = request.getSession(true); 
			s.setAttribute("usuario", request.getParameter("id"));
	        try{
	        	String respuesta=FacadeLogin.orquestador(request,s);
	        	if(respuesta.equals("login")){
	        		rd= request.getRequestDispatcher("VistaHome.jsp");
			        rd.forward(request, response);
			        out.close();
			    }
	        	else if(respuesta.equals("no login")){
	        		out.print("<p style=\"color:blue\">USUARIO Y/O CONTRASEÑA INCORRECTOS</p>");    
		            rd=request.getRequestDispatcher("VistaLogin.jsp"); 
		            rd.include(request,response);
		            out.close();	 
		        }
	        	else if(respuesta.equals("salir")){
	        		s.invalidate();
	        		s=request.getSession(false);
	        		rd=request.getRequestDispatcher("VistaLogin.jsp");
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
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}	
}
