package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Conection.Conexion;
import dao.pojos.Articulo;
import dao.pojos.Usuario;

public class OperationsProductosDB {
	
	
	//Variables
	private static Connection conexion;	
	
	
	
	
    //---------------------------MODIFICAR---------------------------//
	public boolean modificarProducto(Articulo articulo){
		
			conexion = Conexion.getConexion();
		  	PreparedStatement stmt;
	        
			try {
				
				stmt = conexion.prepareStatement("update productos set id_categoria= ?, nombre = ?, descripcion = ?, precio = ?, stock = ?, impuesto = ? where id=? ");
				stmt.setInt(1, articulo.getId_categoria());
				stmt.setString(2, articulo.getNombre());
				stmt.setString(3, articulo.getDescripcion());
				stmt.setFloat(4, articulo.getPrecio());
				stmt.setInt(5, articulo.getStock());
				stmt.setFloat(6, articulo.getImpuesto());
				stmt.setInt(7, articulo.getId());
				
				int result = stmt.executeUpdate();
				conexion.commit();
				
//				System.out.println("El email es " + user.getEmail());
				return true;
		        
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
	}	
	
	public boolean modificarProductoBaja(int id){
		
		conexion = Conexion.getConexion();
	  	PreparedStatement stmt;
        
		try {
			
			stmt = conexion.prepareStatement("update productos set baja = '1' where id=?");
			stmt.setInt(1, id);
			
			int result = stmt.executeUpdate();
			conexion.commit();
			
//			System.out.println("El email es " + user.getEmail());
			return true;
	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
}	
	
    //---------------------------INSERTAR---------------------------//
	public static boolean insertarProducto(Articulo articulo){
		
			conexion = Conexion.getConexion();
		  	PreparedStatement stmt;
	        
			try {
				
				stmt = conexion.prepareStatement("insert into productos (id_categoria, nombre, descripcion, precio, stock, fecha_alta, impuesto) values (?,?,?,?,?,?,?)");
				stmt.setInt(1, articulo.getId_categoria());
				stmt.setString(2, articulo.getNombre());
				stmt.setString(3, articulo.getDescripcion());
				stmt.setFloat(4, articulo.getPrecio());
				stmt.setInt(5, articulo.getStock());
				stmt.setDate(6, new Date(new java.util.Date().getTime()));
				stmt.setFloat(7, articulo.getImpuesto());
				
				int result = stmt.executeUpdate();
				conexion.commit();
				
//				System.out.println("El email es " + user.getEmail());
				return true;
		        
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
	}	
}
