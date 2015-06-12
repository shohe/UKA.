<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html"; charset="UTF-8" />
	<meta http-equiv="Content-Style-Type" content="text/css"; charset="UTF-8" />
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
	<style type="text/css">
		<%@ include file="/css/reset.css" %>
		<%@ include file="/css/font.css" %>
		<%@ include file="/css/common.css" %>
		<%@ include file="/css/header.css" %>
	</style>
	<script type="text/javascript"><%@ include file="/js/jquery/jquery-2.1.4.min.js" %></script>
	<script type="text/javascript"><%@ include file="/js/chart/Chart.js" %></script>
	<script type="text/javascript"><%@ include file="/js/chart/chartData.js" %></script>
	
<title>header</title>
</head>

<body>
	<div id="header_line"></div>
	<div id="logo">
		<div id="logo_img"><!-- <img src="#" alt="logo"> --></div>
		<div class="logo_title" id="uka">UKA.</div>
		<div class="logo_title" id="uka_text">nipponham business experts Ltd.</div>
	</div>
	<div id="g_nav">
		<ul>
			<a href="#" class="g_nav_link"><li class="g_nav_menu">ホーム</li></a>
			<a href="#" class="g_nav_link"><li class="g_nav_menu">プロジェクトを投稿する</li></a>
			<a href="#" class="g_nav_link"><li class="g_nav_menu">プロジェクトを探す</li></a>
			<a href="#" class="g_nav_link"><li class="g_nav_menu">UKA.とは？</li></a>
			<a href="#" class="g_nav_link"><li class="g_nav_menu">管理人にメッセージ</li></a>
		</ul>
	</div>