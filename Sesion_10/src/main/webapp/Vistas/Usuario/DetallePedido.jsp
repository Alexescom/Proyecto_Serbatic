<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<%= request.getContextPath() %>/CSS/index.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/CSS/Valoracion.css">
<meta charset="ISO-8859-1">
<title>Detalle pedido</title>
</head>
<body>
	<!--  Cabecera de la página -->
	<jsp:include page="../Estaticos/Header.jsp" />
	
	 <div class="md-0  float-left m-2" style="position: absolute ;margin-left: 5px ">
      <a href="UsuarioServlet?Operacion=Pedidos" style="text-decoration: none; color: black">
      <h5> &#10094 &nbsp Volver atrás</h5>
      </a>
    </div>
	<!--  Sección central -->
	<div class="container">
		<br>
		<br>

		<div>
			<h2> DETALLES DEL PEDIDO:  <%= request.getAttribute("Id_pedido") %> </h2>
		</div>
		<br>
		
		<div class="row row-cols-1 row-cols-sm-4 row-cols-md-4 g-4">
					<%@page import="java.util.ArrayList" %>
					<%@page import="dao.pojos.Detalle" %>
					<%@page import="java.text.DecimalFormat" %>

		            <%
		            	ArrayList <Detalle> detalles = (ArrayList<Detalle>)request.getAttribute("Detalles");
		            	DecimalFormat df = new DecimalFormat("###.##");
		                if (detalles != null){
		            		for (Detalle a: detalles){%>
		            		
							
			            		<div class="bg-light  p-3 m-5 rounded border border-2" style="margin-top: 25px; boder:1px">
			            			<img class="bd-placeholder-img card-img-top " width="100%" height="225" src="<%= request.getContextPath() %>/Sources/Imagenes/Productos/<%= a.getId_producto() %>.jpg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"></img>
			            			<br>
								    <h5>Nombre del artículo: <%= a.getNombre()%></h5>
								    <h6>Unidades: <%= a.getUnidades()%></h6>
								    <br>
								    <div class="d-flex justify-content-between align-items-center">
									    <p class="lead">Precio total: <%= df.format(a.getTotal())%>$</p>
									    <div>
									    </div>
									 </div>
									 <%
											if (request.getAttribute("Estado").equals("PE")){%>
												<%if (a.isCancelar() == false){%>
										    	<a  href="PedidoServlet?Id=<%= a.getId() %>&Operacion=EliminarDetalle&Id_pedido=<%= request.getAttribute("Id_pedido")%>" style="color: red">
										    		Cancelar articulo 
										    	</a>
									    		<%	}else { %> 
									    		<a  style="color: red; style: none">
										    		Producto cancelado
										    	</a>
									    		<%	} %> 
									    	<%} else if  (request.getAttribute("Estado").equals("E")){%> 
									    		<form action="<%= request.getContextPath() %>/ValoracionServlet?Id_producto=<%= a.getId_producto()%>">
												  	<input type="text" class="form-control" placeholder="Introduce un comentario" name="Comentario" >
												  	<input type="text" class="form-control" value="<%= a.getId_producto()%>" name="Id_producto" style="display:none">
												  	<input type="text" class="form-control" value="<%= a.getId_pedido()%>" name="Id_pedido" style="display:none">
												  	<br>
													  <p class="clasificacion">
													  	<button type="submit" class="btn btn-warning">Valorar</button>
													    <input id="radio1<%= a.getId_producto()%>" type="radio" name="estrellas<%= a.getId_producto()%>" value="5"><!--
													    --><label for="radio1<%= a.getId_producto()%>">★</label><!--
													    --><input id="radio2<%= a.getId_producto()%>" type="radio" name="estrellas<%= a.getId_producto()%>" value="4"><!--
													    --><label for="radio2<%= a.getId_producto()%>">★</label><!--
													    --><input id="radio3<%= a.getId_producto()%>" type="radio" name="estrellas<%= a.getId_producto()%>" value="3"><!--
													    --><label for="radio3<%= a.getId_producto()%>">★</label><!--
													    --><input id="radio4<%= a.getId_producto()%>" type="radio" name="estrellas<%= a.getId_producto()%>" value="2"><!--
													    --><label for="radio4<%= a.getId_producto()%>">★</label><!--
													    --><input id="radio5<%= a.getId_producto()%>" type="radio" name="estrellas<%= a.getId_producto()%>" value="1"><!--
													    --><label for="radio5<%= a.getId_producto()%>">★</label>
													</p>

												</form>
									    		
		
										<%	} %> 
								</div>
							
		            	<%}%>
		            <%}%>
		</div>
	</div>
	
	<br><br>
	<!-- Pie de página -->
    <footer class="footer fixed-bottom ">
        <div >
            <h4>2022 © Automatic License Plate Recognition</h4>
        </div>
    </footer>
</body>
</html>