package com.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OperationsDB;
import dao.OperationsValoracionDB;

/**
 * Servlet implementation class ProductoServlet
 */
public class ProductoServlet extends HttpServlet {
	
	//Variables
    private static OperationsDB ope =  new OperationsDB(); 
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//Recogemos id del prodcuto
		int id =Integer.parseInt(request.getParameter("Id"));
		
		//Operación a base de datos
		request.setAttribute("Articulo", ope.recogerArticulos(id)); //Recoger articulo
		request.setAttribute("Valoraciones", OperationsValoracionDB.recogerValoraciones(id)); //Recogemos valoraciones
		
		//Cargamos la vista
		request.getRequestDispatcher("Vistas/Productos/Producto.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
