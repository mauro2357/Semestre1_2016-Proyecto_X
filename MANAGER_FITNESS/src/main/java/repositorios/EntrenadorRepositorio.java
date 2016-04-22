package repositorios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import LogicaNegocio.Eventos;


public class EntrenadorRepositorio {

	public static LinkedList<Eventos> getEventos()
	   {
	      LinkedList<Eventos> listaEventos=new LinkedList<Eventos>();
	      try
	      {
	    	  Class.forName("com.mysql.jdbc.Driver");
	          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_manager_fitness", "root", "root");
	          Statement st= con.createStatement();
	          ResultSet rs = st.executeQuery("SELECT eve_fecha as Fecha, Eve_descripcion as Descripcion, Usu_nombre as Entrenador, Eve_codigo as Codigo FROM EVENTO E INNER JOIN usuarios U ON E.Usu_id=U.Usu_id");
	         while (rs.next())
	         {
	        	String fecha=rs.getString("Fecha");
	        	String descripcion=rs.getString("Descripcion");
	        	String entrenador = rs.getString("Entrenador");
	        	int codigo = rs.getInt("Codigo");
	            Eventos eventos = new Eventos(fecha, descripcion,entrenador, codigo);
	            listaEventos.add(eventos);
	         }
	         rs.close();
	         st.close();
	         con.close();
	      }
	      catch (Exception e)
	      {
	         e.printStackTrace();
	      }
	      return listaEventos;
	   }
	public static boolean modificar(Eventos evento) throws ClassNotFoundException {
	      try
	      {
	    	  Class.forName("com.mysql.jdbc.Driver");
	          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_manager_fitness", "root", "root");
	          Statement st= con.createStatement();
	          String i = "update evento SET Eve_estado = false where Eve_codigo =" + evento.getCodigo()+";";
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
