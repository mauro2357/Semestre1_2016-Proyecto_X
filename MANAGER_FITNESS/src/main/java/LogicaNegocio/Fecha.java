package LogicaNegocio;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import repositorios.MembreciaConsultasRepositorio;

public class Fecha {
	private static int año;
	private static int mes;
	private static int dia;
	
	public static String ObtenerFecha(){
		Calendar fecha=new GregorianCalendar();
		año= fecha.get(Calendar.YEAR);
		mes= fecha.get(Calendar.MONTH);
		dia= fecha.get(Calendar.DAY_OF_MONTH);
		
		String fechaActual= Integer.toString(año)+"-"+Integer.toString(mes)+"-"+Integer.toString(dia); 
		return fechaActual;
		
	}

	public static int getAño() {
		return año;
	}

	public static void setAño(int año) {
		Fecha.año = año;
	}

	public static int getMes() {
		return mes;
	}

	public static void setMes(int mes) {
		Fecha.mes = mes;
	}

	public static int getDia() {
		return dia;
	}

	public static void setDia(int dia) {
		Fecha.dia = dia;
	}
	public static int diferencia(String fecha ) throws SQLException{
		int año1=Integer.parseInt(fecha.substring(0,4));
		int mes1=Integer.parseInt(fecha.substring(5,7));
		int dia1=Integer.parseInt(fecha.substring(8));
		String fecha2=Fecha.ObtenerFecha();
		int año2= Fecha.getAño();
		int mes2=Fecha.getMes();
		int dia2= Fecha.getDia();
		int dias1=año1*365 + mes1*30 +dia1;
		int dias2=año2*365 + mes2*30 +dia2;
		int dif=dias2-dias1;
		return dif;
	}
}
