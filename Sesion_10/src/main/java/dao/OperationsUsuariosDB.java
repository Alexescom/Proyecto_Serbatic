package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Conection.Conexion;
import dao.pojos.Usuario;

public class OperationsUsuariosDB {
	
	//Variables
	private static Connection conexion;
    private static ArrayList <Usuario> usuarios = new ArrayList<Usuario>();
	
	
	//Métodos
	public ArrayList<Usuario> recogerUsuarios(int id){
		
		conexion = Conexion.getConexion();
		usuarios.clear();
        PreparedStatement stmt;
		
			try {
				stmt = conexion.prepareStatement("select * from usuarios where id_rol = ?");
				stmt.setInt(1, id);
				ResultSet rs = stmt.executeQuery(); 
				int contador = 0;
				
				while(rs.next() ) {
					
					Usuario user = new Usuario();
					user.setId(rs.getInt("id"));
					user.setId_rol(rs.getInt("id_rol"));
					user.setEmail(rs.getString("email"));
					user.setClave(rs.getString("clave"));
					user.setNombre(rs.getString("nombre"));
					user.setApellido1(rs.getString("apellido1"));
					user.setApellido2(rs.getString("apellido2"));
					user.setDireccion(rs.getString("direccion"));
					user.setProvincia(rs.getString("provincia"));
					user.setLocalidad(rs.getString("localidad"));
					user.setTelefono(rs.getString("telefono"));
					user.setDni(rs.getString("dni"));
					user.setBaja(rs.getBoolean("baja"));
					
//					System.out.println("El stock del producto " + rs.getInt("id") + " es: " + rs.getInt("stock"));
					usuarios.add(user);
					contador++;

					if (contador >25) {
						break;
					}
				}

		        stmt.close();
		        return usuarios;
		        
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			
			
			}
		
	}
	

	


}
