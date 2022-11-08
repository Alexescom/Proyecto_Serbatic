package com.controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.DatosUsuario;
import Service.UsuariosService;
import dao.OperationsDescuentosDB;
import dao.pojos.Descuento;
import dao.pojos.Detalle;
import dao.pojos.Usuario;

/**
 * Servlet implementation class DescuentosServlet
 */
public class DescuentosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


    public DescuentosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList <Detalle> carro = (ArrayList<Detalle>)request.getSession().getAttribute("Carro");
		
		//FUNCIONES CLIENTE	
		if (request.getParameter("Entidad").equals("Cliente")) {
			
			Descuento desc = OperationsDescuentosDB.buscarDescuento(request.getParameter("Codigo"));
			//Buscamos el descuento en la base de datos
			if (desc.getCodigo() != null ) { 
				
				request.setAttribute("mensaje", "");
				
				//Calculamos el precio total
				double precioTotal = 0;
				for ( Detalle a : carro) {
					precioTotal += a.getTotal();
				}
				
				float descuentoTotal =(float) precioTotal * desc.getDescuento();
				
				
				request.setAttribute("Total", precioTotal);
				request.setAttribute("Descuento", descuentoTotal);
				request.getRequestDispatcher("Vistas/Compra/MetodoPago.jsp").forward(request, response);
				
				
				
			} else {
				
				request.setAttribute("mensaje", "Código de descuento no encontrado");
				
				//Calculamos el precio total
				double precioTotal = 0;
				for ( Detalle a : carro) {
					precioTotal += a.getTotal();
				}
				
				request.setAttribute("Total", precioTotal);
				request.getRequestDispatcher("Vistas/Compra/MetodoPago.jsp").forward(request, response);
				
			}
			
		
			
		//FUNCIONES ADMINISTRADOR
		} else {
			
			if (request.getParameter("Operacion").equals("Index")) {
				
				request.setAttribute("Descuentos", OperationsDescuentosDB.recogerDescuentos());
				request.getRequestDispatcher("Vistas/Administrador/Descuentos/DescuentosIndex.jsp").forward(request, response); 
				
			}else if (request.getParameter("Operacion").equals("VerDescuento")) { //Ver descuento a modificar
				
				Descuento descuento = OperationsDescuentosDB.recogerDescuento(Integer.parseInt(request.getParameter("Id")));
				request.setAttribute("Descuento", descuento);
				request.getRequestDispatcher("Vistas/Administrador/Descuentos/DescuentosVista.jsp").forward(request, response); 
				
			}else if (request.getParameter("Operacion").equals("Modificar")) { //Modificar datos de un usuario
				
				
				//Rellenamos los datos
				Descuento descuento = new Descuento();
				descuento.setCodigo(request.getParameter("Codigo"));
				descuento.setDescuento(Float.parseFloat(request.getParameter("Descuento")));
				descuento.setId(Integer.parseInt(request.getParameter("Id")));

				//Modificamos el descuento
				OperationsDescuentosDB.modificarDescuento(descuento);
				 
				//Recogemos datos del usuario de nuevo
				descuento = OperationsDescuentosDB.recogerDescuento(Integer.parseInt(request.getParameter("Id")));
				request.setAttribute("Descuento", descuento);
				request.getRequestDispatcher("Vistas/Administrador/Descuentos/DescuentosVista.jsp").forward(request, response); 
			
			
			
			}else { //Insertamos nuevo descuento
				
				//Rellenamos los datos
				Descuento descuento = new Descuento();
				descuento.setCodigo(request.getParameter("Codigo"));
				descuento.setDescuento(Float.parseFloat(request.getParameter("Descuento")));
				
				//Insertamos el descuento
				OperationsDescuentosDB.insertarDescuento(descuento);
				
				//Redirigimos
				request.setAttribute("Descuentos", OperationsDescuentosDB.recogerDescuentos());
				request.getRequestDispatcher("Vistas/Administrador/Descuentos/DescuentosIndex.jsp").forward(request, response); 
				
			}

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
