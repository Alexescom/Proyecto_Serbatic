
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registro</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/CSS/index.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.2/animate.min.css">
</head>
  
<body style:"height: 100%">

	<!--  Cabecera de la página -->
	<jsp:include page="../Estaticos/Header.jsp" />



    <!-- Sección central -->
    <center><section class="container-fluid " style="overflow-x: hidden"   id ="container"  >
		<div class="col-md-5 p-5 my-auto " id="colcentral" style="padding: 2rem!important">
		            <form id="form" class="card card-body my-auto  " action= "<%= request.getContextPath() %>/Register" method= "POST" >
		               <center><h1>Registrar usuario</h1></center>
		               <br>
		               
						<div class="form-group float-right ">
		                 <input class="form-control" type="text" style= "width:280px" id="nombre" placeholder="Nombre" name = "Nombre">
		                </div>
		                 <br>
						<div class="form-group float-right ">
		                <input class="form-control" type="text" style= "width:280px" id="apellido"  placeholder="Primer apellido" name = "Apellido1">
						</div>
						<br>
						<div class="form-group float-right ">
		               <input class="form-control" type="text" style= "width:280px" id="apellido"  placeholder="Segundo apellido" name = "Apellido2">
		               </div>
		               <br>
		               <div class="form-group float-right ">
		               <input class="form-control" type="text" id="correo" style= "width:280px" placeholder="Correo" name = "Correo">
		               </div>
		               <br>
		               <div class="form-group float-right ">
		               <input class="form-control" type="password" id="contraseña" style= "width:280px" placeholder="Contraseña" name = "Contraseña">
		               </div>
		               <br>
		               <div class="form-group float-right ">
		               <input class="form-control" type="text" id="telefono" style= "width:280px" placeholder="Télefono de contacto" name = "Telefono">
		               </div>
		               <br>
		               
		                   <div class="form-group float-left ">
		                       <input class="form-control" type="text" style= "width:280px" id="documento" placeholder="DNI/NIE" name = "Documento">
		                   </div>
		                   <br>
		                   <div class="form-group float-right ">
		                       <input class="form-control" type="text" style= "width:280px" id="poblacion"  placeholder="Provincia" name = "Provincia">
		                   </div>
		                   	<br>
		                   <div class="form-group float-right ">
		                       <input class="form-control" type="text" style= "width:280px" id="poblacion"  placeholder="Localización" name = "Localizacion">
		                   </div>
		                   	<br>

		               
		               <br></br>
		               <center><row>
		                   <input type="button" class="btn btn-warning " style= "width:300px" onclick="registrarUsuarioC()" id="botonn" value="Registrar">
		               </row></center>
		               
		            </div>
		            
		            <br></br>
 
           </div>
    </section></center>


        <!-- Pie de página -->
    <footer class="footer fixed-bottom ">
        <div >
            <h4>2022 © Automatic License Plate Recognition</h4>
        </div>
    </footer>

</body>



</html>