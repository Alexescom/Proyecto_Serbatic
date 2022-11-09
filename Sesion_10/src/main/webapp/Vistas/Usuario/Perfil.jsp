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

	
	<% 
	Usuario usuario = (Usuario)request.getAttribute("Usuario");
	
	if (usuario.getId_rol() == 1){%>
		<!--  Cabecera de la p�gina -->
		<jsp:include page="../Estaticos/Header.jsp" />
	<%} else if (usuario.getId_rol() == 3){%>
		<!--  Cabecera de la p�gina -->
		<jsp:include page="../Estaticos/Header2.jsp" />
	
	<%}%>
	
	
	
	<!-- Secci�n central -->
	<div class="container">

		<br>
		<br>
		            <%@page import="dao.pojos.Usuario" %>
		            <%@page import="java.text.DecimalFormat" %>
		            <%
		            	String tipoCliente;
		            	DecimalFormat df = new DecimalFormat("###.##");
		            	if (usuario.getId_rol() == 1){
		            		tipoCliente = "Cliente";
		            	}else if (usuario.getId_rol() == 2){
		            		tipoCliente = "Administrador";
		            	}else{
		            		tipoCliente = "Empleado";
		            	}
		            %>
                         <div class="bg-light col-md-11 mx-auto overflow-auto p-3 rounded border border-3"  >
                          <form id="form" class="card card-body my-auto" action= "<%= request.getContextPath() %>/UsuarioServlet?Operacion=Editar" method= "POST" enctype="multipart/form-data">
                          	<div class="row">
                              <div class="col-6 overflow-auto border-right" >
                                <h3 class="text-center"> Informaci�n personal:</h3>
                                <hr class="mb-12">
                                <br></br>
                                <div class="col-md-12" >
                                	<div class="row justify-content-md-center">
                                		<div class="col-6">
	                                    	<h6 class="text-right"> &#11166 &nbsp Correo:</h6>
	                                  	</div>
	                                  	<div class="col-6  m-auto" >
	                                    	<h6  style="color:grey;"><%=usuario.getEmail()%></h6>
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
                                    		<h6 class="text-right"> &#11166 &nbsp Direcci�n:</h6>
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
  								
  								<div class="col-md-6 overflow-auto">
                                <h3 class="text-center"> Informaci�n Cuenta:</h3>
                                <hr class="mb-12">
                                <br></br>
                                <div class="col-md-12 overflow-hidden  float-right">
                                	<div class="row justify-content-md-center">
                                		<div class="col-6">
                                    		<h6 class="text-right"> &#11166 &nbsp Tipo de cuenta:</h6>
                                  		</div>
										<div class="col-6  m-auto" >
                                    		<h6 style="color:grey;"><%=tipoCliente%></h6>
                                  		</div>
                                	</div>
                                </div>
                                <br><br>
                                <div class="col-md-12 overflow-hidden  float-right">
                                	<div class="row justify-content-md-center">
                                		<div class="col-6">
                                    		<h6 class="text-right"> &#11166 &nbsp Cambiar contrase�a:</h6>
                                  		</div>
										<div class="col-6  m-auto" >
		                                  	<a href="<%= request.getContextPath() %>/Contrase�aServlet?Operacion=Ver" style="text-decoration: none; color: white">
		                                    	<button type = "button" class ="btn btn-primary">
		                                   
		                                    			Cambiar contrase�a
		                                    		
		                                    	</button>
		                                    </a>
                                  		</div>
                                	</div>
                                </div>
                                <br><br>
                                <div class="col-md-12 overflow-hidden  float-right">
                                	<div class="row justify-content-md-center">
                                		<div class="col-5">
                                    		<h6 class="text-right"> &#11166 &nbsp Cambiar foto de perfil:</h6>
                                  		</div>
										<div class="col-7  m-auto" >
											<div >
	                                    		<input class="text" type="file" style="color:grey;" accept="image/png, image/jpeg" value="<%= request.getContextPath() %>/Sources/Imagenes/Perfiles/<%= usuario.getImagen() %>" name="Imagen"></input>
	                                  		</div>
		                                    
                                  		</div>
                                	</div>
                                </div>    
                                <br><br>                    
                                <center><div class="col-lg-12 ">
									<img class="bd-placeholder-img rounded-circle" src ="<%= request.getContextPath() %>/Sources/Imagenes/Perfiles/<%= usuario.getImagen() %>" width="340" height="340"></img>
							        <h2 class="fw-normal">Foto de perfil</h2>
							     </div></center>
                                <br></br><br>
                                <div class="col-md-12 overflow-hidden  float-right">
                                	<div class="row justify-content-md-center">
		                                <div class="col-7">
		                                    <h6> Si desea cerrar sesi�n pulse el bot�n:</h6>
		                                </div>
		                                <div class="col-2 float-right "  >
		                                	<a href="LogoutServlet" >
		                                  		<button type="button" class="btn-sm btn-secondary " style= "width:140px;margin-right:0px" >
				                                    Cerrar sesi�n
				                               </button>
				                            </a>
		                                </div>
		                             </div>
  								</div>
  							</div>	
  						  </div>
  						</form>
                      </div>      
                      <br></br><br><br><br>     
	
	
	</div>    
	
	
	<!-- Pie de p�gina -->
    <footer class="footer fixed-bottom ">
        <div >
            <h4>2022 � Automatic License Plate Recognition</h4>
        </div>
    </footer>
</body>
</html>