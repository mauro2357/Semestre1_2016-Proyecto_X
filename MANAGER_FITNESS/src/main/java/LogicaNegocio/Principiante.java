package LogicaNegocio;

import repositorios.MembreciaConsultasRepositorio;

public class Principiante extends Membrecia{

	public Principiante(String fecha, int usuId) {
		super(fecha, usuId);
	}
	
	public boolean comprar(){
		if(MembreciaConsultasRepositorio.validarDatacredito(this.getUsuId()))return false;
		return true;
			
	}
	
	

}
