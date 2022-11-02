package com.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OperationsDB;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
	
	//Variables
	private static final long serialVersionUID = 1L;
       

	//Métodos
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Cerramos la sesión
		request.getSession().invalidate();
		
		//Cargamos los artículos que se tienen que mostrar en el catálogo
		OperationsDB ope =  new OperationsDB();
		request.setAttribute("Articulos", ope.recogerArticulos(0));
		
		//Redirigimos
		request.getRequestDispatcher("Vistas/lista.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
