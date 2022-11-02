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
	<jsp:include page="../../Estaticos/HeaderEmpleado.jsp" />
	
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
							    <h2 style="display: inline">Número de factura: Sin número de factura</h2>
							    <h5 style="display: inline">Estado: <%= estado%></h5>
							    </row>
							    <h4>Realizado: <%= a.getFecha()%></h4>
							    <br>
							    
							    <div class="d-flex justify-content-between align-items-center">
								    <div>
								    <p class="lead">Precio total: <%= df.format(a.getTotal())%>$</p>
									</div>
								    <div>
								    	<a  href="PedidoServlet?Id_pedido=<%= a.getId() %>&Operacion=Cambiar&Estado=E&Entidad=Empleado">
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