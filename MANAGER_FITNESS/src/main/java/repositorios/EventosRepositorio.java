package repositorios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
}
