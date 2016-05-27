package LogicaNegocio;

import repositorios.MembreciaConsultasRepositorio;

public class Principiante extends Membrecia{

	public Principiante(String fecha, int usuId) {
		super(fecha, usuId);
	}
	
	public boolean comprar() throws Exception{
		if(MembreciaConsultasRepositorio.validarDataCredito(this.getUsuId()))return false;
		return true;
			
	}
}
