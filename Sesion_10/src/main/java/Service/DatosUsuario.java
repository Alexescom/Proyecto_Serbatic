package Service;

import dao.OperationsUsuario;
import dao.pojos.Usuario;

public class DatosUsuario {

	//Variables
	private static OperationsUsuario ope = new OperationsUsuario();
	
	
	//Métodos
	public static Usuario recogerDatosUsuario (int id){
		
		return ope.recogerUsuario(id);
		
	}
	
	public static boolean modificarUsuario (Usuario user){
		
		return ope.modificarUsuario(user);
		
	}
	
	public static boolean modificarContraseña (Usuario user){
		
		return ope.modificarContraseña(user);
		
	}
	
	public static Boolean modificarContraseñaRecuperacion (Usuario user){
		
		return ope.modificarContraseñaRecuperacion(user);
		
	}
	
	public static boolean modificarUsuarioBaja (int id){
		
		return ope.modificarUsuarioBaja(id);
		
	}
	
	public static boolean insertarUsuario (Usuario user){
		
		return ope.insertarUsuario(user);
		
	}
}
