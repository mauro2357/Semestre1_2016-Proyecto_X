package repositorios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import LogicaNegocio.Animalex;
import LogicaNegocio.Membrecia;
import LogicaNegocio.Practicante;
import LogicaNegocio.Principiante;

public class MembreciaRepositorio {
	
	public static boolean agregarMembrecia(Membrecia membrecia) {
        Connection con;
        Statement st;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_manager_fitness", "root", "root");
            st = con.createStatement();
            if (membrecia instanceof Principiante){
	            String i = "INSERT INTO Mensualidad(Men_fecha,Tim_codigo,Usu_id)" + " VALUES ('" + membrecia.getFecha() + "'," + 1 + ","+ membrecia.getUsuId() + ");";
	            System.out.println(i);
	            st.executeUpdate(i);
	            st.close();
            }
            else if (membrecia instanceof Practicante){
            	String i = "INSERT INTO Mensualidad(Men_fecha,Tim_codigo,Usu_id)" + " VALUES ('" + membrecia.getFecha() + "'," + 2 + ","+ membrecia.getUsuId() + ");";
            	System.out.println(i);
	            st.executeUpdate(i);
	            st.close();
            }
            else if (membrecia instanceof Animalex){
            	String i = "INSERT INTO Mensualidad(Men_fecha,Tim_codigo,Usu_id)" + " VALUES ('" + membrecia.getFecha() + "'," + 3 + ","+ membrecia.getUsuId() + ");";    
	            st.executeUpdate(i);
	            st.close();
            }
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
}

