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
import repositorios.AgregarUsuarios;
import repositorios.ConsultarDatos;

@WebServlet("/UsuariosControlador")
public class UsuariosControlador extends HttpServlet {
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
		             String dir =request.getParameter("direccion");
		             String fechan =request.getParameter("fechaN");
		             int tel =Integer.parseInt(request.getParameter("tel"));
		             String email =request.getParameter("email"); 
		             String pass=request.getParameter("password");
		             String tipoUsuario = request.getParameter("tipou");
		             Usuarios miusuario=new Usuarios(id,nombre,dir,tel,email,pass, fechan,tipoUsuario);
		             if(AgregarUsuarios.agregar(miusuario)){
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
		        	int resul=ConsultarDatos.consultarCantidad();
		        	String resultado = Integer.toString(resul);
		            	 
		             }
	        }catch(NumberFormatException e) {
	            request.setAttribute("estado", "error");
	        }finally{
	        	
	        }
	    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	@Override
    public String getServletInfo() {
        return "Short description";
    }
	
}
