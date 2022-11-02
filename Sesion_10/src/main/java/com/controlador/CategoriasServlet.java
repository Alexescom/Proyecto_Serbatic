package com.controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.CategoriasService;
import Service.Ordenacion;
import dao.OperationsDB;
import dao.pojos.Articulo;
import dao.pojos.Categoria;

/**
 * Servlet implementation class CategoriasServlet
 */
public class CategoriasServlet extends HttpServlet {
	
	//Variables
	private static final long serialVersionUID = 1L;
    private static OperationsDB ope =  new OperationsDB();
    private static Ordenacion orden = new Ordenacion(); 

	//Métodos
    public CategoriasServlet() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//FILTRAMOS
		if (request.getParameter("Operacion").equals("Filtrar")) {
			
			int id =Integer.parseInt(request.getParameter("Categoria"));

			//Cargamos los artículos que se tienen que mostrar en el catálogo
			ArrayList <Articulo> articulos = new ArrayList<Articulo>();
			
			//FILTRAMOS CATEGORIA
			if (id == 0) {
				
				articulos = ope.recogerArticulos(0);
				
			}else {
				
				articulos= ope.recogerArticulosCategoria(id);
				
			}
			
			//ORDENAMOS SI ES NECESARIO
			if ( request.getParameter("Precio") != null) {
				
				if (request.getParameter("Precio").equals("1")) {
					try {
						orden.ordenarListaMarcas(articulos, "precio", 1);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else if (request.getParameter("Precio").equals("2")) {
					try {
						orden.ordenarListaMarcas(articulos, "precio", 0);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
			request.setAttribute("Articulos", articulos);
			
			//Cargamos la vista
			request.getRequestDispatcher("Vistas/lista.jsp").forward(request, response);
			
			
		//BUSCADOR POR NOMBRE	
		} else if (request.getParameter("Operacion").equals("Buscar")) {
			
			//Recogemos el nombre a buscar
			String nombre = request.getParameter("Buscador");
			
			//Cargamos los artículos que se tienen que mostrar en el catálogo
			request.setAttribute("Articulos", ope.recogerArticulosBuscador(nombre));
			
			//Cargamos la vista
			request.getRequestDispatcher("Vistas/lista.jsp").forward(request, response);
		
		//INSERTAR CATEGORÍAS
		} else if (request.getParameter("Operacion").equals("Ver")) {
			
			//Cargamos los artículos que se tienen que mostrar en el catálogo
			request.setAttribute("Categorias", CategoriasService.getCategorias());
			
			//Cargamos la vista
			request.getRequestDispatcher("Vistas/Empleado/Categorias/CategoriasIndex.jsp").forward(request, response);
			
		} else if (request.getParameter("Operacion").equals("Insertar")) {
			
			//Rellenamos la categoría
			Categoria categoria = new Categoria();
			categoria.setNombre(request.getParameter("Nombre"));
			categoria.setDescripcion(request.getParameter("Descripcion"));
			
			//Insertamos categoría
			CategoriasService.insertarCategoria(categoria);			
			
			
			
			//Cargamos los artículos que se tienen que mostrar en el catálogo
			request.setAttribute("Categorias", CategoriasService.getCategorias());
			
			//Cargamos la vista
			request.getRequestDispatcher("Vistas/Empleado/Categorias/CategoriasIndex.jsp").forward(request, response);
			
		}
			


	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
