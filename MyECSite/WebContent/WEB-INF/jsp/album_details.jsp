<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>album_details</title>

<link href="../CSS/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
<link href="../js/select2-4.0.6-rc.1/dist/css/select2.css" rel="stylesheet">
<link href="../CSS/main.css" rel="stylesheet">

<script src="../js/jquery-3.2.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
</head>
<body>
 <!-- navbar -->
<jsp:include page="../include/header.jsp" />
<!--  DETAIL  -->
    <div class="container-fluid">
        <div class="row main">

            <div class="col-lg-12">
                <h1>ALBUM TITLE</h1>
            </div>
            <div class="col-xs-6">
                <img src="../img/no.jpeg" class="detail_img">
            </div>
            <div class="col-xs-6">
                <p>RELEASE DATE : yyyy/MM/dd</p>
                <h4>ALBUM PRICE</h4>
                <a href="cart.html" type="button" value="¥99999- ADD CART" class="btn btn-primary">¥99999- ADD CART</a><br>
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
                            <tr class="row">
                                <td class="col-sm-1">1.</td>
                                <td class="col-sm-4">MUSIC</td>
                                <td class="col-sm-4">MUSICIAN</td>
                                <td class="col-sm-1">¥9999-</td>
                                <td class="col-sm-1">
                                    <audio src="../mp3/piano.mp3" controlslist="nodownload" controls></audio></td>
                                <td class="col-sm-1"><a href="cart.html" type="button" value="ADD CART" class="btn btn-primary inBtn">ADD CART</a><br></td>
                            </tr>
                            <tr class="row">
                                <td class="col-sm-1">2.</td>
                                <td class="col-sm-4">MUSIC</td>
                                <td class="col-sm-4">MUSICIAN</td>
                                <td class="col-sm-1">¥9999-</td>
                                <td class="col-sm-1">
                                    <audio src="../mp3/piano.mp3" controlslist="nodownload" controls></audio></td>
                                <td class="col-sm-1"><a href="../mp3/piano.mp3" type="button" value="ADD CART" class="btn btn-success inBtn">DOWNLOAD</a><br></td>
                            </tr>
                            <tr class="row">
                                <td class="col-sm-1">3.</td>
                                <td class="col-sm-4">MUSIC</td>
                                <td class="col-sm-4">MUSICIAN</td>
                                <td class="col-sm-1">¥9999-</td>
                                <td class="col-sm-1">
                                    <audio src="../mp3/piano.mp3" controlslist="nodownload" controls></audio></td>
                                <td class="col-sm-1"><a href="cart.html" type="button" value="ADD CART" class="btn btn-primary inBtn">ADD CART</a><br></td>
                            </tr>
                            <tr class="row">
                                <td class="col-sm-1">4.</td>
                                <td class="col-sm-4">MUSIC</td>
                                <td class="col-sm-4">MUSICIAN</td>
                                <td class="col-sm-1">¥9999-</td>
                                <td class="col-sm-1">
                                    <audio src="../mp3/piano.mp3" controlslist="nodownload" controls></audio></td>
                                <td class="col-sm-1"><a href="cart.html" type="button" value="ADD CART" class="btn btn-primary inBtn">ADD CART</a><br></td>
                            </tr>
                            <tr class="row">
                                <td class="col-sm-1">5.</td>
                                <td class="col-sm-4">MUSIC</td>
                                <td class="col-sm-4">MUSICIAN</td>
                                <td class="col-sm-1">¥9999-</td>
                                <td class="col-sm-1">
                                    <audio src="../mp3/piano.mp3" controlslist="nodownload" controls></audio></td>
                                <td class="col-sm-1"><a href="cart.html" type="button" value="ADD CART" class="btn btn-primary inBtn">ADD CART</a><br></td>
                            </tr>
                            <tr class="row">
                                <td class="col-sm-1">6.</td>
                                <td class="col-sm-4">MUSIC</td>
                                <td class="col-sm-4">MUSICIAN</td>
                                <td class="col-sm-1">¥9999-</td>
                                <td class="col-sm-1">
                                    <audio src="../mp3/piano.mp3" controlslist="nodownload" controls></audio></td>
                                <td class="col-sm-1"><a href="cart.html" type="button" value="ADD CART" class="btn btn-primary inBtn">ADD CART</a><br></td>
                            </tr>
                        </tbody>
                    </table>
                    </div>
                </div>

</body>
</html>