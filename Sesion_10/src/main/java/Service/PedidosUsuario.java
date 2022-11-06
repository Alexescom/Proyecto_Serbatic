package Service;

import java.util.ArrayList;

import dao.pojos.Detalle;
import dao.pojos.Pedido;
import dao.OperationsPedidoDB;

public class PedidosUsuario {
	
	//Variables
	private static OperationsPedidoDB ope = new OperationsPedidoDB();
	
	
	//Métodos
	public ArrayList<Pedido> recogerPedidos(int id){
		
		return ope.recogerPedidos(id);
		
	}
	
	public ArrayList<Pedido> recogerPedidosEmpleado(){
		
		return ope.recogerPedidosEmpleado();
		
	}
	
	public ArrayList<Pedido> recogerPedidosAdmin(){
		
		return ope.recogerPedidosAdmin();
		
	}
	
	public ArrayList<Detalle> recogerDetallePedidos(int id){
		
		return ope.recogerDetallePedidos(id);
		
	}

	public boolean eliminarDetallePedido(int id){
		
		return ope.eliminarDetallePedido(id);
		
	}
	
	public Boolean cambiarEstadoPedido(int id, String estado){
		
		return ope.cambiarEstadoPedido(id, estado);
		
	}
	
	public Boolean cambiarNumeroFactura(int id, double numero){
		
		return ope.cambiarNumeroFactura(id, numero);
		
	}
}
