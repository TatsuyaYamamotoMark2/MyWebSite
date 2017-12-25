<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="ja">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>update_music</title>
<link href="CSS/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
<link href="js/select2-4.0.6-rc.1/dist/css/select2.css" rel="stylesheet">
<link href="CSS/main.css" rel="stylesheet">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/select2-4.0.6-rc.1/dist/js/select2.min.js"></script>
<script src="js/selectfanction.js"></script>
</head>
<body>
<!-- navbar -->
<jsp:include page="../include/header.jsp" />

<!--  DETAIL  -->
<form action="Update_Music" method="post"  enctype='multipart/form-data' data-ajax="false">
<input type="hidden" name="al_id" value="${album.al_id }">
	<div class="container-fluid">
		<div class="row main">
			<div class="col-xs-10">
				<p class="result">${resultMessage}　</p>
				<p class="error">${errorMessage}　</p>
				<h1>${album.al_name }</h1>
			</div>
			<div class="col-xs-2">
				<input type="submit" value="UPDATE" class="btn btn-primary block_mt">
			</div>
			<div class="col-xs-6">
				<img src="./img/${album.image }" class="detail_img">
			</div>
			<div class="col-xs-6">
				<p>RELEASE DATE : ${album.release_date }</p><br>
				<p>mp3以外を入力すると楽曲が追加されます</p><br>
				<p>mp3を設定した場合のみ商品ページに視聴ボタンが表示されます</p>
			</div>
		</div>
<!--    CONTENT      -->
		<h4>CONTENT</h4>
			<div class="col-xs-12 table-responsive">

				<table  class="table table-hover">
				 <thead>
					<tr>
						<th>No</th>
						<th>TITLE</th>
						<th>ARTIST</th>
						<th>PRICE</th>
						<th>SAMPLE.MP3</th>
						<th>DL.FILE</th>
						<th></th>
					</tr>
				</thead>
				<tbody>

<c:forEach var="music" items="${albumDetail}" varStatus="count">
					<tr>
						<td>
							<input type=hidden name="m_id${count.count}" value="${music.m_id}">
							<select name="no${count.count}">
								<c:forEach var="track" items="${albumDetail}"  varStatus="st">
									<c:if test="${st.count == music.track_no}">
										<option value="${st.count }" selected="selected">${st.count }</option>
									</c:if>
									<c:if test="${st.count != music.track_no}">
										<option value="${st.count }" >${st.count }</option>
									</c:if>
								</c:forEach>
							</select>
						</td>
						<td><input type="text" size="10" value="${music.m_name }" name="m_name${count.count}"></td>
						<td><select name="artist${count.count }" class="select" style="width: 130px">
								<c:forEach var="artist" items="${artist}">
									<option name="artist${count.count }" value="${artist.ar_id }">${artist.ar_name }</option>
								</c:forEach>

							</select></td>
						<td>¥<input type="text" size="10" value="${music.m_price }" name="price${count.count }"></td>
						<td><input type="file" accept='audio/mp3' name="mp3File${count.count}"></td>
						<td><input type="file" accept='audio/*' name="waveFile${count.count}"></td>
						<td><input type="checkbox" name ="delete${count.count }">　削除</td>
					</tr>
</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</form>
</body>
</html>
