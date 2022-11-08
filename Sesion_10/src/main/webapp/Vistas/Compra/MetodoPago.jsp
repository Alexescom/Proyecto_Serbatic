<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/CSS/index.css">
<title>Checkout</title>
</head>
<body class="overflow-x-hidden">
	<!--  Cabecera de la página -->
	<jsp:include page="../Estaticos/Header.jsp" />
	
	
	<!--  Sección central -->
	<br>
	<div class="container">


      <div class="row">
        <div class="col-md-4 order-md-2 mb-4">
          <h4 class="d-flex justify-content-between align-items-center mb-3">
            <span class="text-muted">Tu carrito</span>
            <span class="badge badge-secondary badge-pill">3</span>
          </h4>
          <ul class="list-group mb-3">
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
            <li class="list-group-item d-flex justify-content-between lh-condensed">
              <div>
                <h6 class="my-0">Nombre del producto: <%= a.getNombre()%></h6>
                <small class="text-muted">Unidades: <%= a.getUnidades() %></small>
              </div>
              <span class="text-muted">Total: <%= df.format(a.getTotal()) %>$</span>
            </li>
							
	    
	            	<%}%>
	            <%}%>
          
            <li class="list-group-item d-flex justify-content-between">
              <span>Total </span>
              <strong><%= df.format(request.getAttribute("Total")) %>$</strong>
            </li>
            
             <%
               		if(request.getAttribute("Descuento") != null){
             %>
            <li class="list-group-item d-flex justify-content-between">
              <span>Descuento </span>
              <strong>-<%= df.format(request.getAttribute("Descuento")) %>$</strong>
            </li>
            
            <%}%>
          </ul>

		  <form class="card p-2" action= "<%= request.getContextPath() %>/DescuentosServlet">
            <div class="input-group">
              <input type="text" class="form-control" placeholder="Código de promoción" name="Codigo">
              <input type="text" class="form-control" value="Cliente" style="display:none" name="Entidad">
              <input type="text" class="form-control" value="Aplicar" style="display:none" name="Operacion">
              <div class="input-group-append">
                <button type="submit" class="btn btn-secondary">Aplicar</button>
              </div>
            </div>
          </form>
          
               <%
               		if(request.getAttribute("mensaje") != null){
               %>
               		<br><center><p style="color: red"><%=request.getAttribute("mensaje") %></p></center>
               <%} %>
               
        </div>
        

        
        <div class="col-md-8 order-md-1">
          <h4 class="mb-3">Dirección de envio</h4>
          <form class="needs-validation" novalidate="">
            <div class="mb-3">
              <label for="address">Dirección</label>
              <input type="text" class="form-control" id="address" placeholder="1234 Main St" required="">
              <div class="invalid-feedback">
                Porfavor, introduzca su dirección.
              </div>
            </div>

            <div class="mb-3">
              <label for="address2">Dirección 2 <span class="text-muted">(Optional)</span></label>
              <input type="text" class="form-control" id="address2" placeholder="Apartment or suite">
            </div>

            <div class="row">
              <div class="col-md-3 mb-3">
                <label for="zip">Código postal</label>
                <input type="text" class="form-control" id="zip" placeholder="" required="">
                <div class="invalid-feedback">
                  Zip code required.
                </div>
              </div>
            </div>
            <hr class="mb-4">

          <form class="card p-2">

            <h4 class="mb-3">Método de pago</h4>

            <div class="d-block my-3">
              <div class="custom-control custom-radio">
                <input id="credit" name="paymentMethod" type="radio" class="custom-control-input" checked="" required="">
                <label class="custom-control-label" for="credit">Credit card</label>
              </div>
              <div class="custom-control custom-radio">
                <input id="debit" name="paymentMethod" type="radio" class="custom-control-input" required="">
                <label class="custom-control-label" for="debit">Debit card</label>
              </div>
              <div class="custom-control custom-radio">
                <input id="paypal" name="paymentMethod" type="radio" class="custom-control-input" required="">
                <label class="custom-control-label" for="paypal">Paypal</label>
              </div>
            </div>
            <div class="row">
              <div class="col-md-6 mb-3">
                <label for="cc-name">Nombre en la tarjeta</label>
                <input type="text" class="form-control" id="cc-name" placeholder="" required="">
                <small class="text-muted">Full name as displayed on card</small>
                <div class="invalid-feedback">
                  Name on card is required
                </div>
              </div>
              <div class="col-md-6 mb-3">
                <label for="cc-number">Número de tarjeta</label>
                <input type="text" class="form-control" id="cc-number" placeholder="" required="">
                <div class="invalid-feedback">
                  Credit card number is required
                </div>
              </div>
            </div>
            <div class="row">
              <div class="col-md-3 mb-3">
                <label for="cc-expiration">Expiración</label>
                <input type="text" class="form-control" id="cc-expiration" placeholder="" required="">
                <div class="invalid-feedback">
                  Expiration date required
                </div>
              </div>
              <div class="col-md-3 mb-3">
                <label for="cc-expiration">CVV</label>
                <input type="text" class="form-control" id="cc-cvv" placeholder="" required="">
                <div class="invalid-feedback">
                  Security code required
                </div>
              </div>
            </div>
            <%if(request.getAttribute("Descuento") == null){%>
            <a href="CompraServlet?Operacion=Comprar" style="text-decoration: none; color: black">
            	<button type="button" class="btn btn-warning" style="width: 150px; height: 50px">Comprar</button>
            </a>
            <%} else { 
            	Float descuento = (float)(request.getAttribute("Descuento"));
            	
            %>
            <a href="CompraServlet?Operacion=Comprar&Descuento=<%= descuento %>" style="text-decoration: none; color: black">
            	<button type="button" class="btn btn-warning" style="width: 150px; height: 50px">Comprar</button>
            	
            </a>
            <%} %>
        </div>
      </div>

    </div>
	
	
	
	
	<br><br><br><br>
	
	<!-- Pie de página -->
    <footer class="footer fixed-bottom ">
        <div >
            <h4>2022 © Automatic License Plate Recognition</h4>
        </div>
    </footer>
</body>
</html>