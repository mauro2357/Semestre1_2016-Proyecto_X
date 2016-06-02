package repositorios;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import LogicaNegocio.Animalex;
import LogicaNegocio.Membrecia;
import LogicaNegocio.Practicante;
import LogicaNegocio.Principiante;

public class MembreciaRepositorio {
	
	public static boolean agregarMembrecia(Membrecia membrecia) throws Exception {
        try {
        	Connection con = new conexion().ObtenerConexion();
        	Statement st = con.createStatement();
            if (membrecia instanceof Principiante){
	            String insert = "INSERT INTO mensualidad(Men_fecha,Tim_codigo,Usu_id)" + " VALUES ('" + membrecia.getFecha() + "'," + 1 + ","+ membrecia.getUsuId() + ");";
	            st.executeUpdate(insert);
	            st.close();
            }
            else if (membrecia instanceof Practicante){
            	String insert = "INSERT INTO mensualidad(Men_fecha,Tim_codigo,Usu_id)" + " VALUES ('" + membrecia.getFecha() + "'," + 2 + ","+ membrecia.getUsuId() + ");";
	            st.executeUpdate(insert);
	            st.close();
            }
            else if (membrecia instanceof Animalex){
            	String insert = "INSERT INTO mensualidad(Men_fecha,Tim_codigo,Usu_id)" + " VALUES ('" + membrecia.getFecha() + "'," + 3 + ","+ membrecia.getUsuId() + ");";    
	            st.executeUpdate(insert);
	            st.close();
            }
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

