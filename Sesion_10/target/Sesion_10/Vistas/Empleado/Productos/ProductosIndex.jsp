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
	<!--  Cabecera de la p?gina -->
	<jsp:include page="../../Estaticos/Header2.jsp" />
	<!--  Secci?n central -->
	<div class = "col-md-11">
		<div class="row" stye="margin-right: 0rem">
	        <nav class="col-md-2 d-none d-md-block bg-light sidebar" >
	          <div class="sidebar-sticky">
	            <ul class="nav flex-column">
	            <br>
	              <li class="nav-item">
	                <a class="nav-link active" href="#">
	                 <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-shopping-cart"><circle cx="9" cy="21" r="1"></circle><circle cx="20" cy="21" r="1"></circle><path d="M1 1h4l2.68 13.39a2 2 0 0 0 2 1.61h9.72a2 2 0 0 0 2-1.61L23 6H6"></path></svg>
	                  Gestionar productos 
	                </a>
	              </li>
	              <br>
	              <li class="nav-item">
	                <a class="nav-link" href="#">
	                  <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-users"><path d="M17 21v-2a4 4 0 0 0-4-4H5a4 4 0 0 0-4 4v2"></path><circle cx="9" cy="7" r="4"></circle><path d="M23 21v-2a4 4 0 0 0-3-3.87"></path><path d="M16 3.13a4 4 0 0 1 0 7.75"></path></svg>
	                  Gestionar clientes
	                </a>
	              </li>
	              <br>
	              <li class="nav-item">
	                <a class="nav-link" href="#">
	                  <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file"><path d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path><polyline points="13 2 13 9 20 9"></polyline></svg>
	                  Gestionar pedidos
	                </a>
	              </li>
	              <br><br><br><br><br><br><br><br><br><br><br><br><br><br>
	              <li><hr class="dropdown-divider"></li>
	              <li class="nav-item">
	                <a class="nav-link" href="<%= request.getContextPath() %>/LogoutServlet">
	                  <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-layers"><polygon points="12 2 2 7 12 12 22 7 12 2"></polygon><polyline points="2 17 12 22 22 17"></polyline><polyline points="2 12 12 17 22 12"></polyline></svg>
	                  Cerrar sesi?n
	                </a>
	              </li>
	            </ul>
				<br><br><br>
	          </div>
	        </nav>
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
					        <th style="width: 200px" scope="col">Descripci?n</th>
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




	<!-- Pie de p?gina -->
    <footer class="footer fixed-bottom ">
        <div >
            <h4>2022 ? Proyecto Serbatic</h4>
        </div>
     </footer> 
</body>
</html>