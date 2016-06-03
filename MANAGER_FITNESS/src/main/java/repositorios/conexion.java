package repositorios;

import java.sql.Connection;
import java.sql.DriverManager;

public class conexion {
   private static Connection con;
	
	public  Connection ObtenerConexion() throws Exception {
		    if(con!=null) return con;
			String driver = "com.mysql.jdbc.Driver";
		    Class.forName(driver);
		    con = DriverManager.getConnection("jdbc:mysql://mysql12469-projectx.j.facilcloud.com:3306/bd_manager_fitness","root", "root");
		    //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_manager_fitness","root", "root");
		    return con;
		
	  }
}