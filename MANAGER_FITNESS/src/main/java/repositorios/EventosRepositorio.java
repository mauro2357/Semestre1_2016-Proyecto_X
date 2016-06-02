package repositorios;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import LogicaNegocio.Eventos;


public class EventosRepositorio {
	
	public static boolean agregar (Eventos evento) throws Exception {
		try{
			Connection con = new conexion().ObtenerConexion();
		    String insert = "INSERT INTO evento(Eve_fecha,Usu_id, Eve_descripcion)" + " VALUES ('" + evento.getFecha() + "'," + evento.getIdEntrenador() + ",'" + evento.getDescripcion()+ "')";
		    Statement st = con.createStatement();
		    st.executeUpdate(insert);
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
	
	public static LinkedList<Eventos>getEventos() throws Exception { 
		LinkedList<Eventos> listaEventos=new LinkedList<Eventos>();
		Connection con = (Connection) new conexion().ObtenerConexion();
	    String consulta = "SELECT eve_fecha as Fecha, Eve_descripcion as Descripcion, Usu_nombre as Entrenador FROM evento E INNER JOIN usuarios U ON E.Usu_id=U.Usu_id";
	    Statement st = con.createStatement();
	    ResultSet miconsulta = st.executeQuery(consulta);
	    while(miconsulta.next()){
	    	String fecha=miconsulta.getString("Fecha");
        	String descripcion=miconsulta.getString("Descripcion");
        	String nombre =miconsulta.getString("Entrenador");
        	Eventos evento = new Eventos(fecha, descripcion, 0,nombre, 0);
            listaEventos.add(evento);
	    }
	    st.close();
	    return listaEventos; 
	}
}
