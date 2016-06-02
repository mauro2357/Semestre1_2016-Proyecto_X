package repositorios;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import LogicaNegocio.Enfermedades;
import LogicaNegocio.Fidelizacion;
import LogicaNegocio.Login;
import repositorios.conexion;

public class ConsultasRepositorio {
	
    public static int consultarCantidad() throws Exception { 
		Connection con = (Connection) new conexion().ObtenerConexion();
	    String consulta = "select count(*) as cantidad from usuarios where Tip_codigo = 'CLIN';";
	    Statement st = con.createStatement();
	    ResultSet miconsulta = st.executeQuery(consulta);
	    int cant=0;
	    if(miconsulta.next()){
	    	cant = miconsulta.getInt("cantidad");
	    }
	    st.close();
	    return cant;
	}
	
        	
	public static boolean autenticar(Login login)throws Exception  {
		Connection con = (Connection) new conexion().ObtenerConexion();
		String consulta = "select * from usuarios where Usu_id =" + login.getId() + " and Usu_password ='" + login.getPass() + "';";
		Statement st = con.createStatement();
	    ResultSet miconsulta = st.executeQuery(consulta);
	    if(miconsulta.next())return true;
	    st.close();
	    return false;
    }
	
	public static String ConsultarUsuario(Login prueba)throws Exception  {
		Connection con = (Connection) new conexion().ObtenerConexion();
		String consulta = "select * from usuarios where Usu_id =" + prueba.getId() + " and Usu_password ='" + prueba.getPass() + "';";
		Statement st = con.createStatement();
	    ResultSet miconsulta = st.executeQuery(consulta);
	    String codigo=null;
	    if(miconsulta.next())codigo=miconsulta.getString("Tip_codigo");
	    st.close();
	    return codigo;
    }
	public static LinkedList<Enfermedades>getEnfermedad() throws Exception { 
		LinkedList<Enfermedades> listaEnfermedades=new LinkedList<Enfermedades>();
		Connection con = (Connection) new conexion().ObtenerConexion();
	    String consulta = "select Enf_codigo as codigo, Enf_descripcion as enfermedad from enfermedad;" ;
	    Statement st = con.createStatement();
	    ResultSet miconsulta = st.executeQuery(consulta);
	    while(miconsulta.next()){
	    	String codigo =miconsulta.getString("codigo");
        	String descripcion =miconsulta.getString("enfermedad");
        	Enfermedades enfermedad = new Enfermedades(codigo,descripcion);
            listaEnfermedades.add(enfermedad);
	    }
	    st.close();
	    return listaEnfermedades; 
	}
	public static LinkedList<Fidelizacion>getFidelizacion() throws Exception { 
		LinkedList<Fidelizacion> listaFidelizacion=new LinkedList<Fidelizacion>();
		Connection con = (Connection) new conexion().ObtenerConexion();
	    String consulta = "select  C.usu_id as Cedula, U.usu_nombre as Nombre, C.Cli_fecha_inscripcion as Fecha From usuarios U, cliente C where U.usu_id= C.usu_id ";
	    Statement st = con.createStatement();
	    ResultSet miconsulta = st.executeQuery(consulta);
	    while(miconsulta.next()){
	    	int id = miconsulta.getInt("Cedula");
        	String nombre =miconsulta.getString("Nombre");
        	String fecha =miconsulta.getString("Fecha");
        	Fidelizacion fidelizacion = new Fidelizacion(id, nombre,fecha);
            listaFidelizacion.add(fidelizacion);
	    }
	    st.close();
	    return listaFidelizacion; 
	} 
	 public static String consultarCorreo(int id) throws Exception { 
			Connection con = (Connection) new conexion().ObtenerConexion();
		    String consulta = "SELECT Usu_correo as correo FROM bd_manager_fitness.usuarios where Usu_id ="+id+";";
		    Statement st = con.createStatement();
		    ResultSet miconsulta = st.executeQuery(consulta);
		    String correo = null;
		    if(miconsulta.next()){
		    	correo = miconsulta.getString("correo");
		    }
		    st.close();
		    return correo;
		}
	 public static String consultarHorario(int codigo) throws Exception { 
			Connection con = (Connection) new conexion().ObtenerConexion();
		    String consulta = "SELECT hor_descripcion as descripcion FROM bd_manager_fitness.horario where hor_id ="+codigo+";";
		    Statement st = con.createStatement();
		    ResultSet miconsulta = st.executeQuery(consulta);
		    String descripcion = null;
		    if(miconsulta.next()){
		    	descripcion = miconsulta.getString("descripcion");
		    }
		    st.close();
		    return descripcion;
		}
}



	
	






