<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="CSS/index.css">
<title>Carro</title>
</head>

	<!--  Cabecera de la página -->
	<jsp:include page="../Estaticos/Header.jsp" />
  
	<body>
	 <div class="md-0  float-left" style="position: absolute ;margin-left: 5px " >
      <br>
      <a href="IndexServlet" style="text-decoration: none; color: black">
      <h5> &#10094 &nbsp Volver atrás</h5>
      </a>
    </div>
    
	<center><div class="col-md-8">
	<br>
	<br>
	<h1>CARRO DE LA COMPRA</h1>
	<br>
	<br>
	<div class="md-10 float left">
 	<table class="table table-striped table-dark ">
      <thead class="thead-dark">
        <tr>
        <th style="width: 50px; color:yellow" scope="col">#</th>
        <th style="width: 200px" scope="col">Producto</th>
        <th style="width: 200px" scope="col">Precio Total</th>
        <th style="width: 200px" scope="col">Cantidad</th>
        <th style="width: 200px" scope="col">Aumentar</th>
        <th style="width: 200px" scope="col">Decrementar</th>
        </tr>
      </thead>
            <%@page import="java.util.ArrayList" %>
            <%@page import="java.text.DecimalFormat" %>
            <%@page import="dao.pojos.Detalle" %>
            <%
            	DecimalFormat df = new DecimalFormat("###.##");
            	int i = 0;
            	ArrayList <Detalle> carrito = (ArrayList<Detalle>)request.getSession().getAttribute("Carro");
                if (carrito != null){
                	
            		for (Detalle a: carrito){
            			i++;
            			%>
						 <tr>
						 <td style="vertical-align:middle"><%= i%></td>
		                <td style="vertical-align:middle"><%= a.getNombre()%></td>
		                <td style="vertical-align:middle"><%= df.format(a.getTotal()) %></td>
		                <td style="vertical-align:middle"><%= a.getUnidades() %></td>
		                <td style="vertical-align:middle">
		                	 <a href="CarritoServlet?id=<%= a.getId_producto() %>&nombre=<%= a.getNombre() %>&operacion=masC&precio=<%= a.getPrecio_unidad() %>"">
                            	<button type="button" class="btn btn-warning" style="width: 50px; height: 30px">+</button>
                            </a>
		                </td>
		                <td style="vertical-align:middle">
		                	 <a href="CarritoServlet?id=<%= a.getId_producto() %>&nombre=<%= a.getNombre() %>&operacion=-">
                            	<button type="button" class="btn btn-danger" style="width: 50px; height: 30px">-</button>
                            </a>
		                </td>
              			</tr>
						
    
            	<%}%>
            <%}%>
            </table></div>
            <div class="md-2 float right">
           		<a href="CompraServlet?Operacion=Checkout" style="text-decoration: none; color: black">
            		<button type="button" class="btn btn-warning" style="width: 150px; height: 50px">COMPRAR</button>
            	</a>
            </div>
	</div>
</center>



	<!-- Pie de página -->
   <footer>
        <div >
            <h4>2022 © Proyecto Serbatic</h4>
        </div>
    </footer> 

</body>

</html>