package com.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;

import Service.ConfiguracionService;
import Service.DatosUsuario;
import Service.UsuariosService;
import dao.pojos.Configuracion;
import dao.pojos.Usuario;

/**
 * Servlet implementation class ConfiguracionServlet
 */
public class ConfiguracionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

    public ConfiguracionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getParameter("Operacion").equals("Index")) {

			request.setAttribute("Configuracion", ConfiguracionService.getConfiguracion());
			request.getRequestDispatcher("Vistas/Administrador/Configuracion/ConfiguracionIndex.jsp").forward(request, response); 
			
		}else if (request.getParameter("Operacion").equals("Modificar")) { //Ver usuario a modificar
			
			//Modificamos configuracion en base de datos
			ArrayList <Configuracion> config = new ArrayList<Configuracion>();
			Configuracion c = new Configuracion();
			Configuracion c1 = new Configuracion();
			Configuracion c2 = new Configuracion();
			
			//Map<String,String[]> mapaParam = request.getParameterMap();
			
			c.setClave("ajuste");
			c.setValor(request.getParameter("ajuste"));
			config.add(c);
			
			
			c1.setClave("numero_factura");
			c1.setValor(request.getParameter("numero_factura"));
			config.add(c1);
			
			
			c2.setClave("prefijo");
			c2.setValor(request.getParameter("prefijo"));
			config.add(c2);
			
			//Modificamos los valores en base de datos
			ConfiguracionService.setConfiguracion(config);
			
			
			System.out.println("estamos aqui");
			request.setAttribute("Configuracion", ConfiguracionService.getConfiguracion());
			request.getRequestDispatcher("Vistas/Administrador/Configuracion/ConfiguracionIndex.jsp").forward(request, response); 
		
		}
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
