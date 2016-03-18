package LogicaNegocio;

import java.util.Calendar;
import java.util.GregorianCalendar;

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

}
