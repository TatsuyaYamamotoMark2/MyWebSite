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
<!--  body  -->
<div class="container-fluid">
	<div class="row main">
	<form action="Purchase" method="post">
		<div class="col-lg-12">
			<p class="result">${resultMessage}　</p>
			<p class="error">${errorMessage}　</p>
			<h1>CART</h1>
				<c:if test="${cart == null}" var="flg" />

				<c:if test="${!flg}" >
					<input type="submit" value="¥${cartPrice}-  Purchase" class="btn btn-primary"><br>
				</c:if>

				<c:if test="${flg}" >
				<input type="button" value="EMPTY CART" class="btn btn-Default"><br>
				</c:if>

		</div>
	</form>
</div>

<!--    CONTENT    -->
<h4>CONTENT</h4>
<div class="col-lg-12 table-responsive">
	<table  class="table table-hover">
		<tbody>

			<c:forEach var="cart" items="${cart}">
			<form method="post" action="RemoveCart">
			<tr>
				<td><a href= Album_detail?al_id=${cart.al_id}><img src="./img/${cart.image}" class="cart_img"></a><br></td>
				<td><a href= Album_detail?al_id=${cart.al_id}>${cart.m_name }</a></td>
				<td><a href= Album_detail?al_id=${cart.al_id}>${cart.al_name }</a></td>
				<td><p>${cart.ar_name }</p></td>
				<td><p href="">¥${cart.m_price }-</p></td>
					<input type="hidden" value="${cart.m_name }" name="m_name">
					<input type="hidden" value="${cart.m_id}" name="m_id">
					<input type="hidden" value="${cart.al_id}" name="al_id">
				<td><input type="submit" class="btn btn-primary inBtn" value="remove"></td>
			</tr>
			</form>
			</c:forEach>

		</tbody>
	</table>
</div>
</div>
</body>
</html>
