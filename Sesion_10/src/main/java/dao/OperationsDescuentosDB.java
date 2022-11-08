package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Conection.Conexion;
import dao.pojos.Articulo;
import dao.pojos.Descuento;
import dao.pojos.Usuario;

public class OperationsDescuentosDB {

	//Variables
	private static Connection conexion;
    private static ArrayList <Descuento> descuentos = new ArrayList<Descuento>();
	
	//Métodos
    //---------------------------RECOGER---------------------------//
	public static Descuento buscarDescuento(String codigo) {
		
		conexion = Conexion.getConexion();
        PreparedStatement stmt;
		try {
			stmt = conexion.prepareStatement("select * from descuentos where codigo = ?");
			stmt.setString(1, codigo);
			ResultSet rs = stmt.executeQuery(); 
			Descuento descuento = new Descuento();
			
			while(rs.next() ) {

				descuento.setCodigo(rs.getString("codigo"));
				descuento.setDescuento(rs.getFloat("descuento"));
				descuento.setId(rs.getInt("id"));
				

			}

	        stmt.close();
	        return descuento;
	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static ArrayList<Descuento> recogerDescuentos(){
		conexion = Conexion.getConexion();
		descuentos.clear();
	    PreparedStatement stmt;
		
			try {
				stmt = conexion.prepareStatement("select * from descuentos ");
				ResultSet rs = stmt.executeQuery(); 
				int contador = 0;
				
				while(rs.next() ) {
					
					Descuento descuento = new Descuento();
					descuento.setId(rs.getInt("id"));
					descuento.setCodigo(rs.getString("codigo"));
					descuento.setDescuento(rs.getFloat("descuento"));
				
					
	//				System.out.println("El stock del producto " + rs.getInt("id") + " es: " + rs.getInt("stock"));
					descuentos.add(descuento);

				}
	
		        stmt.close();
		        return descuentos;
		        
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			
			
			}
	}
	
	
	public static Descuento recogerDescuento(int id){
		
		conexion = Conexion.getConexion();
	  	PreparedStatement stmt;
        
		try {
			stmt = conexion.prepareStatement("select * from descuentos where id = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery(); 
			rs.next();
				Descuento descuento = new Descuento();
				descuento.setId(id);
				descuento.setCodigo(rs.getString("codigo"));
				descuento.setDescuento(rs.getFloat("descuento"));

				stmt.close();
				return descuento;
	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	 //---------------------------INSERTAR---------------------------//
	public static boolean insertarDescuento(Descuento descuento){
			
				conexion = Conexion.getConexion();
			  	PreparedStatement stmt;
		        
				try {
					
					stmt = conexion.prepareStatement("insert into descuentos (codigo, descuento) values (?, ?)");
					stmt.setString(1, descuento.getCodigo());
					stmt.setFloat(2, descuento.getDescuento());
					
					int result = stmt.executeUpdate();
					conexion.commit();
					
//					System.out.println("El email es " + user.getEmail());
					return true;
			        
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				}
	}
		
		
		
		
		
	    //---------------------------MODIFICAR---------------------------//
		public static boolean modificarDescuento(Descuento descuento){
			
				conexion = Conexion.getConexion();
			  	PreparedStatement stmt;
		        
				try {
					
					stmt = conexion.prepareStatement("update descuentos set codigo= ?, descuento=? where id=?");
					stmt.setString(1, descuento.getCodigo());
					stmt.setFloat(2, descuento.getDescuento());
					stmt.setInt(3, descuento.getId());
					
					int result = stmt.executeUpdate();
					conexion.commit();
					
//					System.out.println("El email es " + user.getEmail());
					return true;
			        
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				}
		}
}
