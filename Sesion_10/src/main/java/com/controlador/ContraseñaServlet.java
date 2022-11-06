package com.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.DatosUsuario;
import dao.pojos.Usuario;

/**
 * Servlet implementation class ContraseñaServlet
 */
public class ContraseñaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
			 request.setAttribute("Usuario", usuario);
			 
			 //Redirigimos
			 request.getRequestDispatcher("Vistas/Usuario/Perfil.jsp").forward(request, response);
			
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
