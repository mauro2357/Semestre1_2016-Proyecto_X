package dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class conexion {
    public Connection conexion;
    public boolean crearConexion() {
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
	        conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_mananger_fitness", "root", "root");
    	} catch (SQLException ex) {
    		ex.printStackTrace();
    		return false;
        } catch (ClassNotFoundException ex) {
        	ex.printStackTrace();
        	return false;
	    }
	        return true;
    }

	public boolean ejecutarSQL_registro(String a) {
		try {
            Statement sentencia = conexion.createStatement();
            sentencia.executeUpdate("INSERT INTO `bd_mananger_fitness`.`usuarios` VALUES  ("+ a +");");
            sentencia.close();
		 } catch (SQLException ex) {
	            ex.printStackTrace();
	            return false;
	        }
	        return true;
	    }
	public boolean ejecutarSQL_opinion(String b) {
		try {
            Statement sentencia = conexion.createStatement();
            sentencia.executeUpdate("INSERT INTO `bd_mananger_fitness`.`sugerencia` VALUES  ("+ b +");");
            sentencia.close();
		 } catch (SQLException ex) {
	            ex.printStackTrace();
	            return false;
	        }
	        return true;
	    }
	public ResultSet ejecutarSQLSelect(String select) {
		ResultSet resultado; 
	   	try {
	   	    Statement sentencia = (Statement) conexion.createStatement();
	   	    resultado = sentencia.executeQuery(select);    
	   	} catch (SQLException ex) {
	   	    return null;
	   	} 
	   	return resultado;
	}
}