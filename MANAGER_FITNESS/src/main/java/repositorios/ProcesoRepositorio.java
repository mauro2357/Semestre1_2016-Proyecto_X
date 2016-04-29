package repositorios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import LogicaNegocio.Proceso;
import LogicaNegocio.TipoProceso;


public class ProcesoRepositorio {
	public static LinkedList<TipoProceso> getTipoProceso()
	   {
	      LinkedList<TipoProceso> listaTipoProceso=new LinkedList<TipoProceso>();
	      try
	      {
	    	  Class.forName("com.mysql.jdbc.Driver");
	          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_manager_fitness", "root", "root");
	          Statement st= con.createStatement();
	          ResultSet rs = st.executeQuery("SELECT Tip_codigo as codigo, Tip_descripcion as descripcion FROM bd_manager_fitness.tipo_proceso" ); 
	         while (rs.next())
	         {
	        	String codigo =rs.getString("codigo");
	        	String descripcion=rs.getString("descripcion");
	            TipoProceso proceso = new TipoProceso(codigo, descripcion);
	            listaTipoProceso.add(proceso);
	         }
	         rs.close();
	         st.close();
	         con.close();
	      }
	      catch (Exception e)
	      {
	         e.printStackTrace();
	      }
	      return listaTipoProceso;
	   }
	public static boolean agregarProceso(Proceso proceso) {
        Connection con;
        Statement st;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_manager_fitness", "root", "root");
            st = con.createStatement();
            String i = "INSERT INTO proceso(Pro_peso, Pro_fecha, Rut_codigo, Usu_id, Pro_observacion, Tip_codigo, Pro_estatura)" + " VALUES (" + proceso.getPeso() + ",'" + proceso.getFecha() + "'," + proceso.getRutina() + "," + proceso.getId() + ",'" + proceso.getObservacion() + "','" + proceso.getTipoProceso() + "'," + proceso.getEstatura() + ")";    
            System.out.println(i);
            st.executeUpdate(i);
            st.close();
        }catch (SQLException e){
        	System.out.println("entro en el catch");
        	e.printStackTrace();
        	return false;
        }catch (ClassNotFoundException e){
        	e.printStackTrace();
            System.out.println("La clase no existe");
            return false;
        }
        return true;
	}
	public static LinkedList<Proceso> getProceso(int id)
	   {
	      LinkedList<Proceso> listaProceso=new LinkedList<Proceso>();
	      try
	      {
	    	  Class.forName("com.mysql.jdbc.Driver");
	          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_manager_fitness", "root", "root");
	          Statement st= con.createStatement();
	          ResultSet rs = st.executeQuery("select P.pro_fecha as Fecha, P.pro_peso as Peso, P.Pro_estatura as Estatura,TP.Tip_descripcion as Proceso, R.Rut_nombre as Rutina, P.Pro_observacion as Observacion  From proceso P, Rutina R, Usuarios u, tipo_proceso TP where U.usu_id=P.usu_id and P.usu_id=" + id ); 
	         while (rs.next())
	         {
	        	String fecha =rs.getString("Fecha");
	        	double peso = rs.getDouble("Peso");
	        	double estatura = rs.getDouble("Estatura");
	        	String proceso =rs.getString("Proceso");
	        	String rutina =rs.getString("Rutina");
	        	String observacion =rs.getString("Observacion");
	            Proceso miproceso = new Proceso(peso,estatura,observacion,fecha,proceso,rutina);
	            listaProceso.add(miproceso);
	         }
	         rs.close();
	         st.close();
	         con.close();
	      }
	      catch (Exception e)
	      {
	         e.printStackTrace();
	      }
	      return listaProceso;
	   }
}


