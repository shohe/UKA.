<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/admin_header.jsp"%>
<h1>詳細・メール作成</h1>
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<h2>送信内容作成</h2>
<div class="repmail">
	<h2>送信内容作成</h2>
	<form action="AdminMailSent" method="post">
		<h3>件名</h3>
		<input type="text" name="title">
		<h3>本文</h3>
		<textarea name="content" cols=40 rows=4></textarea>
<input type="hidden" name="user_id" value="${selectmail.user_id}">
		<br /> <input type="submit" value="メールを送信">

	</form>
</div>
<br />
<br />
<br />
<br />
<br />
<br />
<%@ include file="/WEB-INF/views/admin_footer.jsp"%>