package Service;

import dao.pojos.Detalle;
import dao.OperationsDB;

public class ReductorStock {
	
	//Variables
	private static OperationsDB ope = new OperationsDB();
	
	//Métodos
	public static boolean reducirStock(Detalle a) {
		
		if (ope.reducirStock(a)) {
			
			return true;
			
		}else {
			
			System.out.println("Error al reducir stock en el producto: " + a.getNombre());
			return false;
		}
		
	}
}
