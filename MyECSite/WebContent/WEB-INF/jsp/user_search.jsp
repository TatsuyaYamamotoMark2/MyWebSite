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
			<h1>USER SEARCH</h1>
				<form action="User_search" method="post">
					<div class="col-lg-2 col-xs-6 col-sm-6 col-md-6">
						<h4>LOGIN ID</h4>
						<input type="text" name=login_id size=15>
					</div>
					<div class="col-lg-3 col-xs-6 col-sm-6 col-md-6">
						<h4>NAME</h4>
						<input type="text" name="name" size=15>
					</div>
					<div class="col-lg-4 col-xs-12 col-sm-6 col-md-6" id="birthdate">
						<h4>BRITH DATE</h4>
						<input type="date" id="birth" name="birth_date_from"size=15> ~
						<input type="date" id="birth" name="birth_date_to"size=15>
					</div>
					<div class="col-lg-3 col-xs-12 col-sm-6 col-md-6">
						<h4></h4><input type="submit" value="SEARCH" class="btn btn-primary block-mt" style="display:inline">
					</div>
				</form><br>


				<h4 class="col-xs-12">RESULT</h4>
				<div class="col-lg-12 table-responsive">
					<table  class="table table-hover">
						<thead>
							<tr>
								<th>LOGIN ID</th>
								<th>USER NAME</th>
								<th>BIRTH DATE</th>
								<th></th>
							</tr>
						</thead>
						<tbody>

						<c:forEach var="usbList" items="${usbList}">

							<tr>
								<td>${usbList.login_id}</td>
								<td>${usbList.name}</td>
								<td>${usbList.format_Birth_date}</td>
								<td><a href="User?id=${usbList.id}">詳細</a></td>
							</tr>

						</c:forEach>
						</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
