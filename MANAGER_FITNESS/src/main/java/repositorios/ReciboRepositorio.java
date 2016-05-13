package repositorios;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import LogicaNegocio.Fecha;

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

	public static int ConsultarEstado(int id) throws SQLException {
        String consulta= ("Select men_fecha as Fecha From mensualidad where usu_id= "+id+" order by Men_fecha desc limit 1");  
        ResultSet miconsulta = con.ejecutarSQLSelect(consulta);
        String fecha="";
        if(miconsulta.next()){
             fecha= miconsulta.getString("Fecha"); 	  
        }
        return Fecha.diferencia(fecha);
             
   }

}
