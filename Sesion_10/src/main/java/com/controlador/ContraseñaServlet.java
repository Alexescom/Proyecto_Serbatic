package com.controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.DatosUsuario;
import Service.RecuperarService;
import dao.OperationsDB;
import dao.pojos.Articulo;
import dao.pojos.Usuario;

/**
 * Servlet implementation class ContraseñaServlet
 */
public class ContraseñaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static OperationsDB ope =  new OperationsDB();

    public ContraseñaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getParameter("Operacion").equals("Ver")) { 
			
			 //Redirigimos
			 request.getRequestDispatcher("Vistas/Usuario/Contraseña.jsp").forward(request, response);
			
		}else if (request.getParameter("Operacion").equals("Modificar")) {
			
			//Rellenamos con los datos introducidos
			 Usuario user = new Usuario();
			 user.setId((int)request.getSession().getAttribute("Id"));
			 user.setClave(request.getParameter("Contraseña"));
			 
			 //Modificamos en base de datos
			 DatosUsuario.modificarContraseña(user);
			 
			 //Recogemos datos del usuario de nuevo
			 Usuario usuario = DatosUsuario.recogerDatosUsuario((int)request.getSession().getAttribute("Id"));
			 
			 //Ramificamos de forma diferente
			 if (usuario.getNombre().equals("admin")) {
				 
				//Cargamos los artículos que se tienen que mostrar en el catálogo
				ArrayList <Articulo> articulos = ope.recogerArticulos(0);
				request.setAttribute("Articulos", articulos);
				request.getRequestDispatcher("Vistas/Administrador/Productos/ProductosIndex.jsp").forward(request, response);
				 
			 }else {
				 
				 request.setAttribute("Usuario", usuario);
				 
				 //Redirigimos
				 request.getRequestDispatcher("Vistas/Usuario/Perfil.jsp").forward(request, response);
				 
			 }

			
		}else if (request.getParameter("Operacion").equals("Recuperar")) {
			
			String usuario = (request.getParameter("UsuarioRecuperar"));
			System.out.println(usuario);
			if(!RecuperarService.recuperarContraseña(usuario)) {

				request.setAttribute("mensaje", "Usuario no encontrado en el sistema");
				request.getRequestDispatcher("Vistas/Autenticacion/RecuperarContraseña.jsp").forward(request, response);
				
			} else {
				
				request.setAttribute("mensaje", "");
				request.getRequestDispatcher("Vistas/Autenticacion/Login.jsp").forward(request, response);
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
