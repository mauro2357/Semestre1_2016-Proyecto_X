package juank;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class mail {

	public static void main(String[] args) {

			    // La dirección de envío (to)
			    String para = "jkarlos1938@hotmail.com";

			    // La dirección de la cuenta de envío (from)
			    String de = "sanche3z@gmail.com";

			    // El servidor (host). En este caso usamos localhost
			    String host = "localhost";

			    // Obtenemos las propiedades del sistema
			    Properties propiedades = System.getProperties();

			    // Configuramos el servidor de correo
			    propiedades.put("mail.smtp.host",host);
			    propiedades.setProperty("mail.smtp.port", "8080");
			    propiedades.setProperty("mail.user", "sanche3z");
			    propiedades.setProperty("mail.password", "55610021");
			    // Obtenemos la sesión por defecto
			    Session sesion = Session.getDefaultInstance(propiedades);

			    try{
			      // Creamos un objeto mensaje tipo MimeMessage por defecto.
			      MimeMessage mensaje = new MimeMessage(sesion);

			      // Asignamos el “de o from” al header del correo.
			      mensaje.setFrom(new InternetAddress(de));

			      // Asignamos el “para o to” al header del correo.
			      mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(para));

			      // Asignamos el asunto
			      mensaje.setSubject("Primer correo HTML");

			      // Asignamos el contenido HTML, tan grande como nosotros queramos
			      mensaje.setContent("<h1>bienvenido</h1>","text/html" );

			      // Enviamos el correo
			      Transport.send(mensaje);
			      System.out.println("Mensaje enviado");
			    } catch (MessagingException e) {
			      e.printStackTrace();
			    }
			  }
			}

