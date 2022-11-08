package com.controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.PedidosUsuario;
import Service.ValoracionService;
import dao.pojos.Detalle;
import dao.pojos.Valoracion;

/**
 * Servlet implementation class ValoracionServlet
 */
public class ValoracionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


    public ValoracionServlet() {
        super();

    }



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Rellenamos la valoracion
		Valoracion valoracion = new Valoracion();
		valoracion.setComentario(request.getParameter("Comentario"));
		valoracion.setId_producto(Integer.parseInt(request.getParameter("Id_producto")));
		valoracion.setId_usuario((int)request.getSession().getAttribute("Id"));
		valoracion.setNombre((String)request.getSession().getAttribute("usuario"));
		String valor = request.getParameter("estrellas"+valoracion.getId_producto());
		if (valor != null) {
			if (valor.equals("5")) { //5 estrellas
				valoracion.setValoracion(5);
			} else if (valor.equals("4")) { //4 estrellas
				valoracion.setValoracion(4);
			} else if (valor.equals("3")) { //3 estrellas
				valoracion.setValoracion(3);
			} else if (valor.equals("2")) { //2 estrellas
				valoracion.setValoracion(2);
			} else if (valor.equals("1")) { //1 estrella
				valoracion.setValoracion(1);
			} 
		}else { //0 estrellas
			valoracion.setValoracion(0);
		}

		ValoracionService.insertarValoracion(valoracion);
		
		//Redireccionamos a pedidos
		PedidosUsuario pedido = new PedidosUsuario();
		ArrayList<Detalle> detalles = new ArrayList<Detalle>();
		detalles = pedido.recogerDetallePedidos(Integer.parseInt(request.getParameter("Id_pedido")));
		request.setAttribute("Detalles", detalles);
		request.setAttribute("Id_pedido", request.getParameter("Id_pedido"));
		request.setAttribute("Estado", "E");
		//Redireccionamos
		request.getRequestDispatcher("Vistas/Usuario/DetallePedido.jsp").forward(request, response);
		
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}

}
