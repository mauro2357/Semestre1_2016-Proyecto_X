package repositorios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class conexion {
    private Connection con = null;
    private Statement st = null;
    
    public conexion() {
	    try {
	     Class.forName("com.mysql.jdbc.Driver").newInstance();
	     con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_manager_fitness","root", "root");
	    } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
	    	e.printStackTrace();
	    }
   }

   public Connection getConexion(){
    return con;
   }
   public ResultSet ejecutarSQLSelect(String select) {
		ResultSet resultado; 
	   	try {
	   	    st= (Statement) 
	   	    con.createStatement();
	   	    resultado = st.executeQuery(select);
	   	} catch (SQLException ex) {
	   		return null;
	   	}
	   	return resultado;
	}

   
}
