package repositorios;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import LogicaNegocio.Horario;

public class HorarioArchivoRepositorio implements IHorarioRepositorio{
	
	public boolean agregar (Horario horario) throws Exception {
		try{
			Connection con = new conexion().ObtenerConexion();
		    String insert = "INSERT INTO programacion(Usu_id, Hor_id)" + " VALUES (" + horario.getUsu_id() + "," + horario.getHor_id() + ")"; 
		    Statement st = con.createStatement();
		    st.executeUpdate(insert);
		    
		    File archivo= new File("C:\\Users\\magud\\Desktop\\ArchivosHorario\\archivo.txt");
            if (!archivo.exists()) {
				archivo.createNewFile();
				System.out.println("Se ha creado el archivo");    				
			}            	
            FileWriter w = new FileWriter(archivo);
            BufferedWriter bw = new BufferedWriter(w);

            bw.write(insert);                      
            bw.close();
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
