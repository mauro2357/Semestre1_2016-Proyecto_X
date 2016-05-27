package repositorios;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import LogicaNegocio.Horario;

public class HorarioRepositorio implements IHorarioRepositorio{
	
	public boolean agregar (Horario horario) throws Exception {
		try{
			Connection con = new conexion().ObtenerConexion();
		    String insert = "INSERT INTO programacion(Usu_id, Hor_id)" + " VALUES (" + horario.getUsu_id() + "," + horario.getHor_id() + ")";
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
	
	public static LinkedList<Horario>getHorario() throws Exception { 
		LinkedList<Horario> listaHorario=new LinkedList<Horario>();
		Connection con = (Connection) new conexion().ObtenerConexion();
	    String consulta = "select hor_descripcion as descripcion, Hor_id as codigo from horario;";
	    Statement st = con.createStatement();
	    ResultSet miconsulta = st.executeQuery(consulta);
	    while(miconsulta.next()){
	    	String descripcion=miconsulta.getString("descripcion");
        	int codigo=miconsulta.getInt("codigo");
        	Horario horario= new Horario(descripcion,codigo);
            listaHorario.add(horario);
	    }
	    st.close();
	    return listaHorario; 
	}
	
}
	
	

	

