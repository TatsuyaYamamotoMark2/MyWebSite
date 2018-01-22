<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>album_details</title>
<!-- favicon  -->
<link rel="icon" href="./ico/favi.ico">
<link href="CSS/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
<link href="CSS/main.css" rel="stylesheet">
<script type="text/javascript" src="CSS/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script></head>
<body>
<!-- navbar -->
<jsp:include page="../include/header.jsp" />
<!--  user  -->

	<div class="container-fluid">
		<div class="row main border-bot">
			<p class ="error">${errorMessage}</p>
			<p class ="result">${resultMessage}</p>
			<h1>USERDETAIL</h1>
				<form action="Update" method="post">
				<input type ="hidden" value="${usd.id}" name="user_id">
				<div class="col-xs-6">
					<c:choose>
					<c:when test="${sessionScope.usb.id == 1}">
					<p>LOGIN ID</p>
					<input type="text" class="block-mb"size="15"  value="${usd.login_id}" required name="login_id">
					<p>NAME</p>
					<input type="text" class="block-mb" size="15" value="${usd.name}"required name="name">
					<p>BIRTH DATE</p>
					<input type="date" class="block-mb "size="15"  value="${usd.birth_date }"required name="birth_date">
					<p>PASSWORD</p>
					<input type="password" class="block-mb " size="15" name="password">
					<p>EENTER PASSWORD</p>
					<input type="password" class="block-mb " size="15" name="verification_password">
				</div>
				<div class="col-xs-6">
					<p>E-MAIL</p>
					<input type="text" class="block-mb "size="15"  value="${usd.email}"required name="email">
					<p>UPDATE</p>
					<p class="block-mb">${usd.format_Update_date}</p>
					<p>CREATEDATE</p>
					<p class="block-mb">${usd.format_Create_date}</p>
					<input type="submit" class="btn btn-primary block-mt linkBtn " value="UPDATE">
					<a type="button" href="Library?id=${usd.id }" class="btn btn-info block-mt linkBtn">MUSIC LIST</a>
			</form>
					<form id="delete_form" action="User_delete" method="post">
					<input type ="hidden" value="${usd.id}" name="user_id" form="delete_form">
					<input type="submit" class="btn btn-danger block-mt linkBtn" value="DELETE" form="delete_form"></form>

					<a href="Admin_menu" class="btn btn-success block-mt linkBtn">ADMIN MENU</a>
				</div>
				</c:when>
				<c:when test="${sessionScope.usb.id == usd.id}">
					<p>LOGIN ID</p>
					<input type="text" class="block-mb" value="${usd.login_id }"required name="login_id">
					<p>NAME</p>
					<input type="text" class="block-mb" value="${usd.name }"required name="name">
					<p>BIRTH DATE</p>
					<input type="date" class="block-mb" value="${usd.birth_date }"required name="birth_date">
					<p>PASSWORD</p>
					<input type="password" class="block-mb" name="password">
					<p>EENTER PASSWORD</p>
					<input type="password" class="block-mb" name="verification_password">
				</div>
				<div class="col-xs-6">
					<p>E-MAIL</p>
					<input type="text" class="block-mb" value="${usd.email}"required name="email">
					<p>UPDATE</p>
					<p class="block-mb">${usd.format_Update_date }</p>
					<p>CREATEDATE</p>
					<p class="block-mb">${usd.format_Create_date }</p>
					<input type="submit" class="btn btn-primary block-mt linkBtn " value="UPDATE">
					<a type="button" href="Library?id=${usd.id }" class="btn btn-info block-mt linkBtn">MUSIC LIST</a>
				</div>
			</form>
				</c:when>
				<c:otherwise>

					<p>NAME</p>
					<p class="block-mb">${usd.name}
					<p>BIRTH DATE</p>
					<p class="block-mb">${usd.format_Birth_date }
				</div>
				<div class="col-xs-6">
					<p>UPDATE</p>
					<p class="block-mb">${usd.format_Update_date }</p>
					<p>CREATEDATE</p>
					<p class="block-mb">${usd.format_Create_date }</p>
					<a type="button" href="Library?id=${usd.id }" class="btn btn-info block-mt linkBtn">MUSIC LIST</a>
				</div>
			</form>
				</c:otherwise>
				</c:choose>
		</div>
	</div>
</body>
</html>
