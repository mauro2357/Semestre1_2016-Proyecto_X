package repositorios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import LogicaNegocio.Entrenador;
import LogicaNegocio.Horario;

public class HorarioRepositorio {
	public static boolean agregar(Horario horario) {
        Connection con;
        Statement st;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_manager_fitness", "root", "root");
            st = con.createStatement();
            String i = "INSERT INTO programacion(Usu_id, Hor_id)" + " VALUES (" + horario.getUsu_id() + "," + horario.getHor_id() + ")";    
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
	public static boolean agregar(Entrenador entrenador) {
        Connection con;
        Statement st;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_manager_fitness", "root", "root");
            st = con.createStatement();
            String i = "INSERT INTO entrenador(Usu_id, Tip_codigo)" + " VALUES (" + entrenador.getId() + ",'" + entrenador.getTipoEntrenador() + "')";    
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
}

