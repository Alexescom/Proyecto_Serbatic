package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Conection.Conexion;
import dao.pojos.Detalle;
import dao.pojos.Pedido;

public class OperationsPedidoDB {

	//Variables
	private static Connection conexion;
    private static ArrayList <Pedido> pedidos = new ArrayList<Pedido>();
    private static ArrayList <Detalle> detalles = new ArrayList<Detalle>();
	
    
    //Métodos
    //---------------------------INSERTAR---------------------------//
	public int insertarPedido(Pedido p){
		
		conexion = Conexion.getConexion();

		try {
			
			//Insertamos en la base de datos
			PreparedStatement stmt2;
			stmt2 = conexion.prepareStatement("insert into pedidos (id_usuario, fecha, metodo_pago, estado, total) values (?, ?, ?, ?, ?)");
			stmt2.setInt(1, p.getId_usuario());
			stmt2.setDate(2, new Date(new java.util.Date().getTime()));
			stmt2.setString(3, p.getMetodo_pago());
			stmt2.setString(4, p.getEstado());
			stmt2.setDouble(5, p.getTotal());
					
			stmt2.executeUpdate();
			conexion.commit();
			//Contamos el número de factura
			PreparedStatement stmt;
			stmt = conexion.prepareStatement("select count(*) from pedidos");
			ResultSet rs = stmt.executeQuery();
			rs.next();
			return (rs.getInt("count(*)"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
	}
	
	
	public boolean insertarDetallePedido(Detalle d){
			
			conexion = Conexion.getConexion();
	
			try {
	
				//Insertamos en la base de datos
				PreparedStatement stmt2;
				stmt2 = conexion.prepareStatement("insert into detalles_pedido (id_pedido, id_producto, precio_unidad, unidades, impuesto, total, nombre) values (?, ?, ?, ?, ?, ?, ?)");
				stmt2.setInt(1, d.getId_pedido());
				stmt2.setInt(2, d.getId_producto());
				stmt2.setFloat(3, d.getPrecio_unidad());
				stmt2.setInt(4, d.getUnidades());
				stmt2.setFloat(5, 1);
				stmt2.setDouble(6, d.getTotal());
				stmt2.setString(7, d.getNombre());
						
				stmt2.executeUpdate();
				conexion.commit();
	

				return true;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			
		}
	
	
	
	
	//---------------------------RECOGER---------------------------//
	public ArrayList<Pedido> recogerPedidos(int id){
			
			conexion = Conexion.getConexion();
	        PreparedStatement stmt;
	        pedidos.clear();
	        
			try {
				stmt = conexion.prepareStatement("select * from pedidos where id_usuario = ?");
				stmt.setInt(1, id);
				ResultSet rs = stmt.executeQuery(); 
				
				while(rs.next() ) {
					
					Pedido pedido = new Pedido();
					pedido.setId(rs.getInt("id"));
					pedido.setEstado(rs.getString("estado"));
					pedido.setFecha((Date) rs.getDate("fecha"));
					pedido.setMetodo_pago(rs.getString("metodo_pago"));
					pedido.setNum_factura(rs.getString("num_factura"));
					pedido.setTotal(rs.getDouble("total"));
					pedidos.add(pedido);

				}
	
		        stmt.close();
		        return pedidos;
		        
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
	
	public static Pedido recogerPedido(int id){
		
		conexion = Conexion.getConexion();
        PreparedStatement stmt;
        pedidos.clear();
        
		try {
			stmt = conexion.prepareStatement("select * from pedidos where id = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery(); 
			
			while(rs.next() ) {
				
				Pedido pedido = new Pedido();
				pedido.setId(rs.getInt("id"));
				pedido.setEstado(rs.getString("estado"));
				pedido.setFecha((Date) rs.getDate("fecha"));
				pedido.setMetodo_pago(rs.getString("metodo_pago"));
				pedido.setNum_factura(rs.getString("num_factura"));
				pedido.setTotal(rs.getDouble("total"));
				pedidos.add(pedido);

			}

	        stmt.close();
	        return pedidos.get(0);
	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Pedido> recogerPedidosEmpleado(){
		
		conexion = Conexion.getConexion();
        PreparedStatement stmt;
        pedidos.clear();
        
		try {
			stmt = conexion.prepareStatement("select * from pedidos where estado = 'PE'");
			ResultSet rs = stmt.executeQuery(); 
			
			while(rs.next() ) {
				
				Pedido pedido = new Pedido();
				pedido.setId(rs.getInt("id"));
				pedido.setEstado(rs.getString("estado"));
				pedido.setFecha((Date) rs.getDate("fecha"));
				pedido.setMetodo_pago(rs.getString("metodo_pago"));
				pedido.setNum_factura(rs.getString("num_factura"));
				pedido.setTotal(rs.getDouble("total"));
				pedidos.add(pedido);

			}

	        stmt.close();
	        return pedidos;
	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Pedido> recogerPedidosAdmin(){
		
		conexion = Conexion.getConexion();
        PreparedStatement stmt;
        pedidos.clear();
        
		try {
			stmt = conexion.prepareStatement("select * from pedidos where estado = 'PC'");
			ResultSet rs = stmt.executeQuery(); 
			
			while(rs.next() ) {
				
				Pedido pedido = new Pedido();
				pedido.setId(rs.getInt("id"));
				pedido.setEstado(rs.getString("estado"));
				pedido.setFecha((Date) rs.getDate("fecha"));
				pedido.setMetodo_pago(rs.getString("metodo_pago"));
				pedido.setNum_factura(rs.getString("num_factura"));
				pedido.setTotal(rs.getDouble("total"));
				pedidos.add(pedido);

			}

	        stmt.close();
	        return pedidos;
	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	public static ArrayList <Detalle> recogerDetallePedidos(int id){
		
		conexion = Conexion.getConexion();
        PreparedStatement stmt;
        detalles.clear();
        
		try {
			stmt = conexion.prepareStatement("select * from detalles_pedido where id_pedido = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery(); 
			
			while(rs.next() ) {
				
				Detalle detalle = new Detalle();
				detalle.setId(rs.getInt("id"));
				detalle.setId_pedido(rs.getInt("id_pedido"));
				detalle.setId_producto(rs.getInt("id_producto"));
				detalle.setPrecio_unidad(rs.getFloat("precio_unidad"));
				detalle.setUnidades(rs.getInt("unidades"));
				detalle.setImpuesto(rs.getFloat("impuesto"));
				detalle.setTotal(rs.getDouble("total"));
				detalle.setNombre(rs.getString("nombre"));
				detalles.add(detalle);

			}

	        stmt.close();
	        return detalles;
	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	//---------------------------ACTUALIZAR---------------------------//
	public Boolean cambiarEstadoPedido(int id, String estado){
		
		conexion = Conexion.getConexion();
	  	PreparedStatement stmt;
        
		try {
			
			stmt = conexion.prepareStatement("update pedidos set estado= ?  where id=?");
			stmt.setString(1, estado);
			stmt.setInt(2, id);
			
			stmt.executeUpdate();
			conexion.commit();
			
//			System.out.println("El email es " + user.getEmail());
			return true;
	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
		
	}
	
	public Boolean cambiarNumeroFactura(int id, double numero){
		
		conexion = Conexion.getConexion();
	  	PreparedStatement stmt;
        
		try {
			
			stmt = conexion.prepareStatement("update pedidos set num_factura= ?  where id=?");
			stmt.setDouble(1, numero);
			stmt.setInt(2, id);
			
			stmt.executeUpdate();
			conexion.commit();
			
//			System.out.println("El email es " + user.getEmail());
			return true;
	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
		
	}
		
}
