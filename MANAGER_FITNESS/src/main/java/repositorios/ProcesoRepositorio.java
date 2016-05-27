package repositorios;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import LogicaNegocio.Proceso;
import LogicaNegocio.TipoProceso;


public class ProcesoRepositorio {
	
	public static LinkedList<TipoProceso>getTipoProceso() throws Exception { 
		LinkedList<TipoProceso> listaTipoProceso=new LinkedList<TipoProceso>();
		Connection con = (Connection) new conexion().ObtenerConexion();
	    String consulta = "SELECT Tip_codigo as codigo, Tip_descripcion as descripcion FROM bd_manager_fitness.tipo_proceso";
	    Statement st = con.createStatement();
	    ResultSet miconsulta = st.executeQuery(consulta);
	    while(miconsulta.next()){
	    	String codigo =miconsulta.getString("codigo");
        	String descripcion=miconsulta.getString("descripcion");
            TipoProceso proceso = new TipoProceso(codigo, descripcion);
            listaTipoProceso.add(proceso);
	    }
	    st.close();
	    return listaTipoProceso;
	}
	public static boolean agregar (Proceso proceso) throws Exception {
		try{
			Connection con = new conexion().ObtenerConexion();
		    String insert = "INSERT INTO proceso(Pro_peso, Pro_fecha, Rut_codigo, Usu_id, Pro_observacion, Tip_codigo, Pro_estatura)" + " VALUES (" + proceso.getPeso() + ",'" + proceso.getFecha() + "'," + proceso.getRutina() + "," + proceso.getId() + ",'" + proceso.getObservacion() + "','" + proceso.getTipoProceso() + "'," + proceso.getEstatura() + ")";
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
	
	public static LinkedList<Proceso>getProceso(int id) throws Exception { 
		LinkedList<Proceso> listaProceso=new LinkedList<Proceso>();
		Connection con = (Connection) new conexion().ObtenerConexion();
	    String consulta = "select P.pro_fecha as Fecha, P.pro_peso as Peso, P.Pro_estatura as Estatura,TP.Tip_descripcion as Proceso, R.Rut_nombre as Rutina, P.Pro_observacion as Observacion  From proceso P, Rutina R,tipo_proceso TP where P.Rut_codigo= R.Rut_codigo and P.tip_codigo= TP.tip_codigo and P.usu_id=" + id ;
	    Statement st = con.createStatement();
	    ResultSet miconsulta = st.executeQuery(consulta);
	    while(miconsulta.next()){
	    	String fecha =miconsulta.getString("Fecha");
        	double peso = miconsulta.getDouble("Peso");
        	double estatura = miconsulta.getDouble("Estatura");
        	String proceso =miconsulta.getString("Proceso");
        	String rutina =miconsulta.getString("Rutina");
        	String observacion =miconsulta.getString("Observacion");
            Proceso miproceso = new Proceso(peso,estatura,observacion,fecha,proceso,rutina);
            listaProceso.add(miproceso);
	    }
	    st.close();
	    return listaProceso; 
	}
}


