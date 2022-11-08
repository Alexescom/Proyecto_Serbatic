package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Conection.Conexion;
import dao.pojos.Categoria;
import dao.pojos.Valoracion;

public class OperationsValoracionDB {
	
	//Variables
	private static Connection conexion;
    private static ArrayList <Valoracion> valoraciones = new ArrayList<Valoracion>();
	
	
	//Métodos
	public static boolean insertarValoracion (Valoracion v) {
		conexion = Conexion.getConexion();

		try {
			
			//Insertamos en la base de datos
			PreparedStatement stmt2;
			stmt2 = conexion.prepareStatement("insert into valoraciones (id_producto, id_usuario, valoracion, comentario, nombre_usuario) values (?, ?, ?, ?, ?)");
			stmt2.setInt(1, v.getId_producto());
			stmt2.setInt(2, v.getId_usuario());
			stmt2.setInt(3, v.getValoracion());
			stmt2.setString(4, v.getComentario());
			stmt2.setString(5, v.getNombre());
					
			stmt2.executeUpdate();
			
			//Calculamos la media de valoraciones del producto
			PreparedStatement stmt4;
			stmt4 = conexion.prepareStatement("select valoracion, num_valoraciones from productos where id = ?");
			stmt4.setInt(1, v.getId_producto());
			ResultSet rs = stmt4.executeQuery(); 
			
			while(rs.next() ) {
				
				int valoracion= rs.getInt("valoracion");
				int numValoraciones = rs.getInt("num_valoraciones");
				
				valoracion = ((valoracion * numValoraciones) + v.getValoracion()) / (numValoraciones + 1);
				numValoraciones ++;
				
				//Hacemos el update
				PreparedStatement stmt3;
				stmt3 = conexion.prepareStatement("update productos set valoracion = ?, num_valoraciones = ?  where id=?");
				stmt3.setInt(1, valoracion);
				stmt3.setInt(2, numValoraciones);
				stmt3.setInt(3, v.getId_producto());
				
				stmt3.executeUpdate();
			}
			
			conexion.commit();
			return true;

			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	public static ArrayList<Valoracion> recogerValoraciones (int id) {

		conexion = Conexion.getConexion();
		valoraciones.clear();
        PreparedStatement stmt;
		
			try {
				stmt = conexion.prepareStatement("select * from valoraciones where id_producto = ?");
				stmt.setInt(1, id);
				ResultSet rs = stmt.executeQuery(); 
				
				while(rs.next() ) {
					
					Valoracion valoracion = new Valoracion();
					valoracion.setComentario(rs.getString("comentario"));
					valoracion.setValoracion(rs.getInt("valoracion"));
					valoracion.setId_usuario(rs.getInt("id_usuario"));
					valoracion.setNombre(rs.getString("nombre_usuario"));
					valoraciones.add(valoracion);

				}

		        stmt.close();
		        return valoraciones;
		        
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			
			
			}
		
		
	}

}
