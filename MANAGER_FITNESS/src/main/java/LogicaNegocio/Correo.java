package LogicaNegocio;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class Correo {
	final String username = "managerfitness2016@gmail.com";
	final String password = "proyectox2016";
	private String asunto;
	private String mensaje;
	private String destinatario;
	public boolean sendEmail(){
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		Session session = Session.getInstance(props,new javax.mail.Authenticator(){protected PasswordAuthentication getPasswordAuthentication() {return new PasswordAuthentication(username, password);}});
		try {
			Message message = new MimeMessage(session);
			//Seteamos la dirección desde la cual enviaremos el mensaje
			 message.setFrom(new InternetAddress("managerfitness2016@gmail.com"));
			//Seteamos el destino de nuestro mensaje
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
			//Seteamos el asunto
			message.setSubject(asunto);
			//Y por ultimo el texto.
			message.setText(mensaje);
			//Esta orden envía el mensaje
			 Transport.send(message);
			 return true;
			 }
		catch (MessagingException e) {
			 }
		return false;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}
	public Correo(String asunto, String mensaje, String destinatario) {
		super();
		this.asunto = asunto;
		this.mensaje = mensaje;
		this.destinatario = destinatario;
	}
}
