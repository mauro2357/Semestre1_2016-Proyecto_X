package LogicaNegocio;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Fecha {
	
	public static String ObtenerFecha(){
		Calendar fecha=new GregorianCalendar();
		
		int a�o= fecha.get(Calendar.YEAR);
		int mes= fecha.get(Calendar.MONTH);
		int dia= fecha.get(Calendar.DAY_OF_MONTH);
		
		String fechaActual= Integer.toString(a�o)+"-"+Integer.toString(mes)+"-"+Integer.toString(dia); 
		return fechaActual;
		
	}

}
