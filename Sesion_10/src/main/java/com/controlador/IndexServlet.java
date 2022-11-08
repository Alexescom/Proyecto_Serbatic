package com.controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.AdminService;
import Service.Ordenacion;
import dao.pojos.Articulo;
import dao.pojos.Detalle;
import threads.ProcesamientoPedidos;
import dao.OperationsDB;

/**
 * Servlet implementation class IndexServlet
 */
public class IndexServlet extends HttpServlet {
	
	//Variables
	private static ProcesamientoPedidos hiloPedidos = new ProcesamientoPedidos();
	private static final long serialVersionUID = 1L;
    private static OperationsDB ope =  new OperationsDB();  
    private static int acumulador;
    private static Ordenacion orden = new Ordenacion();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		//Creamos la variable carrito al entrar en la web
		if (request.getSession().getAttribute("Carro") == null) {//Si carro null

		    ArrayList <Detalle> car = new ArrayList<Detalle>();
			request.getSession().setAttribute("Carro", car);
			
			//ARRANCAMOS EL HILO CONTADOR - P32
//			hiloPedidos.start();
//			hiloPedidos.parar();
			
			//CREAR ADMIN AL DESPLEGAR - P45
			AdminService.crearAdmin();

			
		}else if (request.getSession().getAttribute("Carro") != null) {//Miramos a ver si tenemos que contar productos del carrito
			
			acumulador = 0;
			ArrayList<Detalle> carro = (ArrayList<Detalle>) request.getSession().getAttribute("Carro");
			for (Detalle a: carro ) {
				acumulador += a.getUnidades();
				
			}
			System.out.println(acumulador);
			request.getSession().setAttribute("Acumulador", acumulador);
		}
		
		
		//Cargamos los artículos que se tienen que mostrar en el catálogo
		ArrayList <Articulo> articulos = ope.recogerArticulos(0);
		request.setAttribute("Articulos", articulos);
		
		//Cargamos la vista
		request.getRequestDispatcher("Vistas/lista.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
