package LogicaNegocio;

import repositorios.IHorarioRepositorio;


public class Horario {
	private int usu_id;
	private int hor_id;
	private String descripcion;
	private IHorarioRepositorio horarioRepo;
	
	public Horario (IHorarioRepositorio horarioRepo){
		this.horarioRepo=horarioRepo;
	} 
	
	public int getUsu_id() {
		return usu_id;
	}
	public IHorarioRepositorio getHorarioRepo() {
		return horarioRepo;
	}

	public void setHorarioRepo(IHorarioRepositorio horarioRepo) {
		this.horarioRepo = horarioRepo;
	}

	public void setUsu_id(int usu_id) {
		this.usu_id = usu_id;
	}
	public int getHor_id() {
		return hor_id;
	}
	public void setHor_id(int hor_id) {
		this.hor_id = hor_id;
	}
	public Horario(IHorarioRepositorio horarioRepo, int usu_id, int hor_id) {
		super();
		this.horarioRepo=horarioRepo;
		this.usu_id = usu_id;
		this.hor_id = hor_id;
	}
	public Horario( String descripcion,int hor_id) {
		super();
		this.descripcion = descripcion;
		this.hor_id = hor_id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public boolean agregarbd (){
		if(horarioRepo.agregar(this)) return true;
		return false;
	}
}
