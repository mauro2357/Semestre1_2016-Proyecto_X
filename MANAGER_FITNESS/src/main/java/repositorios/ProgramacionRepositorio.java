package repositorios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
	          ResultSet rs = st.executeQuery("Select Hor_id as Horario, Usu_nombre as Entrenador from programacion p inner join usuarios u on p.Usu_id = u.Usu_id" ); 
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

}
