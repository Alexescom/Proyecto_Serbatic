package com.controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.pojos.Articulo;
import dao.pojos.Detalle;
import dao.OperationsDB;

/**
 * Servlet implementation class CarritoServlet
 */
public class CarritoServlet extends HttpServlet {
	
	//Variables
	private static final long serialVersionUID = 1L;
	private static ArrayList <Detalle> carro = new ArrayList<Detalle>();
    private static ArrayList <Detalle> car = new ArrayList<Detalle>();
    private static OperationsDB ope =  new OperationsDB();  
	private static boolean bandera;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarritoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Cargamos variables necesarias
		bandera = false;
		carro = (ArrayList<Detalle>)request.getSession().getAttribute("Carro");
		String operacion = request.getParameter("operacion");
		int acumulador = 0;
		
		//Filtrado de operaciones
		if (operacion.equals("mas")) { //Añadir artículo desde lprincipal
			int id = Integer.parseInt(request.getParameter("id"));
			float precio = Float.parseFloat(request.getParameter("precio"));
			String nombre = request.getParameter("nombre");
			System.out.println("----- Carro ----");
			if (carro != null) {
				for ( Detalle a : carro) {
					
					System.out.println(a.getId());
					if (a.getId_producto() == id) {
						int cant = a.getUnidades();
						cant++;
						a.setUnidades(cant);
						a.setTotal(cant*precio);
						bandera = true;
	//					continue;
					}
					
					acumulador += a.getUnidades();
				}
			}
			
			if(bandera == false) {
				Detalle a = new Detalle();
				a.setId_producto(id);
				a.setPrecio_unidad(precio);
				//if (nombre != null) {
					a.setNombre(nombre);
				//}
				a.setTotal(precio);
				a.setUnidades(1);
				acumulador += a.getUnidades();
				carro.add(a);
				System.out.println(a.getId());
				request.getSession().setAttribute("Carro", carro);
			}
			
			//Cargamos los artículos que se tienen que mostrar en el catálogo
			request.setAttribute("Articulos", ope.recogerArticulos(0));
			request.getSession().setAttribute("Acumulador", acumulador);
			request.getRequestDispatcher("Vistas/lista.jsp").forward(request, response); //Interno
			
		}else if (operacion.equals("-")){//Decrementar en la vista de carro
			int id = Integer.parseInt(request.getParameter("id"));
			int i = 0;
			int num = 0;
			boolean eliminar = false;
			
			for (Detalle a : carro) {
				if (a.getId_producto() == id) {
					int cant = a.getUnidades();
					cant--;
					//Comprobamos que la cantidad no sea 0
					if (cant == 0) {
						
						eliminar = true;
						num = i;
						continue;
						
					}else {//Cantidad mayor que 0
						a.setUnidades(cant);
						a.setTotal(cant*a.getPrecio_unidad());
						bandera = true;
						continue;
					}
				}
				i++;
			}
			
			if (eliminar == true) {
				
				carro.remove(num);
				request.getSession().setAttribute("Carro", carro);
			}
			
			request.getRequestDispatcher("Vistas/Usuario/Carro.jsp").forward(request, response); //Interno
			
		
		}else if (operacion.equals("masC")){ //Incrementar en la vista de carro
			
			int id = Integer.parseInt(request.getParameter("id"));
			float precio = Float.parseFloat(request.getParameter("precio"));
			String nombre = request.getParameter("nombre");
			System.out.println("----- Carro ----");
			if (carro != null) {
				for ( Detalle a : carro) {
					System.out.println(a.getId_producto());
					System.out.println(id);
					if (a.getId_producto() == id) {
						int cant = a.getUnidades();
						cant++;
						a.setUnidades(cant);
						a.setTotal(cant*precio);
						bandera = true;
	//					continue;
					}
				}
			}
			
			if(bandera == false) {
				Detalle a = new Detalle();
				a.setId_producto(id);
				a.setPrecio_unidad(precio);
				//if (nombre != null) {
					a.setNombre(nombre);
				//}
				
				a.setUnidades(1);
				a.setTotal(precio);
				carro.add(a);
				request.getSession().setAttribute("Carro", carro);
			}
		

			request.getRequestDispatcher("Vistas/Usuario/Carro.jsp").forward(request, response); //Interno
		
		
		}else if (operacion.equals("mostrar")) {

			request.getRequestDispatcher("Vistas/Usuario/Carro.jsp").forward(request, response); //Interno
			
		}

	}//Fin doGet
	
	
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
