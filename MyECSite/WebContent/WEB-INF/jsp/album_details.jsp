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
				<h1>${albumBean.al_name }</h1>
			</div>
			<div class="col-xs-6">
				<img src="./img/${albumBean.image}" class="detail_img">
			</div>
			<div class="col-xs-6">
				<p>RELEASE DATE : ${albumBean.format_Release_date}</p>
				<h4>ALBUM PRICE</h4>
				<a href="cart.html" type="button"  class="btn btn-primary">¥${albumBean.al_price }- ADD CART</a><br>
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
						<th class="col-lg-1">SAMPLE</th>
						<th class="col-lg-1"></th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="musicList" items="${musicList}">
					<form action="AddCart" method="post">
					<tr class="row">
						<td class="col-sm-1">${musicList.track_no }.</td>
						<td class="col-sm-4">${musicList.m_name }</td>
						<td class="col-sm-4">${musicList.ar_name}</td>
						<td class="col-sm-1">¥${musicList.m_price}-</td>
						<td class="col-sm-1">
							<c:if test="${musicList.mp3 == null}" var="flg" />
							<c:if test="${flg}" >
							</c:if>
							<c:if test="${!flg}" >
								<div class="mediPlayer">
								<audio class="listen" src="./mp3/${musicList.mp3}" controlslist="nodownload" data-size="25"></audio></div>
						</td></c:if>
						<input type="hidden" value="${musicList.m_id}" name="m_id">
						<td class="col-sm-1"><input type="submit" value="ADD CART" class="btn btn-primary inBtn"><br></td>
					</tr>
					</form>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
