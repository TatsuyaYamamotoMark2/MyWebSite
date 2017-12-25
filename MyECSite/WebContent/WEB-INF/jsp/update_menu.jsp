<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="ja">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>update_menu</title>
<link href="CSS/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
<link href="js/select2-4.0.6-rc.1/dist/css/select2.css" rel="stylesheet">
<link href="CSS/main.css" rel="stylesheet">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>

<script src="js/select2-4.0.6-rc.1/dist/js/select2.min.js"></script>
<script src="js/selectfanction.js"></script>
</head>
<body>
<!-- navbar -->
<jsp:include page="../include/header.jsp" />
<!--  body  -->

	<div class="container-fluid">
		<div class="row main">
		<p class="result">${resultMessage}　</p>
		<p class="error">${errorMessage}　</p>
			<h1>ADD/UPDATE</h1>
			<div class="col-sm-4">
				<h4>ALBUM</h4>
				<form action="Update_Album" method="get">
					<select name="select" class="select" style="width: 190px">
						<c:forEach var="album" items="${albumList}">
						<option value="${album.al_id }">${album.al_name}</option>
						</c:forEach>
					</select>
					<div class="block-mt">
						<input type="submit" name="submit" value="update" class="btn btn-primary">
						<input type="submit" name="submit" value="delete" class="btn btn-danger">
						<input type="submit" name="submit" value="new" class="btn btn-success">
					</div>
				</form>
			</div>
			<div class="col-sm-4">
				<h4>ARTIST</h4>
				<form  action="Update_Artist" method="get">
					<select name="select" class="select" style="width: 190px">
						<c:forEach var="artist" items="${artistList}">
						<option value="${artist.ar_id }">${artist.ar_name}</option>
						</c:forEach>
					</select>
					<div class="block-mt">
						<input type="submit" name="submit" value="update" class="btn btn-primary">
						<input type="submit" name="submit" value="delete" class="btn btn-danger">
						<input type="submit" name="submit" value="new" class="btn btn-success">
					</div>
				</form>
			</div>
			<div class="col-sm-4">
				<h4>MUSIC</h4>
				<form  action="Update_Music" method="get">
				<select name="select"  class="select" style="width: 190px">
					<c:forEach var="album" items="${albumList}">
					<option value="${album.al_id }">${album.al_name}</option>
					</c:forEach>
				</select>
				<div class="block-mt">
					<input type="submit"  value="update" class="btn btn-primary">
				</div>
			</form>
		 </div>
	</div>
</div>
</body>
</html>
