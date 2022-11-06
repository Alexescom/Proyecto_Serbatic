<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<%= request.getContextPath() %>/CSS/index.css">
<meta charset="ISO-8859-1">
<title>Mis pedidos</title>
</head>
<body>
	<!--  Cabecera de la página -->
	<jsp:include page="../Estaticos/Header.jsp" />
	
	<!--  Sección central -->
	<div class="container">
		<br>
		<br>
		<div>
			<h2> PEDIDOS DEL USUARIO </h2>
			
		</div>
		<br>
		
		<div class="row row-cols-1 ">
	
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
	
		            		<div class="bg-light  p-3 rounded border border-2" style="margin-top: 25px; boder:1px">
							    <row  class="d-flex justify-content-between">
							    
							    <%
							    	if (a.getNum_factura() == null){%>
							     <h2 style="display: inline">Número de factura: Sin número</h2>		
							    <%	}else{ %>
							     <h2 style="display: inline">Número de factura: <%= a.getNum_factura()%></h2>
							    <%}%>
							    <h5 style="display: inline">Estado: <%= estado%></h5>
							    </row>
							    <h4>Realizado: <%= a.getFecha()%></h4>
							    <br>
							    
							    <div class="d-flex justify-content-between align-items-center">
								    <div>
								    <p class="lead">Precio total: <%= df.format(a.getTotal())%>$</p>
								    <%
								    	if (a.getEstado().equals("PE")){%>
								    		
								    	<a  href="PedidoServlet?Id_pedido=<%= a.getId() %>&Operacion=Cancelar&Estado=PC" style="color: red">
								    		Cancelar pedido
								    	</a>
								    
								   <%}%>
									</div>
								    <div>
								    								    <%
										if (a.getEstado().equals("E")){%>
										<a href="<%= request.getContextPath() %>/DocumentoServlet?Id=<%= a.getId() %>" style="text-decoration: none; color: black">
											<img href="<%= request.getContextPath() %>/DocumentoServlet?Id=<%= a.getId() %>"src="https://img.icons8.com/ios/50/000000/pdf--v1.png" style="height: 30px"/>  
										</a>   	
										<%	}else{ %> 
								    	
										<%}%>
								    	<a  href="PedidoServlet?Id_pedido=<%= a.getId() %>&Operacion=Mostrar&Estado=<%= a.getEstado()%>">
								    		<small class="btn btn-sm btn-warning"  role="button">Detalles del pedido »</small>
								    	</a>
								    </div>

								 </div>
							</div>

		            	<%}%>
		            <%}%>
		</div>
	</div>
	<br><br><br><br><br>
	 <!-- Pie de página -->
    <footer class="footer fixed-bottom ">
        <div >
            <h4>2022 © Automatic License Plate Recognition</h4>
        </div>
    </footer>
</body>
</html>