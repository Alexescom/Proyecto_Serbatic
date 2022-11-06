package com.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.DatosUsuario;
import Service.ExportarService;
import Service.ProductosService;
import Service.UsuariosService;
import dao.OperationsDB;
import dao.pojos.Articulo;
import dao.pojos.Usuario;

/**
 * Servlet implementation class ProductosServlet
 */
public class ProductosServlet extends HttpServlet {
	
	//Variables
	private static ProductosService service = new ProductosService();
    private static OperationsDB ope =  new OperationsDB(); 
	private static final long serialVersionUID = 1L;
       

    public ProductosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getParameter("Entidad").equals("Empleado")) { //Recoger usuarios empleado
			
			if (request.getParameter("Operacion").equals("Index")) { //Ver lista de productos
				
				//Cargamos los artículos que se tienen que mostrar en el catálogo
				ArrayList <Articulo> articulos = ope.recogerArticulos(0);
				request.setAttribute("Articulos", articulos);
				request.getRequestDispatcher("Vistas/Empleado/Productos/ProductosIndex.jsp").forward(request, response);
				
			}else if (request.getParameter("Operacion").equals("Ver")) { //Ver producto a modificar
				
				ArrayList<Articulo> artic = ope.recogerArticulos(Integer.parseInt(request.getParameter("Id")));
				Articulo articulo = artic.get(0);
				request.setAttribute("Articulo", articulo);
				request.getRequestDispatcher("Vistas/Empleado/Productos/ProductosVista.jsp").forward(request, response); 
				
			}else if (request.getParameter("Operacion").equals("Modificar")) { //modificar datos de unproducto
				
				//Rellenamos con los datos introducidos
				 Articulo articulo = new Articulo();
				 articulo.setId(Integer.parseInt(request.getParameter("Id")));
				 articulo.setId_categoria(Integer.parseInt(request.getParameter("Id_categoria")));
				 articulo.setNombre(request.getParameter("Nombre"));
				 articulo.setDescripcion(request.getParameter("Descripcion"));
				 articulo.setPrecio(Float.parseFloat(request.getParameter("Precio")));
				 articulo.setStock(Integer.parseInt(request.getParameter("Stock")));
				 articulo.setImpuesto(Float.parseFloat(request.getParameter("Impuesto")));
				
				 
				 //Modificamos el producto en base de datos
				 ProductosService.modificarProducto(articulo);
				 
				 ArrayList<Articulo> artic = ope.recogerArticulos(Integer.parseInt(request.getParameter("Id")));
				 articulo = artic.get(0);
				 request.setAttribute("Articulo", articulo);
				 request.getRequestDispatcher("Vistas/Empleado/Productos/ProductosVista.jsp").forward(request, response); 
				
				
			}else if (request.getParameter("Operacion").equals("Insertar")) { //insertar nuevo producto
				
				//Rellenamos con los datos introducidos
				 Articulo articulo = new Articulo();
				 articulo.setId_categoria(Integer.parseInt(request.getParameter("Id_categoria")));
				 articulo.setNombre(request.getParameter("Nombre"));
				 articulo.setDescripcion(request.getParameter("Descripcion"));
				 articulo.setPrecio(Float.parseFloat(request.getParameter("Precio")));
				 articulo.setStock(Integer.parseInt(request.getParameter("Stock")));
				 articulo.setImpuesto(Float.parseFloat(request.getParameter("Impuesto")));
				 
				 //Insertamos el producto en la base de datos
				 ProductosService.insertarProducto(articulo);
				 
				 //Redirigimos 
				ArrayList <Articulo> articulos = ope.recogerArticulos(0);
				request.setAttribute("Articulos", articulos);
				request.getRequestDispatcher("Vistas/Empleado/Productos/ProductosIndex.jsp").forward(request, response);
				
			} else if (request.getParameter("Operacion").equals("Exportar")) {
				
				//Exportamos los articulos
				ExportarService.exportarProductos(ope.recogerArticulos(0));
				
				//Redirigimos 
				//Cargamos los artículos que se tienen que mostrar en el catálogo
				ArrayList <Articulo> articulos = ope.recogerArticulos(0);
				request.setAttribute("Articulos", articulos);
				request.getRequestDispatcher("Vistas/Empleado/Productos/ProductosIndex.jsp").forward(request, response);
				
			}
			
		}else if (request.getParameter("Entidad").equals("Admin")) { //Recoger usuarios administrador
			
			if (request.getParameter("Operacion").equals("Index")) { //Ver lista de productos
				
				//Cargamos los artículos que se tienen que mostrar en el catálogo
				ArrayList <Articulo> articulos = ope.recogerArticulos(0);
				request.setAttribute("Articulos", articulos);
				request.getRequestDispatcher("Vistas/Administrador/Productos/ProductosIndex.jsp").forward(request, response);
				
			}else if (request.getParameter("Operacion").equals("Eliminar")) { //Eliminar producto
				
				//Modificamos el producto en base de datos
				ProductosService.modificarProductoBaja(Integer.parseInt(request.getParameter("Id")));
				 
				//Cargamos los artículos que se tienen que mostrar en el catálogo
				ArrayList <Articulo> articulos = ope.recogerArticulos(0);
				request.setAttribute("Articulos", articulos);
				request.getRequestDispatcher("Vistas/Administrador/Productos/ProductosIndex.jsp").forward(request, response);
				
			}else if (request.getParameter("Operacion").equals("Importar")) { //Importar productos
				
				//Importamos los productos
				ExportarService.importarProductos();
				
				//Cargamos los artículos que se tienen que mostrar en el catálogo
				ArrayList <Articulo> articulos = ope.recogerArticulos(0);
				request.setAttribute("Articulos", articulos);
				request.getRequestDispatcher("Vistas/Administrador/Productos/ProductosIndex.jsp").forward(request, response);
				
				
			}
			
		}
		
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
