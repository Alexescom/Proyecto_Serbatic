<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="CSS/index.css">
<title>Productos</title>
</head>
<body>
	<!--  Cabecera de la página -->
	<jsp:include page="../../Estaticos/Header2.jsp" />
	<jsp:include page="../../Estaticos/HeaderEmpleado.jsp" />

			 <div class="col-md-10 p-2">
					<br>
					<div>
						<h2> PRODUCTOS EN EL SISTEMA </h2>
						
					</div>
					<!-- Example single danger button -->
					<div style="float: right">
						<a href="<%= request.getContextPath() %>/Vistas/Empleado/Productos/Insertar.jsp">
							<button class="btn btn-outline-warning"> Insertar nuevo producto </button>
						</a>
					</div>
					<br><br>
					<div class="md-10 float left">
				 	<table class="table table-striped table-dark " style="margin-left:30px">
					      <thead class="thead-dark">
					        <tr>
					        <th style="width: 50px; color:yellow" scope="col">#</th>
					        <th style="width: 200px" scope="col">Nombre</th>
					        <th style="width: 200px" scope="col">Descripción</th>
					        <th style="width: 200px" scope="col">Precio</th>
					        <th style="width: 200px" scope="col">Stock</th>
					        <th style="width: 200px" scope="col">Editar</th>
					        </tr>
					      </thead>
		            <%@page import="java.util.ArrayList" %>
		            <%@page import="dao.pojos.Articulo" %>
		            <%@page import="java.text.DecimalFormat" %>
		            <%
		            	int i = 0;
		            	DecimalFormat df = new DecimalFormat("###.##");
		            	ArrayList <Articulo> articulos = (ArrayList<Articulo>)request.getAttribute("Articulos");
		                if (articulos != null){
		                	for (Articulo a: articulos){
		                		i++;
					%>
	
 							<tr>
								<td style="vertical-align:middle"><%= i%></td>
				                <td style="vertical-align:middle"><%= a.getNombre()%></td>
				                <td style="vertical-align:middle"><%= a.getDescripcion() %></td>
				                <td style="vertical-align:middle"><%= a.getPrecio() %></td>
				                <td style="vertical-align:middle"><%= a.getStock() %></td>
				                <td style="vertical-align:middle">
				                	 <a href="ProductosServlet?Entidad=Empleado&Operacion=Ver&Id=<%= a.getId() %>">
		                            	<button type="button" class="btn btn-warning" style="width: 100px;">Editar</button>
		                            </a>
				                </td>

		              		</tr>
						
    
            	<%}%>
            <%}%>
            </table></div>
			</div>
			
	      </div>
	      <br><br><br><br><br><br>
      </div>




	<!-- Pie de página -->
    <footer class="footer fixed-bottom ">
        <div >
            <h4>2022 © Proyecto Serbatic</h4>
        </div>
     </footer> 
</body>
</html>