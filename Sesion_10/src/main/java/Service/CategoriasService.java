package Service;

import java.util.ArrayList;

import dao.OperationsCategoriaDB;
import dao.pojos.Categoria;

public class CategoriasService {
	
	//Métodos
	public static ArrayList<Categoria> getCategorias(){
		
		return OperationsCategoriaDB.getCategorias();
	}
	
	public static boolean insertarCategoria(Categoria c){
		
		return OperationsCategoriaDB.insertarCategoria(c);
	}

}
