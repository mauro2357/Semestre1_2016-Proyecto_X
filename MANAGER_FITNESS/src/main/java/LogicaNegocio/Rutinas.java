package LogicaNegocio;

public class Rutinas {
	private int codigo;
	private String nombre;
	private String descripcion;
	private int calorias;
	
	public Rutinas(String nombre, String descripcion, int calorias) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.calorias = calorias;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getCalorias() {
		return calorias;
	}
	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}
	public Rutinas(int codigo, String nombre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
	}
	

}
