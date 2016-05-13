package repositorios;

import java.sql.Connection;

import LogicaNegocio.Cliente;
import LogicaNegocio.Entrenador;
import LogicaNegocio.Usuarios;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UsuariosRepositorio  {

    public static boolean agregarUsuario(Usuarios usuario) {
        Connection con;
        Statement st;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_manager_fitness", "root", "root");
            st = con.createStatement();
            String i = "INSERT INTO Usuarios(Usu_id,Usu_nombre, Usu_direccion, Usu_telefono, Usu_correo, Usu_password, Usu_fechaNac,Tip_codigo)" + " VALUES (" + usuario.getId() + ",'" + usuario.getNombre() + "','" + usuario.getDireccion() + "'," + usuario.getTelefono() + ",'" + usuario.getCorreo() + "','" + usuario.getPassword() + "','" + usuario.getFechaN() + "','" + usuario.getTipoUsuario() + "')";    
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
    public static boolean agregarCliente(Cliente cliente) {
        Connection con;
        Statement st;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_manager_fitness", "root", "root");
            st = con.createStatement();
            String i = "INSERT INTO cliente(Cli_estatura, Cli_fecha_inscripcion, Usu_id, Cli_peso, Cli_pesfuerzo)" + " VALUES (" + cliente.getEstatura() + ",'" + cliente.getFechaInscripcion() + "'," + cliente.getClinId() + "," + cliente.getPeso() + "," + cliente.getPruebaEsfuerzo() + ")";    
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
    public static  boolean agregar(Entrenador entrenador) {
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