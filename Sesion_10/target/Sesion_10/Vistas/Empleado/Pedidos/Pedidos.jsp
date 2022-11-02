<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="CSS/index.css">
<meta charset="ISO-8859-1">
<title>Pedidos</title>
</head>
<body>
	<!--  Cabecera de la página -->
	<jsp:include page="../../Estaticos/Header2.jsp" />
	<!--  Sección central -->
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
	                  Cerrar sesión
	                </a>
	              </li>
	            </ul>
				<br><br><br>
	          </div>
	        </nav>
			 <div class="col-md-10 ">
					<br>
					<br>
					<div>
						<h2> PEDIDOS PENDIENTES DE ENVIO </h2>
						
					</div>
					<br>
		            <%@page import="java.util.ArrayList" %>
		            <%@page import="dao.pojos.Pedido" %>
		            <%@page import="java.text.DecimalFormat" %>
		            <%
		            	String estado;
		            	DecimalFormat df = new DecimalFormat("###.##");
		            	ArrayList <Pedido> pedidos = (ArrayList<Pedido>)request.getAttribute("Pedidos");
		                if (pedidos != null){
		            		for (Pedido a: pedidos){
		            		
		            		if (a.getEstado().equals("PC")){
		            		
		            			estado = "Pendiente de cancelación";
		            		}else if (a.getEstado().equals("PE")){
		            		
		            			estado = "Pendiente de envio";
		            		}else if (a.getEstado().equals("E")){
		            		
		            			estado = "Enviado";
		            		}else{
		            			estado = "Cancelado";
		            			
		            		}%>
	
		            		<div class="bg-light  p-3 rounded border border-2 m-5" style="margin-top: 25px; boder:1px">
							    <row  class="d-flex justify-content-between">
							    <h2 style="display: inline">Número de factura: <%= a.getNum_factura()%></h2>
							    <h5 style="display: inline">Estado: <%= estado%></h5>
							    </row>
							    <h4>Realizado: <%= a.getFecha()%></h4>
							    <br>
							    
							    <div class="d-flex justify-content-between align-items-center">
								    <div>
								    <p class="lead">Precio total: <%= df.format(a.getTotal())%>$</p>
									</div>
								    <div>
								    	<a  href="PedidoServlet?Id_pedido=<%= a.getId() %>&Operacion=Cambiar&Estado=E">
								    		<small class="btn btn-sm btn-warning"  role="button">Marcar pedido como enviado »</small>
								    	</a>
								    </div>

								 </div>
							</div>

		            	<%}%>
		            <%}%>
		            <br><br><br><br><br>
			</div>
			
	      </div>
      </div>




	<!-- Pie de página -->
    <footer class="footer fixed-bottom ">
        <div >
            <h4>2022 © Proyecto Serbatic</h4>
        </div>
     </footer> 
</body>
</html>