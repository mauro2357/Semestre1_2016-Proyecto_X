package LogicaNegocio;

public class Entrenador {
	private int id;
	private String tipoEntrenador;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipoEntrenador() {
		return tipoEntrenador;
	}
	public void setTipoEntrenador(String tipoEntrenador) { 
		this.tipoEntrenador = tipoEntrenador;
	}
	public Entrenador(int id, String tipoEntrenador) {
		super();
		this.id = id;
		this.tipoEntrenador = tipoEntrenador;
	}
	

}
