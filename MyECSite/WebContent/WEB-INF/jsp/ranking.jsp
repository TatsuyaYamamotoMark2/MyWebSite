<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>ranking</title>
<!-- favicon  -->
<link rel="icon" href="./ico/favi.ico">
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
			<h1>RANKING</h1>
			<h2>TOP10</h2>
				<div class="col-lg-12 table-responsive">


					<table  class="table table-hover">
						<thead>
							<tr>
								<th>#</th>
								<th>Title</th>
								<th>Album</th>
								<th>Artist</th>
								<th></th>
							</tr>
						</thead>
						<tbody>

						<c:forEach var="music" items="${musicList}">
							<tr>
								<td>int</td>
								<td>${music.m_name}</td>
								<td><a href= Album_detail?al_id=${music.al_id}><img src="./img/${music.image}" class="cart_img"></a>${music.al_name}</td>
								<td>${music.ar_name}</td>
								<td><a href="Album_detail?al_id=${music.al_id}">購入画面</a></td>
							</tr>
						</c:forEach>
						</tbody>
				</table>


			</div>
		</div>
	</div>





</body>
</html>