package LogicaNegocio;

public class Sugerencias {
	private String fecha;
	private String descripcion;
	private int idUsuario;
	private String tipo;
	
	
	public Sugerencias(String fecha, String descripcion, int idUsuario, String tipo ) {
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.idUsuario = idUsuario;
		this.tipo = tipo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	

}
