package repositorios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import LogicaNegocio.Eventos;
import LogicaNegocio.Usuarios;

public class EventosRepositorio {

	 public static boolean agregar(Eventos evento) {
	        Connection con;
	        Statement st;
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_manager_fitness", "root", "root");
	            st = con.createStatement();
	            String i = "INSERT INTO evento(Eve_fecha,Usu_id, Eve_descripcion)" + " VALUES ('" + evento.getFecha() + "'," + evento.getIdEntrenador() + ",'" + evento.getDescripcion()+ "')";    
	            System.out.println(i);
	            st.executeUpdate(i);
	            st.close();
	        }catch (SQLException e){
	        	System.out.println("entro en el catch");
	        	e.printStackTrace();
	        	return false;
	        }catch (ClassNotFoundException e){
	        	e.printStackTrace();
	            System.out.println("La clase no existe");
	            return false;
	        }
	        return true;
	    }
	 
	 public static LinkedList<Eventos> getEventos()
	   {
	      LinkedList<Eventos> listaEventos=new LinkedList<Eventos>();
	      try
	      {
	    	  Class.forName("com.mysql.jdbc.Driver");
	          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_manager_fitness", "root", "root");
	          Statement st= con.createStatement();
	          ResultSet rs = st.executeQuery("SELECT eve_fecha as Fecha, Eve_descripcion as Descripcion, Usu_nombre as Entrenador FROM EVENTO E INNER JOIN usuarios U ON E.Usu_id=U.Usu_id" ); 
	         while (rs.next())
	         {
	        	String fecha=rs.getString("Fecha");
	        	String descripcion=rs.getString("Descripcion");
	        	String nombre =rs.getString("Entrenador");
	            Eventos evento = new Eventos(fecha, descripcion, nombre);
	            listaEventos.add(evento);
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
}
