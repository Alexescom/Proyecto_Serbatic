<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!--  Sección central -->
	<div class = "col-md-11">
		<div class="row" stye="margin-right: 0rem">
	        <nav class="col-md-2 sticky-top d-none d-md-block bg-light sidebar">
	          <div class="sidebar-sticky">
	            <ul class="nav flex-column">
	            <br>
	              <li class="nav-item">
	                <a class="nav-link active" href="<%= request.getContextPath() %>/ProductosServlet?Entidad=Empleado&Operacion=Index">
	                 <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-shopping-cart"><circle cx="9" cy="21" r="1"></circle><circle cx="20" cy="21" r="1"></circle><path d="M1 1h4l2.68 13.39a2 2 0 0 0 2 1.61h9.72a2 2 0 0 0 2-1.61L23 6H6"></path></svg>
	                  Gestionar productos 
	                </a>
	              </li>
	              <br>
	              <li class="nav-item">
	                <a class="nav-link" href="<%= request.getContextPath() %>/UsuariosServlet?Entidad=Empleado&Operacion=Index">
	                  <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-users"><path d="M17 21v-2a4 4 0 0 0-4-4H5a4 4 0 0 0-4 4v2"></path><circle cx="9" cy="7" r="4"></circle><path d="M23 21v-2a4 4 0 0 0-3-3.87"></path><path d="M16 3.13a4 4 0 0 1 0 7.75"></path></svg>
	                  Gestionar clientes
	                </a>
	              </li>
	              <br>
	              <li class="nav-item">
	                <a class="nav-link" href="<%= request.getContextPath() %>/PedidosEmpleadoServlet?Entidad=Empleado">
	                  <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file"><path d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path><polyline points="13 2 13 9 20 9"></polyline></svg>
	                  Gestionar pedidos
	                </a>
	              </li>
	              <br>
	              <li><hr></li>
	              <br>
	              <li class="nav-item">
	                <a class="nav-link active" href="<%= request.getContextPath() %>/CategoriasServlet?Operacion=Ver">
	                  <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-layers align-text-bottom" aria-hidden="true"><polygon points="12 2 2 7 12 12 22 7 12 2"></polygon><polyline points="2 17 12 22 22 17"></polyline><polyline points="2 12 12 17 22 12"></polyline></svg>
	                  Gestionar categorías
	                </a>
	              </li>
	              <br>
	              <li class="nav-item">
	                <a class="nav-link active" href="<%= request.getContextPath() %>/ProductosServlet?Entidad=Empleado&Operacion=Exportar">
						<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" class="bi bi-file-earmark-break" viewBox="0 0 16 16">
						  <path d="M14 4.5V9h-1V4.5h-2A1.5 1.5 0 0 1 9.5 3V1H4a1 1 0 0 0-1 1v7H2V2a2 2 0 0 1 2-2h5.5L14 4.5zM13 12h1v2a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2v-2h1v2a1 1 0 0 0 1 1h8a1 1 0 0 0 1-1v-2zM.5 10a.5.5 0 0 0 0 1h15a.5.5 0 0 0 0-1H.5z"/>
						</svg>
	                 	Exportar productos
	                </a>
	              </li>
	              <br>
	              <li class="nav-item">
	                <a class="nav-link active" href="<%= request.getContextPath() %>/ProveedoresServlet?Operacion=Index">
	                  <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" class="bi bi-truck-flatbed" viewBox="0 0 16 16">
						  <path d="M11.5 4a.5.5 0 0 1 .5.5V5h1.02a1.5 1.5 0 0 1 1.17.563l1.481 1.85a1.5 1.5 0 0 1 .329.938V10.5a1.5 1.5 0 0 1-1.5 1.5H14a2 2 0 1 1-4 0H5a2 2 0 1 1-4 0 1 1 0 0 1-1-1v-1h11V4.5a.5.5 0 0 1 .5-.5zM3 11a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm9 0a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm1.732 0h.768a.5.5 0 0 0 .5-.5V8.35a.5.5 0 0 0-.11-.312l-1.48-1.85A.5.5 0 0 0 13.02 6H12v4a2 2 0 0 1 1.732 1z"/>
					  </svg>
	                 	Gestionar proveedores
	                </a>
	              </li>
	              <br>
	              <br><br>
	              <li><hr class="dropdown-divider"></li>
	              <li class="nav-item">
	                <a class="nav-link" href="<%= request.getContextPath() %>/LogoutServlet">
	                  <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-layers"><polygon points="12 2 2 7 12 12 22 7 12 2"></polygon><polyline points="2 17 12 22 22 17"></polyline><polyline points="2 12 12 17 22 12"></polyline></svg>
	                  Cerrar sesión
	                </a>
	              </li>
	            </ul>
				<br><br><br>
	          </div>
	        </nav>
</body>
</html>