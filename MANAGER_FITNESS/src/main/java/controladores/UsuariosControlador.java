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
import LogicaNegocio.Cliente;
import LogicaNegocio.Fecha;
import LogicaNegocio.Usuarios;
import repositorios.UsuariosRepositorio;
import repositorios.ConsultasRepositorio;
import repositorios.EnfermedadRepositorio;


@WebServlet("/UsuariosControlador")
public class UsuariosControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
			PrintWriter out= response.getWriter();
		    response.setContentType("text/html;charset=UTF-8");
		    HttpSession s = request.getSession(true); 
			s.setAttribute("tipo", request.getParameter("tipou"));
	        try{
	        	if(request.getParameter("formulario").equals("registrar")){
		        	 int id = Integer.parseInt(request.getParameter("id"));
		             String nombre =request.getParameter("nombre");
		             String dir =request.getParameter("direccion");
		             String fechan =request.getParameter("fechaN");
		             int tel =Integer.parseInt(request.getParameter("tel"));
		             String email =request.getParameter("email"); 
		             String pass=request.getParameter("password");
		             String tipoUsuario = request.getParameter("tipou");
		             System.out.println(tipoUsuario);
		             Usuarios miusuario=new Usuarios(id,nombre,dir,tel,email,pass, fechan,tipoUsuario);
		             if(miusuario.agregar()){
		            	 if(s.getAttribute("tipo").equals("CLIN")){
			            	 rd= request.getRequestDispatcher("VistaAuxCliente.jsp");
				             rd.forward(request, response);
				             out.close();
		            	 }
			             if (s.getAttribute("tipo").equals("ENTR")){
			            	 rd= request.getRequestDispatcher("VistaAuxEntrenador.jsp");
			            	 rd.forward(request, response);
			            	 out.close();
			             }    
		            	 rd=request.getRequestDispatcher("VistaAdministrador.jsp");    
		            	 rd.include(request,response);
		            	 out.print("<p style=\"color:red\">REGISTRO EXITOSO</p>");
		             }
		             else{   
		            	 out.print("<p style=\"color:red\">NO SE PUDO REGISTRAR, INTENTELO NUEVAMENTE</p>");    
		            	 rd=request.getRequestDispatcher("VistaAdministrador.jsp");    
		            	 rd.include(request,response);
		            	 
		             }
	        	}
		        else if(request.getParameter("formulario").equals("cantidad")) {
		        	int resultado=ConsultasRepositorio.consultarCantidad();
		        	request.setAttribute("resultado",Integer.toString(resultado));
		            rd = request.getRequestDispatcher("VistaAdministrador.jsp");
		            rd.forward(request, response);
		            	 
		             }
		        else if(request.getParameter("formulario").equals("inscribir")){
		        	 int id = Integer.parseInt(request.getParameter("id"));
		             double estatura =Double.parseDouble(request.getParameter("estatura"));
		             double peso =Double.parseDouble(request.getParameter("peso"));
		             String fecha=Fecha.ObtenerFecha();
		             int pruebaEsfuerzo = Integer.parseInt(request.getParameter("pruebaEsfuerzo"));
		             String[] enfermedad = request.getParameterValues("enfermedad");
		             Cliente ncliente= new Cliente(estatura, fecha, id,enfermedad, peso,pruebaEsfuerzo);
		             if(UsuariosRepositorio.agregarCliente(ncliente)){
		            	 if (enfermedad != null){
			            	 EnfermedadRepositorio.agregarEnfermedad(ncliente);
			             }  
		            	 out.print("<p style=\"color:red\">REGISTRO EXITOSO</p>");
		            	 rd=request.getRequestDispatcher("VistaAdministrador.jsp");    
		            	 rd.include(request,response);
			             out.close();
		            }
		            else{
		            	out.print("<p style=\"color:red\">NO SE PUDO REGISTRAR, INTENTELO NUEVAMENTE</p>");    
		            	 rd=request.getRequestDispatcher("VistaAuxCliente.jsp");    
		            	 rd.include(request,response);
		        }      
		      }
	        }catch(NumberFormatException e ) {
	            request.setAttribute("estado", "error");
	        }
	        catch(NullPointerException c) {
	        	request.setAttribute("estado", "error");
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
