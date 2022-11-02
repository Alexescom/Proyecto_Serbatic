<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="<%= request.getContextPath() %>/CSS/index.css">
<title>Producto</title>
</head>
<body>

	<!--  Cabecera de la página -->
	<jsp:include page="../../Estaticos/Header2.jsp" />
	
	
	<div class="md-0  float-left" style="position: absolute ;margin-left: 5px " >
      <br>
      <a href="<%= request.getContextPath() %>/ProductosServlet?Entidad=Empleado&Operacion=Index" style="text-decoration: none; color: black">
      <h5> &#10094 &nbsp Volver atrás</h5>
      </a>
    </div>
	
	
	<!-- Sección central -->
	<div class="container">

		<br>
		<br>
		            <%@page import="dao.pojos.Articulo" %>
		            <%@page import="java.text.DecimalFormat" %>
		            <%
		            	String tipoCliente;
		           		Articulo articulo = (Articulo)request.getAttribute("Articulo");
		            	DecimalFormat df = new DecimalFormat("###.##");
		            %>
                         <div class="bg-light col-md-8 mx-auto overflow-auto p-3 rounded border border-3"  >
                          <form id="form" class="card card-body my-auto" action= "<%= request.getContextPath() %>/ProductosServlet?Entidad=Empleado&Operacion=Modificar&Id=<%=articulo.getId()%>" method= "POST" >

                              <div class="col-12  border-right" >
                                <h3 class="text-center"> Información del producto:</h3>
                                <hr class="mb-12">
                                <br></br>
                                <div class="col-md-12" >
                                	<div class="row justify-content-md-center">
                                		<div class="col-6">
	                                    	<h6 class="text-right"> &#11166 &nbsp Nombre:</h6>
	                                  	</div>
	                                  	<div class="col-6  m-auto" >
	                                    	<input class="text" style="color:grey;" value=<%=articulo.getNombre()%> name="Nombre"></input>
	                                  	</div>
	                                 </div>
                                </div>
                                <br></br>
                                <div class="col-md-12" >
                                	<div class="row justify-content-md-center">
                                		<div class="col-6">
	                                    	<h6 class="text-right"> &#11166 &nbsp Categoría:</h6>
	                                  	</div>
	                                  	<div class="col-6  m-auto" >
	                                    	<input class="text" style="color:grey;" value=<%=articulo.getId_categoria()%> name="Id_categoria"></input>
	                                  	</div>
	                                 </div>
                                </div>
                                <br></br>
                                <div class="col-md-12 overflow-hidden  float-right">
                                	<div class="row justify-content-md-center">
                                		<div class="col-6">
	                                    	<h6 class="text-right"> &#11166 &nbsp Descripcion:</h6>
	                                  	</div>
	                                  	<div class="col-6  m-auto" >
	                                    	<input class="text" style="color:grey;" value=<%=articulo.getDescripcion()%> name="Descripcion"></input>
	                                  	</div>
	                                 </div>
                                </div>
                                <br><br>
                                <div class="col-md-12 overflow-hidden  float-right">
                                	<div class="row justify-content-md-center">
                                		<div class="col-6">
                                    		<h6 class="text-right"> &#11166 &nbsp Precio:</h6>
                                  		</div>
										<div class="col-6  m-auto" >
                                    		<input class="text" style="color:grey;" value=<%=articulo.getPrecio()%> name="Precio"></input>
                                  		</div>
                                	</div>
                                </div>
                                <br><br>
                                <div class="col-md-12 overflow-hidden  float-right">
                                	<div class="row justify-content-md-center">
                                		<div class="col-6">
                                    		<h6 class="text-right"> &#11166 &nbsp Stock:</h6>
                                  		</div>
										<div class="col-6  m-auto" >
                                    		<input class="text" style="color:grey;" value=<%=articulo.getStock()%> name="Stock"></input>
                                  		</div>
                                	</div>
                                </div>
                                <br><br>
                                <div class="col-md-12 overflow-hidden  float-right">
                                	<div class="row justify-content-md-center">
                                		<div class="col-6">
                                    		<h6 class="text-right"> &#11166 &nbsp Impuesto:</h6>
                                  		</div>
										<div class="col-6  m-auto" >
                                    		<input class="text" style="color:grey;" value=<%=articulo.getImpuesto()%> name="Impuesto"></input>
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
	
	
	<!-- Pie de página -->
    <footer class="footer fixed-bottom ">
        <div >
            <h4>2022 © Automatic License Plate Recognition</h4>
        </div>
    </footer>
</body>
</html>