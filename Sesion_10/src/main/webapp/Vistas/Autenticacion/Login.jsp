
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/CSS/index.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.2/animate.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
</head>
  
<body style:"height: 100%">

	<!--  Cabecera de la página -->
	<jsp:include page="../Estaticos/Header.jsp" />



    <!-- Sección central -->
    <center><section class="container-fluid " style="overflow-x: hidden; overflow-y: auto;"   id ="container"  >
        <div class="col-md-5 p-5 my-auto " >
            <form id="form" class="card card-body my-auto" action= "<%= request.getContextPath() %>/Login" method= "POST" >
               <center><h1>Iniciar sesión</h1></center>
               <br></br>
               <div class="mb-3 row">
                   <label for="inputPassword" class="col-sm-3 col-form-label">Usuario</label>
                   <div class="col-sm-7">
                       <input type="text" class="form-control" id="usuario" name = "usuario">
                   </div>
               </div>
<!--                <div class="mb-3 row"> -->
<!--                    <label for="inputPassword" class="col-sm-3 col-form-label">Contraseña</label> -->
<!--                    <div class="col-sm-7 "> -->
<!--                        <input type="password" class="form-control" id="contraseña" name ="password"> -->
<!--                        	<button class="btn btn-secundary" type="button" id="button-addon2" style="margin-left:330px;margin-top: -67px"><i class="far fa-eye" id="togglePassword"></i></button> -->
<!--                    </div> -->
<!--                </div> -->
               <div class="mb-3 row">
                   <label for="inputPassword" class="col-sm-3 col-form-label">Contraseña</label>
                   <div class="col-sm-7 ">
                       <input type="password" class="form-control" id="contraseña" name ="password">
                       	<button class="btn btn-secundary" type="button" id="button-addon2" style="margin-left:230px;margin-top: -67px"><i class="far fa-eye" id="togglePassword"></i></button>
                   </div>
               </div>
				<br>
               <center>
               <input type="submit" class="btn btn-warning " style= "width:150px" id="botonn" value="Entrar">
               <a href="<%= request.getContextPath() %>/Vistas/Autenticacion/Register.jsp">
               		<input type="button" class="btn btn-outline-warning" style= "width:150px"  id="botonn" value="Registrar">
               	</a>
               </center>
               <center><a href="<%= request.getContextPath() %>/Vistas/Autenticacion/RecuperarContraseña.jsp" style="text-decoration: none; color: black">Si ha olvidado su contraseña, pulse <span style="Color: #FFBF00">aquí</span>.</a></center>
               <%
               		if(request.getAttribute("mensaje") != null){
               %>
               		<p style="color: red"><%=request.getAttribute("mensaje") %></p>
               <%} %>
             </form>

   
           </div>
    </section></center>

    <script> 
		    const togglePassword = document.querySelector('#togglePassword');
		    const password = document.querySelector('#contraseña');
		
		    togglePassword.addEventListener('click', function (e) {
		      // toggle the type attribute
		      const type = password.getAttribute('type') === 'password' ? 'text' : 'password';
		      password.setAttribute('type', type);
		      // toggle the eye slash icon
		      this.classList.toggle('fa-eye-slash');
		  });
    
    
    </script>

        <!-- Pie de página -->
    <footer>
        <div >
            <h4>2022 © Automatic License Plate Recognition</h4>
        </div>
    </footer>

</body>



</html>