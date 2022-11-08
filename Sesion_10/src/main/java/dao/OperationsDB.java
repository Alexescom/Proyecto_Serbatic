package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.util.password.StrongPasswordEncryptor;
import dao.pojos.Articulo;
import dao.pojos.Detalle;
import extraSources.Mailer;
import Conection.Conexion;

public class OperationsDB {
	
	//Variables
	private static Connection conexion;
    private static ArrayList <Articulo> articulos = new ArrayList<Articulo>();
	public static int idUsuario;
	public static String emailUsuario;
	public static int idRol;
	StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
	
	//Métodos
	public boolean autenticar(String nombre, String contraseña){
		
		conexion = Conexion.getConexion();
		String contraseñaC;
//		System.out.println(passwordEncryptor.encryptPassword("1234"));
        PreparedStatement stmt;
		try {
			stmt = conexion.prepareStatement("select clave,id,email,id_rol from usuarios where nombre = ? ");
			//stmt.setString(1, ""+nombre+"");
			stmt.setString(1, nombre);
			ResultSet rs = stmt.executeQuery(); 
			
			while(rs.next()) {
				
				contraseñaC = rs.getString("clave");
				idUsuario = rs.getInt("id");
				emailUsuario = rs.getString("email");
				idRol = rs.getInt("id_rol");
				if (passwordEncryptor.checkPassword(contraseña, contraseñaC)) {
					
					//Enviamos correo
					//Mailer.enviarMail(emailUsuario);
					//Devolvemos verdadero
					return true;
				}else {
					return false;
				}
			}
			
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
	
	public ArrayList<Articulo> recogerArticulos(int id){
		
		conexion = Conexion.getConexion();
		articulos.clear();
        PreparedStatement stmt;
		
		if (id == 0 ) {

			try {
				stmt = conexion.prepareStatement("select * from productos where baja = '0'");
				
				ResultSet rs = stmt.executeQuery(); 
				int contador = 0;
				
				while(rs.next() ) {
					
					Articulo artic = new Articulo();
					artic.setId(rs.getInt("id"));
					artic.setId_categoria(rs.getInt("id_categoria"));
					artic.setNombre(rs.getString("nombre"));
					artic.setDescripcion(rs.getString("descripcion"));
					artic.setPrecio(rs.getFloat("precio"));
					artic.setStock(rs.getInt("stock"));
					artic.setBaja(rs.getBoolean("baja"));
					artic.setValoracion(rs.getInt("valoracion"));
//					System.out.println("El stock del producto " + rs.getInt("id") + " es: " + rs.getInt("stock"));
					articulos.add(artic);
					contador++;

					if (contador >25) {
						break;
					}
				}

		        stmt.close();
		        return articulos;
		        
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			
			
			}
		}else {
			
			try {
				stmt = conexion.prepareStatement("select * from productos where id = ?");
				stmt.setInt(1, id);
				ResultSet rs = stmt.executeQuery(); 
				int contador = 0;
				
				while(rs.next() ) {
					
					Articulo artic = new Articulo();
					artic.setId(rs.getInt("id"));
					artic.setId_categoria(rs.getInt("id_categoria"));
					artic.setNombre(rs.getString("nombre"));
					artic.setDescripcion(rs.getString("descripcion"));
					artic.setPrecio(rs.getFloat("precio"));
					artic.setStock(rs.getInt("stock"));
					artic.setValoracion(rs.getInt("valoracion"));
//					System.out.println("El stock del producto " + rs.getInt("id") + " es: " + rs.getInt("stock"));
					articulos.add(artic);
				}

		        stmt.close();
		        return articulos;
		        
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			
			
			}
			
		}
	}
	
	
	
	public ArrayList<Articulo> recogerArticulosCategoria(int id){
		
		conexion = Conexion.getConexion();
		articulos.clear();
        PreparedStatement stmt;
		try {
			stmt = conexion.prepareStatement("select * from productos where id_categoria = ? AND baja = '0'");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery(); 
			int contador = 0;
			
			while(rs.next() ) {
				
				Articulo artic = new Articulo();
				artic.setId(rs.getInt("id"));
				artic.setNombre(rs.getString("nombre"));
				artic.setDescripcion(rs.getString("descripcion"));
				artic.setPrecio(rs.getFloat("precio"));
				artic.setStock(rs.getInt("stock"));
				artic.setValoracion(rs.getInt("valoracion"));
//				System.out.println("El stock del producto " + rs.getInt("id") + " es: " + rs.getInt("stock"));
				articulos.add(artic);
				contador++;

				if (contador >25) {
					break;
				}
			}

	        stmt.close();
	        return articulos;
	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	public ArrayList<Articulo> recogerArticulosBuscador(String nombre){
		
		conexion = Conexion.getConexion();
		articulos.clear();
        PreparedStatement stmt;
		try {
			stmt = conexion.prepareStatement("select * from productos where nombre LIKE ? AND baja = '0'");
			stmt.setString(1,"%" + nombre + "%");
			ResultSet rs = stmt.executeQuery(); 
			int contador = 0;
			
			while(rs.next() ) {
				
				Articulo artic = new Articulo();
				artic.setId(rs.getInt("id"));
				artic.setNombre(rs.getString("nombre"));
				artic.setDescripcion(rs.getString("descripcion"));
				artic.setPrecio(rs.getFloat("precio"));
				artic.setStock(rs.getInt("stock"));
				artic.setValoracion(rs.getInt("valoracion"));
//				System.out.println("El stock del producto " + rs.getInt("id") + " es: " + rs.getInt("stock"));
				articulos.add(artic);
				contador++;

				if (contador >25) {
					break;
				}
			}

	        stmt.close();
	        return articulos;
	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	public boolean reducirStock(Detalle a){
		
		conexion = Conexion.getConexion();
		int stock;
        PreparedStatement stmt;
        
		try {
			stmt = conexion.prepareStatement("select  stock from productos where id = ? ");
			//stmt.setString(1, ""+nombre+"");
			stmt.setInt(1, a.getId_producto());
			ResultSet rs = stmt.executeQuery(); 
			
			while(rs.next()) {
				
				stock = rs.getInt(1);
				stock--;
//				System.out.println("Reducimos stock del producto: " + a.getId_producto() + " stock: " + rs.getInt(1));
				PreparedStatement stmt2;
				stmt2 = conexion.prepareStatement("update productos set stock=? where id = ? ");
				stmt2.setInt(1, stock);
				stmt2.setInt(2, a.getId_producto());
				
				int result = stmt2.executeUpdate();
				conexion.commit();

			}
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

}
