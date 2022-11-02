package com.controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.DocumentoService;
import Service.PedidosUsuario;
import dao.OperationsPedidoDB;
import dao.pojos.Pedido;

/**
 * Servlet implementation class DocumentoServlet
 */
public class DocumentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//Variables
	private static PedidosUsuario p = new PedidosUsuario();

    public DocumentoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id =Integer.parseInt(request.getParameter("Id"));
		
		//Llamamos a recoger pedido
		DocumentoService.exportarPDF(OperationsPedidoDB.recogerDetallePedidos(id), OperationsPedidoDB.recogerPedido(id));
		System.out.println("Aqui estoy");
		//Mostramos los pedidos
		ArrayList <Pedido> pedidos = p.recogerPedidos((int)request.getSession().getAttribute("Id"));
		request.setAttribute("Pedidos", pedidos);
		request.getRequestDispatcher("Vistas/Usuario/Pedidos.jsp").forward(request, response);
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
