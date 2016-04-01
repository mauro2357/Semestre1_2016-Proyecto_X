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

import LogicaNegocio.Animalex;
import LogicaNegocio.Fecha;
import LogicaNegocio.Membrecia;
import LogicaNegocio.Practicante;
import LogicaNegocio.Principiante;


@WebServlet("/MembreciaControlador")
public class MembreciaControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd;
       
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		PrintWriter out= response.getWriter();
	    response.setContentType("text/html;charset=UTF-8");
	    String str = request.getSession().getAttribute("usuario").toString();
	    int id= Integer.parseInt(str);
	    System.out.println(id);
        try{
        	if(request.getParameter("formulario").equals("comprarPrincipiante")){
	        	 String fecha=Fecha.ObtenerFecha();
	             Membrecia principiante= new Principiante(fecha,id);
	             if (principiante.comprar() && principiante.agregarbd()){
	            	 out.print("<p style=\"color:blue\">COMPRA EXITOSA</p>");    
	            	 rd=request.getRequestDispatcher("VistaHome.jsp"); 
	            	 rd.include(request,response);
	             }
	            else{
	            	out.print("<p style=\"color:blue\">NO CUMPLE CON LOS REQUISITOS PARA REALIZAR LA COMPRA</p>");    
	            	 rd=request.getRequestDispatcher("VistaHome.jsp"); 
	            	 rd.include(request,response); 
	             }
        	}
        	else if(request.getParameter("formulario").equals("comprarPracticante")){
	        	 String fecha=Fecha.ObtenerFecha();
	             Membrecia practicante= new Practicante(fecha,id);
	             if (practicante.comprar() && practicante.agregarbd()){
	            	 out.print("<p style=\"color:blue\">COMPRA EXITOSA</p>");    
	            	 rd=request.getRequestDispatcher("VistaHome.jsp"); 
	            	 rd.include(request,response);
		         }
	            else{
	            	out.print("<p style=\"color:blue\">NO CUMPLE CON LOS REQUISITOS PARA REALIZAR LA COMPRA</p>");    
	            	rd=request.getRequestDispatcher("VistaHome.jsp"); 
	                rd.include(request,response); 
	             }
        	}
        	else if(request.getParameter("formulario").equals("comprarAnimalex")){
	        	 String fecha=Fecha.ObtenerFecha();
	             Membrecia animalex= new Animalex(fecha,id);
	             if (animalex.comprar() && animalex.agregarbd()){
	            	 out.print("<p style=\"color:blue\">COMPRA EXITOSA</p>");    
	            	 rd=request.getRequestDispatcher("VistaHome.jsp"); 
	            	 rd.include(request,response);
	             }
	            else{
	            	out.print("<p style=\"color:blue\">NO CUMPLE CON LOS REQUISITOS PARA REALIZAR LA COMPRA</p>");    
	            	rd=request.getRequestDispatcher("VistaHome.jsp"); 
	            	rd.include(request,response); 
	             }
        	}
        	
        }catch(NumberFormatException e) {
            request.setAttribute("estado", "error");
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
