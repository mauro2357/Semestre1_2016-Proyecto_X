package LogicaNegocio;

public class Eventos {
	private String fecha;
	private String Descripcion;
	private int idEntrenador;
	private String nombreEntrenador;
	private int codigo;
	

	public Eventos(String fecha, String descripcion, int idEntrenador, String nombreEntrenador, int codigo) {
		this.fecha = fecha;
		Descripcion = descripcion;
		this.idEntrenador = idEntrenador;
		this.nombreEntrenador = nombreEntrenador;
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Eventos (int codigo){
		this.codigo = codigo; 
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
