<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Compra</title>
</head>
<body>
<br>
<br>
<center><h1>GRACIAS POR CONFIAR EN NUESTROS SERVICIOS</h1>
<h3>Compra del usuario <%= request.getSession().getAttribute("usuario") %> realizada.</h3>

 <%@page import="java.text.DecimalFormat" %>
             <%
            	DecimalFormat df = new DecimalFormat("###.##");
             	
             %>
<h4>Precio total del pedido: <%= df.format(request.getAttribute("Total"))%>$.</h4>
<br>
<br>
<br>
<br>
<br>
<br>
<a href="IndexServlet" style="text-decoration: none; color: black">
    <button type="button" class="btn btn-warning" style="width: 150px; height: 50px">VOLVER</button>
</a></center>
</body>
</html>