package repositorios;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import LogicaNegocio.Horario;

public class HorarioArchivoRepositorio implements IHorarioRepositorio{
	
	public boolean agregar(Horario horario){
        Connection con;
        Statement st;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_manager_fitness", "root", "root");
            st = con.createStatement();
            String i = "INSERT INTO programacion(Usu_id, Hor_id)" + " VALUES (" + horario.getUsu_id() + "," + horario.getHor_id() + ")";    
            
            File archivo= new File("C:\\Users\\magud\\Desktop\\ArchivosHorario\\archivo.txt");
            if (!archivo.exists()) {
				archivo.createNewFile();
				System.out.println("Se ha creado el archivo");    				
			}            	
            FileWriter w = new FileWriter(archivo);
            BufferedWriter bw = new BufferedWriter(w);

            bw.write(i);                      
            bw.close();
            st.executeUpdate(i);
            st.close();
        }catch (IOException e) {	
    		System.err.println("No se ha podido crear el archivo" + e );
    		System.out.println("NOOO Se ha creado el archivo");	
    		return false;
    	}catch (SQLException e){
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
