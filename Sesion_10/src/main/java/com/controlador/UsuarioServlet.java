package com.controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.pojos.Pedido;
import dao.pojos.Usuario;
import Service.DatosUsuario;
import Service.PedidosUsuario;

/**
 * Servlet implementation class UsuarioServlet
 */
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//Variables
	private static PedidosUsuario p = new PedidosUsuario();
	private static DatosUsuario u = new DatosUsuario();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Operación ver pedidos
		if (request.getParameter("Operacion").equals("Pedidos")) {
		
			ArrayList <Pedido> pedidos = p.recogerPedidos((int)request.getSession().getAttribute("Id"));
			request.setAttribute("Pedidos", pedidos);
			request.getRequestDispatcher("Vistas/Usuario/Pedidos.jsp").forward(request, response); //Interno
			
		}else if (request.getParameter("Operacion").equals("Perfil")){//Operación ver perfil
			
			Usuario usuario = u.recogerDatosUsuario((int)request.getSession().getAttribute("Id"));
			request.setAttribute("Usuario", usuario);
			request.getRequestDispatcher("Vistas/Usuario/Perfil.jsp").forward(request, response);
			
		}else { //Modificar datos usuario
			
			 //Recogemos datos del usuario de nuevo
			 Usuario usuario = u.recogerDatosUsuario((int)request.getSession().getAttribute("Id"));
			
			//Rellenamos con los datos introducidos
			 Usuario user = new Usuario();
			 user.setId((int)request.getSession().getAttribute("Id"));
			 user.setDni(request.getParameter("Dni"));
			 user.setNombre(request.getParameter("Nombre"));
			 user.setApellido1(request.getParameter("Apellido1"));
			 user.setApellido2(request.getParameter("Apellido2"));
			 user.setDireccion(request.getParameter("Direccion"));
			 user.setProvincia(request.getParameter("Provincia"));
			 user.setLocalidad(request.getParameter("Localidad"));
			 user.setTelefono(request.getParameter("Telefono"));

			 user.setEmail(usuario.getEmail());
			 //Modificamos el usuario en base de datos
			 u.modificarUsuario(user);
			 
			 //Recogemos datos del usuario de nuevo
			 usuario = u.recogerDatosUsuario((int)request.getSession().getAttribute("Id"));
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
