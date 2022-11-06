package extraSources;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mailer {
	
	public static void enviarMail(String email) {
		
		try {
			// Propiedades de la conexion
			Properties prop = new Properties();
			// Nombre del servidor de salida
			prop.setProperty("mail.smtp.host", "smtp.office365.com");
			// Habilitamos TLS
			prop.setProperty("mail.smtp.starttls.enable", "true");
			// Indicamos el puerto
			prop.setProperty("mail.smtp.port", "587");
			// Indicamos el usuario
			prop.setProperty("mail.smtp.user", "tienda-online-curso@outlook.com");
			// Indicamos que requiere autenticación
			prop.setProperty("mail.smtp.auth", "true");

			// Creamos un objeto sesion
			Session sesion = Session.getDefaultInstance(prop);
			
			//TODO
//			sesion.setDebug(true);
			
			// Creamos un objeto mensaje a traves de la sesion
			MimeMessage mensaje = new MimeMessage(sesion);
			
			// Indicamos la cuenta desde la que se va a enviar
			mensaje.setFrom(new InternetAddress("tienda-online-curso@outlook.com"));

			// Añadimos el recipiente al mensaje al que va a ir dirigido el mensaje
			mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(email));

			//TODO
			// Creamos el asunto del mensaje
			mensaje.setSubject("Nuevo inicio de sesión");

			//TODO
			// Creamos el cuerpo del mensaje
//			mensaje.setText("Se ha producido un nuevo inicio de sesión en su cuenta."
//					+ "<br> En caso de no haber sido usted, por favor, cambie la contraseña");

			mensaje.setText(
			"Se ha producido un nuevo inicio de sesión en su cuenta. <br> En caso de no haber sido usted, por favor, <b>cambie la contraseña</b>.",
			"ISO-8859-1",
			"html");
			
			// Utilizamos un objeto transport para hacer el envio indicando el protocolo
			Transport t = sesion.getTransport("smtp");
			// Hacemos la conexion
			t.connect("tienda-online-curso@outlook.com", "cursojava2022");
			// Enviamos el mensaje
			t.sendMessage(mensaje, mensaje.getAllRecipients());

			// Cerramos la conexion
			t.close();

		} catch (AddressException ex) {
			Logger.getLogger(Mailer.class.getName()).log(Level.SEVERE, null, ex);
		} catch (MessagingException ex) {
			Logger.getLogger(Mailer.class.getName()).log(Level.SEVERE, null, ex);
		}

	}
	
	public static Boolean enviarMailRecuperacion(String email, String contraseña) {
		
		try {
			// Propiedades de la conexion
			Properties prop = new Properties();
			// Nombre del servidor de salida
			prop.setProperty("mail.smtp.host", "smtp.office365.com");
			// Habilitamos TLS
			prop.setProperty("mail.smtp.starttls.enable", "true");
			// Indicamos el puerto
			prop.setProperty("mail.smtp.port", "587");
			// Indicamos el usuario
			prop.setProperty("mail.smtp.user", "tienda-online-curso@outlook.com");
			// Indicamos que requiere autenticación
			prop.setProperty("mail.smtp.auth", "true");

			// Creamos un objeto sesion
			Session sesion = Session.getDefaultInstance(prop);
			
			//TODO
//			sesion.setDebug(true);
			
			// Creamos un objeto mensaje a traves de la sesion
			MimeMessage mensaje = new MimeMessage(sesion);
			
			// Indicamos la cuenta desde la que se va a enviar
			mensaje.setFrom(new InternetAddress("tienda-online-curso@outlook.com"));

			// Añadimos el recipiente al mensaje al que va a ir dirigido el mensaje
			mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(email));

			//TODO
			// Creamos el asunto del mensaje
			mensaje.setSubject("Contraseña perdida");

			//TODO
			// Creamos el cuerpo del mensaje
//			mensaje.setText("Se ha producido un nuevo inicio de sesión en su cuenta."
//					+ "<br> En caso de no haber sido usted, por favor, cambie la contraseña");

			mensaje.setText(
			"Se ha solicitado un cambio de contraseña por parte del usuario. <br> Aquí dispone de la nueva contraseña temporal generada: <b>" + contraseña + "</b>. <br> No se olvide de cambiar la contraseña una vez iniciada sesión.",
			"ISO-8859-1",
			"html");
			
			// Utilizamos un objeto transport para hacer el envio indicando el protocolo
			Transport t = sesion.getTransport("smtp");
			// Hacemos la conexion
			t.connect("tienda-online-curso@outlook.com", "cursojava2022");
			// Enviamos el mensaje
			t.sendMessage(mensaje, mensaje.getAllRecipients());

			// Cerramos la conexion
			t.close();
			
			return true;

		} catch (AddressException ex) {
			Logger.getLogger(Mailer.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		} catch (MessagingException ex) {
			Logger.getLogger(Mailer.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}

	}

}
