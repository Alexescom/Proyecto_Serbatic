<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Catálogo</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/CSS/index.css">

</head>


 
<body style="height: 100%">
	<!--  Cabecera de la página -->
	<jsp:include page="Estaticos/Header.jsp" />
	
	<div class="container">
	<br>
	<br>
	<div>
		<h2> PRODUCTOS DEL CATÁLOGO </h2>
		<!-- Example single danger button -->
		<div class="btn-group">
			<form style="display: inline" action= "<%= request.getContextPath() %>/CategoriasServlet?Operacion=Filtrar" method= "POST">
				<select class="btn btn-warning" aria-label=".form-select-sm example" style="display: inline; width: 200px; text-align:left" name="Categoria">
				  <option selected value="0">Todas las categorias</option>
				  <option value="2">Placas bases</option>
				  <option value="3">Procesadores</option>
				  <option value="4">Memoria RAM</option>
				  <option value="5">Discos duros</option>		  
				</select>
		 <!--   <button type="button" class="btn btn-warning dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
		    Todas las categorías
		  </button>
		  <ul class="dropdown-menu" style="min-width: 11.8rem">
		    <li><a href="<%= request.getContextPath() %>/CategoriasServlet?Operacion=Filtrar&Categoria=2" class="dropdown-item" href="#">Placas bases</a></li>
		    <li><a href="<%= request.getContextPath() %>/CategoriasServlet?Operacion=Filtrar&Categoria=3" class="dropdown-item" href="#">Procesadores</a></li>
		    <li><a href="<%= request.getContextPath() %>/CategoriasServlet?Operacion=Filtrar&Categoria=4" class="dropdown-item" href="#">Memoria RAM</a></li>
		    <li><a href="<%= request.getContextPath() %>/CategoriasServlet?Operacion=Filtrar&Categoria=5" class="dropdown-item" href="#">Discos duros</a></li>
		  </ul>-->
	
				<select class="form-select form-select-sm" aria-label=".form-select-sm example" style="display: inline; width: 200px" name="Precio">
				  <option selected value="0">Precio de los productos sin filtro</option>
				  <option value="1">Precio de productos ascendente</option>
				  <option value="2">Precio de productos descendente</option>
				</select>
		
		<a  style="text-decoration: none; color: black">
			<button type="submit" class="btn btn-secondary btn-sm">
				<img  src="https://img.icons8.com/ios-glyphs/30/000000/filter.png" height="13px"/>
			</button>
		</a></form></div>
		<a href="CarritoServlet?operacion=mostrar" style="text-decoration: none; color: black">
			 <%
					
			if (request.getSession().getAttribute("Acumulador") != null) {%>
				<h5 style="float: right">: <%= request.getSession().getAttribute("Acumulador") %> </h5>
			<%}%>
			
			
			<img style="float: right" src="https://img.icons8.com/windows/32/000000/add-shopping-cart.png"/>
		</a>
	</div>
	<br>
	<br>
	
	<div class="row row-cols-1 row-cols-sm-4 row-cols-md-4 g-4">
	            <%@page import="java.util.ArrayList" %>
	            <%@page import="dao.pojos.Articulo" %>
	            <%
	            	ArrayList <Articulo> articulos = (ArrayList<Articulo>)request.getAttribute("Articulos");
	                if (articulos != null){
	            		for (Articulo a: articulos){%>
	            		        <div class="col" >
						          <div class="card shadow-sm">
						            <img class="bd-placeholder-img card-img-top p-3"  width="100%" height="300" src="<%= request.getContextPath() %>/Sources/Imagenes/Productos/<%= a.getId() %>.jpg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"></img>
						
						            <div class="card-body">
							          <a href="ProductoServlet?Id=<%= a.getId() %>" style="text-decoration: none; color: black">
							            <h4 style="text-align: left" "><%= a.getNombre() %></h4>
							          </a>
						              <br>
						              <div class="d-flex justify-content-between align-items-center">
							              <h6><%= a.getPrecio()%>$</h6>
							              <h6><% for (int i = 0; i < a.getValoracion(); i++){ %> <span style="color: #ffc107">★ </span><%}%><% for (int i = 0; i < 5 - a.getValoracion(); i++){ %> ★ <%}%></h6>
							          </div>
							          
						              <div class="d-flex justify-content-between align-items-center">
						                <div class="btn-group">
			                            <a href="CarritoServlet?id=<%= a.getId() %>&nombre=<%= a.getNombre() %>&operacion=mas&precio=<%= a.getPrecio() %>">
			                            	<button type="button" class="btn btn-warning">Añadir</button>
			                            </a>
						                </div>
						                <small class="text-muted">Stock: <%= a.getStock() %></small>
						              </div>
						            </div>
						          </div>
						        </div>
	            	<%}%>
	            <%}%>
	</div>
	
	
	
	</div>
	<br><br><br><br><br><br>
	<!-- Pie de página -->
	   <footer class="footer fixed-bottom ">
	        <div >
	            <h4>2022 © Proyecto Serbatic</h4>
	        </div>
	    </footer>
	
	</body>
	</html>