package repositorios;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import LogicaNegocio.Login;

public class ValidacionMembreciaRepositorio {
	private static conexion con= new conexion();
    Statement st;
	
	
	public static boolean validarDatacredito(int id) {
		try{
            String consulta = "select * from `bd_manager_fitness`.`datacredito` where Usu_id =" + id + ";";
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
	
	public static boolean validarPruebaEsfuerzo(int id) {
		try{
            String consulta = "select * from `bd_manager_fitness`.`cliente` where Usu_id =" + id +"and Cli_pesfuerzo>50; ";
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
	
	public static String consultarFechaIns(int id) throws SQLException {
        String consulta= ("select Cli_fecha_inscripcion as fecha1 from bd_manager_fitness.cliente where Usu_id = "+id +";");  
        ResultSet miconsulta = con.ejecutarSQLSelect(consulta);
        	if(miconsulta.next()){
              String fecha1 = miconsulta.getString("fecha1");
              return fecha1;
            }
       return "";     
   }
	public static double consultarImc(int id) throws SQLException {
        String consulta= ("select Pro_peso as peso, Pro_estatura as estatura from bd_manager_fitness.proceso where Usu_id = "+id + "order by Pro_fecha desc limit 1;");  
        ResultSet miconsulta = con.ejecutarSQLSelect(consulta);
        	if(miconsulta.next()){
              Double peso = miconsulta.getDouble("peso");
              Double estatura = miconsulta.getDouble("estatura");
              return peso/(estatura*estatura);
            }
       return 0;     
   }
	public static boolean consultarCantidad() throws SQLException {
        String consulta1= ("select count(*) as numMembrecias from bd_manager_fitness.mensualidad where Tim_codigo = 3;");
        String consulta2= ("select count(*) as numEntrenadores from bd_manager_fitness.entrenador where Tip_codigo = 'ANX';");
        ResultSet miconsulta1 = con.ejecutarSQLSelect(consulta1);
        ResultSet miconsulta2 = con.ejecutarSQLSelect(consulta2);
        int numMembrecias=0; 
        int numEntrenadores=0;
        if(miconsulta1.next()){
             numMembrecias = miconsulta1.getInt("numMembrecias");
         }
        if(miconsulta2.next()){
            numEntrenadores = miconsulta2.getInt("numEntrenadores");
        }
        if(numMembrecias%numEntrenadores != 0)return true;
       return false;     
   }
	
}
