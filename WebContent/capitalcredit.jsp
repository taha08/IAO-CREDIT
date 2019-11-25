<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Calculer mensualite</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">

<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
	<style>
ul {  
  list-style-type: none;
    margin: -64px;
    margin-left: 115PX;
    padding: 13px;
    overflow: hidden;
}

li {
  float: left;
  
}

li a {
  display: block;
  color: #666;
  text-align: center;
 
  padding: 9px 24px;
  text-decoration: none;
}


li a.active {
  color: white;
  background-color: #ff7069;
  border-radius:130px;
}
</style>
</head>
<body>
			
			<%
		//  if(session.getAttribute("email")==null){response.sendRedirect("logincredit.jsp");}
		 response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
		response.setHeader("Pragma","no-cache, no-store, must-revalidate");
		response.setHeader("Expires","0");
		
		%>    
	<div class="limiter">
		
		<div class="container-login100" style=" padding:80px 130px 33px 95px;"">
		
			<div class="wrap-login100" style=" padding:80px 130px 33px 95px;">
                   <% if( session.getAttribute("id") != null )	{  %>
		    <i>   <h4 style="    margin-top: -44px; margin-bottom: 49px;">Bonjour <b>${username } </b></h4> </i>
		   <form action="LogoutServlet"> <button style=" border-radius:8px;   margin-top: -141px;margin-left: 646px;background-color:#6b7f9e;"class=" wrap btn btn-primary" type="submit" value="logout"> <i class="fa fa-sign-out fa-spin" aria-hidden="true"></i>Déconnexion</button></form>
<% } else {  %>	
   <li> <form action="LoginServlet"> <button style="margin-top: -86px;margin-left: 11px;background-color:#6b7f9e;"class=" wrap btn btn-primary" type="submit" value="login"> <i class="fa fa-sign-in " aria-hidden="true"></i> Se connecter</button></form></li>
   <li> <form action="RegisterServlet"> <button style="margin-top: -86px;background-color:#6b7f9e;"class=" wrap btn btn-primary" type="submit" value=" Register"> <i class="fa fa-user-plus " aria-hidden="true"></i> s'inscrire</button></form></li>
                  
<%  } %>
			  <div class="wrap-login100">
			     <ul>
		  <li><a  href="index.jsp">Annuite</a></li>
		  <li><a class="active" href="capitalcredit.jsp">Capital</a></li>
		  <li><a href="dureecredit.jsp">Duree</a></li>
		     <% if( session.getAttribute("id") != null )	{  %>
		            <li><a href="affiche">Credit</a></li>
		   <%  } %>
	
		</ul>
			  </div>

				<div class="login100-pic js-tilt" data-tilt>
					<a href="index.jsp">	<img src="images/logo.jpg" alt="IMG"> </a>
				</div>

				<form class="login100-form validate-form" method="post" action="CapitalServlet" >
					<span class="login100-form-title">
						Calcule Capital 
					</span>

					<div class="wrap-input100 validate-input" data-validate = "annuite is required">
						<input class="input100" type="number" step="any" min="1" name="annuitecap" placeholder="annuite" value=${annuite}>
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class=" fa fa-usd" aria-hidden="true"></i>
						</span>
					</div>

					<div class="wrap-input100 validate-input" data-validate = "duree is required">
						<input class="input100" type="number"  min="1" name="dureecap" placeholder="duree emprunt" value=${dureecap}>
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-clock-o" aria-hidden="true"></i>
						</span>
					</div>
						<div class="wrap-input100 validate-input" data-validate = "Taux is required">
						<input class="input100" type="number" step="any" min="0" name="tauxcap" placeholder="taux annuel " value= ${tauxcap}>
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa fa-percent" aria-hidden="true"></i>
						</span>
					</div>
					
				        
					
					<div class="container-login100-form-btn">
						<button style="background-color:#ff7069;"class="login100-form-btn" type="submit" name="calculc">
						  calculer
						</button>
					</div>
					
						  <% if( session.getAttribute("id") != null )	{  %>
     <div class="container-login100-form-btn">
						<button style="background-color:#ff7069;"class="login100-form-btn" type="submit" name="savecapital">
						  sauvgarder
						</button>
					</div>		  
<% } %>		
   	
         <% if( session.getAttribute("capital") != null )	{  %>
					<div class="text-center p-t-12">
						<span class="txt1">
			
						</span>
						<a class="txt2" href="#">
						Capital égale : <h2>  ${capital} </h2>
						</a>
					</div>
 <% } %>	
				</form>
			</div>
		</div>
	</div>
	
	

	
<!--===============================================================================================-->	
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/tilt/tilt.jquery.min.js"></script>
	<script >
		$('.js-tilt').tilt({
			scale: 1.1
		})
	</script>
<!--===============================================================================================-->
	<script src="js/main.js"></script>

</body>
</html>