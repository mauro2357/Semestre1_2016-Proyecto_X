package repositorios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import LogicaNegocio.Cliente;

public class EnfermedadRepositorio {
	
	 public static boolean agregarenfermedad(Cliente usuario) {
	        Connection con;
	        Statement st;
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_manager_fitness", "root", "root");
	            st = con.createStatement();
	            String in = null;
	            for(int i = 0 ; i < usuario.getCodenfermedad().length ; ++i){
		             in = "INSERT INTO `bd_manager_fitness`.`enfermedadxcliente` (`Enf_codigo`,`Usu_id`) VALUES ('"+usuario.getCodenfermedad()[i]+"',"+usuario.getClinId()+");";    
		             st.executeUpdate(in);
	            }
	            System.out.println(in);
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
