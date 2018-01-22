<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="ja">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>update_artist</title>
<!-- favicon  -->
<link rel="icon" href="./ico/favi.ico">
<link href="CSS/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
<link href="CSS/main.css" rel="stylesheet">
<script type="text/javascript" src="CSS/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
<!-- navbar -->
<jsp:include page="../include/header.jsp" />
<!--  body  -->

<div class="container-fluid">
	<div class="row main">
		<h1>UPDATE ARTIST</h1>

		<c:if test="${artist != null}" var="flg" />

		<c:if test="${flg}" >
			<form action="Update_Artist" method="post">
				<div class="col-sm-12">
					<input type="hidden" name="id" value = ${artist.ar_id }>
					<input type="text" name="name"value="${artist.ar_name }">
					<input type="submit" name ="submit" value="UPDATE" class="btn btn-primary">
				</div>
			</form>
		</c:if>

		<c:if test="${!flg}" >
			<form action="Update_Artist" method="post">
				<div class="col-sm-12">
					<input type="text"name="name">
					<input type="submit" name ="submit" value="ADD" class="btn btn-primary">
				</div>
			</form>
		</c:if>


	</div>
</div>
</body>
</html>
