package controladores;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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

import repositorios.ProcesoRepositorio;
import repositorios.ReciboRepositorio;


@WebServlet("/RecibosControlador")
public class RecibosControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd;
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		PrintWriter out= response.getWriter();
	    response.setContentType("text/html;charset=UTF-8");
	    String str = request.getSession().getAttribute("usuario").toString();
	    int id= Integer.parseInt(str);
        try{
        	if(request.getParameter("formulario").equals("generar")){
	        	 int cedula = Integer.parseInt(request.getParameter("id"));
	        	 String recibo=ReciboRepositorio.GenerarReporte(cedula);
	        	 File archivo= new File("C:\\Users\\jessica\\Desktop\\recibo.txt");
	             if (!archivo.exists()) {
	 				archivo.createNewFile();
	 				System.out.println("Se ha creado el archivo");    				
	 			}            	
	             FileWriter w = new FileWriter(archivo);
	             BufferedWriter bw = new BufferedWriter(w);
	             bw.write(recibo);                
	             bw.close();
	             
	             out.print("<p style=\"color:blue\">SE GENERO EL RECIBO DE PAGO EXITOSAMENTE</p>");    
            	 rd=request.getRequestDispatcher("VistaAdministrador.jsp"); 
            	 rd.include(request,response);
            	 out.close();	 
            	 
        	}else if(request.getParameter("formulario").equals("estado")){
        		int dif= ReciboRepositorio.ConsultarEstado(id);
        		if (dif<30){
        			request.setAttribute("mensualidad","Activa");
   	             	rd = request.getRequestDispatcher("VistaHome.jsp");
   	             	rd.forward(request, response);
        		}else{
        			request.setAttribute("mensualidad","Inactiva");
   	             	rd = request.getRequestDispatcher("VistaHome.jsp");
   	             	rd.forward(request, response);
        		}
       	}
        	
        } catch (NumberFormatException e) {
            request.setAttribute("estado", "error");
         }finally{

         }
   
        }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
