package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Conection.Conexion;
import dao.pojos.Categoria;

public class OperationsCategoriaDB {

	//Variables
	private static Connection conexion;
    private static ArrayList <Categoria> categorias = new ArrayList<Categoria>();
	
	
	//Métodos
	public static ArrayList<Categoria> getCategorias(){
		conexion = Conexion.getConexion();
		categorias.clear();
        PreparedStatement stmt;
		
			try {
				stmt = conexion.prepareStatement("select * from categorias");
				
				ResultSet rs = stmt.executeQuery(); 
				
				while(rs.next() ) {
					
					Categoria categoria = new Categoria();
					categoria.setNombre(rs.getString("nombre"));
					categoria.setDescripcion(rs.getString("descripcion"));
					categorias.add(categoria);

				}

		        stmt.close();
		        return categorias;
		        
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			
			
			}
		
	}
	
	public static boolean insertarCategoria(Categoria c){
		conexion = Conexion.getConexion();

		try {
			
			//Insertamos en la base de datos
			PreparedStatement stmt2;
			stmt2 = conexion.prepareStatement("insert into categorias (nombre, descripcion) values (?, ?)");
			stmt2.setString(1,c.getNombre());
			stmt2.setString(2, c.getDescripcion());
					
			stmt2.executeUpdate();
			conexion.commit();

			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
}
