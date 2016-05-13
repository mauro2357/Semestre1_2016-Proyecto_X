package LogicaNegocio;

public class Cliente {
	private double estatura;
	private String fechaInscripcion;
	private int clinId;
	private String[] codenfermedad;
	private double peso;
	private int pruebaEsfuerzo;
	public int getPruebaEsfuerzo() {
		return pruebaEsfuerzo;
	}
	public void setPruebaEsfuerzo(int pruebaEsfuerzo) {
		this.pruebaEsfuerzo = pruebaEsfuerzo;
	}
	public double getEstatura() {
		return estatura;
	}
	public void setEstatura(double estatura) {
		this.estatura = estatura;
	}
	public String getFechaInscripcion() {
		return fechaInscripcion;
	}
	public void setFechaInscripcion(String fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}
	public int getClinId() {
		return clinId;
	}
	public void setClinId(int clinId) {
		this.clinId = clinId;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public Cliente(double estatura, String fechaInscripcion, int clinId, double peso, int pruebaEsfuerzo) {
		super();
		this.estatura = estatura;
		this.fechaInscripcion = fechaInscripcion;
		this.clinId = clinId;
		this.peso = peso;
		this.pruebaEsfuerzo = pruebaEsfuerzo;
	}
	public Cliente(int clinId, String[] codenfermedad) {
		super();
		this.clinId = clinId;
		this.codenfermedad = codenfermedad;
	}
	public Cliente(double estatura, String fechaInscripcion, int clinId, String[] codenfermedad, double peso,
			int pruebaEsfuerzo) {
		super();
		this.estatura = estatura;
		this.fechaInscripcion = fechaInscripcion;
		this.clinId = clinId;
		this.codenfermedad = codenfermedad;
		this.peso = peso;
		this.pruebaEsfuerzo = pruebaEsfuerzo;
	}
	public String[] getCodenfermedad() {
		return codenfermedad;
	}
	public void setCodenfermedad(String[] codenfermedad) {
		this.codenfermedad = codenfermedad;
	}
	
	
}
