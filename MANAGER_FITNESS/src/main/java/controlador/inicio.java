package controlador;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 
import dto.conexion;

@WebServlet("/inicio")
public class inicio extends HttpServlet {
    private String u;
    private String p;
    private RequestDispatcher rd;
    private conexion miconexion= new conexion();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         try{
        if(request.getParameter("formulario").equals("login")){
             u = "'" + request.getParameter("usuario") + "'";
             p = "'" + request.getParameter("password") + "'";
             System.out.println("hola");
             this.login();
            if(this.login()){
                System.out.println("hola ee");
		rd= request.getRequestDispatcher("home.html");
		rd.forward(request,response);
		}else{
			rd= request.getRequestDispatcher("login.html");
                        rd.forward(request,response);
		} 
	}
        } catch (NumberFormatException e) {
            request.setAttribute("estado", "error");
        } finally {
            rd = request.getRequestDispatcher("login.html");
            rd.forward(request, response);
        }
         if(request.getParameter("formulario").equals("registrar")){
            String id ="'"+ request.getParameter("id")+"',";
            String n ="'"+ request.getParameter("nombre")+"',";
            String fn ="'"+ request.getParameter("fechaN")+"',";
            String dir ="'"+ request.getParameter("direccion")+"',";
            String tel = "'"+request.getParameter("tel")+"',";
            String email ="'"+ request.getParameter("email")+"',"; 
            String c= "'"+ request.getParameter("password")+"',";
            String tc = "'"+ request.getParameter("tipou")+"'";
            String todos = id+n+fn+dir+tel+email+c+tc;
            System.out.println(todos);
            conexion datos = new conexion();
            datos.crearConexion();
            if(datos.ejecutarSQL_registro(todos)){
                rd = request.getRequestDispatcher("entrenador.html");
                rd.forward(request, response);
            } 
            else
            {
                rd = request.getRequestDispatcher("redireccion.html");
                rd.forward(request, response);
            }    
         }
         
         if (request.getParameter("formulario").equals("opinion")){
        	 String id ="'"+ request.getParameter("id")+"'";
             String fecha ="'"+ request.getParameter("fecha")+"',";
             String descripcion ="'"+ request.getParameter("descripcion")+"',";
             String opinion = descripcion + fecha + id;
             System.out.println(opinion);
             conexion mi_opinion = new conexion();
             mi_opinion.crearConexion();
             if(mi_opinion.ejecutarSQL_opinion(opinion)){
                 rd = request.getRequestDispatcher("home.html");
                 rd.forward(request, response);
             } 
             else 
             {
                 rd = request.getRequestDispatcher("redireccion.html");
                 rd.forward(request, response);
             }    
        	 
         }
    }
    public boolean login(){
        try{
            String consulta= "select * from 'bd_mananger_fitness'.'usuarios' where Usu_id="+ u + " and Usu_contrase�a=" + p + ";";
            miconexion.crearConexion();  
            ResultSet miconsulta = miconexion.ejecutarSQLSelect(consulta);
            if(miconsulta.next()){
                return true;
            }
        } 
             catch (SQLException ex){
		Logger.getLogger(inicio.class.getName()).log(Level.SEVERE, null, ex);
		return false;
              }
		return false;
		
	}

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private boolean ejecutarSQL() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}


