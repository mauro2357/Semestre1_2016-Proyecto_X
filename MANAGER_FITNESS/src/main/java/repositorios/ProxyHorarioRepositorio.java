package repositorios;

import LogicaNegocio.Horario;

public class ProxyHorarioRepositorio implements IHorarioRepositorio {

	public boolean agregar(Horario horario) {
		HorarioRepositorio horariorepositorio=new HorarioRepositorio();
		if(horario.getHor_id()<5){
			if(horariorepositorio.agregar(horario))return true;
		}
		return false;
	}

}
