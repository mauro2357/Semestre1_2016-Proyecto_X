package LogicaNegocio;

public class Horario {
	private int usu_id;
	private int hor_id;
	private String descripcion;
	
	public int getUsu_id() {
		return usu_id;
	}
	public void setUsu_id(int usu_id) {
		this.usu_id = usu_id;
	}
	public int getHor_id() {
		return hor_id;
	}
	public void setHor_id(int hor_id) {
		this.hor_id = hor_id;
	}
	public Horario(int usu_id, int hor_id) {
		super();
		this.usu_id = usu_id;
		this.hor_id = hor_id;
	}
	public Horario( String descripcion,int hor_id) {
		super();
		this.descripcion = descripcion;
		this.hor_id = hor_id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
