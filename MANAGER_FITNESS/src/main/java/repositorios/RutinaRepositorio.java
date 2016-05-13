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
	public static LinkedList<Rutinas> getCalorias()
	   {
	      LinkedList<Rutinas> listaCalorias=new LinkedList<Rutinas>();
	      try
	      {
	    	  Class.forName("com.mysql.jdbc.Driver");
	          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_manager_fitness", "root", "root");
	          Statement st= con.createStatement();
	          ResultSet rs = st.executeQuery("Select Rut_nombre as nombre, Rut_descripcion as descripcion, Rut_caloria as caloria from rutina" ); 
	         while (rs.next())
	         {
	        	String nombre =rs.getString("nombre");
	        	String descripcion = rs.getString("descripcion");
	        	int calorias = rs.getInt("caloria");
	        	Rutinas rutinas = new Rutinas(nombre, descripcion,calorias);
	            listaCalorias.add(rutinas);
	         }
	         rs.close();
	         st.close();
	         con.close();
	      }
	      catch (Exception e)
	      {
	         e.printStackTrace();
	      }
	      return listaCalorias;
	   }


}
