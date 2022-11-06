<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Producto</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/CSS/index.css">
</head>
<body>

	<!--  Cabecera de la página -->
	<jsp:include page="../Estaticos/Header.jsp" />
	
	<!--  Sección central -->
	<div class="md-0  float-left" style="position: absolute ;margin-left: 5px " >
      <br>
      <a href="IndexServlet" style="text-decoration: none; color: black">
      <h5> &#10094 &nbsp Volver atrás</h5>
      </a>
    </div>
    
	<div class="container">
		<br>
		<br>
		<br>
		<div>
			<h2> PRODUCTO </h2>
		</div>
		
		<div class="row row-cols-1 ">
				<div class="d-flex justify-content-between ">
					<%@page import="java.util.ArrayList" %>
					<%@page import="dao.pojos.Articulo" %>
					<%@page import="dao.pojos.Valoracion" %>
					<%@page import="java.text.DecimalFormat" %>

		            <%
		            	ArrayList <Articulo> detalles = (ArrayList<Articulo>)request.getAttribute("Articulo");
		            	ArrayList <Valoracion> valoraciones = (ArrayList<Valoracion>)request.getAttribute("Valoraciones");
		            	DecimalFormat df = new DecimalFormat("###.##");
		                if (detalles != null){
		            		for (Articulo a: detalles){%>
	
		            	<div class="bg-light  p-3 m-5 rounded border border-2" style="margin-top: 25px; boder:1px">
		            			<img class="bd-placeholder-img card-img-top " width="100%" height="600" src="<%= request.getContextPath() %>/Sources/Imagenes/Productos/<%= a.getId() %>.jpg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"></img>
						</div>


		            	<div class="col col-md  p-3 m-5" >
		            		<h1 style="text-align:justify"><%= a.getNombre()%></h1>
		            		<h3 style="text-align:justify">Descripción del producto: <%= a.getDescripcion()%></h2>
							<br><br><br>
						    <div class="d-flex justify-content-between">
						    	<h3>Precio: <%= a.getPrecio()%></h3>
						    
			                   <a href="CarritoServlet?id=<%= a.getId() %>&nombre=<%= a.getNombre() %>&operacion=mas&precio=<%= a.getPrecio() %>">
			                      <button type="button" class="btn btn-warning">Añadir</button>
			                   </a>
			                   
						    </div>		            		
		            	
		            	</div>
		            	<%}%>
		            <%}%>
			</div>
			<hr style="height: 2px">
			<h2> VALORACIONES </h2>
			<div class="row row-cols-1 row-cols-sm-2 row-cols-md-2 g-2">
			
			<br><br>
				<%
                if (valoraciones != null){
            		for (Valoracion v: valoraciones){%>
					<div class="col col-md-5 bg-light  p-2 m-5 rounded border">
						<h2>Usuario: <%= v.getId_usuario() %></h2>
						<h3>Comentario: <%= v.getComentario() %></h3>
						<h6>Valoracion:<% for (int i = 0; i < v.getValoracion(); i++){ %> <span style="color: #ffc107">★ </span><%}%><% for (int i = 0; i < 5 - v.getValoracion(); i++){ %> ★ <%}%></h6>
					
					</div>
				     <%}%>
		        <%}%>
			</div>
			
		</div>
	</div>
	
	
	
	<br><br><br><br><br>
	<!-- Pie de página -->
    <footer class="footer fixed-bottom ">
        <div >
            <h4>2022 © Proyecto Serbatic</h4>
        </div>
    </footer>
	
</body>
</html>