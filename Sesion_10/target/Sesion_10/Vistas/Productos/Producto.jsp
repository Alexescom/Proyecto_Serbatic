<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
		<div>
			<h2> PRODUCTO </h2>
			
		</div>
		<br>
		
		<div class="row row-cols-1 ">
				<div class="row row-cols-1 row-cols-sm-4 row-cols-md-4 g-4">
					<%@page import="java.util.ArrayList" %>
					<%@page import="dao.pojos.Articulo" %>
					<%@page import="java.text.DecimalFormat" %>

		            <%
		            	ArrayList <Articulo> detalles = (ArrayList<Articulo>)request.getAttribute("Articulo");
		            	DecimalFormat df = new DecimalFormat("###.##");
		                if (detalles != null){
		            		for (Articulo a: detalles){%>
	
		            		<div class="bg-light  p-3 m-5 rounded border border-2" style="margin-top: 25px; boder:1px">
		            			<img class="bd-placeholder-img card-img-top " width="100%" height="225" src="<%= request.getContextPath() %>/Sources/Imagenes/Productos/<%= a.getId() %>.jpg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"></img>
		            			<br>
							    <h5>Nombre del artículo: <%= a.getNombre()%></h5>
							    <h6>Stock: <%= a.getStock()%></h6>
							    <br>
							    <div class="d-flex justify-content-between align-items-center">
								    <p class="lead">Descripción: <%= a.getDescripcion()%></p>
								    <div>
								    </div>
								 </div>
							</div>

		            	<%}%>
		            <%}%>
		</div>
		</div>
	</div>
	
	
	
	
	<!-- Pie de página -->
    <footer class="footer fixed-bottom ">
        <div >
            <h4>2022 © Automatic License Plate Recognition</h4>
        </div>
    </footer>
	
</body>
</html>