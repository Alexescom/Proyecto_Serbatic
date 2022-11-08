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
		<!--  Cabecera de la página -->
		<jsp:include page="../Estaticos/Header.jsp" />
	<%} else if (usuario.getId_rol() == 3){%>
		<!--  Cabecera de la página -->
		<jsp:include page="../Estaticos/Header2.jsp" />
	
	<%}%>
	
	
	
	<!-- Sección central -->
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
                          <form id="form" class="card card-body my-auto" action= "<%= request.getContextPath() %>/UsuarioServlet?Operacion=Editar" method= "POST" >
                          	<div class="row">
                              <div class="col-6 overflow-auto border-right" >
                                <h3 class="text-center"> Información personal:</h3>
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
                                    		<h6 class="text-right"> &#11166 &nbsp Dirección:</h6>
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
                                <h3 class="text-center"> Información Cuenta:</h3>
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
                                    		<h6 class="text-right"> &#11166 &nbsp Cambiar contraseña:</h6>
                                  		</div>
										<div class="col-6  m-auto" >
		                                  	<a href="<%= request.getContextPath() %>/ContraseñaServlet?Operacion=Ver" style="text-decoration: none; color: white">
		                                    	<button type = "button" class ="btn btn-primary">
		                                   
		                                    			Cambiar contraseña
		                                    		
		                                    	</button>
		                                    </a>
                                  		</div>
                                	</div>
                                </div>
                         
                                
                                <br></br><br><br></br><br><br></br><br><br></br><br><br></br><br><br></br><br><br></br><br><br><br><br><br>
                                <div class="col-md-12 overflow-hidden  float-right">
                                	<div class="row justify-content-md-center">
		                                <div class="col-7">
		                                    <h6> Si desea cerrar sesión pulse el botón:</h6>
		                                </div>
		                                <div class="col-2 float-right "  >
		                                	<a href="LogoutServlet" >
		                                  		<button type="button" class="btn-sm btn-secondary " style= "width:140px;margin-right:0px" >
				                                    Cerrar sesión
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
	
	
	<!-- Pie de página -->
    <footer class="footer fixed-bottom ">
        <div >
            <h4>2022 © Automatic License Plate Recognition</h4>
        </div>
    </footer>
</body>
</html>