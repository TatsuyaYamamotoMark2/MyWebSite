<%@ page language="java" contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<div class="container">
	<div class="row">
		<nav class="navbar navbar-default navbar-fixed-top bg-theme ">
		<!-- Left menu -->
			<div class="col-xs-6 col-sm-3">
				<a href="Music_search" class="navbar-brand"><span style="font-size: 15px" class="glyphicon glyphicon-music" aria-hidden="true"></span> MUSIC EC</a>
			</div>
		<!-- Right menu -->
			<div class="col-xs-6 col-sm-9  ">
				<ul class="nav navbar-nav navbar-right">
					<c:if test="${usb == null}" var="flg" />
					<c:if test="${flg}" >
						<li class="nav-li"><a href="Login_register"><span class="glyphicon glyphicon-log-in" aria-hidden="true"></span> LOGIN/REGISTER</a></li>
					</c:if>
					<c:if test="${!flg}" >
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#gnavi">
					      <span class="sr-only">メニュー</span>
					      <span class="icon-bar"></span>
					      <span class="icon-bar"></span>
					      <span class="icon-bar"></span>
   					</button>
					<div id="gnavi" class="collapse navbar-collapse  ">
   					 <ul class="nav navbar-nav  ">
						<li class="nav-li"><a href="User?id=${usb.id}"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> MY PAGE</a></li>
						<li class="nav-li"><a href="Library?id=${usb.id }"><span class="glyphicon glyphicon-music" aria-hidden="true"></span> MY LIBRARY</a></li>
						<li class="nav-li"><a href="Cart?addFlg=0"><span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span> CART</a></li>
						<li class="nav-li"><a href="User_search"><span class="glyphicon glyphicon-search" aria-hidden="true"></span> USER SEACH</a></li>
						<li class="nav-li"><a href="Logout"><span class="glyphicon glyphicon-log-out" aria-hidden="true"></span> LOGOUT</a></li>
					</ul>
					</div>
					</c:if>
				</ul>
			</div>
		</nav>

	</div>
</div>
