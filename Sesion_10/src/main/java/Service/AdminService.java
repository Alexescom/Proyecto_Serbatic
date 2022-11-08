package Service;

import dao.OperationsUsuario;
import dao.pojos.Usuario;

public class AdminService {
	
	
	public static boolean crearAdmin() {
		
		int cont = OperationsUsuario.recogerAdmin();
		if (cont == 0) { //Creamos al usuario admin
			
			Usuario usuario = new Usuario();
			usuario.setClave("admin");
			usuario.setNombre("admin");
			usuario.setId_rol(4);
			usuario.setEmail("admin");
			System.out.println("Creamos usuario super-Admin");
			return OperationsUsuario.insertarUsuario(usuario);
			
		}else {
			return true;
		}
	}

}
