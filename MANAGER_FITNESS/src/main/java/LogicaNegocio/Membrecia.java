package LogicaNegocio;

import java.sql.SQLException;

import repositorios.MembreciaRepositorio;

public abstract class Membrecia {
	private String fecha;
	private int usuId;
	
	
	public Membrecia(String fecha, int usuId) {
		super();
		this.fecha = fecha;
		this.usuId = usuId;
	}


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
	
	public abstract boolean comprar () throws SQLException;
	
	
	
}
