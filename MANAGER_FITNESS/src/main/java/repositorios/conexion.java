package repositorios;

import java.sql.Connection;
import java.sql.DriverManager;

public class conexion {
   private static Connection con;
	
	public  Connection ObtenerConexion() throws Exception {
		    /*if(con!=null) return con;
			String driver = "com.mysql.jdbc.Driver";
		    Class.forName(driver);
		    con = DriverManager.getConnection("jdbc:mysql://mqqqysql12200-ucomaps.j.facilcloud.com/ucomaps","root", "Y9Rkh2Fsk6");
		    //con = DriverManager.getConnection("jdbc:mysql://mysql12198-managerfitness.j.facilcloud.com:11005/bd_manager_fitness","root", "Cb1LkP3zeL");
		  //  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_manager_fitness","root", "root");
		    return con;*/
		
		String driver ="com.mysql.jdbc.Driver";
		String connection = "jdbc:mysql://mysql12198-managerfitness.j.facilcloud.com:11005/bd_manager_fitness";
		//String connection="jdbc:mysql://localhost:3306/bd_manager_fitness";
		String user ="root";
		String password="Cb1LkP3zeL";
		//String password="root";
		
		/*String driver ="com.mysql.jdbc.Driver";
		String connection = "jdbc:mysql://localhost:3306/ucomaps";
		String user = "root";
		String pass = "";*/
		Class.forName(driver);
		con = DriverManager.getConnection(connection, user, password);
		return con;
	  }
}