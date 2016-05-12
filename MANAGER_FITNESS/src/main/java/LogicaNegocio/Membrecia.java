package LogicaNegocio;

import java.sql.SQLException;

import repositorios.MembreciaRepositorio;

public abstract class Membrecia {
	private String fecha;
	private int usuId;
	//private static Membrecia membrecia=null;
	
	
	public Membrecia(String fecha, int usuId) {
		this.fecha = fecha;
		this.usuId = usuId;
		
	}
	/*
	public static Membrecia getInstance(String fech, int Id) {
        if (membrecia == null) {
            membrecia= new Membrecia(fech, Id);
        }
        return membrecia;
		}*/


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public int getUsuId() {
		return usuId;
	}


	public void setUsuId(int usuId) {
		this.usuId = usuId;
	}
	public boolean agregarbd (){
		if(MembreciaRepositorio.agregarMembrecia(this)) return true;
		return false;
	}
	public boolean obtener() throws SQLException{
		if (comprar() && agregarbd()) return true;
		return false;
	}
	
	public abstract boolean comprar () throws SQLException;
	
	
	
}
