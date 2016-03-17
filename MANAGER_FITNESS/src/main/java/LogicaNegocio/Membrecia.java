package LogicaNegocio;

import java.sql.SQLException;

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
	
	public abstract boolean comprar () throws SQLException;
	
}
