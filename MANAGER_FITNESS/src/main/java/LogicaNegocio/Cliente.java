package LogicaNegocio;

public class Cliente {
	private double estatura;
	private String fechaInscripcion;
	private int clinId;
	private double peso;
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
	public Cliente(double estatura, String fechaInscripcion, int clinId, double peso) {
		super();
		this.estatura = estatura;
		this.fechaInscripcion = fechaInscripcion;
		this.clinId = clinId;
		this.peso = peso;
	}
	
	
}
