package repositorios;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import LogicaNegocio.Rutinas;

public class RutinaRepositorio {
	
	public static LinkedList<Rutinas>getRutinas() throws Exception { 
		LinkedList<Rutinas> listaRutinas=new LinkedList<Rutinas>();
		Connection con = (Connection) new conexion().ObtenerConexion();
	    String consulta = "Select Rut_codigo as codigo, Rut_nombre as nombre from rutina";
	    Statement st = con.createStatement();
	    ResultSet miconsulta = st.executeQuery(consulta);
	    while(miconsulta.next()){
	    	String nombre =miconsulta.getString("nombre");
        	int codigo = miconsulta.getInt("codigo");
        	Rutinas rutinas = new Rutinas(codigo,nombre);
            listaRutinas.add(rutinas);
	    }
	    st.close();
	    return listaRutinas; 
	}
	
	public static LinkedList<Rutinas> getCalorias() throws Exception{
	      LinkedList<Rutinas> listaCalorias=new LinkedList<Rutinas>();
	      Connection con = (Connection) new conexion().ObtenerConexion();
		  String consulta = "Select Rut_nombre as nombre, Rut_descripcion as descripcion, Rut_caloria as caloria from rutina";
		  Statement st = con.createStatement();
		  ResultSet miconsulta = st.executeQuery(consulta);
	      while (miconsulta.next()){
	    	  String nombre =miconsulta.getString("nombre");
	          String descripcion = miconsulta.getString("descripcion");
	          int calorias = miconsulta.getInt("caloria");
	          Rutinas rutinas = new Rutinas(nombre, descripcion,calorias);
	          listaCalorias.add(rutinas);	
	      }
	      st.close();
	      return listaCalorias;
	   }


}
