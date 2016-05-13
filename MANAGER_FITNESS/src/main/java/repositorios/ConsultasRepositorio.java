package repositorios;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import LogicaNegocio.Login;
import repositorios.conexion;

public class ConsultasRepositorio {
	private static conexion con= new conexion();
    Statement st;
    
	public static int consultarCantidad() throws SQLException {
        String consulta= ("select count(*) as cantidad from bd_manager_fitness.usuarios where Tip_codigo = 'CLIN';");  
        ResultSet miconsulta = con.ejecutarSQLSelect(consulta);
        	if(miconsulta.next()){
              int cant = miconsulta.getInt("cantidad");
              return cant;
            }
       return 0;     
   }
	public static boolean autenticar(Login login) {
		try{
            String consulta = "select * from `bd_manager_fitness`.`usuarios` where Usu_id =" + login.getId() + " and Usu_password ='" + login.getPass() + "';";
            ResultSet miconsulta = con.ejecutarSQLSelect(consulta);
            if (miconsulta.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasRepositorio.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return false;
    }
	
	public static String ConsultarUsuario(Login prueba){
		try{
            String consulta = "select Tip_codigo from `bd_manager_fitness`.`usuarios` where Usu_id =" + prueba.getId() + " and Usu_password ='" + prueba.getPass() + "';";
            ResultSet miconsulta = con.ejecutarSQLSelect(consulta);
            if (miconsulta.next()) {
                return miconsulta.getString("Tip_codigo");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasRepositorio.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return null;
    }
		
	}



	
	






