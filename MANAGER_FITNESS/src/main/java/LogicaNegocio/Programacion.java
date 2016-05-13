package LogicaNegocio;

public class Programacion {
	String nombreEntrenador;
	String horario;
	int cedulaEntrenador;
	int CodigoHorario;
	public int getCedulaEntrenador() {
		return cedulaEntrenador;
	}
	public void setCedulaEntrenador(int cedulaEntrenador) {
		this.cedulaEntrenador = cedulaEntrenador;
	}
	public String getNombreEntrenador() {
		return nombreEntrenador;
	}
	public void setNombreEntrenador(String nombreEntrenador) {
		this.nombreEntrenador = nombreEntrenador;
	}
	public String getHorario() {
		return horario;
	}
	public Programacion(int cedulaEntrenador, int codigoHorario) {
		super();
		this.cedulaEntrenador = cedulaEntrenador;
		this.CodigoHorario = codigoHorario;
	}
	public int getCodigoHorario() {
		return CodigoHorario;
	}
	public void setCodigoHorario(int codigoHorario) {
		CodigoHorario = codigoHorario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public Programacion(String nombreEntrenador, String horario) {
		super();
		this.nombreEntrenador = nombreEntrenador;
		this.horario = horario;
	}
	

}
