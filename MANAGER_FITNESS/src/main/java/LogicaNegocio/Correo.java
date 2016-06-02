package LogicaNegocio;
import org.javahelp4u.mailSender.*;
public class Correo {
	/*public boolean enviar(){
		MailSender.sendMail("managerfitness2016@gmail.com", "prueba", "prueba");
	}*/
	public static void main(String[] args){
		System.out.println("enviando");
		MailSender.sendMail("managerfitness2016@gmail.com", "prueba", "prueba");
		System.out.println("enviado");
	}

	
}
