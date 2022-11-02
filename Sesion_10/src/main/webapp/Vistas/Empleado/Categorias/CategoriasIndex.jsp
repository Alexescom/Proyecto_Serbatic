<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="CSS/index.css">
<meta charset="ISO-8859-1">
<title>Categorias</title>
</head>
<body>
	<!--  Cabecera de la página -->
	<jsp:include page="../../Estaticos/Header2.jsp" />
	<!--  Sección central -->
	<jsp:include page="../../Estaticos/HeaderEmpleado.jsp" />
	
	
				 <div class="col-md-10 p-2">
					<br>
					<div>
						<h2> CATEGORIAS </h2>
						
					</div>
					<!-- Example single danger button -->
					<div style="float: right">
						<a href="<%= request.getContextPath() %>/Vistas/Empleado/Categorias/Insertar.jsp">
							<button class="btn btn-outline-warning"> Insertar nueva categoría </button>
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
					        </tr>
					      </thead>
		            <%@page import="java.util.ArrayList" %>
		            <%@page import="dao.pojos.Categoria" %>
		            <%@page import="java.text.DecimalFormat" %>
		            <%
		            	int i = 0;
		            	DecimalFormat df = new DecimalFormat("###.##");
		            	ArrayList <Categoria> categorias = (ArrayList<Categoria>)request.getAttribute("Categorias");
		                if (categorias != null){
		                	for (Categoria a: categorias){
		                		i++;
					%>
	
 							<tr>
								<td style="vertical-align:middle"><%= i%></td>
				                <td style="vertical-align:middle"><%= a.getNombre()%></td>
				                <td style="vertical-align:middle"><%= a.getDescripcion() %></td>

		              		</tr>
						
    
            	<%}%>
            <%}%>
            </table></div>
			</div>
			
</div></div>
	      <br><br><br><br><br><br>





	<!-- Pie de página -->
    <footer class="footer fixed-bottom ">
        <div >
            <h4>2022 © Proyecto Serbatic</h4>
        </div>
     </footer> 
</body>
</html>