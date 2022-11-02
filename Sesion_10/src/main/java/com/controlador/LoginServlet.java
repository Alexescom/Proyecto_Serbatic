package com.controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.Comprobador;
import dao.OperationsDB;
import dao.pojos.Articulo;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	
	//Variables
	private static final long serialVersionUID = 1L;
	private static Comprobador comp = new Comprobador();
    private static OperationsDB ope =  new OperationsDB();
    
    
    //Métodos  
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String usuario;
		String password;
		int id;

		usuario = request.getParameter("usuario");
		password = request.getParameter("password");

			
		if (!comp.comprobarNull(usuario, password)) {
				
				System.out.println("error1");
				request.setAttribute("mensaje", "Usuario o contraseña en blanco");
				request.getRequestDispatcher("Vistas/Autenticacion/Login.jsp").forward(request, response);
				
		}else {
				
				if(!ope.autenticar(usuario, password)) {
			
				System.out.println("error2");
				request.setAttribute("mensaje", "Usuario o contraseña incorrecto");
				request.getRequestDispatcher("Vistas/Autenticacion/Login.jsp").forward(request, response);
				
				}else { //Login correcto
					
					if (ope.idRol == 1) { //Usuario cliente
						
						request.setAttribute("mensaje", "");
						request.setAttribute("Articulos", ope.recogerArticulos(0));
						request.getSession().setAttribute("usuario", usuario);
						request.getSession().setAttribute("Email", ope.emailUsuario);
						request.getSession().setAttribute("Id", ope.idUsuario);
						request.getRequestDispatcher("Vistas/lista.jsp").forward(request, response); //Interno						
						
					}else if (ope.idRol == 3) { //Usuario empleado

						request.setAttribute("mensaje", "");
						request.getSession().setAttribute("usuario", usuario);
						request.getSession().setAttribute("Email", ope.emailUsuario);
						request.getSession().setAttribute("Id", ope.idUsuario);
						//Cargamos los artículos que se tienen que mostrar en el catálogo
						ArrayList <Articulo> articulos = ope.recogerArticulos(0);
						request.setAttribute("Articulos", articulos);
						request.getRequestDispatcher("Vistas/Empleado/Productos/ProductosIndex.jsp").forward(request, response); //Interno	
						
					}else { //Usuario administrador
						
						request.setAttribute("mensaje", "");
						request.getSession().setAttribute("usuario", usuario);
						request.getSession().setAttribute("Email", ope.emailUsuario);
						request.getSession().setAttribute("Id", ope.idUsuario);
						//Cargamos los artículos que se tienen que mostrar en el catálogo
						ArrayList <Articulo> articulos = ope.recogerArticulos(0);
						request.setAttribute("Articulos", articulos);
						request.getRequestDispatcher("Vistas/Administrador/Productos/ProductosIndex.jsp").forward(request, response);
						
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
