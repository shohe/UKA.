<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>メール返信</title>
</head>
<body>
<c:forEach var="selectmail" items="${selectmail}" varStatus="status">
	<h1>詳細・メール作成</h1>
	<form action="adminTransition" method="post">
		<input type="submit" name="adtransubmit" value="トップへ戻る">
	</form>
	<br />
	<br />
	<br />
	<h2>メール詳細</h2>

	<h3></h3>
	<p>
		送信者名:<c:out value="${selectmail.user_id}"/>
		<!--送信者名-->
	</p>
	<h3>件名</h3>
	<p>
		<c:out value="${selectmail.enquiry_title}"/>
		<!--件名-->
	</p>
	<h3>本文</h3>
	<p>
		<c:out value="${selectmail.enquiry_content}"/>
		<!--本文-->
	</p>
	<h3>送信日時</h3>
	<p>
		<c:out value="${selectmail.date}"/>
		<!--送信日時-->
	</p>
	<br />
	<br />
	<br />

	<h2>送信内容作成</h2>
	<form action="AdminMailSent" method="post">
		<h3>件名</h3>
		<input type="text" name="title">
		<h3>本文</h3>
		<textarea name="content" cols=40 rows=4></textarea>
<input type="hidden" name="user_id" value="${selectmail.user_id}">
		<br /> <input type="submit" value="メールを送信">
				</c:forEach>
	</form>
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
</body>
</html>