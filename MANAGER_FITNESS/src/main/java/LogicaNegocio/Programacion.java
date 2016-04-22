package LogicaNegocio;

public class Programacion {
	String nombreEntrenador;
	String horario;
	public String getNombreEntrenador() {
		return nombreEntrenador;
	}
	public void setNombreEntrenador(String nombreEntrenador) {
		this.nombreEntrenador = nombreEntrenador;
	}
	public String getHorario() {
		return horario;
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
