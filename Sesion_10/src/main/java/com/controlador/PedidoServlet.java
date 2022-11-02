package com.controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.pojos.Detalle;
import Service.ConfiguracionService;
import Service.PedidosUsuario;

/**
 * Servlet implementation class PedidoServlet
 */
public class PedidoServlet extends HttpServlet {
	
	//Variables
	private static final long serialVersionUID = 1L;
	private static PedidosUsuario pedido = new PedidosUsuario();
	private static ArrayList<Detalle> detalles = new ArrayList<Detalle>();
       

	//Metodos
    public PedidoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("Id_pedido"));
		
		if (request.getParameter("Operacion").equals("Mostrar")) { //Mostrar detalles pedido
			
			//Recogemos los detalles pedido del pedido
			detalles = pedido.recogerDetallePedidos(id);
			request.setAttribute("Detalles", detalles);
			request.setAttribute("Id_pedido", id);

			//Redireccionamos
			request.getRequestDispatcher("Vistas/Usuario/DetallePedido.jsp").forward(request, response);
			
			
		}else { //Cancelar pedido pendiente de envio
			
			//Llamamos a modificar la base de datos
			pedido.cambiarEstadoPedido(id, request.getParameter("Estado"));
			
			if (request.getParameter("Estado").equals("E")) {
				
				//Insertamos numero de factura nuevo
				pedido.cambiarNumeroFactura(id, Double.parseDouble(ConfiguracionService.getNumeroFactura()));
				
			}
			
			if (request.getParameter("Operacion").equals("Cancelar")) {
				//Redireccionamos
				request.getRequestDispatcher("UsuarioServlet?Operacion=Pedidos").forward(request, response);
				
			}if (request.getParameter("Operacion").equals("Cambiar")) {
				
				if (request.getParameter("Entidad").equals("Admin")) {
					
					request.setAttribute("Entidad", "Admin");
					//Redireccionamos
					request.getRequestDispatcher("PedidosEmpleadoServlet").forward(request, response);
					
				}else {
					
					request.setAttribute("Entidad", "Empleado");
					//Redireccionamos
					request.getRequestDispatcher("PedidosEmpleadoServlet").forward(request, response);
					
				}
			}

			
		}

		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
