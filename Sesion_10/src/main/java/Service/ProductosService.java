package Service;

import dao.OperationsProductosDB;
import dao.OperationsUsuario;
import dao.pojos.Articulo;
import dao.pojos.Usuario;

public class ProductosService {

	//Variables
	private static OperationsProductosDB ope = new OperationsProductosDB();
	
	
	
	//Métodos
	public static boolean modificarProducto (Articulo articulo){
		
		return ope.modificarProducto(articulo);
		
	}
	
	public static boolean modificarProductoBaja (int id){
		
		return ope.modificarProductoBaja(id);
		
	}
	
	//Métodos
	public static boolean insertarProducto (Articulo articulo){
		
		return ope.insertarProducto(articulo);
		
	}
	
}
