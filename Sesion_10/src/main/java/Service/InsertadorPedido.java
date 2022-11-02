package Service;

import dao.pojos.Detalle;
import dao.pojos.Pedido;
import dao.OperationsPedidoDB;

public class InsertadorPedido {

	//Variables
	private static OperationsPedidoDB ope = new OperationsPedidoDB();
	
	//Métodos
	public static int insertarPedido(Pedido p) {
		
			return ope.insertarPedido(p);
		
	}
	
	//Métodos
	public static boolean insertarDetallePedido(Detalle d) {
		
			return ope.insertarDetallePedido(d);
		
	}
}
