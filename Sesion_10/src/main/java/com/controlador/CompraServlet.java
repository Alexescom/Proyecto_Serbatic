package com.controlador;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.pojos.Detalle;
import dao.pojos.Pedido;
import Service.InsertadorPedido;
import Service.ReductorStock;
import dao.OperationsDB;

/**
 * Servlet implementation class CompraServlet
 */
public class CompraServlet extends HttpServlet {
	
	//Variables
	private static final long serialVersionUID = 1L;
	private static ArrayList <Detalle> carro = new ArrayList<Detalle>();
    private static OperationsDB ope =  new OperationsDB();  
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompraServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		carro = (ArrayList<Detalle>)request.getSession().getAttribute("Carro");
		
		if (carro != null) {
			
			//Si no hemos inciado sesión
			if (request.getSession().getAttribute("usuario") == null) {
				
				request.getRequestDispatcher("Vistas/Autenticacion/Login.jsp").forward(request, response);
				
			}else {
				
				//Filtrado de operacion
				if (request.getParameter("Operacion").equals("Checkout")) { //Mostrar check out
					
					//Calculamos el precio total
					double precioTotal = 0;
					for ( Detalle a : carro) {
						precioTotal += a.getTotal();
					}
					
					request.setAttribute("Total", precioTotal);
					request.getRequestDispatcher("Vistas/Compra/MetodoPago.jsp").forward(request, response);
					
				}else { //Realizar pedido
					
					System.out.println("Entramos por aqui");
					//Calculamos el precio total
					double precioTotal = 0;
					for ( Detalle a : carro) {
						precioTotal += a.getTotal();
						ReductorStock.reducirStock(a);
					}
					
					//Número aleatorio de factura
					Random rand = new Random();
					
					//Rellenamos el pedido
					Pedido pedido = new Pedido();
					pedido.setId_usuario(44);
					pedido.setFecha(new Date());
					pedido.setMetodo_pago("Tarjeta");
					pedido.setEstado("PE");
					pedido.setTotal(precioTotal);
					
					//Obtenemos el número de factura obtenido
					int numPedido = InsertadorPedido.insertarPedido(pedido);
					
					for (Detalle a: carro) {
						a.setId_pedido(numPedido);
						InsertadorPedido.insertarDetallePedido(a);
					}
					
					request.getSession().setAttribute("Carro", null);
					request.getSession().setAttribute("Acumulador", 0);
					request.setAttribute("Total", precioTotal);
					request.getRequestDispatcher("Vistas/Compra/Compra.jsp").forward(request, response);
				}
				
				
				

				
			}

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
