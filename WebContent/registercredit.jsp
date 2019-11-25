<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <!DOCTYPE html>
<html lang="en">
<head>
	<title>S'inscrire </title>
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
</head>
<body>
    <%
			
	//	  if(session.getAttribute("email")==null){response.sendRedirect("logincredit.jsp");}
		 response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
		response.setHeader("Pragma","no-cache, no-store, must-revalidate");
		response.setHeader("Expires","0");
		
		%> 
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<div class="aaaac js-tilt" data-tilt>
					<a href="index.jsp">	<img src="images/logo.jpg" alt="IMG"> </a>
				</div>

				<form class="login100-form validate-form"  method="post" action="RegisterServlet">
					<span class="login100-form-title">
					<i class="fa fa-user-plus " aria-hidden="true"></i>	s'inscrire
					</span>
                
                <div class="wrap-input100 validate-input" data-validate = "name is required: taha" >
						<input class="input100" type="text" name="name" placeholder="Nom d'utilisateur">
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-user " aria-hidden="true"></i>
						</span>
					</div>
					
					<div class="wrap-input100 validate-input" data-validate = "Valid email is required: ex@abc.xyz">
						<input class="input100" type="text" name="email" placeholder="Email">
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-envelope " aria-hidden="true"></i>
						</span>
					</div>
					
					
					<div class="wrap-input100 validate-input" data-validate = "Telis required: XXXXXXXXXX">
						<input class="input100"  type="tel"  pattern="0[6-7]{1}[0-9]{8}" required name="tel" placeholder="Tel">
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class=" fa fa-phone-square " aria-hidden="true"></i>
						</span>
					</div>
					<div class="wrap-input100 validate-input" data-validate = "Adress is required: XX Rue ibe XXX">
						<input class="input100" type="text" name="adresse" placeholder="Adress">
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-location-arrow " aria-hidden="true"></i>
						</span>
					</div>

                    <div class="wrap-input100 validate-input" data-validate = "City is required: Rabat">
						<input class="input100" type="text" name="city" placeholder="Ville">
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-street-view " aria-hidden="true"></i>
						</span>
					</div>


					<div class="wrap-input100 validate-input" data-validate = "Password is required">
						<input class="input100" type="password" name="pass" placeholder="mot de passe">
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-lock" aria-hidden="true"></i>
						</span>
					</div>
					
					<div class="container-login100-form-btn">
						<button class="login100-form-btn" type="submit" name="login">
							s'inscrire
						</button>
					</div>

					<div class="text-center p-t-12">
						<span class="txt1">
							
						</span>
						<a class="txt2" href="logincredit.jsp">
							Se connecter
						</a>
					</div>

				</form>
			</div>
		</div>
	</div>
	
	
<%
session.setMaxInactiveInterval(2);
%>


<script type="text/javascript">
var Msgg ='<%=session.getAttribute("valid")%>';
    if (Msgg != "null") {
 function alertNamee(){
 alert(" vous avez bien enregistré");
 } 
 }
 </script> 
 
 
 <script type="text/javascript"> window.onload = alertNamee; </script>
	
	
 <script type="text/javascript">
var Msg ='<%=session.getAttribute("error")%>';
    if (Msg != "null") {
 function alertName(){
 alert("Email is exist");
 } 
 }
 </script> 
 
 <script type="text/javascript"> window.onload = alertName; </script>
	
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