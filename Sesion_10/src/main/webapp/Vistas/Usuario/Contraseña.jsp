<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<%= request.getContextPath() %>/CSS/index.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Perfil</title>
</head>
<body>

	
	<!--  Cabecera de la p�gina -->
	<jsp:include page="../Estaticos/Header.jsp" />
	
	
	
	<!-- Secci�n central -->
	<div class="container">

					<!-- Secci�n central -->
					<div class="container">
				
						<br>
						<br>
                         <div class="bg-light col-md-8 mx-auto overflow-auto p-3 rounded border border-3"  >
                          <form id="form" class="card card-body my-auto" name="formulario" action= "<%= request.getContextPath() %>/Contrase�aServlet?Operacion=Modificar" method= "POST" >
							<div class="col-12  border-right" >
                                <h3 class="text-center"> Cambiar contrase�a </h3>
                                <hr class="mb-12">
                                <br></br>

                                <div class="col-md-12" >
                                	<div class="row justify-content-md-center">
                                		<div class="col-6">
	                                    	<h6 class="text-right"> Contrase�a</h6>
	                                  	</div>
	                                  	<div class="col-6  m-auto" >
	                                    	<input class="text" style="color:grey;" id="c1" value="" name ="Contrase�a"></input>
	                                  	</div>
	                                 </div>
                                </div>
                                <br><br>
                                <div class="col-md-12" >
                                	<div class="row justify-content-md-center">
                                		<div class="col-6">
	                                    	<h6 class="text-right"> Repita la constrase�a</h6>
	                                  	</div>
	                                  	<div class="col-6  m-auto" >
	                                    	<input class="text" style="color:grey;" id="c2" value=""></input>
	                                  	</div>
	                                 </div>
                                </div>
                                <br><br>

  							        <center><div class="col-md-12 overflow-hidden ">
										<div class="align-middle" >
                                    		  <button type="button" class="btn btn-warning btn-sm" onclick="comprobarContrase�a()" style= "width:80px" >
			                                    Cambiar
			                                  </button>
                                  		</div>
                                	</div> </center>                      
  						</form>
                      </div>           
					</div>
					<br><br>
					<center><h6 class="hidden" style="color:red; display: none" id="fallo">Las contrase�as deben ser iguales</h6></center>      
	
	</div>    
	
	<script>
	const comprobarContrase�a = async () =>{
		
		if (document.getElementById("c1").value == document.getElementById("c2").value) {
			document.getElementById("fallo").style.display = "none";
			document.formulario.submit();
		}else{
			document.getElementById("fallo").style.display = "block";
		}
		 
	 }
		
	
	
	
	</script>
	
	<!-- Pie de p�gina -->
    <footer class="footer fixed-bottom ">
        <div >
            <h4>2022 � Automatic License Plate Recognition</h4>
        </div>
    </footer>
</body>
</html>