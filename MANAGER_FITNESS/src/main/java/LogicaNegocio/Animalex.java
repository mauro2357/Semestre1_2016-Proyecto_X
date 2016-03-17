package LogicaNegocio;

import java.sql.SQLException;

import repositorios.ValidacionMembreciaRepositorio;

public class Animalex extends Membrecia{

	public Animalex(String fecha, int usuId) {
		super(fecha, usuId);
	}
	
	public boolean validarTiempo() throws SQLException{
		String fecha1= ValidacionMembreciaRepositorio.consultarFechaIns(this.getUsuId());
		int año1=Integer.parseInt(fecha1.substring(0,4));
		int mes1=Integer.parseInt(fecha1.substring(5,7));
		int dia1=Integer.parseInt(fecha1.substring(8));
		String fecha2=Fecha.ObtenerFecha();
		int año2=Integer.parseInt(fecha2.substring(0,4));
		int mes2=Integer.parseInt(fecha2.substring(5,7));
		int dia2=Integer.parseInt(fecha2.substring(8));
		int dias1=año1*365 + mes1*30 +dia1;
		int dias2=año2*365 + mes2*30 +dia2;
		int dif=dias2-dias1;
		if (dif/365 >= 5)return true;
		return false;
	}
	
	public boolean comprar() throws SQLException {
		double imc= ValidacionMembreciaRepositorio.consultarImc(this.getUsuId());
		if (validarTiempo()&& ValidacionMembreciaRepositorio.consultarCantidad() && imc>18.5 && imc<25)return true;
		return false;
		
	}

	
}
