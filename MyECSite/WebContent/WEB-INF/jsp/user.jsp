<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>album_details</title>
<link href="CSS/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
<link href="CSS/main.css" rel="stylesheet">
<script type="text/javascript" src="CSS/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
<!-- navbar -->
<jsp:include page="../include/header.jsp" />
<!--  user  -->

	<div class="container-fluid">
		<div class="row main border-bot">
			<h1>USERDETAIL</h1>
				<form action="Update" method="post">
				<div class="col-xs-6">
					<c:choose>
					<c:when test="${sessionScope.usb.id == 1}">
					<p>USER ID</p>
					<input type="text" class="block-mb" value="${usd.login_id}"required>
					<p>NAME</p>
					<input type="text" class="block-mb" value="${usd.name}"required>
					<p>BIRTH DATE</p>
					<input type="date" class="block-mb" value="${usd.birth_date }"required>
					<p>PASSWORD</p>
					<input type="password" class="block-mb">
					<p>EENTER PASSWORD</p>
					<input type="password" class="block-mb">
				</div>
				<div class="col-xs-6">
					<p>E-MAIL</p>
					<input type="text" class="block-mb" value="${usd.email}"required>
					<p>UPDATE</p>
					<p class="block-mb">${usd.format_Update_date}</p>
					<p>CREATEDATE</p>
					<p class="block-mb">yyyy年MM月d日HH:mm:ss</p>
					<input type="submit" class="btn btn-primary block-mt linkBtn " value="UPDATE">
					<a type="button" href="libtaty.html" class="btn btn-info block-mt linkBtn">MUSIC LIST</a>
					<a type="button" href="result.html" class="btn btn-danger block-mt linkBtn">DELETE</a>
					<a href="update_menu.html" class="btn btn-success block-mt linkBtn">admin menu</a>
				</c:when>
				<c:when test="${sessionScope.usb.id == usd.id}">
					<p>USER ID</p>
					<input type="text" class="block-mb" value="${usd.login_id }"required>
					<p>NAME</p>
					<input type="text" class="block-mb" value="${usd.name }"required>
					<p>BIRTH DATE</p>
					<input type="date" class="block-mb" value="${usd.birth_date }"required>
					<p>PASSWORD</p>
					<input type="password" class="block-mb">
					<p>EENTER PASSWORD</p>
					<input type="password" class="block-mb">
				</div>
				<div class="col-xs-6">
					<p>E-MAIL</p>
					<input type="text" class="block-mb" value="${usd.email}"required>
					<p>UPDATE</p>
					<p class="block-mb">${usd.format_Update_date }</p>
					<p>CREATEDATE</p>
					<p class="block-mb">${usd.format_Create_date }</p>
					<input type="submit" class="btn btn-primary block-mt linkBtn " value="UPDATE">
					<a type="button" href="Library" class="btn btn-info block-mt linkBtn">MUSIC LIST</a>
				</c:when>
				<c:otherwise>
					<p>USER ID</p>
					<p class="block-mb">${usd.login_id}
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
					<a type="button" href="libtaty.html" class="btn btn-info block-mt linkBtn">MUSIC LIST</a>
				</c:otherwise>
				</c:choose>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
