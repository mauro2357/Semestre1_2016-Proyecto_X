package repositorios;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import LogicaNegocio.Cliente;

public class EnfermedadRepositorio {
	
	public static boolean agregarEnfermedad (Cliente usuario) throws Exception {
		try{
			Connection con = new conexion().ObtenerConexion();
		    Statement st = con.createStatement();
		    String enfermedad=null;
		    for(int i = 0 ; i < usuario.getCodenfermedad().length ; ++i){
	             enfermedad = "INSERT INTO enfermedadxcliente (`Enf_codigo`,`Usu_id`) VALUES ('"+usuario.getCodenfermedad()[i]+"',"+usuario.getClinId()+");";
	             st.executeUpdate(enfermedad);
           }
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
