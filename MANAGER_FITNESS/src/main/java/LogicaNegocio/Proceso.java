package LogicaNegocio;

public abstract class Proceso {
	private int id;
	private double peso;
	private int rutina;
	private String observacion;
	
	public Proceso(int id, double peso, int rutina, String observacion) {
		super();
		this.id = id;
		this.peso = peso;
		this.rutina = rutina;
		this.observacion = observacion;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public int getRutina() {
		return rutina;
	}
	public void setRutina(int rutina) {
		this.rutina = rutina;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
	
	
	
	

}
