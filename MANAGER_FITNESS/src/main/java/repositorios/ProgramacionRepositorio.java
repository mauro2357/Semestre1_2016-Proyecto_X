package repositorios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import LogicaNegocio.Programacion;

public class ProgramacionRepositorio {
	public static LinkedList<Programacion> getProgramacion()
	   {
	      LinkedList<Programacion> listaProgramacion=new LinkedList<Programacion>();
	      try
	      {
	    	  Class.forName("com.mysql.jdbc.Driver");
	          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_manager_fitness", "root", "root");
	          Statement st= con.createStatement();
	          ResultSet rs = st.executeQuery("SELECT U.Usu_nombre AS Entrenador, H.hor_descripcion AS Horario FROM programacion P INNER JOIN usuarios U ON P.Usu_id=U.Usu_id INNER JOIN horario H ON P.Hor_id=H.Hor_id;" ); 
	         while (rs.next())
	         {
	        	String nombreEntrenador =rs.getString("Entrenador");
	        	String horario =rs.getString("Horario");
	        	Programacion programacion = new Programacion(nombreEntrenador,horario);
	            listaProgramacion.add(programacion);
	         }
	         rs.close();
	         st.close();
	         con.close();
	      }
	      catch (Exception e)
	      {
	         e.printStackTrace();
	      }
	      return listaProgramacion;
	   }
	public static boolean modificarProgramacion(Programacion programacion) throws ClassNotFoundException {
	      try
	      {
	    	  Class.forName("com.mysql.jdbc.Driver");
	          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_manager_fitness", "root", "root");
	          Statement st= con.createStatement();
	          String i = "update programacion SET Hor_id =" + programacion.getCodigoHorario() +" where Usu_id =" + programacion.getCedulaEntrenador()+";";
	          st.executeUpdate(i);
	          st.close();
	      }catch (SQLException e){
	        	e.printStackTrace();
	        	return false;
	        }catch (ClassNotFoundException e){
	        	e.printStackTrace();
	            return false;
	        }
	        return true;
	    }

}
