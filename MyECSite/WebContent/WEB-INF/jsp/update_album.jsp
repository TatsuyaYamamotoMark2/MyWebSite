<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>update_album</title>
<link href="../CSS/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
<link href="../CSS/main.css" rel="stylesheet">

</head>
<body>
<!-- navbar -->
<jsp:include page="../include/header.jsp" />
<!--  body  -->

    <div class="container-fluid">
        <div class="row main">

                <div class="col-xs-8">
                    <h1>ADD ALBUM</h1>
                </div>
                <div class="col-xs-4">
                    <input type="button" class="btn btn-success" value="add">
                </div>


                    <div class="col-xs-6">
                        <p>album jacket image file(1:1)
                        <input type="file"></p>
                        <p>album name</p>
                        <input type="text">
                </div>
                    <div class="col-xs-6">
                        <p>RELEASE DATE : yyyy/MM/dd(today)</p>
                        <h4>ALBUM PRICE</h4>
                        <p>空欄の場合、合計金額になります。</p>
                        ¥<input type="text" value="">-<br>
                    </div>
        </div>
    </div>
</body>
</html>