package repositorios;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import LogicaNegocio.Eventos;

public class EntrenadorRepositorio {
	
	public static LinkedList<Eventos>getEventos() throws Exception { 
		LinkedList<Eventos> listaEventos=new LinkedList<Eventos>();
		Connection con = (Connection) new conexion().ObtenerConexion();
	    String consulta = "SELECT eve_fecha as Fecha, Eve_descripcion as Descripcion, Usu_nombre as Entrenador, Eve_codigo as Codigo FROM evento E INNER JOIN usuarios U ON E.Usu_id=U.Usu_id";
	    Statement st = con.createStatement();
	    ResultSet miconsulta = st.executeQuery(consulta);
	    while(miconsulta.next()){
	    	String fecha=miconsulta.getString("Fecha");
        	String descripcion=miconsulta.getString("Descripcion");
        	String entrenador = miconsulta.getString("Entrenador");
        	int codigo = miconsulta.getInt("Codigo");
            Eventos eventos = new Eventos(fecha, descripcion,0,entrenador, codigo);
            listaEventos.add(eventos);
	    }
	    st.close();
	    return listaEventos; 
	}
	
	public static boolean modificarEventos (Eventos evento) throws Exception {
		try{
			Connection con = new conexion().ObtenerConexion();
		    Statement st = con.createStatement();
		    String insert= "update evento SET Eve_estado = false where Eve_codigo =" + evento.getCodigo()+";";
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
	
}
