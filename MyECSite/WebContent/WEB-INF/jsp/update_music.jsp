<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>update_music</title>
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
<form>
<!--  DETAIL  -->
    <div class="container-fluid">
        <div class="row main">

            <div class="col-xs-10">
                <h1>ALBUM TITLE</h1>
            </div>
            <div class="col-xs-2">
                <input type="button" value="UPDATE" class="btn btn-primary block_mt">
            </div>
            <div class="col-xs-6">
                <img src="../img/no.jpeg" class="detail_img">
            </div>
            <div class="col-xs-6">
                <p>RELEASE DATE : yyyy/MM/dd</p>
                <h4>ALBUM PRICE</h4>
                <p>¥999999</p>
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
                            <th>DL.WAV</th>
                            <th></th>
                        </tr>
                        </thead>

                        <tbody>
                            <tr>
                                <td>
                                    <select>
                                        <option value="1" selected>1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                        <option value="4">4</option>
                                        <option value="5">5</option>
                                        <option value="6">6</option>
                                        <option value="7">7</option>
                                    </select>
                                </td>
                                <td><input type="text" size="10"></td>
                                <td><select name="prefecture" class="select" style="width: 130px">
                                  <option value="null">artist name</option>
                                  <option value="1">artist1aaaaaaaaaaaaaaaaaaa</option>
                                  <option value="2">artist2</option>
                                  <option value="3">artist3</option>
                                  <option value="4">artist4</option>
                                </select></td>
                                <td>¥<input type="text" size="10"></td>
                                <td><input type="file"></td>
                                <td><input type="file"></td>
                                <td><a>削除</a></td>
                            </tr>

                            <tr>
                                <td>
                                    <select>
                                        <option value="1">1</option>
                                        <option value="2" selected>2</option>
                                        <option value="3">3</option>
                                        <option value="4">4</option>
                                        <option value="5">5</option>
                                        <option value="6">6</option>
                                        <option value="7">7</option>
                                    </select></td>
                                <td><input type="text" size="10"></td>
                                <td><select name="prefecture" class="select" style="width: 130px">
                                  <option value="null">artist name</option>
                                  <option value="1">artist1</option>
                                  <option value="2">artist2</option>
                                  <option value="3">artist3</option>
                                  <option value="4">artist4</option>
                                </select></td>
                                <td>¥<input type="text" size="10"></td>
                                <td><input type="file"></td>
                                <td><input type="file"></td>
                                <td><a>削除</a></td>
                            </tr>

                            <tr>
                                <td>
                                    <select>
                                        <option value="1">1</option>
                                        <option value="2">2</option>
                                        <option value="3" selected>3</option>
                                        <option value="4">4</option>
                                        <option value="5">5</option>
                                        <option value="6">6</option>
                                        <option value="7">7</option>
                                    </select></td>
                                <td><input type="text" size="10"></td>
                                <td><select name="prefecture" class="select" style="width: 130px">
                                  <option value="null">artist name</option>
                                  <option value="1">artist1</option>
                                  <option value="2">artist2</option>
                                  <option value="3">artist3</option>
                                  <option value="4">artist4</option>
                                </select></td>
                                <td>¥<input type="text" size="10"></td>
                                <td><input type="file"></td>
                                <td><input type="file"></td>
                                <td><a>削除</a></td>
                            </tr>

                            <tr>
                                <td>
                                    <select>
                                        <option value="1">1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                        <option value="4" selected>4</option>
                                        <option value="5">5</option>
                                        <option value="6">6</option>
                                        <option value="7">7</option>
                                    </select></td>
                                <td><input type="text" size="10"></td>
                                <td><select name="prefecture" class="select" style="width: 130px">
                                  <option value="null">artist name</option>
                                  <option value="1">artist1</option>
                                  <option value="2">artist2</option>
                                  <option value="3">artist3</option>
                                  <option value="4">artist4</option>
                                </select></td>
                                <td>¥<input type="text" size="10"></td>
                                <td><input type="file"></td>
                                <td><input type="file"></td>
                                <td><a>削除</a></td>
                            </tr>

                            <tr>
                                <td>
                                    <select>
                                        <option value="1">1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                        <option value="4">4</option>
                                        <option value="5" selected>5</option>
                                        <option value="6">6</option>
                                        <option value="7">7</option>
                                    </select></td>
                                <td><input type="text" size="10"></td>
                                <td><select name="prefecture" class="select" style="width: 130px">
                                  <option value="null">artist name</option>
                                  <option value="1">artist1</option>
                                  <option value="2">artist2</option>
                                  <option value="3">artist3</option>
                                  <option value="4">artist4</option>
                                </select></td>
                                <td>¥<input type="text" size="10"></td>
                                <td><input type="file"></td>
                                <td><input type="file"></td>
                                <td><a>削除</a></td>
                            </tr>

                            <tr>
                                <td>
                                    <select>
                                        <option value="1">1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                        <option value="4">4</option>
                                        <option value="5">5</option>
                                        <option value="6" selected>6</option>
                                        <option value="7">7</option>
                                    </select></td>
                                <td><input type="text" size="10"></td>
                                <td><select name="prefecture" class="select" style="width: 130px">
                                  <option value="null">artist name</option>
                                  <option value="1">artist1</option>
                                  <option value="2">artist2</option>
                                  <option value="3">artist3</option>
                                  <option value="4">artist4</option>
                                </select></td>
                                <td>¥<input type="text" size="10"></td>
                                <td><input type="file"></td>
                                <td><input type="file"></td>
                                <td><a>削除</a></td>
                            </tr>

                            <tr>
                                <td>
                                    <select>
                                        <option value="1">1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                        <option value="4">4</option>
                                        <option value="5">5</option>
                                        <option value="6">6</option>
                                        <option value="7" selected>7</option>
                                    </select></td>
                                <td><input type="text" size="10"></td>
                                <td><select name="prefecture" class="select" style="width: 130px">
                                  <option value="null">artist name</option>
                                  <option value="2">artist2</option>
                                  <option value="3">artist3</option>
                                  <option value="4">artist4</option>
                                </select></td>
                                <td>¥<input type="text" size="10"></td>
                                <td><input type="file"></td>
                                <td><input type="file"></td>
                                <td><a>削除</a></td>
                            </tr>


                        </tbody>
                    </table>
                    </div>
                </div>
    </form>
</body>
</html>