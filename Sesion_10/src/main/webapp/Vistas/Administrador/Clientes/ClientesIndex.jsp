<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="/docs/4.0/assets/img/favicons/favicon.ico">
    <title>Clientes</title>
    <link rel="canonical" href="https://getbootstrap.com/docs/4.0/examples/dashboard/">
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <!-- Custom styles for this template -->
    <link href="dashboard.css" rel="stylesheet">
  <style type="text/css">/* Chart.js */
@-webkit-keyframes chartjs-render-animation{from{opacity:0.99}to{opacity:1}}@keyframes chartjs-render-animation{from{opacity:0.99}to{opacity:1}}.chartjs-render-monitor{-webkit-animation:chartjs-render-animation 0.001s;animation:chartjs-render-animation 0.001s;}</style></head>
<body>
		<!--  Cabecera de la página -->
		<jsp:include page="../../Estaticos/Header3.jsp" />


        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4"><div class="chartjs-size-monitor" style="position: absolute; inset: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;"><div class="chartjs-size-monitor-expand" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:1000000px;height:1000000px;left:0;top:0"></div></div><div class="chartjs-size-monitor-shrink" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:200%;height:200%;left:0; top:0"></div></div></div>
 			<div class="col-md-10 p-2">
					<br>
					<div>
						<h2> CLIENTES EN EL SISTEMA </h2>
						
					</div>

					<br><br>
					<div class="md-10 float left">
				 	<table class="table table-striped table-dark " style="margin-left:30px">
					      <thead class="thead-dark">
					        <tr>
					        <th style="width: 50px; color:yellow" scope="col">#</th>
					        <th style="width: 200px" scope="col">Email</th>
					        <th style="width: 200px" scope="col">Nombre</th>
					        <th style="width: 200px" scope="col">Primer apellido</th>
					        <th style="width: 200px" scope="col">Segundo apellido</th>
					        <th style="width: 200px" scope="col">Baja</th>
					        <th style="width: 200px" scope="col">Eliminar</th>
					        </tr>
					      </thead>
		            <%@page import="java.util.ArrayList" %>
		            <%@page import="dao.pojos.Usuario" %>
		            <%@page import="java.text.DecimalFormat" %>
		            <%
		            	int i = 0;
		            	DecimalFormat df = new DecimalFormat("###.##");
		            	ArrayList <Usuario> usuarios = (ArrayList<Usuario>)request.getAttribute("Clientes");
		                if (usuarios != null){
		                	for (Usuario a: usuarios){
		                		i++;
					%>
	
 							<tr>
								<td style="vertical-align:middle"><%= i%></td>
				                <td style="vertical-align:middle"><%= a.getEmail()%></td>
				                <td style="vertical-align:middle"><%= a.getNombre() %></td>
				                <td style="vertical-align:middle"><%= a.getApellido1() %></td>
				                <td style="vertical-align:middle"><%= a.getApellido2() %></td>
				                <td style="vertical-align:middle"><%= a.getBaja() %></td>
				                <td style="vertical-align:middle">
				                	 <a href="UsuariosServlet?Entidad=Admin&Operacion=Eliminar&Id=<%= a.getId() %>">
		                            	<button type="button" class="btn btn-warning" style="width: 100px;">Eliminar</button>
		                            </a>
				                </td>

		              		</tr>
						
    
            	<%}%>
            <%}%>
            </table></div>
			</div>
        </main>
      </div>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
    <script src="../../assets/js/vendor/popper.min.js"></script>
    <script src="../../dist/js/bootstrap.min.js"></script>

    <!-- Icons -->
    <script src="https://unpkg.com/feather-icons/dist/feather.min.js"></script>
    <script>
      feather.replace()
    </script>

    <!-- Graphs -->
    <script src="https://cdn.jsdelivr.net/npm/chart.js@2.7.1/dist/Chart.min.js"></script>
    <script>
      var ctx = document.getElementById("myChart");
      var myChart = new Chart(ctx, {
        type: 'line',
        data: {
          labels: ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"],
          datasets: [{
            data: [15339, 21345, 18483, 24003, 23489, 24092, 12034],
            lineTension: 0,
            backgroundColor: 'transparent',
            borderColor: '#007bff',
            borderWidth: 4,
            pointBackgroundColor: '#007bff'
          }]
        },
        options: {
          scales: {
            yAxes: [{
              ticks: {
                beginAtZero: false
              }
            }]
          },
          legend: {
            display: false,
          }
        }
      });
    </script>
  

</body>
</html>