<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="ja">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>update_album</title>
<!-- favicon  -->
<link rel="icon" href="./ico/favi.ico">
<link href="CSS/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
<link href="CSS/main.css" rel="stylesheet">

</head>
<body>
<!-- navbar -->
<jsp:include page="../include/header.jsp" />
<!--  body  -->

<div class="container-fluid">
	<div class="row main">
		<div class="col-xs-12">
			<p class ="result">${resultMessage}　</p>
			<p class ="error">${errorMessage}　</p>
			<h1>UPDATE ALBUM</h1>
		</div>

		<c:if test="${album == null}" var="flg" />
		<c:if test="${!flg}" >
		<div class="col-sm-6">
			<img src="./img/${album.image}" class="detail_img">
		</div>
		<form action="Update_Album" method="post" enctype='multipart/form-data' data-ajax="false">
		<div class="col-sm-6">
			<input type="submit" name="submit" class="btn btn-primary" value="UPDATE">
		</div>
		<div class="col-sm-6">
			<p>album jacket image file(1:1)
			<input type="file" name ="image" accept='image/*'>
			<input type="checkbox" name ="delete">　ジャケットを削除</p>
			<p>album name</p>
			<input type="text" name="name" value="${album.al_name }"required>
			<input type="hidden" name="al_id" value="${album.al_id}">
			<input type="hidden" name="default" value="${album.image}">
		</div>
		<div class="col-sm-6">
			<p>RELEASE DATE : ${album.release_date }</p>
		</div>
		</form>

		</c:if>
		<c:if test="${flg}" >

		<form action="Update_Album" method="post" enctype='multipart/form-data' data-ajax="false">
		<div class="col-xs-12">
			<input type="submit" name="submit" class="btn btn-success" value="ADD">
		</div>
		<div class="col-xs-6">
			<p>album jacket image file(1:1)
			<input type="file" name="image"></p>
			<p>album name</p>
			<input type="text" name="name" required>

		</div>
		<div class="col-xs-12">
			<p>RELEASE DATE :  today</p>
		</div>
		</form>


		</c:if>
		</div>
	</div>
</body>
</html>
