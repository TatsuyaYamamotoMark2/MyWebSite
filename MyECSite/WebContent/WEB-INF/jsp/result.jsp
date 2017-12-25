<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>result</title>
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
            <form>
            <div class="col-lg-12">
                <h1>RESULT</h1>
                <p class="result">${resultMessage}</p>
                <a href="${link}" class="btn btn-primary">${buttonValue}</a><br>
            </div>
            </form>
        </div>
    </div>
</body>
</html>