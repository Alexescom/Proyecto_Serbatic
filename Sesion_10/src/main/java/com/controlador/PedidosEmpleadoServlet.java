package com.controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.PedidosUsuario;
import dao.pojos.Pedido;

/**
 * Servlet implementation class PedidosEmpleado
 */
public class PedidosEmpleadoServlet extends HttpServlet {
	
	//Variables
	private static PedidosUsuario p = new PedidosUsuario();
	private static final long serialVersionUID = 1L;

	
    public PedidosEmpleadoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("Entidad").equals("Empleado")) { //Recoger pedidos empleado
			
			ArrayList <Pedido> pedidos = p.recogerPedidosEmpleado();
			request.setAttribute("Pedidos", pedidos);
			request.getRequestDispatcher("Vistas/Empleado/Pedidos/Pedidos.jsp").forward(request, response);
			
		}else {
			
			ArrayList <Pedido> pedidos = p.recogerPedidosAdmin();
			request.setAttribute("Pedidos", pedidos);
			request.getRequestDispatcher("Vistas/Administrador/Pedidos/Pedidos.jsp").forward(request, response);
			
		}
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
