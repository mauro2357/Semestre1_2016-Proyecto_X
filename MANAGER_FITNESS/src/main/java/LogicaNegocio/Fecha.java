package LogicaNegocio;

import java.util.Calendar;
import java.util.GregorianCalendar;

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

}
