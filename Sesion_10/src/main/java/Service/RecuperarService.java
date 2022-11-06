package Service;

import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;

import dao.OperationsUsuario;
import dao.pojos.Usuario;
import extraSources.Mailer;


public class RecuperarService {
	
	//Variables
	OperationsUsuario ope = new OperationsUsuario();
	
	
	//Métodos
	public static Boolean recuperarContraseña(String usuario) {
		Boolean bandera = true;
		
		//Generamos nueva contraseña temporal
		String randomPassword = RandomStringUtils.randomAlphanumeric(10);
		System.out.println(randomPassword);
		
		//Enviamos email
		if (!Mailer.enviarMailRecuperacion(usuario, randomPassword)) {
			bandera = false;
		}
		
		//Rellenamos objeto usuario
		Usuario user = new Usuario();
		user.setEmail(usuario);
		user.setClave(randomPassword);
		
		//Cambiamos contraseña usuario con el servicio
		if (!DatosUsuario.modificarContraseñaRecuperacion(user)) {
			bandera = false;
		}
		
		return bandera;
		
	}
		

}
