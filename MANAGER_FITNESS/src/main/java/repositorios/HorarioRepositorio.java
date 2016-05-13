package repositorios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import LogicaNegocio.Eventos;
import LogicaNegocio.Horario;

public class HorarioRepositorio implements IHorarioRepositorio{
	
	public boolean agregar(Horario horario) {
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
	public static LinkedList<Horario> getHorario()
	   {
	      LinkedList<Horario> listaHorario=new LinkedList<Horario>();
	      try
	      {
	    	  Class.forName("com.mysql.jdbc.Driver");
	          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_manager_fitness", "root", "root");
	          Statement st= con.createStatement();
	          ResultSet rs = st.executeQuery("select hor_descripcion as descripcion, Hor_id as codigo from horario;");
	         while (rs.next())
	         {
	        	String descripcion=rs.getString("descripcion");
	        	int codigo =rs.getInt("codigo");
	            Horario horario = new Horario(descripcion, codigo);
	            listaHorario.add(horario);
	         }
	         rs.close();
	         st.close();
	         con.close();
	      }
	      catch (Exception e)
	      {
	         e.printStackTrace();
	      }
	      return listaHorario;
	   }
	
}
	
	

	

