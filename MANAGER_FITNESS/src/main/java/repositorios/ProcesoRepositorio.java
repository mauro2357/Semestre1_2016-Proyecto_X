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
	
	public static double consultarImc(int id) throws SQLException {
		conexion con= new conexion();
        String consulta= ("Select Pro_peso as Peso, Pro_estatura as Estatura From proceso  where Usu_id= "+id+" order by pro_fecha desc limit 1");  
        ResultSet miconsulta = con.ejecutarSQLSelect(consulta);
        	if(miconsulta.next()){
        	  double peso=miconsulta.getDouble("Peso");
        	  double estatura=miconsulta.getDouble("Estatura");
              return peso/(estatura*estatura);
            }
       return 0;     
   }
	
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
	          ResultSet rs = st.executeQuery("select P.pro_fecha as Fecha, P.pro_peso as Peso, P.Pro_estatura as Estatura,TP.Tip_descripcion as Proceso, R.Rut_nombre as Rutina, P.Pro_observacion as Observacion  From proceso P, Rutina R,tipo_proceso TP where P.Rut_codigo= R.Rut_codigo and P.tip_codigo= TP.tip_codigo and P.usu_id=" + id ); 
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


