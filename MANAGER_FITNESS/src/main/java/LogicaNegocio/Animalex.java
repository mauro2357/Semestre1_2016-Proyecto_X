package LogicaNegocio;

import java.sql.SQLException;

import repositorios.MembreciaConsultasRepositorio;

public class Animalex extends Membrecia{

	public Animalex(String fecha, int usuId) {
		super(fecha, usuId);
	}
	
	public boolean validarTiempo() throws SQLException{
		String fecha1= MembreciaConsultasRepositorio.consultarFechaIns(this.getUsuId());
		int a�o1=Integer.parseInt(fecha1.substring(0,4));
		int mes1=Integer.parseInt(fecha1.substring(5,7));
		int dia1=Integer.parseInt(fecha1.substring(8));
		String fecha2=Fecha.ObtenerFecha();
		int a�o2= Fecha.getA�o();
		int mes2=Fecha.getMes();
		int dia2= Fecha.getDia();
		int dias1=a�o1*365 + mes1*30 +dia1;
		int dias2=a�o2*365 + mes2*30 +dia2;
		int dif=dias2-dias1;
		if (dif/365 >= 5)return true;
		return false;
	}
	
	public boolean comprar() throws SQLException {
		double imc= MembreciaConsultasRepositorio.consultarImc(this.getUsuId());
		if (validarTiempo()&& MembreciaConsultasRepositorio.consultarCantidad() && imc>18.5 && imc<25)return true;
		return false;
		
	}

	
}