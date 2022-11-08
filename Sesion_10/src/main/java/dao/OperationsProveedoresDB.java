package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Conection.Conexion;
import dao.pojos.Proveedor;
import dao.pojos.Usuario;

public class OperationsProveedoresDB {
	
	
	//Variables
	private static Connection conexion;
    private static ArrayList <Proveedor> proveedores = new ArrayList<Proveedor>();
	
	//Métodos
    //---------------------------RECOGER---------------------------//
	public static ArrayList<Proveedor> recogerProveedores(int id){
			
			conexion = Conexion.getConexion();
			proveedores.clear();
	        PreparedStatement stmt;
			
	        if (id == 0) { //Llamada general
				try {
					stmt = conexion.prepareStatement("select * from proveedores where baja = '0'");
					ResultSet rs = stmt.executeQuery(); 
					
					while(rs.next() ) {
						
						Proveedor proveedor = new Proveedor();
						proveedor.setId(rs.getInt("id"));
						proveedor.setNombre(rs.getString("nombre"));
						proveedor.setDireccion(rs.getString("direccion"));
						proveedor.setProvincia(rs.getString("provincia"));
						proveedor.setLocalidad(rs.getString("localidad"));
						proveedor.setTelefono(rs.getString("telefono"));
						proveedor.setCif(rs.getString("cif"));
						proveedor.setEmail(rs.getString("email"));
						proveedor.setBaja(rs.getBoolean("baja"));
						
//						System.out.println("El stock del producto " + rs.getInt("id") + " es: " + rs.getInt("stock"));
						proveedores.add(proveedor);

					}

			        stmt.close();
			        return proveedores;
			        
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				
				
				}
				
	        }else { //Llamada para recoger valor de un solo usuario
	        	
				try {
					stmt = conexion.prepareStatement("select * from proveedores where id = ?");
					stmt.setInt(1, id);
					ResultSet rs = stmt.executeQuery(); 
					
					while(rs.next() ) {
						
						Proveedor proveedor = new Proveedor();
						proveedor.setId(rs.getInt("id"));
						proveedor.setNombre(rs.getString("nombre"));
						proveedor.setDireccion(rs.getString("direccion"));
						proveedor.setProvincia(rs.getString("provincia"));
						proveedor.setLocalidad(rs.getString("localidad"));
						proveedor.setTelefono(rs.getString("telefono"));
						proveedor.setCif(rs.getString("cif"));
						proveedor.setEmail(rs.getString("email"));
						proveedor.setBaja(rs.getBoolean("baja"));
						
//						System.out.println("El stock del producto " + rs.getInt("id") + " es: " + rs.getInt("stock"));
						proveedores.add(proveedor);

					}

			        stmt.close();
			        return proveedores;
			        
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				
				
				}
	        	
	        }
	}
	
    //---------------------------MODIFICAR---------------------------//
	public static boolean modificarProveedor(Proveedor proveedor){
		
			conexion = Conexion.getConexion();
		  	PreparedStatement stmt;
	        
			try {
				
				stmt = conexion.prepareStatement("update proveedores set email= ?, nombre=?,  direccion=?, provincia=?, localidad=?, telefono=?, cif=? where id=?");
				stmt.setString(1, proveedor.getEmail());
				stmt.setString(2, proveedor.getNombre());
				stmt.setString(3, proveedor.getDireccion());
				stmt.setString(4, proveedor.getProvincia());
				stmt.setString(5, proveedor.getLocalidad());
				stmt.setString(6, proveedor.getTelefono());
				stmt.setString(7, proveedor.getCif());
				stmt.setInt(8, proveedor.getId());
				
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
	
	public static boolean modificarProveedorBaja(int id){
		
		conexion = Conexion.getConexion();
	  	PreparedStatement stmt;
        
		try {
			
			stmt = conexion.prepareStatement("update proveedores set baja = '1' where id=?");
			stmt.setInt(1, id);
			
			int result = stmt.executeUpdate();
			conexion.commit();
			
			return true;
	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
    //---------------------------INSERTAR---------------------------//
	public static boolean insertarProveedor(Proveedor proveedor){
		
			conexion = Conexion.getConexion();
		  	PreparedStatement stmt;
	        
			try {
				
				stmt = conexion.prepareStatement("insert into proveedores ( email,  nombre, direccion, provincia, localidad, telefono, cif) values (?, ?, ?, ?, ?, ?, ?)");
				
				stmt.setString(1, proveedor.getEmail());
				stmt.setString(2, proveedor.getNombre());
				stmt.setString(3, proveedor.getDireccion());
				stmt.setString(4, proveedor.getProvincia());
				stmt.setString(5, proveedor.getLocalidad());
				stmt.setString(6, proveedor.getTelefono());
				stmt.setString(7, proveedor.getCif());
				
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
