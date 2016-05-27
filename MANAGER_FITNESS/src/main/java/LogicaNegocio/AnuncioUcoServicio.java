package LogicaNegocio;

public class AnuncioUcoServicio {
	private String titulo;
	private String descripcion;
	
	public AnuncioUcoServicio(String titulo, String descripcion) {
		super();
		this.titulo = titulo;
		this.descripcion = descripcion;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	

}
