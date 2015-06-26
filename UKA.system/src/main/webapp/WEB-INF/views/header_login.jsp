<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="hal.tokyo.dao.*" %>
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

<body class="home">
    <!-- Color Bars (above header)-->
	<div class="color-bar-1"></div>
    <div class="color-bar-2 color-bg"></div>
    <header>
        <div class="row header"><!-- Begin Header -->
          <div id="logo">
                <div id="logo_img"><img src="<c:url value="/resources/img/logo.png" />" alt="logo"></div>
                <div class="logo_title" id="uka">UKA.</div>
                <div class="logo_title" id="uka_text">nipponham business experts Ltd.</div>
                <div id="login-form">
                    <form class="" action="" method="post">
                        <div class="left">
                            <!-- out -->
                            <%
                            	String mailaddress =  (String)session.getAttribute("MailAddress");
                            	out.println("<p>");
                            	out.println(mailaddress + "さん");
                            	out.println("</p>");
                            %>
                            <!-- in -->
                            <!-- <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                一般社員
                                <span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                                <li><a href="#">管理者</a></li>
                            </ul> -->
                        </div>
                        <div class="right">
                            <button type="submit" class="btn btn-default">ログアウト</button>
                        </div>
                    </form>
                </div>
          </div>
          <nav>
              <ul>
                <a href="<c:url value="/" />"><li class="navi">ホーム</li></a>
                <a href="#"><li class="navi">プロジェクトを投稿する</li></a>
                <a href="#"><li class="navi">プロジェクトを探す</li></a>
                <a href="#"><li class="navi">UKA.とは？</li></a>
                <a href="#"><li class="navi">管理人にメッセージ</li></a>
                <a href="<c:url value="/regist" />"><li class="navi">新規登録</li></a>
              </ul>
          </nav>
        </div><!-- End Header -->
    </header>