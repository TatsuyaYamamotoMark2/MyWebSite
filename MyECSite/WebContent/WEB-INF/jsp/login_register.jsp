<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>login_register</title>
<link href="CSS/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
<link href="CSS/main.css" rel="stylesheet">
<script type="text/javascript" src="CSS/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script></head>
<body>
 <!-- navbar -->
<jsp:include page="../include/header.jsp" />
<!--  body  -->
	<div class="container-fluid">
		<div class="row main">
			<p class ="result">${resultMessage}　</p>
			<p class ="error">${errorMessage}　</p>
			<h1>LOGIN/REGISTER</h1>
			<div class="col-xs-6">
				<form action="Login_register" method="post">
					<h4>LOGIN</h4>
					<p>LOGIN ID</p>
					<input type="text" class="block-mb"size="15" name="login_id"required>
					<p>PASSWORD</p>
					<input type="password" class="block-mb"size="15"  name="password"required>
					<input type="submit" class="btn btn-primary block-mt linkBtn" value="LOGIN">
				</form>
			</div>
			<div class="col-xs-6 border-left">
				<form action="Register" method="post">
					<h4>REGISTER</h4>
					<p>E-MAIL</p>
					<input type="text" class="block-mb"size="15"  name="email"required>
					<p>NAME</p>
					<input type="text" class="block-mb"size="15"  name="name"required>
					<p>LOGIN ID</p>
					<input type="text" class="block-mb"size="15"  name="login_id"required>
					<p>BIRTH DATE</p>
					<input type="date" class="block-mb"size="15"  name="birth_date"required>
					<p>PASSWORD</p>
					<input type="password" class="block-mb"size="15"  name="password"required>
					<p>REENTER PASSWORD</p>
					<input type="password" class="block-mb"size="15"  name="verification_password"required>
					<input type="submit" class="btn btn-primary block-mt linkBtn" value="REGISTER"></a>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
