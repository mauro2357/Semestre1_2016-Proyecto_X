package LogicaNegocio;

public class Enfermedades {
	private String codigo;
	private String enfermedad;
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getEnfermedad() {
		return enfermedad;
	}
	public void setEnfermedad(String enfermedad) {
		this.enfermedad = enfermedad;
	}
	public Enfermedades(String codigo, String enfermedad) {
		super();
		this.codigo = codigo;
		this.enfermedad = enfermedad;
	}
	
	

}
