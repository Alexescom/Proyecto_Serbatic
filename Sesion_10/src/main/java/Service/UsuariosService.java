package Service;

import java.util.ArrayList;

import dao.OperationsUsuariosDB;
import dao.pojos.Usuario;

public class UsuariosService {
	
	//Variables
	private static OperationsUsuariosDB ope = new OperationsUsuariosDB();
	
	//Métodos
	public static ArrayList <Usuario> recogerUsuarios(int id) {
		
		return ope.recogerUsuarios(id);
		
	}	
	
//	public static ArrayList <Usuario> recogerEmpleados() {
//		
//	}	

}
