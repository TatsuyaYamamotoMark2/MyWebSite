<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>update_menu</title>
<link href="../CSS/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
<link href="../js/select2-4.0.6-rc.1/dist/css/select2.css" rel="stylesheet">
<link href="../CSS/main.css" rel="stylesheet">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>

<script src="../js/select2-4.0.6-rc.1/dist/js/select2.min.js"></script>
<script src="../js/selectfanction.js"></script>
</head>
<body>
<!-- navbar -->
<jsp:include page="../include/header.jsp" />
<!--  body  -->

    <div class="container-fluid">
        <div class="row main">
            <h1>ADD/UPDATE</h1>

                <div class="col-sm-4">
                    <h4>ALBUM</h4>
                        <select name="select" class="select" style="width: 190px">
                          <option value="1">asdaalbum1</option>
                          <option value="2">albudadm1</option>
                          <option value="3">alb234um1</option>
                          <option value="4">alb426um1</option>
                          <option value="1">album154</option>
                          <option value="2">albu546m1</option>
                          <option value="3">album1</option>
                          <option value="4">albu74m1</option>
                          <option value="1">album1</option>
                          <option value="2">album1</option>
                          <option value="3">alb54um1</option>
                          <option value="4">album51</option>
                          <option value="1">alb74um1</option>
                          <option value="2">alb7um1</option>
                          <option value="3">a54lbum1</option>
                          <option value="4">album1</option>
                          <option value="1">albu748m1</option>
                          <option value="2">album1</option>
                          <option value="3">alb780um1</option>
                          <option value="4">album1</option>
                          <option value="1">albu708m1</option>
                          <option value="2">albu07m17</option>
                          <option value="3">albu708m1</option>
                          <option value="4">album1</option>
                          <option value="1">al708bum1</option>
                          <option value="2">albu780m1</option>
                          <option value="3">albu79m1</option>
                          <option value="4">alb47um1</option>
                        </select>
                    <div class="block-mt">
                        <a href="update_album.html" type="button" value="update" class="btn btn-primary">update</a>
                        <a href="update_menu.html" type="button" value="delete" class="btn btn-danger">delete</a>
                        <a href="update_artist.html" type="button" value="new" class="btn btn-success">new</a>
                    </div>
                </div>
                <div class="col-sm-4">
                    <h4>ARTIST</h4>
                        <select name="select" class="select" style="width: 190px">
                          <option value="1">artist1</option>
                          <option value="2">artist2</option>
                          <option value="3">artist3</option>
                          <option value="4">artist4</option>
                        </select>
                    <div class="block-mt">
                        <a href="update_artist.html" type="button" value="update" class="btn btn-primary">update</a>
                        <a href="update_menu.html" type="button" value="delete" class="btn btn-danger">delete</a>
                        <a href="update_artist.html" type="button" value="new" class="btn btn-success">new</a>
                    </div>

                </div>
                <div class="col-sm-4">
                    <h4>MUSIC</h4>
                        <select name="selest"  class="select" style="width: 190px">
                          <option value="1">album1</option>
                          <option value="2">album2</option>
                          <option value="3">album3</option>
                          <option value="4">album4</option>
                        </select>
                    <div class="block-mt">
                        <a href="update_music.html" type="button" value="update" class="btn btn-primary">update</a>
                        <a href="update_music.html" type="button" value="new" class="btn btn-success">new</a>
                    </div>
                </div>
        </div>
    </div>
</body>
</html>