package Service;

import java.util.ArrayList;

import dao.OperationsValoracionDB;
import dao.pojos.Valoracion;

public class ValoracionService {
	
	
	//Métodos
	public static boolean insertarValoracion(Valoracion v) {
		
		return OperationsValoracionDB.insertarValoracion(v);
	}
	
	public static ArrayList<Valoracion> recogerValoraciones (int id) {
		
		return OperationsValoracionDB.recogerValoraciones(id);
	}

}
