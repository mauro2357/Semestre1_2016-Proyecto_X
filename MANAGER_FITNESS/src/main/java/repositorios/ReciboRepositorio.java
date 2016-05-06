package repositorios;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReciboRepositorio {
	private static conexion con= new conexion();
    Statement st;
	
	public static String GenerarReporte(int id) throws SQLException {
        String consulta= ("select M.men_fecha as Fecha, TM.Tim_dias as Num_Dias, TM.Tim_valor as Precio, TM.Tim_descripcion as Descripcion, U.Usu_nombre as Cliente from mensualidad M, tipo_mensualidad TM, usuarios U where M.tim_codigo=TM.tim_codigo and M.usu_id= U.usu_id and M.Usu_id="+id);  
        ResultSet miconsulta = con.ejecutarSQLSelect(consulta);
        	if(miconsulta.next()){
              String reciboPago= "Fecha= "+miconsulta.getString("Fecha")+"\r\n"+
            		  			"Num_Dias= "+miconsulta.getString("Num_Dias")+"\r\n"+
            		  			"Precio= "+miconsulta.getString("Precio")+"\r\n"+
            		  			"Descripcion= "+miconsulta.getString("Descripcion")+"\r\n"+
            		  			"Cliente= "+miconsulta.getString("Cliente");
              return reciboPago;
            }
       return "";     
   }

}
