package com.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.PropertyConfigurator;

import Service.DatosUsuario;
import Service.UsuariosService;
import dao.pojos.Usuario;

/**
 * Servlet implementation class ClientesServlet
 */
public class UsuariosServlet extends HttpServlet {
	
	//variables
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(UsuariosServlet.class);
	
    //Métodos
    public UsuariosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PropertyConfigurator.configure("D:\\Ale\\Formaciones\\Sesion_10\\src\\main\\java\\log4j.properties");
		
		//FUNCIONES EMPLEADO
		if (request.getParameter("Entidad").equals("Empleado")) { //Recoger usuarios empleado
			
			log.info("Acción realizada por el empleado");
			
			if (request.getParameter("Operacion").equals("Index")) {
				
				log.info("Recogemos todos los usuarios del sistema con el rol: 'Cliente'");
				request.setAttribute("Clientes", UsuariosService.recogerUsuarios(1));
				request.getRequestDispatcher("Vistas/Empleado/Clientes/ClientesIndex.jsp").forward(request, response); 
				
			}else if (request.getParameter("Operacion").equals("Ver")) { //Ver usuario a modificar
				
				log.info("Visualización de los datos del usuario a modificar con el rol: 'Cliente';  id: '"+ request.getParameter("Id") +"'");
				Usuario user = DatosUsuario.recogerDatosUsuario(Integer.parseInt(request.getParameter("Id")));
				request.setAttribute("Usuario", user);
				request.getRequestDispatcher("Vistas/Empleado/Clientes/ClientesVIsta.jsp").forward(request, response); 
				
			}else if (request.getParameter("Operacion").equals("Modificar")) { //modificar datos de un usuario
				
				log.info("Modificación de los datos del usuario con el rol: 'Cliente';  id: '"+ request.getParameter("Id") +"'");
				
				//Rellenamos con los datos introducidos
				 Usuario user = new Usuario();
				 user.setId(Integer.parseInt(request.getParameter("Id")));
				 user.setClave(request.getParameter("Password"));
				 user.setDni(request.getParameter("Dni"));
				 user.setNombre(request.getParameter("Nombre"));
				 user.setApellido1(request.getParameter("Apellido1"));
				 user.setApellido2(request.getParameter("Apellido2"));
				 user.setDireccion(request.getParameter("Direccion"));
				 user.setProvincia(request.getParameter("Provincia"));
				 user.setLocalidad(request.getParameter("Localidad"));
				 user.setTelefono(request.getParameter("Telefono"));

				 user.setEmail(request.getParameter("Email"));
				 user.setImagen("");
				 //Modificamos el usuario en base de datos
				 DatosUsuario.modificarUsuario(user);
				 
				 //Recogemos datos del usuario de nuevo
				 user = DatosUsuario.recogerDatosUsuario(Integer.parseInt(request.getParameter("Id")));
				 request.setAttribute("Usuario", user);
				 
				 //Redirigimos
				 request.getRequestDispatcher("Vistas/Empleado/Clientes/ClientesVIsta.jsp").forward(request, response); 
				
				
			}else { //insertar nuevo usuario
				
				log.info("Inserción de un nuevo usuario en el sistema");
				
				//Rellenamos con los datos introducidos
				 Usuario user = new Usuario();				
				 user.setClave(request.getParameter("Password"));
				 user.setDni(request.getParameter("Dni"));
				 user.setNombre(request.getParameter("Nombre"));
				 user.setApellido1(request.getParameter("Apellido1"));
				 user.setApellido2(request.getParameter("Apellido2"));
				 user.setDireccion(request.getParameter("Direccion"));
				 user.setProvincia(request.getParameter("Provincia"));
				 user.setLocalidad(request.getParameter("Localidad"));
				 user.setTelefono(request.getParameter("Telefono"));
				 user.setEmail(request.getParameter("Email"));
				 user.setId_rol(1);
				 user.setImagen("");
				 //Insertamos al usuario en la base de datos
				 DatosUsuario.insertarUsuario(user);
				 
				 //Redirigimos
				 request.setAttribute("Clientes", UsuariosService.recogerUsuarios(1));
				 request.getRequestDispatcher("Vistas/Empleado/Clientes/ClientesIndex.jsp").forward(request, response);
				
			}
		
		//FUNCIONES DEL ADMINISTRADOR
		}else if (request.getParameter("Entidad").equals("Admin")) { //Recoger usuarios administrador
			
			log.info("Acción realizada por el administrador");
			
			//CLIENTES
			if (request.getParameter("Operacion").equals("Index")) {
				
				log.info("Recogemos todos los usuarios del sistema con el rol: 'Cliente'");
				request.setAttribute("Clientes", UsuariosService.recogerUsuarios(1));
				request.getRequestDispatcher("Vistas/Administrador/Clientes/ClientesIndex.jsp").forward(request, response); 
				
			}else if (request.getParameter("Operacion").equals("Eliminar")) { //Ver usuario a modificar
				
				
				//Modificamos el usuario en base de datos
				DatosUsuario.modificarUsuarioBaja(Integer.parseInt(request.getParameter("Id")));
				
				//Redireccionamos
				request.setAttribute("Clientes", UsuariosService.recogerUsuarios(1));
				request.getRequestDispatcher("Vistas/Administrador/Clientes/ClientesIndex.jsp").forward(request, response); 
			
			//EMPLEADOS
			}else if (request.getParameter("Operacion").equals("IndexEmpleados")) {
				
				log.info("Recogemos todos los usuarios del sistema con el rol: 'Empleado'");
				request.setAttribute("Clientes", UsuariosService.recogerUsuarios(3));
				request.getRequestDispatcher("Vistas/Administrador/Empleados/EmpleadosIndex.jsp").forward(request, response); 
				
			}else if (request.getParameter("Operacion").equals("VerEmpleado")) {
				
				log.info("Visualización de los datos del usuario a modificar con el rol: 'Empleado';  id: '"+ request.getParameter("Id") +"'");
				Usuario user = DatosUsuario.recogerDatosUsuario(Integer.parseInt(request.getParameter("Id")));
				request.setAttribute("Usuario", user);
				request.getRequestDispatcher("Vistas/Administrador/Empleados/EmpleadosVista.jsp").forward(request, response); 				
				
			}else if (request.getParameter("Operacion").equals("Modificar")) {
				
				log.info("Modificación de los datos del usuario con el rol: 'Empleado';  id: '"+ request.getParameter("Id") +"'");
				
				//Rellenamos con los datos introducidos
				 Usuario user = new Usuario();
				 user.setId(Integer.parseInt(request.getParameter("Id")));
				 user.setClave(request.getParameter("Password"));
				 user.setDni(request.getParameter("Dni"));
				 user.setNombre(request.getParameter("Nombre"));
				 user.setApellido1(request.getParameter("Apellido1"));
				 user.setApellido2(request.getParameter("Apellido2"));
				 user.setDireccion(request.getParameter("Direccion"));
				 user.setProvincia(request.getParameter("Provincia"));
				 user.setLocalidad(request.getParameter("Localidad"));
				 user.setTelefono(request.getParameter("Telefono"));
				 user.setImagen("");
				 user.setEmail(request.getParameter("Email"));
				
				 //Modificamos el usuario en base de datos
				 DatosUsuario.modificarUsuario(user);
				 
				 //Recogemos datos del usuario de nuevo
				 user = DatosUsuario.recogerDatosUsuario(Integer.parseInt(request.getParameter("Id")));
				 request.setAttribute("Usuario", user);
				 
				 //Redirigimos
				 request.getRequestDispatcher("Vistas/Administrador/Empleados/EmpleadosVista.jsp").forward(request, response);
				 
			}else if (request.getParameter("Operacion").equals("Insertar")) { //insertar nuevo usuario empleado
				
				log.info("Inserción de un nuevo usuario empleado en el sistema");
				
				//Rellenamos con los datos introducidos
				 Usuario user = new Usuario();				
				 user.setClave(request.getParameter("Password"));
				 user.setDni(request.getParameter("Dni"));
				 user.setNombre(request.getParameter("Nombre"));
				 user.setApellido1(request.getParameter("Apellido1"));
				 user.setApellido2(request.getParameter("Apellido2"));
				 user.setDireccion(request.getParameter("Direccion"));
				 user.setProvincia(request.getParameter("Provincia"));
				 user.setLocalidad(request.getParameter("Localidad"));
				 user.setTelefono(request.getParameter("Telefono"));
				 user.setEmail(request.getParameter("Email"));
				 user.setId_rol(3);
				 user.setImagen("");
				 //Insertamos al usuario en la base de datos
				 DatosUsuario.insertarUsuario(user);
				 
				 //Redirigimos
				 request.setAttribute("Clientes", UsuariosService.recogerUsuarios(3));
				 request.getRequestDispatcher("Vistas/Administrador/Empleados/EmpleadosIndex.jsp").forward(request, response);
				
			} else { //Baja de empleado
				
				//Modificamos el usuario en base de datos
				DatosUsuario.modificarUsuarioBaja(Integer.parseInt(request.getParameter("Id")));
				
				//Redireccionamos
				request.setAttribute("Clientes", UsuariosService.recogerUsuarios(3));
				request.getRequestDispatcher("Vistas/Administrador/Empleados/EmpleadosIndex.jsp").forward(request, response); 
				
				
			}
			
		//FUNCIONES DEL SUPER-ADMINISTRADOR
		}else if (request.getParameter("Entidad").equals("SuperAdmin")) { //Recoger usuarios administrador
			
			if (request.getParameter("Operacion").equals("IndexAdministradores")) {
				
				log.info("Recogemos todos los usuarios del sistema con el rol: 'Administrador'");
				request.setAttribute("Clientes", UsuariosService.recogerUsuarios(2));
				request.getRequestDispatcher("Vistas/Administrador/Administradores/AdministradoresIndex.jsp").forward(request, response); 
				
			}else if (request.getParameter("Operacion").equals("VerAdministrador")) {
				
				log.info("Visualización de los datos del usuario a modificar con el rol: 'Administrador';  id: '"+ request.getParameter("Id") +"'");
				Usuario user = DatosUsuario.recogerDatosUsuario(Integer.parseInt(request.getParameter("Id")));
				request.setAttribute("Usuario", user);
				request.getRequestDispatcher("Vistas/Administrador/Administradores/AdministradoresVista.jsp").forward(request, response); 				
				
			}else if (request.getParameter("Operacion").equals("Modificar")) {
				
				log.info("Modificación de los datos del usuario con el rol: 'Administrador';  id: '"+ request.getParameter("Id") +"'");
				
				//Rellenamos con los datos introducidos
				 Usuario user = new Usuario();
				 user.setId(Integer.parseInt(request.getParameter("Id")));
				 user.setClave(request.getParameter("Password"));
				 user.setDni(request.getParameter("Dni"));
				 user.setNombre(request.getParameter("Nombre"));
				 user.setApellido1(request.getParameter("Apellido1"));
				 user.setApellido2(request.getParameter("Apellido2"));
				 user.setDireccion(request.getParameter("Direccion"));
				 user.setProvincia(request.getParameter("Provincia"));
				 user.setLocalidad(request.getParameter("Localidad"));
				 user.setTelefono(request.getParameter("Telefono"));
				 user.setImagen("");
				 user.setEmail(request.getParameter("Email"));
				
				 //Modificamos el usuario en base de datos
				 DatosUsuario.modificarUsuario(user);
				 
				 //Recogemos datos del usuario de nuevo
				 user = DatosUsuario.recogerDatosUsuario(Integer.parseInt(request.getParameter("Id")));
				 request.setAttribute("Usuario", user);
				 
				 //Redirigimos
				 request.getRequestDispatcher("Vistas/Administrador/Administradores/AdministradoresVista.jsp").forward(request, response);
				 
			}else if (request.getParameter("Operacion").equals("Insertar")) { //insertar nuevo usuario empleado
				
				log.info("Inserción de un nuevo usuario empleado en el sistema");
				
				//Rellenamos con los datos introducidos
				 Usuario user = new Usuario();				
				 user.setClave(request.getParameter("Password"));
				 user.setDni(request.getParameter("Dni"));
				 user.setNombre(request.getParameter("Nombre"));
				 user.setApellido1(request.getParameter("Apellido1"));
				 user.setApellido2(request.getParameter("Apellido2"));
				 user.setDireccion(request.getParameter("Direccion"));
				 user.setProvincia(request.getParameter("Provincia"));
				 user.setLocalidad(request.getParameter("Localidad"));
				 user.setTelefono(request.getParameter("Telefono"));
				 user.setEmail(request.getParameter("Email"));
				 user.setId_rol(2);
				 user.setImagen("");
				 //Insertamos al usuario en la base de datos
				 DatosUsuario.insertarUsuario(user);
				 
				 //Redirigimos
				 request.setAttribute("Clientes", UsuariosService.recogerUsuarios(2));
				 request.getRequestDispatcher("Vistas/Administrador/Administradores/AdministradoresIndex.jsp").forward(request, response);
				
			} else { //Baja de administrador
				
				//Modificamos el usuario en base de datos
				DatosUsuario.modificarUsuarioBaja(Integer.parseInt(request.getParameter("Id")));
				
				//Redireccionamos
				request.setAttribute("Clientes", UsuariosService.recogerUsuarios(2));
				request.getRequestDispatcher("Vistas/Administrador/Administradores/AdministradoresIndex.jsp").forward(request, response); 
				
				
			}
				
				
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
