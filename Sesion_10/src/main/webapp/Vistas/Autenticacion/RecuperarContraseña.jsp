<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Recuperar</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/CSS/index.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.2/animate.min.css">
</head>
  
<body style:"height: 100%">

	<!--  Cabecera de la página -->
	<jsp:include page="../Estaticos/Header.jsp" />



    <!-- Sección central -->
    <center><section class="container-fluid justify-content-center" style="overflow-x: hidden; overflow-y: auto;"   id ="container"  >
        <div class="col-md-5 p-5 my-auto " id="colcentral">
            <form id="form" class="card card-body my-auto  " action= "<%= request.getContextPath() %>/ContraseñaServlet?Operacion=Recuperar" method= "POST">
               <center><h1>Recuperar contraseña</h1></center>
               <br></br>
               <input class="form-control" type="text" id="usuario"  placeholder="Correo" name="UsuarioRecuperar">
               <br></br>
               <p align="center">
                    Si no recuerda su contraseña, introduzca su <span style="Color: #FFBF00">correo</span> y recibirá un mensaje con una contraseña temporal para que pueda iniciar sesión.
                </p>
               <br></br>
               <center><row>
                   <input type="submit" class="btn btn-warning " style= "width:300px"    value="Recuperar">
               </row></center>
         
            </form>
            <br></br>
               <%
               		if(request.getAttribute("mensaje") != null){
               %>
               		<p style="color: red"><%=request.getAttribute("mensaje") %></p>
               <%} %>
           </div>
    </section></center>

        <!-- Pie de página -->
    <footer>
        <div >
            <h4>2022 © Automatic License Plate Recognition</h4>
        </div>
    </footer>

</body>



</html>