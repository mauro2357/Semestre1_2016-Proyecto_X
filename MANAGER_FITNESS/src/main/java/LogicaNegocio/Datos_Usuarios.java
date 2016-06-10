package LogicaNegocio;

import java.util.LinkedList;

import repositorios.MembreciaConsultasRepositorio;
import repositorios.RutinaRepositorio;

public class Datos_Usuarios {
	
	private String tipo_usuario;
	private String mensualidad;
	private int dias_restantes;
	private LinkedList<Rutinas> lista;
	
	
	
	public Datos_Usuarios(String tipo_usuario) {
		super();
		this.tipo_usuario = tipo_usuario;
	}
	
	public String getTipo_usuario() {
		return tipo_usuario;
	}
	public void setTipo_usuario(String tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}
	public String getMensualidad() {
		return mensualidad;
	}
	public void setMensualidad(String mensualidad) {
		this.mensualidad = mensualidad;
	}

	public void consultar_mensualidad(int id) throws Exception {
		
		this.mensualidad =  MembreciaConsultasRepositorio.consultarDias(id);
		if (mensualidad != null){
			this.dias_restantes = 30 - Integer.parseInt(mensualidad);
		} 
		
	}

	public int getDias_restantes() {
		return dias_restantes;
	}

	public void setDias_restantes(int dias_restantes) {
		this.dias_restantes = dias_restantes;
	}

	public void consultar_rutinas() throws Exception {
		 this.lista = RutinaRepositorio.getCalorias();	
	}

	public Datos_Usuarios() {
		super();
	}

	public LinkedList<Rutinas> getLista() {
		return lista;
	}

	public void setLista(LinkedList<Rutinas> lista) {
		this.lista = lista;
	}

}
