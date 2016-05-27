package repositorios;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import LogicaNegocio.Programacion;

public class ProgramacionRepositorio {
	
	public static LinkedList<Programacion>getProgramacion() throws Exception { 
		LinkedList<Programacion> listaProgramacion=new LinkedList<Programacion>();
		Connection con = (Connection) new conexion().ObtenerConexion();
	    String consulta ="SELECT U.Usu_nombre AS Entrenador, H.hor_descripcion AS Horario FROM programacion P INNER JOIN usuarios U ON P.Usu_id=U.Usu_id INNER JOIN horario H ON P.Hor_id=H.Hor_id;" ;
	    Statement st = con.createStatement();
	    ResultSet miconsulta = st.executeQuery(consulta);
	    while(miconsulta.next()){
	    	String nombreEntrenador =miconsulta.getString("Entrenador");
        	String horario =miconsulta.getString("Horario");
        	Programacion programacion = new Programacion(nombreEntrenador,horario);
            listaProgramacion.add(programacion);
	    }
	    st.close();
	    return listaProgramacion; 
	}
	
	public static boolean modificarProgramacion (Programacion programacion) throws Exception {
		try{
			Connection con = new conexion().ObtenerConexion();
		    Statement st = con.createStatement();
		    String insert= "update programacion SET Hor_id =" + programacion.getCodigoHorario() +" where Usu_id =" + programacion.getCedulaEntrenador()+";";
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
