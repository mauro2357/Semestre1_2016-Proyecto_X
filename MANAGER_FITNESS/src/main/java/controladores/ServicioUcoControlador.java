package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import LogicaNegocio.AnuncioUcoServicio;
import repositorios.UCOMapsRepositorio;

@WebServlet("/ServicioUcoControlador")
public class ServicioUcoControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd;
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PrintWriter out= response.getWriter();
	    response.setContentType("text/html;charset=UTF-8");
	    
        if(request.getParameter("formulario").equals("crearAnuncio")){
       		String titulo= request.getParameter("titulo");
            String descripcion =request.getParameter("descripcion");
            AnuncioUcoServicio anuncio= new AnuncioUcoServicio(titulo, descripcion); 
            UCOMapsRepositorio.crearAnuncio(anuncio);
            out.print("<p style=\"color:red\">GRACIAS POR AYUDARNOS A MEJORAR</p>");    
          	rd=request.getRequestDispatcher("VistaHome.jsp"); 
          	rd.include(request,response); 
	    }
	}
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
