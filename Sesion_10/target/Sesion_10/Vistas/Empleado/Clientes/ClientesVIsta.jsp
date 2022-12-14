<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<%= request.getContextPath() %>/CSS/index.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Cliente</title>
</head>
<body>

	<!--  Cabecera de la p?gina -->
	<jsp:include page="../../Estaticos/Header2.jsp" />
	
	
	<div class="md-0  float-left" style="position: absolute ;margin-left: 5px " >
      <br>
      <a href="<%= request.getContextPath() %>/UsuariosServlet?Entidad=Empleado&Operacion=Index" style="text-decoration: none; color: black">
      <h5> &#10094 &nbsp Volver atr?s</h5>
      </a>
    </div>
	
	
	<!-- Secci?n central -->
	<div class="container">

		<br>
		<br>
		            <%@page import="dao.pojos.Usuario" %>
		            <%@page import="java.text.DecimalFormat" %>
		            <%
		            	String tipoCliente;
		           		Usuario usuario = (Usuario)request.getAttribute("Usuario");
		            	DecimalFormat df = new DecimalFormat("###.##");
		            	if (usuario.getId_rol() == 1){
		            		tipoCliente = "Cliente";
		            	}else if (usuario.getId_rol() == 2){
		            		tipoCliente = "Administrador";
		            	}else{
		            		tipoCliente = "Empleado";
		            	}
		            %>
                         <div class="bg-light col-md-8 mx-auto overflow-auto p-3 rounded border border-3"  >
                          <form id="form" class="card card-body my-auto" action= "<%= request.getContextPath() %>/UsuariosServlet?Entidad=Empleado&Operacion=Modificar&Id=<%=usuario.getId()%>" method= "POST" >

                              <div class="col-12  border-right" >
                                <h3 class="text-center"> Informaci?n personal:</h3>
                                <hr class="mb-12">
                                <br></br>
                                <div class="col-md-12" >
                                	<div class="row justify-content-md-center">
                                		<div class="col-6">
	                                    	<h6 class="text-right"> &#11166 &nbsp Correo:</h6>
	                                  	</div>
	                                  	<div class="col-6  m-auto" >
	                                    	<input class="text" style="color:grey;" value=<%=usuario.getEmail()%> name="Email"></input>
	                                  	</div>
	                                 </div>
                                </div>
                                <br></br>
                                <div class="col-md-12 overflow-hidden  float-right">
                                	<div class="row justify-content-md-center">
                                		<div class="col-6">
	                                    	<h6 class="text-right"> &#11166 &nbsp Contrase?a:</h6>
	                                  	</div>
	                                  	<div class="col-6  m-auto" >
	                                    	<input class="text" style="color:grey;" value=<%=usuario.getClave()%> name="Password"></input>
	                                  	</div>
	                                 </div>
                                </div>
                                <br><br>
                                <div class="col-md-12 overflow-hidden  float-right">
                                	<div class="row justify-content-md-center">
                                		<div class="col-6">
                                    		<h6 class="text-right"> &#11166 &nbsp DNI/NIE:</h6>
                                  		</div>
										<div class="col-6  m-auto" >
                                    		<input class="text" style="color:grey;" value=<%=usuario.getDni()%> name="Dni"></input>
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
                                    		<input class="text" style="color:grey;" value=<%=usuario.getNombre()%> name="Nombre"></input>
                                  		</div>
                                	</div>
                                </div>
                                <br><br>
                                <div class="col-md-12 overflow-hidden  float-right">
                                	<div class="row justify-content-md-center">
                                		<div class="col-6">
                                    		<h6 class="text-right"> &#11166 &nbsp Primer apellido:</h6>
                                  		</div>
										<div class="col-6  m-auto" >
                                    		<input class="text" style="color:grey;" value=<%=usuario.getApellido1()%> name="Apellido1"></input>
                                  		</div>
                                	</div>
                                </div>
                                <br><br>
                                <div class="col-md-12 overflow-hidden  float-right">
                                	<div class="row justify-content-md-center">
                                		<div class="col-6">
                                    		<h6 class="text-right"> &#11166 &nbsp Segundo apellido:</h6>
                                  		</div>
										<div class="col-6  m-auto" >
                                    		<input class="text" style="color:grey;" value=<%=usuario.getApellido2()%> name="Apellido2"></input>
                                  		</div>
                                	</div>
                                </div>   
                                <br><br>                             
                                <div class="col-md-12 overflow-hidden  float-right">
                                	<div class="row justify-content-md-center">
                                		<div class="col-6">
                                    		<h6 class="text-right"> &#11166 &nbsp Direcci?n:</h6>
                                  		</div>
										<div class="col-6  m-auto" >
                                    		<input class="text" style="color:grey;" value=<%=usuario.getDireccion()%> name="Direccion"></input>
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
                                    		<input class="text" style="color:grey;" value=<%=usuario.getProvincia()%> name="Provincia"></input>
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
                                    		<input class="text" style="color:grey;" value=<%=usuario.getLocalidad()%> name="Localidad"></input>
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
                                    		<input class="number" type="number" style="color:grey;" value=<%=usuario.getTelefono()%> name="Telefono"></input>
                                  		</div>
                                	</div>
                                </div>
                                <br><br>
                                <div class="col-md-12 overflow-hidden  float-right">
                                	<div class="row justify-content-md-center">
                                		<div class="col-6">
                                    		<h6 class="text-right">Si desea editar los datos: </h6>
                                  		</div>
										<div class="col-6  m-auto" >
                                    		  <button type="submit" class="btn btn-warning btn-sm" style= "width:80px" >
			                                    Editar
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
	
	
	<!-- Pie de p?gina -->
    <footer class="footer fixed-bottom ">
        <div >
            <h4>2022 ? Automatic License Plate Recognition</h4>
        </div>
    </footer>
</body>
</html>