package LogicaNegocio;

public class Eventos {
	private String fecha;
	private String Descripcion;
	private int idEntrenador;
	private String nombreEntrenador;

	
	public Eventos(String fecha, String descripcion, int idEntrenador) {
		this.fecha = fecha;
		this.Descripcion = descripcion;
		this.idEntrenador = idEntrenador;
	}
	public Eventos(String fecha, String descripcion, String  nombreEntrenador) {
		this.fecha = fecha;
		this.Descripcion = descripcion;
		this.nombreEntrenador = nombreEntrenador;
	}

	public String getNombreEntrenador() {
		return nombreEntrenador;
	}
	public void setNombreEntrenador(String nombreEntrenador) {
		this.nombreEntrenador = nombreEntrenador;
	}
	public String getFecha() {
		return fecha;
	} 
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public int getIdEntrenador() {
		return idEntrenador;
	}
	public void setIdEntrenador(int idEntrenador) {
		this.idEntrenador = idEntrenador;
	}
	
	

}
