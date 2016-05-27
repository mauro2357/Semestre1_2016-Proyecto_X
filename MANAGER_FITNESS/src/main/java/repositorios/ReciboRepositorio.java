package repositorios;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import LogicaNegocio.Fecha;

public class ReciboRepositorio {
	
	public static String GenerarReporte(int id) throws Exception { 
		Connection con = (Connection) new conexion().ObtenerConexion();
	    String consulta = "select M.men_fecha as Fecha, TM.Tim_dias as Num_Dias, TM.Tim_valor as Precio, TM.Tim_descripcion as Descripcion, U.Usu_nombre as Cliente from mensualidad M, tipo_mensualidad TM, usuarios U where M.tim_codigo=TM.tim_codigo and M.usu_id= U.usu_id and M.Usu_id="+id;
	    Statement st = con.createStatement();
	    ResultSet miconsulta = st.executeQuery(consulta);
	    String reciboPago = null;
	    if(miconsulta.next()){
            reciboPago= "Fecha= "+miconsulta.getString("Fecha")+"\r\n"+
          		  			"Num_Dias= "+miconsulta.getString("Num_Dias")+"\r\n"+
          		  			"Precio= "+miconsulta.getString("Precio")+"\r\n"+
          		  			"Descripcion= "+miconsulta.getString("Descripcion")+"\r\n"+
          		  			"Cliente= "+miconsulta.getString("Cliente");
	    }
	    st.close();
	    return reciboPago;
	}

	public static int ConsultarEstado(int id) throws Exception {
		Connection con = (Connection) new conexion().ObtenerConexion();
        String consulta= ("Select men_fecha as Fecha From mensualidad where usu_id= "+id+" order by Men_fecha desc limit 1");  
        Statement st = con.createStatement();
	    ResultSet miconsulta = st.executeQuery(consulta);
        String fecha=null;
        if(miconsulta.next()){
             fecha= miconsulta.getString("Fecha"); 	  
        }
        return Fecha.diferencia(fecha);
             
   }

}
