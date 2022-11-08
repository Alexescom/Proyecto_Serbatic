<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="CSS/index.css">
	<meta charset="ISO-8859-1">
	<title>Insertar</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/CSS/index.css">
</head>
<body>
	<!--  Cabecera de la página -->
	<jsp:include page="../../Estaticos/Header2.jsp" />
	
	
	<div class="md-0  float-left" style="position: absolute ;margin-left: 5px " >
      <br>
      <a href="<%= request.getContextPath() %>/ProveedoresServlet?Operacion=Index" style="text-decoration: none; color: black">
      <h5> &#10094 &nbsp Volver atrás</h5>
      </a>
    </div>
	
	
	<!-- Sección central -->
	<div class="container">

		<br>
		<br>
                         <div class="bg-light col-md-8 mx-auto overflow-auto p-3 rounded border border-3"  >
                          <form id="form" class="card card-body my-auto" action= "<%= request.getContextPath() %>/ProveedoresServlet?Operacion=Insertar" method= "POST" >

                              <div class="col-12  border-right" >
                                <h3 class="text-center"> Información del proveedor:</h3>
                                <hr class="mb-12">
                                <br></br>
                                <div class="col-md-12" >
                                	<div class="row justify-content-md-center">
                                		<div class="col-6">
	                                    	<h6 class="text-right"> &#11166 &nbsp Correo:</h6>
	                                  	</div>
	                                  	<div class="col-6  m-auto" >
	                                    	<input class="text" style="color:grey;" name="Email"></input>
	                                  	</div>
	                                 </div>
                                </div>
                                <br></br>
                                <div class="col-md-12 overflow-hidden  float-right">
                                	<div class="row justify-content-md-center">
                                		<div class="col-6">
                                    		<h6 class="text-right"> &#11166 &nbsp CIF:</h6>
                                  		</div>
										<div class="col-6  m-auto" >
                                    		<input class="text" style="color:grey;"  name="Cif"></input>
                                  		</div>
                                	</div>
                                </div>
                                <br><br>
                                <div class="col-md-12 overflow-hidden  float-right">
                                	<div class="row justify-content-md-center">
                                		<div class="col-6">
                                    		<h6 class="text-right"> &#11166 &nbsp Nombre:</h6>
                                  		</div>
										<div class="col-6  m-auto" >
                                    		<input class="text" style="color:grey;"  name="Nombre"></input>
                                  		</div>
                                	</div>
                                </div>
                                <br><br>                             
                                <div class="col-md-12 overflow-hidden  float-right">
                                	<div class="row justify-content-md-center">
                                		<div class="col-6">
                                    		<h6 class="text-right"> &#11166 &nbsp Dirección:</h6>
                                  		</div>
										<div class="col-6  m-auto" >
                                    		<input class="text" style="color:grey;"  name="Direccion"></input>
                                  		</div>
                                	</div>
                                </div>
                                <br><br>
                                <div class="col-md-12 overflow-hidden  float-right">
                                	<div class="row justify-content-md-center">
                                		<div class="col-6">
                                    		<h6 class="text-right"> &#11166 &nbsp Provincia:</h6>
                                  		</div>
										<div class="col-6  m-auto" >
                                    		<input class="text" style="color:grey;"  name="Provincia"></input>
                                  		</div>
                                	</div>
                                </div>
                                <br><br>
                                <div class="col-md-12 overflow-hidden  float-right">
                                	<div class="row justify-content-md-center">
                                		<div class="col-6">
                                    		<h6 class="text-right"> &#11166 &nbsp Localidad:</h6>
                                  		</div>
										<div class="col-6  m-auto" >
                                    		<input class="text" style="color:grey;"  name="Localidad"></input>
                                  		</div>
                                	</div>
                                </div>
                                <br><br>
                                <div class="col-md-12 overflow-hidden  float-right">
                                	<div class="row justify-content-md-center">
                                		<div class="col-6">
                                    		<h6 class="text-right"> &#11166 &nbsp Telefono:</h6>
                                  		</div>
										<div class="col-6  m-auto" >
                                    		<input class="number" type="number" style="color:grey;"  name="Telefono"></input>
                                  		</div>
                                	</div>
                                </div>
                                <br><br>
                                <div class="col-md-12 overflow-hidden  float-right">
                                	<div class="row justify-content-md-center">
                                		<div class="col-6">
                                    		<h6 class="text-right">Insertar nuevo proveedor: </h6>
                                  		</div>
										<div class="col-6  m-auto" >
                                    		  <button type="submit" class="btn btn-warning btn-sm" style= "width:80px" >
			                                    Insertar
			                                  </button>
                                  		</div>
                                	</div>
                                </div>
                                <br><br>
  								</div>                           
  						</form>
                      </div>      
                      <br></br><br><br><br>     
	
	
	</div>  
	
	
	
	
	
	
	<!-- Pie de página -->
	<footer class="footer fixed-bottom ">
	     <div >
	            <h4>2022 © Proyecto Serbatic</h4>
	     </div>
	</footer>
	
</body>
</html>