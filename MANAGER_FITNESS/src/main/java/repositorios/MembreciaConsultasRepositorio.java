package repositorios;

import java.sql.ResultSet;
import java.sql.Statement;
import com.mysql.jdbc.Connection;
import LogicaNegocio.Imc;

public class MembreciaConsultasRepositorio {
	
	public static boolean validarDataCredito(int id) throws Exception { 
		Connection con = (Connection) new conexion().ObtenerConexion();
	    String consulta = "select * from `bd_manager_fitness`.`datacredito` where Usu_id =" + id + ";";
	    Statement st = con.createStatement();
	    ResultSet miconsulta = st.executeQuery(consulta);
	    if(miconsulta.next())return true;
	    st.close();
	    return false; 
	}
	
	public static boolean validarPruebaEsfuerzo(int id) throws Exception { 
		Connection con = (Connection) new conexion().ObtenerConexion();
	    String consulta ="select * from `bd_manager_fitness`.`cliente` where Usu_id =" + id +" and Cli_pesfuerzo>50; ";
	    Statement st = con.createStatement();
	    ResultSet miconsulta = st.executeQuery(consulta);
	    if(miconsulta.next())return true;
	    st.close();
	    return false; 
	}
	
	public static String consultarFechaIns(int id) throws Exception { 
		Connection con = (Connection) new conexion().ObtenerConexion();
	    String consulta ="select Cli_fecha_inscripcion as fecha1 from bd_manager_fitness.cliente where Usu_id = "+id +";";
	    Statement st = con.createStatement();
	    ResultSet miconsulta = st.executeQuery(consulta);
	    String fecha = null;
	    if(miconsulta.next()){
	    	fecha=miconsulta.getString("fecha1");
	    }
	    st.close();
	    return fecha; 
	}
	
	public static double consultarImc(int id) throws Exception { 
		Connection con = (Connection) new conexion().ObtenerConexion();
	    String consulta ="select Pro_peso as peso, Pro_estatura as estatura from bd_manager_fitness.proceso where Usu_id = "+id + " order by Pro_fecha desc limit 1;";
	    Statement st = con.createStatement();
	    ResultSet miconsulta = st.executeQuery(consulta);
	    Imc mi_imc = null;
	    if(miconsulta.next()){
	    	Double peso = miconsulta.getDouble("peso");
            Double estatura = miconsulta.getDouble("estatura");
	    	mi_imc=new Imc(peso, estatura);
	    }
	    st.close();
	    return mi_imc.imc(); 
	}
	public static boolean consultarDisponibilidad() throws Exception { 
		Connection con = (Connection) new conexion().ObtenerConexion();
		String consulta1= ("select count(*) as numMembrecias from bd_manager_fitness.mensualidad where Tim_codigo = 3;");
        String consulta2= ("select count(*) as numEntrenadores from bd_manager_fitness.entrenador where Tip_codigo = 'ANX';");
	    Statement st = con.createStatement();
	    ResultSet miconsulta1 = st.executeQuery(consulta1);
	    ResultSet miconsulta2 = st.executeQuery(consulta2);
	    int numMembrecias=0; 
        int numEntrenadores=0;
	    if(miconsulta1.next()){
	    	numMembrecias = miconsulta1.getInt("numMembrecias");
	    }
	    if(miconsulta2.next()){
            numEntrenadores = miconsulta2.getInt("numEntrenadores");
        }
	    st.close();
	    if ((numMembrecias == 0 && numEntrenadores != 0) || numMembrecias%numEntrenadores != 0 )return true;
	    return false;      
	}
}
