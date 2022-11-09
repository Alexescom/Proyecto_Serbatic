<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="CSS/index.css">
<meta charset="ISO-8859-1">
<title>Proveedores</title>
</head>
<body>
	<!--  Cabecera de la página -->
	<jsp:include page="../../Estaticos/Header2.jsp" />
	<!--  Sección central -->
	<jsp:include page="../../Estaticos/HeaderEmpleado.jsp" />
			 <div class="col-md-10 p-2">
					<br>
					<div>
						<h2> PROVEEDORES EN EL SISTEMA </h2>
						
					</div>
					<!-- Example single danger button -->
					<div style="float: right">
						<a href="<%= request.getContextPath() %>/Vistas/Empleado/Proveedores/Insertar.jsp">
							<button class="btn btn-outline-warning"> Insertar nuevo proveedor </button>
						</a>
					</div>
					<br><br>
					<div class="md-10 float left">
				 	<table class="table table-striped table-dark " style="margin-left:30px">
					      <thead class="thead-dark">
					        <tr>
					        <th style="width: 50px; color:yellow" scope="col">#</th>
					        <th style="width: 200px" scope="col">Email</th>
					        <th style="width: 200px" scope="col">Nombre</th>
					        <th style="width: 200px" scope="col">Teléfono</th>
					        <th style="width: 200px" scope="col">CIF</th>
					        <th style="width: 200px" scope="col">Baja</th>
					        <th style="width: 200px" scope="col">Editar</th>
					        <th style="width: 200px" scope="col">Eliminar</th>
					        </tr>
					      </thead>
		            <%@page import="java.util.ArrayList" %>
		            <%@page import="dao.pojos.Proveedor" %>
		            <%@page import="java.text.DecimalFormat" %>
		            <%
		            	int i = 0;
		            	DecimalFormat df = new DecimalFormat("###.##");
		            	ArrayList <Proveedor> proveedores = (ArrayList<Proveedor>)request.getAttribute("Proveedores");
		                if (proveedores != null){
		                	for (Proveedor a: proveedores){
		                		i++;
					%>
	
 							<tr>
								<td style="vertical-align:middle"><%= i%></td>
				                <td style="vertical-align:middle"><%= a.getEmail()%></td>
				                <td style="vertical-align:middle"><%= a.getNombre() %></td>
				                <td style="vertical-align:middle"><%= a.getTelefono() %></td>
				                <td style="vertical-align:middle"><%= a.getCif() %></td>
				                <td style="vertical-align:middle"><%= a.getBaja() %></td>
				                <td style="vertical-align:middle">
				                	 <a href="ProveedoresServlet?Operacion=Ver&Id=<%= a.getId() %>">
		                            	<button type="button" class="btn btn-warning" style="width: 100px;">Editar</button>
		                            </a>
				                </td>
				                <td style="vertical-align:middle">
				                	 <a href="ProveedoresServlet?Operacion=Eliminar&Id=<%= a.getId() %>">
		                            	<button type="button" class="btn btn-danger" style="width: 100px;">Eliminar</button>
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