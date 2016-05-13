package LogicaNegocio;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import repositorios.MembreciaConsultasRepositorio;

public class Fecha {
	private static int a�o;
	private static int mes;
	private static int dia;
	
	public static String ObtenerFecha(){
		Calendar fecha=new GregorianCalendar();
		a�o= fecha.get(Calendar.YEAR);
		mes= fecha.get(Calendar.MONTH);
		dia= fecha.get(Calendar.DAY_OF_MONTH);
		
		String fechaActual= Integer.toString(a�o)+"-"+Integer.toString(mes)+"-"+Integer.toString(dia); 
		return fechaActual;
		
	}

	public static int getA�o() {
		return a�o;
	}

	public static void setA�o(int a�o) {
		Fecha.a�o = a�o;
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
		int a�o1=Integer.parseInt(fecha.substring(0,4));
		int mes1=Integer.parseInt(fecha.substring(5,7));
		int dia1=Integer.parseInt(fecha.substring(8));
		String fecha2=Fecha.ObtenerFecha();
		int a�o2= Fecha.getA�o();
		int mes2=Fecha.getMes();
		int dia2= Fecha.getDia();
		int dias1=a�o1*365 + mes1*30 +dia1;
		int dias2=a�o2*365 + mes2*30 +dia2;
		int dif=dias2-dias1;
		return dif;
	}
}
