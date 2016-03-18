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
import repositorios.MembreciaRepositorio;


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
        		 System.out.println("if");
	        	 String fecha=Fecha.ObtenerFecha();
	             Membrecia principiante= new Principiante(fecha,id);
	             if (principiante.comprar()){
	            	 System.out.println("comprar");
		             if(MembreciaRepositorio.agregarMembrecia(principiante)){
		            	 System.out.println("repositorio");
		            	 rd= request.getRequestDispatcher("VistaHome.jsp");
		            	 rd.forward(request, response);
		            	 out.close();
		            	 
		             }
	             }
	            else{
	            	 rd=request.getRequestDispatcher("redireccion.html");
	            	 rd.forward(request, response); 
	             }
        	}
        	else if(request.getParameter("formulario").equals("comprarPracticante")){
	        	 String fecha=Fecha.ObtenerFecha();
	             Membrecia practicante= new Practicante(fecha,id);
	             if (practicante.comprar()){
		             if(MembreciaRepositorio.agregarMembrecia(practicante)){
		            	 rd= request.getRequestDispatcher("VistaHome.jsp");
		            	 rd.forward(request, response);
		            	 out.close();
		             }
	             }
	            else{
	            	 rd=request.getRequestDispatcher("redireccion.html");
	            	 rd.forward(request, response); 
	             }
        	}
        	else if(request.getParameter("formulario").equals("comprarAnimalex")){
	        	 String fecha=Fecha.ObtenerFecha();
	             Membrecia animalex= new Animalex(fecha,id);
	             if (animalex.comprar()){
		             if(MembreciaRepositorio.agregarMembrecia(animalex)){
		            	 rd= request.getRequestDispatcher("VistaHome.jsp");
		            	 rd.forward(request, response);
		            	 out.close();
		             }
	             }
	            else{
	            	 rd=request.getRequestDispatcher("redireccion.html");
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