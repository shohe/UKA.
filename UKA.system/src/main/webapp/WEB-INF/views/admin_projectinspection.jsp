<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>UKA.</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- CSS
================================================== -->
<link href='http://fonts.googleapis.com/css?family=Oswald'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet"
	href="<c:url value="/resources/plugins/font-awesome-4.3.0/css/font-awesome.min.css" />">
<link rel="stylesheet"
	href="<c:url value="/resources/plugins/bootstrap-3.3.4-dist/css/bootstrap.min.css" />">
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap-responsive.css" />">
<link rel="stylesheet"
	href="<c:url value="/resources/css/custom-styles.css" />">
<link rel="stylesheet"
	href="<c:url value="/resources/css/project.css" />">
<link rel="stylesheet"
	href="<c:url value="/resources/css/header.css" />">


<!-- Favicons
================================================== -->
<link rel="shortcut icon"
	href="<c:url value="/resources/img/favicon.ico" />">



<!-- JS
================================================== -->
<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
<script src="<c:url value="/resources/js/bootstrap.js" />"></script>
<script src="<c:url value="/resources/js/jquery.custom.js" />"></script>


<!-- PULGIN
================================================== -->
<script
	src="<c:url value="/resources/plugins/jquery/jquery-2.1.4.min.js" />"></script>
<script
	src="<c:url value="/resources/plugins/bootstrap-3.3.4-dist/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/plugins/knob/jquery.knob.js" />"
	type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		$(".knob").knob({});
	});
</script>
</head>
<body>

	<h1>プロジェクト一覧</h1>
	<form action="adminTransition" method="post">
		<input type="submit" name="adtransubmit" value="トップへ戻る">
	</form>
	<br />
	<br />
	<br />
	<form action ="adminlist" method="post">
		検索:<input type="text" name="search">
		<input type="submit" value="検索">
	</form>

	<!-- 期限が過ぎているものなどに色をつけたいなー -->
	<table class="table">
		<tr>
			<th>タイトル</th>
			<th>投稿者名</th>
			<th>投稿日</th>
			<!-- ↓ボタン -->
			<th>詳細</th>
			<!-- ↓ボタン×２　※すでにジャッチが行われている場合はその結果と変更する際のボタンを設置 -->
			<th>ジャッジ</th>
			<!-- ↓ボタン -->
			<th>メール作成</th>
		</tr>

		<!-- ↓jspでがんばるとこ -->
		<c:forEach items="${result}" var="item">
			<tr class="hov_css">
				<td><c:out value="${item.title}" /></td>
				<td><c:out value="${item.name}" /></td>
				<td><c:out value="${item.date}" /></td>
				<td>
					<form action="#" method="post">
						<input type="submit" name="" value="詳細ボタン">
					</form>
				</td>
				<td bgcolor="#FFF" align="center" width="150">
					<form action="#" method="post">
						<input type="submit" name="" value="採用">
						<input type="submit" name="" value="保留">
					</form>
				</td>
				<td bgcolor="#FFF" align="center" width="200">
					<form action="#" method="post">
						<input type="submit" name="" value="メール作成">
					</form>
				</td>
			</tr>
		</c:forEach>
		<!-- ↑jspでがんばるとこ -->

		<tr class="hov_css">
			<td>玉子とベーコンとクリームソースのパスタをみんなで食べ続ける</td>
			<td>安威 卯江雄</td>
			<td>1919/07/21-07:21:48</td>
			<td>
				<form action="#" method="post">
					<input type="submit" name="" value="詳細ボタン">
				</form>
			</td>
			<td bgcolor="#FFF" align="center" width="150">
				<form action="#" method="post">
					<input type="submit" name="" value="採用">
					<input type="submit" name="" value="保留">
				</form>
			</td>
			<td bgcolor="#FFF" align="center" width="200">
				<form action="#" method="post">
					<input type="submit" name="" value="メール作成">
				</form>
			</td>
		</tr>

		<tr class="hov_css">
			<td>玉子とベーコンとクリームソースのパスタをみんなで巻き続ける</td>
			<td>安威 卯江雄</td>
			<td>1919/07/21-07:21:48</td>
			<td>
				<form action="#" method="post">
					<input type="submit" name="" value="詳細ボタン">
				</form>
			</td>
			<td bgcolor="#FFF" align="center" width="150">
				<form action="#" method="post">
					<input type="submit" name="" value="採用">
					<input type="submit" name="" value="保留">
				</form>
			</td>
			<td bgcolor="#FFF" align="center" width="200">
				<form action="#" method="post">
					<input type="submit" name="" value="メール作成">
				</form>
			</td>
		</tr>

		<tr class="hov_css">
			<td>玉子とベーコンとクリームソースのパスタをみんなでゆで続ける</td>
			<td>安威 卯江雄</td>
			<td>1919/07/21-07:21:48</td>
			<td>
				<form action="#" method="post">
					<input type="submit" name="" value="詳細ボタン">
				</form>
			</td>
			<td bgcolor="#FFF" align="center" width="150">
				<form action="#" method="post">
					<input type="submit" name="" value="採用">
					<input type="submit" name="" value="保留">
				</form>
			</td>
			<td bgcolor="#FFF" align="center" width="200">
				<form action="#" method="post">
					<input type="submit" name="" value="メール作成">
				</form>
			</td>
		</tr>
	</table>

</body>
</html>