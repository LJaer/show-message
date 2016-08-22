<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<meta name="keywords"
	content="Flat Dark Web Login Form Responsive Templates, Iphone Widget Template, Smartphone login forms,Login form, Widget Template, Responsive Templates, a Ipad 404 Templates, Flat Responsive Templates" />
<link href="${pageContext.request.contextPath}/css/admin/login.css"
	rel='stylesheet' type='text/css' />
<!--webfonts-->
<link
	href='http://fonts.useso.com/css?family=PT+Sans:400,700,400italic,700italic|Oswald:400,300,700'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.useso.com/css?family=Exo+2' rel='stylesheet'
	type='text/css'>
<!--//webfonts-->
<script
	src="http://ajax.useso.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
</head>
<body>
	<script>
		$(document).ready(function(c) {
			$('.close').on('click', function(c) {
				$('.login-form').fadeOut('slow', function(c) {
					$('.login-form').remove();
				});
			});
		});
		function checkUser(){
			$.post(
				'/show-message/checkUser.action',
				{
					name:$("#name").val(),
					password:$("#password").val()
				},
				function(data){
					if(data!=""){
						var user = data;
						var username = data.name;
						setCookie("username",username);
						window.self.location = "/show-message/admin";
					}else{
						alert("账号或密码错误");
					}
				}
			);
		}
		function setCookie(name,value)
		{
		  var Days = 30; //此 cookie 将被保存 30 天
		  var exp  = new Date();    //new Date("December 31, 9998");
		  exp.setTime(exp.getTime() + Days*24*60*60*1000);
		  document.cookie = name + "="+ escape(value) +";expires="+ exp.toGMTString();
		}
	</script>
	<!--SIGN UP-->
	<h1>klasikal Login Form</h1>
	<div class="login-form">
		<div class="close"></div>
		<div class="head-info">
			<label class="lbl-1"> </label> <label class="lbl-2"> </label> <label
				class="lbl-3"> </label>
		</div>
		<div class="clear"></div>
		<div class="avtar">
			<img
				src="${pageContext.request.contextPath}/pictures/login/avtar.png" />
		</div>
		<form>
			<input type="text" name="name" id="name" class="text" value="Username" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Username';}">
			<div class="key">
				<input type="password"  id="password" value="Password" name="password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}">
			</div>
			<div class="signin">
		</div>
		</form>
			<input type="submit" value="Login" onclick="checkUser()">
		
	</div>
	<div class="copy-rights">
		<p>Copyright &copy; 2015.Company name All rights reserved.More Templates</p>
	</div>
</body>
</html>