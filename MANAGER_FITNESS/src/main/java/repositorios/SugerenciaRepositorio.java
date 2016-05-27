package repositorios;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import LogicaNegocio.Sugerencias;

public class SugerenciaRepositorio {
	
	public static boolean agregar (Sugerencias sugerencia) throws Exception {
		try{
			Connection con = new conexion().ObtenerConexion();
			String insert = "INSERT INTO sugerencia(Sug_descripcion, Sug_fecha, Usu_id,Sug_tipo)" + " VALUES ('" + sugerencia.getDescripcion() + "','" + sugerencia.getFecha() + "','" + sugerencia.getIdUsuario() +"','" + sugerencia.getTipo() +"')";
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
	
}
