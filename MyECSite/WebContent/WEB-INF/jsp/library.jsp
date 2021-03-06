<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<!--  Library  -->
    <div class="container-fluid">
            <div class="main">
            <h1>LIBRARY</h1>

                <form action="Library" method="post">
                <input type="hidden" name="user_id" value="${user_id}">
                <input type="text" name="search_value">
                <input type="submit" value="SEARCH" class="btn btn-primary" style="display:inline"><br>
                <input type="radio" name="searchPattern" value="album.al_name">ALBUM
                <input type="radio" name="searchPattern" value="artist.ar_name">ARTIST
                <input type="radio" name="searchPattern" value="music.m_name">MUSIC
                <input type="radio" name="searchPattern" value="keyword" checked="checked">KEYWORD
                </form>
                <div class="row flex">
                <c:forEach var="album" items="${albList}">

                    <div class="col-md-2 col-sm-3 col-xs-6 text-center">
                        <a href="Album_detail?al_id=${album.al_id}&addFlg=0"><img src="./img/${album.image}" class="library_img"></a><br>
                        <a href="Album_detail?al_id=${album.al_id}">${album.al_name }</a><br>
                        <a href="Album_detail?al_id=${album.al_id}">¥${album.al_price }-</a><br>
                    </div>

                </c:forEach>
                </div>
            </div>
    </div>
</body>
</html>