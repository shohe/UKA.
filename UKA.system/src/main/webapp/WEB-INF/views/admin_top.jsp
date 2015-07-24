<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>UKA.</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- CSS
================================================== -->
<link href='http://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="<c:url value="/resources/plugins/font-awesome-4.3.0/css/font-awesome.min.css" />">
<link rel="stylesheet" href="<c:url value="/resources/plugins/bootstrap-3.3.4-dist/css/bootstrap.min.css" />">
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap-responsive.css" />">
<link rel="stylesheet" href="<c:url value="/resources/css/custom-styles.css" />">
<link rel="stylesheet" href="<c:url value="/resources/css/project.css" />">
<link rel="stylesheet" href="<c:url value="/resources/css/header.css" />">


<!-- Favicons
================================================== -->
<link rel="shortcut icon" href="<c:url value="/resources/img/favicon.ico" />">



<!-- JS
================================================== -->
<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
<script src="<c:url value="/resources/js/bootstrap.js" />"></script>
<script src="<c:url value="/resources/js/jquery.custom.js" />"></script>


<!-- PULGIN
================================================== -->
<script src="<c:url value="/resources/plugins/jquery/jquery-2.1.4.min.js" />"></script>
<script src="<c:url value="/resources/plugins/bootstrap-3.3.4-dist/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/plugins/knob/jquery.knob.js" />" type="text/javascript"></script>
<script type="text/javascript">
  $(function () {
    $(".knob").knob({});
  });
</script>
</head>
<body>
	<br />
	<br />
	<h1>管理者用トップページ</h1>

	<!--
	ログインしている人の名前を入れる
		↓logout処理 -->
	<p class="bg-primary text-left">おっぱいぱん</p>
	<form action="#" method="post">
		<input type="submit" name="logout" value="ログアウト">
	</form>
	<br />
	<br />
	<br />

	<form action="adminTransition" method="post">
		<input type="submit" name="adtransubmit" value="プロジェクト一覧">
	</form>
	<form action="adminTransition" method="post">
		<input type="submit" name="adtransubmit" value="メール一覧">
	</form>
	<form action="adminTransition" method="post">
		<input type="submit" name="adtransubmit" value="権限管理">
	</form>
</body>
</html>