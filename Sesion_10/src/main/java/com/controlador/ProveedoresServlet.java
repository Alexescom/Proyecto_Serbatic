package com.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.DatosUsuario;
import Service.UsuariosService;
import dao.OperationsProveedoresDB;
import dao.pojos.Proveedor;
import dao.pojos.Usuario;

/**
 * Servlet implementation class ProveedoresServlet
 */
public class ProveedoresServlet extends HttpServlet {
	
	//Variables
	private static final long serialVersionUID = 1L;



    public ProveedoresServlet() {

    }



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("Operacion").equals("Index")) {
			
			
			request.setAttribute("Proveedores", OperationsProveedoresDB.recogerProveedores(0));
			request.getRequestDispatcher("Vistas/Empleado/Proveedores/ProveedoresIndex.jsp").forward(request, response); 
			
		}else if (request.getParameter("Operacion").equals("Ver")) { //Ver usuario a modificar
			
			Proveedor proveedor = OperationsProveedoresDB.recogerProveedores(Integer.parseInt(request.getParameter("Id"))).get(0);
			request.setAttribute("Proveedor", proveedor);
			request.getRequestDispatcher("Vistas/Empleado/Proveedores/ProveedoresVista.jsp").forward(request, response); 
			
		}else if (request.getParameter("Operacion").equals("Modificar")) { //modificar datos de un usuario
			
			
			//Rellenamos con los datos introducidos
			 Proveedor proveedor = new Proveedor();
			 proveedor.setId(Integer.parseInt(request.getParameter("Id")));
			 proveedor.setCif(request.getParameter("Cif"));
			 proveedor.setNombre(request.getParameter("Nombre"));
			 proveedor.setDireccion(request.getParameter("Direccion"));
			 proveedor.setProvincia(request.getParameter("Provincia"));
			 proveedor.setLocalidad(request.getParameter("Localidad"));
			 proveedor.setTelefono(request.getParameter("Telefono"));
			 proveedor.setEmail(request.getParameter("Email"));
			 
			 //Modificamos el proveedor en base de datos
			 OperationsProveedoresDB.modificarProveedor(proveedor);
			 
			 //Recogemos datos del proveedor de nuevo
			 proveedor = OperationsProveedoresDB.recogerProveedores(Integer.parseInt(request.getParameter("Id"))).get(0);
			 request.setAttribute("Proveedor", proveedor);
			 
			 //Redirigimos
			 request.getRequestDispatcher("Vistas/Empleado/Proveedores/ProveedoresVista.jsp").forward(request, response); 
			
			
		}else if (request.getParameter("Operacion").equals("Insertar")){ //insertar nuevo uproveedor
			
			
			//Rellenamos con los datos introducidos
			 Proveedor proveedor = new Proveedor();
			 proveedor.setCif(request.getParameter("Cif"));
			 proveedor.setNombre(request.getParameter("Nombre"));
			 proveedor.setDireccion(request.getParameter("Direccion"));
			 proveedor.setProvincia(request.getParameter("Provincia"));
			 proveedor.setLocalidad(request.getParameter("Localidad"));
			 proveedor.setTelefono(request.getParameter("Telefono"));
			 proveedor.setEmail(request.getParameter("Email"));
			 
			 //Insertamos al usuario en la base de datos
			 OperationsProveedoresDB.insertarProveedor(proveedor);
			 
			 //Redirigimos
			 request.setAttribute("Proveedores",  OperationsProveedoresDB.recogerProveedores(0));
			 request.getRequestDispatcher("Vistas/Empleado/Proveedores/ProveedoresIndex.jsp").forward(request, response); 
			
		} else { //Baja lógica
			
			 //Insertamos al usuario en la base de datos
			 OperationsProveedoresDB.modificarProveedorBaja(Integer.parseInt(request.getParameter("Id")));
			 
			 //Redirigimos
			 request.setAttribute("Proveedores",  OperationsProveedoresDB.recogerProveedores(0));
			 request.getRequestDispatcher("Vistas/Empleado/Proveedores/ProveedoresIndex.jsp").forward(request, response); 
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
