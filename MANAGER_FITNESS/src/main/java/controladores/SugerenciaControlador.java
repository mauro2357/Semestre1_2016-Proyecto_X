package controladores;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LogicaNegocio.Fecha;
import LogicaNegocio.Sugerencias;
import repositorios.ConsultasRepositorio;
import repositorios.SugerenciaRepositorio;
import LogicaNegocio.Correo;




@WebServlet("/SugerenciaControlador")
public class SugerenciaControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd;
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PrintWriter out= response.getWriter();
	    response.setContentType("text/html;charset=UTF-8");
	    String str = request.getSession().getAttribute("usuario").toString();
	    int id= Integer.parseInt(str);
        if(request.getParameter("formulario").equals("sugerencia")){
       		String fecha =Fecha.ObtenerFecha();
            String descripcion =request.getParameter("descripcion");
            String tipo =request.getParameter("tipo");
            Sugerencias sugerencia= new Sugerencias(fecha, descripcion, id,tipo);        
	        if(SugerenciaRepositorio.agregar(sugerencia)){
	        Correo correo  =new Correo(tipo,descripcion,"managerfitness2016@gmail.com");
			correo.sendEmail();
	         out.print("<p style=\"color:red\">GRACIAS POR AYUDARNOS A MEJORAR</p>");    
           	 rd=request.getRequestDispatcher("VistaHome.jsp"); 
           	 rd.include(request,response); 
	        }
	        else{
	        	out.print("<p style=\"color:red\">NO SE HA PODIDO REGISTRAR SU SUGERENCIA</p>");    
           	    rd=request.getRequestDispatcher("VistaSugerencias.jsp"); 
           	    rd.include(request,response);
	             }
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
