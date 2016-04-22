package LogicaNegocio;

public  class Proceso {
	private int id;
	private double peso;
	private double estatura;
	private String tipoProceso;
	private int rutina;
	private String observacion;
	private String fecha;
	
	
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public double getEstatura() {
		return estatura;
	}
	public void setEstatura(double estatura) {
		this.estatura = estatura;
	}
	public String getTipoProceso() {
		return tipoProceso;
	}
	public void setTipoProceso(String tipoProceso) {
		this.tipoProceso = tipoProceso;
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
	public Proceso(int id, double peso, double estatura, String tipoProceso, int rutina, String observacion,String fecha) {
		super();
		this.id = id;
		this.peso = peso;
		this.estatura = estatura;
		this.tipoProceso = tipoProceso;
		this.rutina = rutina;
		this.observacion = observacion;
		this.fecha = fecha;
	}


}
