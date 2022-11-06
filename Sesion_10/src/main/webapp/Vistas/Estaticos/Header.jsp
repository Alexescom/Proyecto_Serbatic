<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<header class="p-3 bg-dark text-white">
    <div class="container">
      <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
        <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
          <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"></use></svg>
        </a>

        <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
          <li><a href="<%= request.getContextPath() %>/IndexServlet" class="nav-link px-2 text-secondary">Home</a></li>
          <li><a href="#" class="nav-link px-2 text-white">Features</a></li>
          <li><a href="#" class="nav-link px-2 text-white">Pricing</a></li>
          <li><a href="#" class="nav-link px-2 text-white">FAQs</a></li>
          <li><a href="#" class="nav-link px-2 text-white">About</a></li>
        </ul>

        <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" action= "<%= request.getContextPath() %>/CategoriasServlet?Operacion=Buscar" method= "POST">
          <input type="search" class="form-control form-control-dark" placeholder="Search..." aria-label="Search"  name="Buscador">
        </form>


        <div class="text-end"  >
        <%
        	if (request.getSession().getAttribute("Email") == null){
        %>
           <a href="<%= request.getContextPath() %>/Vistas/Autenticacion/Login.jsp" style="text-decoration: none; color: black">
	          <button type="button" class="btn btn-outline-light me-2">Login</button>
	       </a>
	       <a href="<%= request.getContextPath() %>/Vistas/Autenticacion/Register.jsp">
          	<button type="button" class="btn btn-warning">Sign-up</button>
          </a>
         <%}else{
       	 %>
		<!-- Example single danger button -->
		<div class="btn-group">
		  <button type="button" class="btn btn-secondary dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
		    <%= request.getSession().getAttribute("Email") %>
		  </button>
		  <ul class="dropdown-menu">
		    <li><a href="<%= request.getContextPath() %>/UsuarioServlet?Operacion=Perfil" class="dropdown-item" href="#">Ver perfil</a></li>
		    <li><a href="<%= request.getContextPath() %>/UsuarioServlet?Operacion=Pedidos" class="dropdown-item" href="#">Ver pedidos</a></li>
		    <li><a class="dropdown-item" href="CarritoServlet?operacion=mostrar" style="text-decoration: none; color: black">Carro sesión</a></li>
		    <li><hr class="dropdown-divider"></li>
		    <li><a class="dropdown-item" href="LogoutServlet">Cerrar sesión</a></li>
		  </ul>
		</div>
        <%} %>
         
        
      </div>
    </div>
 </header>
</body>
</html>