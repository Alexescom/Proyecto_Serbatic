package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.jasypt.util.password.StrongPasswordEncryptor;

import Conection.Conexion;
import dao.pojos.Pedido;
import dao.pojos.Usuario;

public class OperationsUsuario {
	
	//Variables
	private static Connection conexion;
	StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
	
    
    //Métodos
    //---------------------------RECOGER---------------------------//
	public Usuario recogerUsuario(int id){
		
			conexion = Conexion.getConexion();
		  	PreparedStatement stmt;
	        
			try {
				stmt = conexion.prepareStatement("select * from usuarios where id = ?");
				stmt.setInt(1, id);
				ResultSet rs = stmt.executeQuery(); 
				rs.next();
					Usuario user = new Usuario();
					user.setId(id);
					user.setClave(rs.getString("clave"));
					user.setEmail(rs.getString("email"));
					user.setNombre(rs.getString("nombre"));
					user.setApellido1(rs.getString("apellido1"));
					user.setApellido2(rs.getString("apellido2"));
					user.setDireccion(rs.getString("direccion"));
					user.setProvincia(rs.getString("provincia"));
					user.setLocalidad(rs.getString("localidad"));
					user.setTelefono(rs.getString("telefono"));
					user.setDni(rs.getString("dni"));
					user.setId_rol(rs.getInt("id_rol"));
					stmt.close();
					return user;
		        
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
	}
	
    //---------------------------MODIFICAR---------------------------//
	public boolean modificarUsuario(Usuario user){
		
			conexion = Conexion.getConexion();
		  	PreparedStatement stmt;
	        
			try {
				
				stmt = conexion.prepareStatement("update usuarios set email= ?, nombre=?, apellido1=?, apellido2=?, direccion=?, provincia=?, localidad=?, telefono=?, dni=? where id=?");
				stmt.setString(1, user.getEmail());
				stmt.setString(3, user.getNombre());
				stmt.setString(4, user.getApellido1());
				stmt.setString(5, user.getApellido2());
				stmt.setString(6, user.getDireccion());
				stmt.setString(7, user.getProvincia());
				stmt.setString(8, user.getLocalidad());
				stmt.setString(9, user.getTelefono());
				stmt.setString(10, user.getDni());
				stmt.setInt(11, user.getId());
				
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
	
	
	
	public boolean modificarContraseña(Usuario user){
		
		conexion = Conexion.getConexion();
	  	PreparedStatement stmt;
	  	String contraseña = passwordEncryptor.encryptPassword(user.getClave());
        
		try {
			
			stmt = conexion.prepareStatement("update usuarios set clave=? where id=?");
			stmt.setString(1, contraseña);
			stmt.setInt(2, user.getId());
			
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
	
	
	public boolean modificarUsuarioBaja(int id){
		
		conexion = Conexion.getConexion();
	  	PreparedStatement stmt;
        
		try {
			
			stmt = conexion.prepareStatement("update usuarios set baja = '1' where id=?");
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
	public boolean insertarUsuario(Usuario user){
		
			conexion = Conexion.getConexion();
		  	PreparedStatement stmt;
	        
			try {
				
				stmt = conexion.prepareStatement("insert into usuarios (id_rol, email, clave, nombre, apellido1, apellido2, direccion, provincia, localidad, telefono, dni) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
				stmt.setInt(1, user.getId_rol());
				stmt.setString(2, user.getEmail());
				stmt.setString(3, user.getClave());
				stmt.setString(4, user.getNombre());
				stmt.setString(5, user.getApellido1());
				stmt.setString(6, user.getApellido2());
				stmt.setString(7, user.getDireccion());
				stmt.setString(8, user.getProvincia());
				stmt.setString(9, user.getLocalidad());
				stmt.setString(10, user.getTelefono());
				stmt.setString(11, user.getDni());
				
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
