package repositorios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import LogicaNegocio.Rutinas;

public class RutinaRepositorio {
	public static LinkedList<Rutinas> getRutinas()
	   {
	      LinkedList<Rutinas> listaRutinas=new LinkedList<Rutinas>();
	      try
	      {
	    	  Class.forName("com.mysql.jdbc.Driver");
	          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_manager_fitness", "root", "root");
	          Statement st= con.createStatement();
	          ResultSet rs = st.executeQuery("Select Rut_codigo as codigo, Rut_nombre as nombre from rutina" ); 
	         while (rs.next())
	         {
	        	String nombre =rs.getString("nombre");
	        	int codigo = rs.getInt("codigo");
	        	Rutinas rutinas = new Rutinas(codigo,nombre);
	            listaRutinas.add(rutinas);
	         }
	         rs.close();
	         st.close();
	         con.close();
	      }
	      catch (Exception e)
	      {
	         e.printStackTrace();
	      }
	      return listaRutinas;
	   }


}
