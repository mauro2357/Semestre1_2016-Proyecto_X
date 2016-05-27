package repositorios;

import LogicaNegocio.Horario;

public class ProxyHorarioArchivoRepositorio implements IHorarioRepositorio{
	public boolean agregar(Horario horario) throws Exception {
		HorarioArchivoRepositorio horarioarchivorepositorio= new HorarioArchivoRepositorio();
		if(horario.getHor_id()<5){
			if(horarioarchivorepositorio.agregar(horario))return true;
		}
		return false;
	}

}
