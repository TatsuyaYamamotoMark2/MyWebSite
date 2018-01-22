<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>album_details</title>

<!-- favicon  -->
<link rel="icon" href="./ico/favi.ico">
<link rel="stylesheet" href="CSS/progres-bar.css">
<link href="CSS/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
<link href="CSS/main.css" rel="stylesheet">

<script src="js/bootstrap.min.js"></script>

<script src="js/jquery-1.12.4.min.js"></script>
<script src="js/player.js"></script>
<script src="js/playerFanction.js"></script>


</head>
<body>
<!-- navbar -->
<jsp:include page="../include/header.jsp" />
<!--  DETAIL  -->
	<div class="container-fluid">
		<div class="row main">
			<div class="col-lg-12">
				<p class="result">${resultMessage}　</p>
				<p class="error">${errorMessage}　</p>
				<h1>${albumBean.al_name }</h1>
			</div>
			<div class="col-xs-6">
				<img src="./img/${albumBean.image}" class="detail_img">
			</div>
			<div class="col-xs-6">
				<p>RELEASE DATE : ${albumBean.format_Release_date}</p>


						<c:choose>
							<c:when test="${albumBean.purchased}">
								<input type="button" value="PURCHASED TRACK" class="btn btn-Default"><br>
							</c:when>
							<c:when test="${!albumBean.add_cart}">
								<h4>ALBUM PRICE</h4>
								<a href="AddAlbum?al_id=${albumBean.al_id }" type="button"  class="btn btn-primary">¥${albumBean.al_price }- ADD CART</a><br>
							</c:when>
							<c:when test="${albumBean.add_cart}">
								<input type="button" value="ADDED CART" class="btn btn-Default"><br>
							</c:when>
						</c:choose>

			</div>
		</div>
<!--    CONTENT      -->
		<h4>CONTENT</h4>

		<div class="col-lg-12 table-responsive">
			<table  class="table table-hover">
				<thead>
					<tr  class="row">
						<th class="col-lg-1">#</th>
						<th class="col-lg-4">TITLE</th>
						<th class="col-lg-4">ARTIST</th>
						<th class="col-lg-1">PRICE</th>
						<th class="col-lg-1"></th>
						<th class="col-lg-1"></th>
					</tr>
				</thead>
				<tbody>

				<c:forEach var="music" items="${musicList}">
					<form action="AddCart" method="post">
					<tr class="row">
						<td class="col-sm-1">${music.track_no }.</td>
						<td class="col-sm-4">${music.m_name }</td>
						<td class="col-sm-4">${music.ar_name}</td>
						<td class="col-sm-1">¥${music.m_price}-</td>
						<td class="col-sm-1">
						<c:if test="${music.mp3 == null}" var="flg" />
						<c:if test="${!flg}" >
								<div class="mediPlayer">
								<audio class="listen" src="./mp3/${music.mp3}" controlslist="nodownload" data-size="25"></audio></div>
						</td>
						</c:if>
						<input type="hidden" value="${music.m_id}" name="m_id">
						<input type="hidden" value="${music.al_id}" name="al_id">


						<c:choose>

							<c:when test="${music.purchased}">
							<td class="col-sm-1"><a href=" ./wave/${music.DL_path }"  download = "${music.DL_path }" type="button" value="DOWNLOAD" class="btn btn-success inBtn" >DOWNLOAD</a><br></td>
							</c:when>
							<c:when test="${!music.add_cart}">
							<td class="col-sm-1"><input type="submit" value="ADD CART" class="btn btn-primary inBtn"><br></td>
							</c:when>
							<c:when test="${music.add_cart}">
							<td class="col-sm-1"><input type="button" value="ADDED CART" class="btn btn-Default inBtn"><br></td>
							</c:when>

						</c:choose>



					</tr>
					</form>
				</c:forEach>

				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
