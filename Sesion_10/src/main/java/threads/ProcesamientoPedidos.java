package threads;

import java.sql.Connection;
import java.util.ArrayList;

import Conection.Conexion;
import Service.ConfiguracionService;
import Service.PedidosUsuario;
import dao.pojos.Pedido;

public class ProcesamientoPedidos extends Thread {
	
	//Variables
    private static Connection conexion;
    private static boolean salir;
	private static PedidosUsuario p = new PedidosUsuario();
    
    //Métodos
	public void run() {
		
		salir = false;
		ArrayList <Pedido> pedidos = p.recogerPedidosEmpleado();
		int contador = 0;
		
		while (!salir) {
			
			int id =  pedidos.get(contador).getId();
			p.cambiarEstadoPedido(id, "E");
			p.cambiarNumeroFactura(id, Double.parseDouble(ConfiguracionService.getNumeroFactura()));
			
			try {
				Thread.sleep(500000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			contador++;
		}
		
	}//Fin run
	
	
    public void parar() {
        salir = true;
    }

}
