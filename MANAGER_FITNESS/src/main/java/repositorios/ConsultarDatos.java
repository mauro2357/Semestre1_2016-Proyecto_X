package repositorios;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import repositorios.conexion;

public class ConsultarDatos {
	private static conexion con= new conexion();
    Statement st;
    
	public static int consultarCantidad() throws SQLException {
        String consulta= ("select count(*) as cantidad from bd_manager_fitness.usuarios;");  
        ResultSet miconsulta = con.ejecutarSQLSelect(consulta);
        	if(miconsulta.next()){
              int cant = miconsulta.getInt("cantidad");
              System.out.println(cant);
              return cant;
            }
       return 0;     
   }
	
	
}





