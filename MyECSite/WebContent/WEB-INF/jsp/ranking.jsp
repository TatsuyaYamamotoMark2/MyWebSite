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
			<h2>TOP${musicList.size()}</h2>
				<div class="col-lg-12 table-responsive">


					<table  class="table table-hover">
						<thead>
							<tr>
								<th>#</th>
								<th>Title/Artist</th>
								<th>Album</th>
								<th></th>
							</tr>
						</thead>
						<tbody>


						<c:forEach var="music" items="${musicList}">

						<c:choose>

							<c:when test="${music.rank == 1}">
								<tr>
									<td><h1>${music.rank}位</h1>${music.count}DL</td>
									<td><a href= Album_detail?al_id=${music.al_id}>${music.m_name}</a><br>${music.ar_name}</td>
									<td><a href= Album_detail?al_id=${music.al_id}><img src="./img/${music.image}" class="cart_img">${music.al_name}</a></td>
									<td><a href="Album_detail?al_id=${music.al_id}">購入画面</a></td>
								</tr>
							</c:when>

							<c:otherwise>
								<tr>
										<td><h3>${music.rank}位</h3>${music.count}DL</td>
										<td><a href= Album_detail?al_id=${music.al_id}>${music.m_name}</a><br>${music.ar_name}</td>
										<td><a href= Album_detail?al_id=${music.al_id}><img src="./img/${music.image}" class="cart_img">${music.al_name}</a></td>
										<td><a href="Album_detail?al_id=${music.al_id}">購入画面</a></td>
									</tr>
							</c:otherwise>

						</c:choose>


						</c:forEach>


						</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>