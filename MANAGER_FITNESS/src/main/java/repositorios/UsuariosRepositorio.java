
package repositorios;

import java.sql.Connection;

import LogicaNegocio.Cliente;
import LogicaNegocio.Entrenador;
import LogicaNegocio.Usuarios;
import java.sql.SQLException;
import java.sql.Statement;

public class UsuariosRepositorio  {
	
	public static boolean agregarUsuario (Usuarios usuario) throws Exception {
		try{
			Connection con = new conexion().ObtenerConexion();
            String insert = "INSERT INTO Usuarios(Usu_id,Usu_nombre, Usu_direccion, Usu_telefono, Usu_correo, Usu_password, Usu_fechaNac,Tip_codigo)" + " VALUES (" + usuario.getId() + ",'" + usuario.getNombre() + "','" + usuario.getDireccion() + "'," + usuario.getTelefono() + ",'" + usuario.getCorreo() + "','" + usuario.getPassword() + "','" + usuario.getFechaN() + "','" + usuario.getTipoUsuario() + "')";    
		    Statement st = con.createStatement();
		    st.executeUpdate(insert);
		    st.close();
		}catch (SQLException e){
        	e.printStackTrace();
        	return false;
        }catch (ClassNotFoundException e){
        	e.printStackTrace();
            return false;
        }
		return true;
	}

    public static boolean agregarCliente(Cliente cliente) throws Exception {
        try {
            Connection con = new conexion().ObtenerConexion();
            String insert = "INSERT INTO cliente(Cli_estatura, Cli_fecha_inscripcion, Usu_id, Cli_peso, Cli_pesfuerzo)" + " VALUES (" + cliente.getEstatura() + ",'" + cliente.getFechaInscripcion() + "'," + cliente.getClinId() + "," + cliente.getPeso() + "," + cliente.getPruebaEsfuerzo() + ")";     
		    Statement st = con.createStatement();
		    st.executeUpdate(insert);
		    st.close(); 
        }catch (SQLException e){
        	e.printStackTrace();
        	return false;
        }catch (ClassNotFoundException e){
        	e.printStackTrace();
            return false;
        }
		return true;
    }
    public static boolean agregar(Entrenador entrenador) throws Exception {
        try {
            Connection con = new conexion().ObtenerConexion();
            String insert = "INSERT INTO entrenador(Usu_id, Tip_codigo)" + " VALUES (" + entrenador.getId() + ",'" + entrenador.getTipoEntrenador() + "')";    
		    Statement st = con.createStatement();
		    st.executeUpdate(insert);
		    st.close(); 
        }catch (SQLException e){
        	e.printStackTrace();
        	return false;
        }catch (ClassNotFoundException e){
        	e.printStackTrace();
            return false;
        }
		return true;
    }
    
}